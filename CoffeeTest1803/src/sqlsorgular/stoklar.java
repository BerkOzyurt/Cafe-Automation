/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozkan
 */
public class stoklar {
    PreparedStatement ps;
    ResultSet rs;
    private String urun_adi, tarih;
    private int urun_no, stok_adet, stok_id;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd H:mm:ss");
    LocalDate localDate = LocalDate.now();
            java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String currentTime = sdf.format(dt);
    public List<sqlsorgular.stoklar> GuncelStokDurumu() throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        List<sqlsorgular.stoklar> liste = new ArrayList<>();
        stoklar[] stok;
        String sorgu;
        sorgu="Select COUNT(*) from stoklar";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac=0;
         while(rs.next()){
            sayac = rs.getInt(1);
        }
        stok=new stoklar[sayac];
        String sorgu2 = "SELECT s.urun_no, s.adet, u.urun_adi, s.id FROM stoklar s INNER JOIN urunler u ON u.urun_kodu=s.urun_no ";
        ps = vb.con.prepareStatement(sorgu2);
        rs = ps.executeQuery(sorgu2);
        int i =0;
        while(rs.next()){
              stok[i] = new stoklar();
              stok[i].setUrun_no(rs.getInt("s.urun_no"));
              stok[i].setStok_adet(rs.getInt("adet"));
              stok[i].setUrun_adi(rs.getString(3));
              int stokno = rs.getInt(4);
              stok[i].setStok_id(stokno);
              stok[i].setTarih(SonDegisiklikTarihi(stokno));
              liste.add(stok[i]);
              i++;
          }
        ps.close();
        rs.close();
        return liste;
    }

    public String SonDegisiklikTarihi(int stok_no) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        String tarih="";
        String sorgu = "SELECT MAX(tarih) FROM stok_log where stok_no="+stok_no+"";
        PreparedStatement ps1 = vb.con.prepareStatement(sorgu);
        ResultSet rs1 = ps1.executeQuery();
        while(rs1.next()){
            tarih = rs1.getString(1);
        }
        return tarih;
    }
    public int StokAdetbyUrunNo(int UrunNo) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int adet = 0;
        String sorgu = "SELECT adet FROM stoklar where urun_no="+UrunNo+"";
        PreparedStatement ps1 = vb.con.prepareStatement(sorgu);
        ResultSet rs1 = ps1.executeQuery();
        while(rs1.next()){
            adet = rs1.getInt(1);
        }
        return adet;
    }
    public boolean StokGuncelle(int UrunNo, int Adet) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        boolean varMi=false;
        String sorgu="";
        varMi=UrunKaydiSorgula(UrunNo);
        if(varMi){
            sorgu = "update stoklar set adet="+Adet+" where urun_no="+UrunNo+"";
        }else{
            sorgu = "INSERT INTO stoklar (urun_no, adet) VALUES ("+UrunNo+", "+Adet+")";
        }
        
        ps = vb.con.prepareStatement(sorgu);
        ps.executeUpdate();
        ps.close();
        vb.con.close();
        return true;
        
    }
    public boolean UrunKaydiSorgula(int urunno) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int sayi=0;
       String sorgu = "SELECT COUNT(*) FROM stoklar where urun_no="+urunno+"";
       ps = vb.con.prepareStatement(sorgu);
       rs = ps.executeQuery();
       while(rs.next()){
           sayi=rs.getInt(1);
       }
       vb.con.close();
       if(sayi==0)
           return false;
       else
           return true;
       
    }
    public boolean StokLogKaydet(int UrunNo, int adet, String islem){
        baglanti vb = new baglanti();
        vb.baglan();
        int stokno=0;
        try {
            stokno = StokAdetbyUrunNo(UrunNo);
        } catch (SQLException ex) {
            Logger.getLogger(stoklar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            String sorgu = "INSERT INTO stok_log (stok_no, adet, islem, tarih) VALUES ("+stokno+", "+adet+", '"+islem+"','"+currentTime+"')";
        ps = vb.con.prepareStatement(sorgu);
        ps.executeUpdate();
        return true; 
        }catch(SQLException e){
            return false;
        }
        
       
    }
    public int StokNoByUrunKodu(int UrunKodu) throws SQLException{
         baglanti vb = new baglanti();
        vb.baglan();
        int stokNo = 0;
        String sorgu = "SELECT stok_no FROM stoklar where urun_no="+UrunKodu+"";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        while(rs.next()){
            stokNo = rs.getInt(1);
        }
        return stokNo;
    }
    public int StokDurumuByUrunKodu(int Urunkodu) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int stokNo = 0;
        String sorgu = "SELECT adet FROM stoklar where urun_no="+Urunkodu+"";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        while(rs.next()){
            stokNo = rs.getInt(1);
        }
        vb.con.close();
        return stokNo;
    }
    public boolean StokAzalt(int urunkodu, int adet){
        try {
            int gunceladet=0;
            try {
                gunceladet = StokDurumuByUrunKodu(urunkodu);
            } catch (SQLException ex) {
                Logger.getLogger(stoklar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(gunceladet==0)
                return false;
            baglanti vb = new baglanti();
            vb.baglan();
            int Adet = gunceladet - adet;
            String sorgu = "update stoklar set adet="+Adet+" where urun_no="+urunkodu+"";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(stoklar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getTarih() {
        return tarih;
    }

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }
    
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getUrun_no() {
        return urun_no;
    }

    public void setUrun_no(int urun_no) {
        this.urun_no = urun_no;
    }

    public int getStok_adet() {
        return stok_adet;
    }

    public void setStok_adet(int stok_adet) {
        this.stok_adet = stok_adet;
    }
    
}
