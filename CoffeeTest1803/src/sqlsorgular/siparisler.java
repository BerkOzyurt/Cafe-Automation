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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ozkan
 */
public class siparisler {

    PreparedStatement ps;
    ResultSet rs;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localDate = LocalDateTime.now();
    String Siparis_No;
    private String siparis_No, Tarih, Urun_Adi, Urun_Ozellik;
    private int Urun_Kodu, Urun_Adet;
    private float Urun_Fiyat;
    public boolean SiparisOlustur(int[] urunKodu, int[] adet, String[] ozellik, int masa) {
        //Yeni bir sipariş oluşturulur. Bu metot <SiparisVerAction.java> sınıfından çağırılır
        System.out.println("Siparis veriyorum");
        String siparisNo = "";
        boolean durum1= false;
        try{
            durum1 = SiparisNumarasiSorgula(masa);
            System.out.println("durum1: "+durum1);
        } //Seçili masanın aktif bir siparişi var mı
        catch(SQLException e){
            durum1 = false;
        }
        System.out.println("durum :"+durum1);
        if (durum1) { //Eğer var ise sorgudan dönen sipariş numarasını kullan
            siparisNo = Siparis_No;
         } 
        else { //yok ise yeni bir sipariş numarası oluştur
        try {
            siparisNo = SiparisNumarasiAl(); //yeni bir sipariş numarası oluştur
        } catch (SQLException ex) {
            Logger.getLogger(siparisler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            }
        }
        //Ürünkodu gelmiyor
        System.out.println("urunkodu"+urunKodu);
        System.out.println("Siparisnoooo: "+siparisNo); 
        if(siparisNo == null) //Yapılan tüm kontrollere rağmen sipariş numarası hal null ise
             return false;  //false döndür.
        System.out.println("ya burası");
        //Sipariş numarasını elde ettik şimdi veritabanına gönderme işlemlerine geçiyoruz
        baglanti vb = new baglanti();
        vb.baglan();
        String tarih = dtf.format(localDate); 
        if (urunKodu.length == 0) {
            System.out.println("u"+urunKodu);
            System.out.println("Buradan fırlat");
            return false;
        }
        System.out.println(urunKodu.length);
        for (int i = 0; i < urunKodu.length; i++) {
            //Ürümlerimt tamamı siparişler tablosuna eklenir
            String sorgu = "INSERT INTO siparisler (siparis_no, masa_no, urun_kodu, adet, tarih, aciklama) VALUES ('" + siparisNo + "'," + masa + ""
                    + "," + urunKodu[i] + ", " + adet[i] + ", '" + tarih + "', '" + ozellik[i] + "')";
           try {
                ps = vb.con.prepareStatement(sorgu); //INSERT sorgusunu gönder
                ps.executeUpdate();
                System.out.println("insert başarılı");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "HATA", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
                
                return false;
            }
        
        }
        System.out.println("durumlar tablosuna geçiş");
        boolean durum=false;
        try {
            durum = DurumlarTablosunaKaydet(masa, siparisNo,true); //Masa_durum tablosu güncelleniyor
        } catch (SQLException ex) {
            Logger.getLogger(siparisler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            vb.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(siparisler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return durum;

    }
    //Yeni bir sipariş numarası yaratan metot
    public String SiparisNumarasiAl() throws SQLException {
        //Son sipariş numarasını alıp onu bir arttırarak bir sipariş numarası oluşturuluyor
        baglanti vb = new baglanti();
        vb.baglan();
        int OdenenSiparis = 0;int Siparisler = 0; int silinen_sip = 0;
        int SonSiparis = 0;
        String sorgu = "SELECT siparis_no FROM odenen_siparisler where id=(Select max(id) from odenen_siparisler)";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        while (rs.next()) {
            if(rs.getString(1)!=null && !rs.getString(1).equals(""))
                OdenenSiparis = Integer.parseInt(rs.getString(1));
        }
        if(OdenenSiparis>SonSiparis)
            SonSiparis=OdenenSiparis;
        String sorgu2 = "SELECT siparis_no FROM siparisler where idsiparisler=(Select max(idsiparisler) from siparisler)";
        ps = vb.con.prepareStatement(sorgu2);
        rs = ps.executeQuery();
        while (rs.next()) {
            if(rs.getString(1)!=null && !rs.getString(1).equals(""))
                Siparisler = Integer.parseInt(rs.getString(1));
        }
        if(Siparisler>SonSiparis)
            SonSiparis=Siparisler;
        String sorgu3 = "SELECT siparis_no FROM silinen_siparisler where id=(Select max(id) from silinen_siparisler)";
        ps = vb.con.prepareStatement(sorgu3);
        rs = ps.executeQuery();
        while (rs.next()) {
            if(rs.getString(1)!=null && !rs.getString(1).equals(""))
                silinen_sip = Integer.parseInt(rs.getString(1));
        }
        if(silinen_sip>SonSiparis)
            SonSiparis=silinen_sip;
        String siparisNo = "";
        System.out.println("Son siparis: "+SonSiparis);
        siparisNo = String.valueOf(SonSiparis + 1);
        return siparisNo;
    }
    
    public boolean SiparisNumarasiSorgula(int masano) throws SQLException{ 
    //Gelen masaya ait sipariş numarası var mı onu sorgular eger varsa değer olarak o sipariş numarasini döndürür
    //böylelikle ayni sipariş numarasiyla farklı defalarda sipariş verilir. Her masanin bir sipariş numarası olmuş olur
        baglanti vb = new baglanti();
        vb.baglan();
        String siparisno = null;
        System.out.println("siparisno sorghula");
        System.out.println("masano: "+masano);
        String sorgu = "SELECT siparis_no FROM masa_durum where masa_no=" + masano + "";
        try {
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery();
            while (rs.next()) {
                siparisno = rs.getString(1);
            }
            System.out.println("siparisnomm1: "+siparisno);
            //siparisno = siparisno.trim();
            if(siparisno==null)
                return false;
            System.out.println("siparisnuamrasisorgula: "+siparisno);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("burada");
            return false;
        }

        if (siparisno.trim() != null && !siparisno.trim().equals("") && siparisno.length()>=1) {
            Siparis_No = siparisno; //sipariş numarasi döndürülür
            return true;
        }
        System.out.println("sioarisno:" + siparisno);
        return false;
    }

    public boolean DurumlarTablosunaKaydet(int masa_no, String siparis_no, boolean durum) throws SQLException {
        //masa_durum tablosunda masa_no bilgisine göre UPDATE yöntemiyle sipariş numarası veritabanına yazılıyor 
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "UPDATE masa_durum SET siparis_no='" + siparis_no + "', durum=" + durum + " where masa_no=" + masa_no + "";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Hata: " + e.getMessage());
            return false;
        }
    }
    
    public List<sqlsorgular.siparisler> SiparisleriAlByMasaNo(int masano) throws SQLException{
         baglanti vb = new baglanti();
         vb.baglan();
        List<sqlsorgular.siparisler> liste = new ArrayList<>();
        siparisler[] siparis;
        String sorgu;
        sorgu="select s.*, u.urun_adi,u.fiyat from silinen_siparisler s JOIN fiyatlar u ON u.urun_kodu=s.urun_kodu where s.masa_no="+masano+"";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac=0;
         while(rs.next()){
            sayac++;
        }
        siparis=new siparisler[sayac];
        int i =0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while(rs.next()){
              siparis[i] = new siparisler();
              siparis[i].setSiparis_No(rs.getString("siparis_no"));
              siparis[i].setUrun_Kodu(rs.getInt("urun_kodu"));
              siparis[i].setUrun_Adet(rs.getInt("adet"));
              siparis[i].setUrun_Adi(rs.getString("urun_adi"));
              siparis[i].setUrun_Fiyat(rs.getFloat("fiyat"));
              siparis[i].setTarih(rs.getString("tarih")); 
              siparis[i].setUrun_Ozellik(rs.getString("ozellik"));
              liste.add(siparis[i]);
              i++;
          }
          return liste;
    }
    public boolean OdemeYap(String siparisNo, String odemeTipi, int indirim) throws SQLException{
         baglanti vb = new baglanti();
         vb.baglan();
         try{
            String sorgu = "INSERT INTO odeme (siparis_no, odeme_tipi, indirim_orani) VALUES ('"+siparisNo+"', '"+odemeTipi+"', "+indirim+")";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            return true;
         }catch(SQLException e){
             System.err.println("Odeme Yaparken Hata: "+e.getMessage());
             return false;
         }
    }
    public boolean OdenenlerTablosunaEkle(String siparisNo, int masano) throws SQLException{
        //Bu metot ödenenler tablosuna ekler, silinen_siparisler tablosundan siler, durumlar tablosunu günceller
        List<siparisler> siparisList = new ArrayList<>();
        try {
            siparisList = SiparisleriAlByMasaNo(masano);
        } catch (SQLException ex) {
            Logger.getLogger(siparisler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!siparisList.get(0).getSiparis_No().equals(siparisNo)){
            return false;
        }
       try{ 
        baglanti vb = new baglanti();
        vb.baglan();
        String sorgu = "INSERT INTO odenen_siparisler (siparis_no, masa_no, urun_kodu, adet, tarih, ozellik) "
                + "VALUES ('"+siparisList.get(0).getSiparis_No()+"', "+masano+", "+siparisList.get(0).getUrun_Kodu()+", "
                + ""+siparisList.get(0).getUrun_Adet()+", '"+siparisList.get(0).getTarih()+"', "
                + "'"+siparisList.get(0).getUrun_Ozellik()+"')";
        ps = vb.con.prepareStatement(sorgu);
        ps.executeUpdate();
        boolean d1, d2;
        d1 = SilinenlerdenSil(siparisNo); //Silinen siparişler tablosundaki veriyi siliyoruz. O veri artık öndenenler tablosunda
           System.out.println("d1: "+d1);
        d2 = DurumlarTablosunaKaydet(masano, "", false); //masa_durum tablosu güncelleniyor. Masa müsait olarak kaydediliyor
           System.out.println("d2: "+d2);
        return true;
       }catch(SQLException e){
           System.err.println("Hata: "+e.getMessage());
           return false;
       }
    }
    public boolean SilinenlerdenSil(String siparisno) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        try{
           String sorgu = "DELETE FROM silinen_siparisler WHERE siparis_no='"+siparisno+"'";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            return true;
        }catch(SQLException e){
            System.err.println("Slinenlerden silerken hata: "+e.getMessage());
            return false;
        }
    }
    public String getSiparis_No() {
        return Siparis_No;
    }

    public void setSiparis_No(String Siparis_No) {
        this.Siparis_No = Siparis_No;
    }

    public String getUrun_Ozellik() {
        return Urun_Ozellik;
    }

    public void setUrun_Ozellik(String Urun_Ozellik) {
        this.Urun_Ozellik = Urun_Ozellik;
    }

    public float getUrun_Fiyat() {
        return Urun_Fiyat;
    }

    public void setUrun_Fiyat(float Urun_Fiyat) {
        this.Urun_Fiyat = Urun_Fiyat;
    }
    
    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String Tarih) {
        this.Tarih = Tarih;
    }

    public int getUrun_Kodu() {
        return Urun_Kodu;
    }

    public void setUrun_Kodu(int Urun_Kodu) {
        this.Urun_Kodu = Urun_Kodu;
    }

    public int getUrun_Adet() {
        return Urun_Adet;
    }

    public String getUrun_Adi() {
        return Urun_Adi;
    }

    public void setUrun_Adi(String Urun_Adi) {
        this.Urun_Adi = Urun_Adi;
    }

    public void setUrun_Adet(int Urun_Adet) {
        this.Urun_Adet = Urun_Adet;
    }
    
}
