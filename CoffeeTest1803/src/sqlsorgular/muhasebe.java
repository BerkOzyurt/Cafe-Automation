/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ozkan
 */
public class muhasebe {
    PreparedStatement ps;
    ResultSet rs;
    int masa_no,urun_kodu,adet;
    String odeme_tipi,siparis_no;
    float indirim_orani, fiyat;
    String tarih;
    
    
    public List<muhasebe> muhasebeBilgiAl() throws SQLException{
        // siparis numaralarin alimi icin kullaniliyor
        baglanti vb = new baglanti();
        vb.baglan();
        List<muhasebe> siparisnolist= new ArrayList<>();
        muhasebe[] muhasebegrup;
        
        try{
           
            String sorgu="SELECT o.siparis_no, o.masa_no, o.urun_kodu,o.tarih, o.adet, s.odeme_tipi, s.indirim_orani, f.fiyat FROM odenen_siparisler o INNER JOIN odeme s ON o.siparis_no=s.siparis_no INNER JOIN fiyatlar f ON o.urun_kodu=f.urun_kodu order by tarih DESC;";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            int sayac=0;
            while (rs.next()){
                sayac++;
            }
            muhasebegrup=new muhasebe[sayac];
            int i = 0;
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                muhasebegrup[i] = new muhasebe();
                muhasebegrup[i].setSiparis_no(rs.getString("siparis_no"));
                muhasebegrup[i].setMasa_no(rs.getInt("masa_no"));
                muhasebegrup[i].setUrun_kodu(rs.getInt("urun_kodu"));
                muhasebegrup[i].setTarih(rs.getString("tarih"));
                muhasebegrup[i].setAdet(rs.getInt("adet"));
                muhasebegrup[i].setOdeme_tipi(rs.getString("odeme_tipi"));
                muhasebegrup[i].setIndirim_orani(rs.getFloat("indirim_orani"));
                muhasebegrup[i].setFiyat(rs.getFloat("fiyat"));
                siparisnolist.add(muhasebegrup[i]);
                i++;
            }
            return siparisnolist;
        }catch(Exception e){
            System.out.println("Siparisler alinirken hata olustu"+ e);
            return siparisnolist;
        }
    }
    public ArrayList<Float> fiyatAl() throws SQLException{
        // fiyat bilgisinin alinmasi icin
        baglanti vb = new baglanti();
        vb.baglan();
        ArrayList<Float> fiyatlist = new ArrayList<>();
        try{
            String sorgu="select fiyatlar.fiyat from fiyatlar inner join odenen_siparisler on fiyatlar.urun_kodu=odenen_siparisler.urun_kodu order by odenen_siparisler.tarih desc";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()){
                fiyatlist.add(rs.getFloat(1));
            }
            
            return fiyatlist;
        }catch(Exception e){
            System.out.println("Fiyatlar alinirken hata olustu "+ e);
            return fiyatlist;
        }
    }
    
    public List<String> GunAyYil(int deger) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int ifade=0;
        List<String> tarihlist = new ArrayList<>();
        try{
            if(deger==1){
                // tarihte bulunan gunu almak icin 
                String sorgu="select distinct day(tarih) from odenen_siparisler group by tarih desc";
                ps = vb.con.prepareStatement(sorgu);
                rs = ps.executeQuery(sorgu);
                while (rs.next()){
                    tarihlist.add(rs.getString(1));
                
                }
            }
            else if(deger==2){
                //tarihlerde bulunan aylari almak icin
                String sorgu="select distinct month(tarih) from odenen_siparisler group by tarih desc";
                ps = vb.con.prepareStatement(sorgu);
                rs = ps.executeQuery(sorgu);
                while (rs.next()){
                    tarihlist.add(rs.getString(1));
                
                }
            }
            else if(deger==3){
                // tarihlerde bulunan yıllari almak icin 
                String sorgu="select distinct year(tarih) from odenen_siparisler group by tarih desc";
                ps = vb.con.prepareStatement(sorgu);
                rs = ps.executeQuery(sorgu);
                while (rs.next()){
                    tarihlist.add(rs.getString(1));
                
                }
            }
            return tarihlist;
            
        }catch(Exception e){
            System.out.println("gun ay yil alirken hata olustu" + e);
            return tarihlist;
        }
    }
    
    public List<String> ikiTarihArasiListele(String baslangictarih, String bitistarih) throws SQLException{
        // gelen tarihler arasindaki tarihleri alir
        baglanti vb = new baglanti();
        vb.baglan();
        List<String> tarihlist=new ArrayList<>();
        try{
            String sorgu="select date(tarih) from odenen_siparisler where date(tarih) between '"+baslangictarih+"' and '"+bitistarih+"'";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()){
                tarihlist.add(rs.getString(1));
                
            }
            
            return tarihlist;
        }catch(Exception e){
            System.out.println("iki tarih arasindaki verileri alirken hata olustu");
            return tarihlist;
        }
    }
    
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSiparis_no() {
        return siparis_no;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public void setSiparis_no(String siparis_no) {
        this.siparis_no = siparis_no;
    }
    

  

    public int getMasa_no() {
        return masa_no;
    }

    public void setMasa_no(int masa_no) {
        this.masa_no = masa_no;
    }

    public int getUrun_kodu() {
        return urun_kodu;
    }

    public void setUrun_kodu(int urun_kodu) {
        this.urun_kodu = urun_kodu;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String getOdeme_tipi() {
        return odeme_tipi;
    }

    public void setOdeme_tipi(String odeme_tipi) {
        this.odeme_tipi = odeme_tipi;
    }

    public float getIndirim_orani() {
        return indirim_orani;
    }

    public void setIndirim_orani(float indirim_orani) {
        this.indirim_orani = indirim_orani;
    }
    
    
}
