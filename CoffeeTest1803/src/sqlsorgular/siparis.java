/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

//import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author fadime
 */
public class siparis {
       private  String urun_adi, not,masa_no, siparis_no;
       private  int adet,urun_kodu;
       private int idsiparisler;
       String tarih;
       PreparedStatement ps;
       ResultSet rs;
       public List<siparis> Siparis_al() throws SQLException{
           
        List<siparis> liste = new ArrayList<>();
        try{   
           baglanti vb= new baglanti();
           vb.baglan();
           //List<siparis> liste = new ArrayList<>();
           siparis[] siparisler;
           String sorgu = "select s.adet, u.urun_adi, s.siparis_no, s.masa_no, s.aciklama from siparisler s, urunler u "
                   + "where s.urun_kodu = u.urun_kodu";
           ps= vb.con.prepareStatement(sorgu);
           rs = ps.executeQuery(sorgu);
           int sayac =0;
           while(rs.next())
               sayac++;
           siparisler = new siparis[sayac];
           int i =0;
           String sorgu2= "select s.adet, u.urun_adi, s.siparis_no, s.masa_no, s.aciklama from siparisler s, urunler u "
                   + "where s.urun_kodu = u.urun_kodu";
           ps= vb.con.prepareStatement(sorgu2);
           rs = ps.executeQuery(sorgu2);
            
           while(rs.next()){
               siparisler[i] = new siparis();
               siparisler[i].setSiparis_no(rs.getString("siparis_no"));
               siparisler[i].setMasa_no(rs.getString("masa_no"));
               siparisler[i].setUrun_adi(rs.getString("urun_adi"));
               siparisler[i].setAdet(rs.getInt("adet"));
               siparisler[i].setNot(rs.getString("aciklama"));
               liste.add(siparisler[i]);
               i++;
           }
           vb.con.close();
           return liste;
        }catch(Exception e) {
             Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
             return liste;
        }
       }
       
       public boolean siparisSil(int idsiparisler) throws SQLException{
            baglanti vb = new baglanti();
            boolean durum=false;
            try{
            vb.baglan();
            }
            catch(Exception e){
                System.out.println("Bağlantı sağlanamadı"+e);
            }
            try{
                //Siparis TABLOSUNDAN VERİLERİ AL
          //  Statement st = vb.con.createStatement();
            String sorgu = "select *, DATE_FORMAT(tarih, '%Y-%m-%d %H:%i:%s') from siparisler where idsiparisler='"+idsiparisler+"'";
            
            ps = vb.con.prepareStatement(sorgu);
            Statement st = vb.con.createStatement();
            rs = st.executeQuery(sorgu);
            
            
            while(rs.next()){
                siparis_no = rs.getString("siparis_no");
                masa_no = rs.getString("masa_no");
                urun_kodu = rs.getInt("urun_kodu");
                adet = rs.getInt("adet");
               tarih = rs.getString(8);
                not= rs.getString("aciklama");
            }
            durum=true;
            }catch(Exception e){
                System.out.println(e);
                durum=false;
            }
            //.........SİLİNEN TABLOSUNA EKLEME.................
            if(durum){
            try{
                //tarih = dateFormat.format(tarih.getTime());
            String sorgu2 = "insert into silinen_siparisler"
                    + " (siparis_no, masa_no, urun_kodu, adet, tarih, ozellik) "
                    + "values"
                    + "('"+siparis_no+"', '"+masa_no+"', '"+urun_kodu+"', '"+adet+"', '"+tarih+"', '"+not+"');";
            ps = vb.con.prepareStatement(sorgu2);
            Statement st = vb.con.createStatement();
            
            ps.executeUpdate();
            durum = true;
            }
            catch(Exception e){
                System.out.println(e);
                durum=false;
                return false;
            }
            // ..........siparisler TABLOSUNDAN SİL ...........
            if(durum){
            try{
            String sorgu3 = "delete from siparisler where idsiparisler='"+idsiparisler+"'";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            durum = true;
            }
            catch(Exception e){
                System.out.println(e);
                durum=false;
                return false;
            }
            }
            return true;
            }
            return false;
       }
       
       public int siparisid_Bul(String siparis_no, String masa_no, int urun_kodu,int adet) throws SQLException{
           try{
               baglanti vb= new baglanti();
               vb.baglan();
               int siparisid = 0;
               String sorgu = "select idsiparisler from siparisler where siparis_no='"+siparis_no+"' and masa_no='"+masa_no+"' and"
                       + " urun_kodu='"+urun_kodu+"' and adet='"+adet+"';";
               
               ps= vb.con.prepareStatement(sorgu);
               
               rs = ps.executeQuery(sorgu);
               while(rs.next()){
                    siparisid=rs.getInt(1);
               }
               
               
                return siparisid;
        
           }catch(Exception e){
               Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }
       
       public int urunkoduGetir(String urun_adi) throws SQLException{
           try{
                baglanti vb= new baglanti();
               vb.baglan();
               int urun_kodu=0;
               Statement st = vb.con.createStatement();
               String sorgu ="select urun_kodu from urunler where urun_adi='"+urun_adi+"'";
               ps= vb.con.prepareStatement(sorgu);
               rs = st.executeQuery(sorgu);
               
               while(rs.next()){
                    urun_kodu=rs.getInt(1);
               }
               
               
                return urun_kodu;
               
           }catch(Exception e){
               Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }
       
       public boolean siparisReddet(int idsiparisler) throws SQLException{
            baglanti vb = new baglanti();
            boolean durum=false;
            try{
            vb.baglan();
            }
            catch(Exception e){
                System.out.println("Bağlantı sağlanamadı"+e);
            }
           try{
            String sorgu3 = "delete from siparisler where idsiparisler='"+idsiparisler+"'";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            durum = true;
            return true;
            }
            catch(Exception e){
                System.out.println(e);
                durum=false;
                return false;
            }
       }
       public int siparisidAl() throws SQLException{
           List<siparis> liste = new ArrayList<>();
           try{
               baglanti vb= new baglanti();
               vb.baglan();
               siparis[] siparisler;
               String sorgu = "select idsiparisler from siparisler ";
               ps= vb.con.prepareStatement(sorgu);
               rs = ps.executeQuery(sorgu);
               int sayac =0;
               while(rs.next())
                    sayac++;
               siparisler = new siparis[sayac];
               int i =0;
               String sorgu2= sorgu;
               ps= vb.con.prepareStatement(sorgu2);
               rs = ps.executeQuery(sorgu2);
               while(rs.next()){
                    siparisler[i] = new siparis();
                    siparisler[i].setIdsiparisler(rs.getInt("idsiparisler"));
                    liste.add(siparisler[i]);
                    i++;
                    
           }
               
               
           return i;
        
           }catch(Exception e){
               Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

   
    

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }

    public String getMasa_no() {
        return masa_no;
    }

    public int getUrun_kodu() {
        return urun_kodu;
    }

    public void setUrun_kodu(int urun_kodu) {
        this.urun_kodu = urun_kodu;
    }

    public void setMasa_no(String masa_no) {
        this.masa_no = masa_no;
    }

    public String getSiparis_no() {
        return siparis_no;
    }

    public void setSiparis_no(String siparis_no) {
        this.siparis_no = siparis_no;
    }

    
 
    public int getIdsiparisler() {
        return idsiparisler;
    }

    public void setIdsiparisler(int idsiparisler) {
        this.idsiparisler = idsiparisler;
    }
       
    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    private String String(String sorgu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
}
