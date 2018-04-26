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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ozkan
 */
public class kullanicilar {
    private String kullanici_adi, sifre;
    private String durum;
    
    PreparedStatement ps;
    ResultSet rs;
    public List<kullanicilar> kullaniciGetir(){
        List<kullanicilar> list = new ArrayList<>();    
        try{
            sqlsorgular.baglanti vb = new baglanti();
            vb.baglan();
            kullanicilar[] kullanici;
            String sorgu = "select * from kullanicilar";
            ps= vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            int sayac =0;
            while(rs.next())
                sayac++;
            kullanici = new kullanicilar[sayac];
            int i=0;
            String sorgu2=sorgu;
            ps= vb.con.prepareStatement(sorgu2);
            rs = ps.executeQuery(sorgu2);
            while(rs.next()){
                kullanici[i]=new kullanicilar();
                kullanici[i].setKullanici_adi(rs.getString("kullanici_adi"));
                kullanici[i].setSifre(rs.getString("sifre"));
                kullanici[i].setDurum(rs.getString("Durum"));
                list.add(kullanici[i]);
                i++;
                
            }
            vb.con.close();
            return list;
            
        }catch (Exception e){
            Logger.getLogger(kullanicilar.class.getName()).log(Level.SEVERE, null, e);
            return list;
        }
    }
    
    public boolean KullaniciSil(int idkullanici) throws SQLException{
            baglanti vb = new baglanti();
            boolean durum=false;
            try{
            vb.baglan();
            }
            catch(Exception e){
                System.out.println("Bağlantı sağlanamadı"+e);
            }
           try{
            String sorgu3 = "delete from kullanicilar where idkullanicilar='"+idkullanici+"'";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            durum = true;
            
            return true;
            }
            catch(Exception e){
                System.out.println(e);
                durum=false;
                return false;
            }finally{
               vb.con.close();
           }
       }
    public boolean KullaniciGuncelle(int idkullanicilar,String kullanici_adi, String sifre, String durum){
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu ="UPDATE kullanicilar SET kullanici_adi='"+kullanici_adi+"', Durum='"+durum+"', sifre='"+sifre+"' where idkullanicilar="+idkullanicilar+"";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            System.out.println("güncellede");
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(urunler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    public boolean KullaniciEkle(String kullanici_adi, String sifre, String durum) throws SQLException {//Ürün resimleri eklenecek
        baglanti vb = new baglanti();
        vb.baglan();
        int kullanici_no=5;
        String sorgu = "INSERT INTO kullanicilar (kullanici_no, kullanici_adi, durum, sifre,admin) VALUES ('" + kullanici_no + "','" + kullanici_adi + "','" + durum + "','"+sifre+"', "+false+")";
        kullanici_no++;
        try {
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            ps.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            vb.con.close();
            ps.close();
            return false;
        }

    }
        public int KullaniciNo_Bul(String kullanici_adi, String sifre, String durum) throws SQLException{
        // gelen degerlere gore kullanici no bulunur   
        try{
               baglanti vb= new baglanti();
               vb.baglan();
               int kullaniciid = 0, kullanicino=0;
               String sorgu = "select idkullanicilar from kullanicilar where kullanici_adi='"+kullanici_adi+"' and sifre='"+sifre+"' and"
                       + " durum='"+durum+"';";
               
               ps= vb.con.prepareStatement(sorgu);
               
               rs = ps.executeQuery(sorgu);
               while(rs.next()){
                    kullaniciid=rs.getInt(1);
               }
               String sorgu2="select kullanici_no from kullanicilar where idkullanicilar="+kullaniciid+"";
               ps= vb.con.prepareStatement(sorgu2);
               
               rs = ps.executeQuery(sorgu2);
               while(rs.next()){
                    kullanicino=rs.getInt(1);
               } 
               
               return kullanicino;
        
           }catch(Exception e){
               Logger.getLogger(kullanicilar.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }
    
    public int KullaniciNoBulByid(int kullanici_id) throws SQLException{
        // kullanici id ye gore kullanici no cekilir
           try{
               baglanti vb= new baglanti();
               vb.baglan();
               int kullanicino = 0;
               String sorgu = "select kullanici_no from kullanicilar where idkullanicilar="+kullanici_id+";";
               
               ps= vb.con.prepareStatement(sorgu);
               
               rs = ps.executeQuery(sorgu);
               while(rs.next()){
                    kullanicino=rs.getInt(1);
               }
                return kullanicino;
        
           }catch(Exception e){
               Logger.getLogger(kullanicilar.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }
    
    public List<Integer> iliskMasaMasaNoCek(int kullanici_no) throws SQLException{
        // kullanici no ya gore ilisk_mas atablosundaki masa nolar cekilir
        sqlsorgular.baglanti vb =new baglanti();
        vb.baglan();
        List<Integer> MasaNo= new ArrayList<>();
        try{
            String sorgu="select masa_no from ilisk_masa where kullanici_no="+kullanici_no+"";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            
            while(rs.next()){
                MasaNo.add(rs.getInt(1));
            }
            return MasaNo;
        }catch(Exception e){
            Logger.getLogger(kullanicilar.class.getName()).log(Level.SEVERE, null, e);
            return MasaNo;
        }
    }
    public List<Integer> iliskMutfakUrunKodCek(int kullanici_no) throws SQLException{
        
        // kullanici no ya gore ilikimutfak tablosundan urun kodlari alinir
        sqlsorgular.baglanti vb =new baglanti();
        vb.baglan();
        List<Integer> UrunKod= new ArrayList<>();
        try{
            String sorgu="select urun_kodu from iliski_mutfak where kullanici_no="+kullanici_no+"";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            
            while(rs.next()){
                UrunKod.add(rs.getInt(1));
            }
            return UrunKod;
        }catch(Exception e){
            Logger.getLogger(kullanicilar.class.getName()).log(Level.SEVERE, null, e);
            return UrunKod;
        }
    }
    public int Kullaniciid_Bul(String kullanici_adi, String sifre, String durum) throws SQLException{
           try{
               baglanti vb= new baglanti();
               vb.baglan();
               int kullaniciid = 0;
               String sorgu = "select idkullanicilar from kullanicilar where kullanici_adi='"+kullanici_adi+"' and sifre='"+sifre+"' and"
                       + " durum='"+durum+"';";
               
               ps= vb.con.prepareStatement(sorgu);
               
               rs = ps.executeQuery(sorgu);
               while(rs.next()){
                    kullaniciid=rs.getInt(1);
               }
                return kullaniciid;
        
           }catch(Exception e){
               Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
               return 0;
           }
       }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

   
    
    
}
