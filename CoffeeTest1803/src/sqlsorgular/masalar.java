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
public class masalar {

    PreparedStatement ps;
    ResultSet rs, rs1;
    private String Masa_Adi;
    private int Masa_No;

    public int MasaAdet() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int adet = 0;
        String sorgu = "SELECT COUNT(*) FROM masalar i";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        while (rs.next()) {
            adet = rs.getInt(1);
        }
        return adet;
    }

    public List<masalar> MasaAdlari() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<masalar> liste = new ArrayList<>();
        masalar[] masa;
        String sorgu;
        sorgu = "select * from masalar";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        masa = new masalar[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            masa[i] = new masalar();
            masa[i].setMasa_No(rs.getInt("masa_no"));
            masa[i].setMasa_Adi(rs.getString("masa_adi"));
            liste.add(masa[i]);
            i++;
        }
        vb.con.close();
        return liste;
        
    }

    public List<Integer> MusaitMasalar() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<Integer> liste = new ArrayList<>();
        masalar[] masa;
        String sorgu;
        sorgu = "select masa_no from masa_durum where durum=1";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            liste.add(rs.getInt(1));
        }
        vb.con.close();
        return liste;
    }

    public List<String> MutfakKullaniciAl() throws SQLException { //mutfak kullanicilari cekilir
         baglanti vb = new baglanti();
        List<String> liste = new ArrayList<>();
        try {
           
            vb.baglan();
            String sorgu = "select kullanici_adi from kullanicilar where durum= 'MUTFAK'";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                liste.add(rs.getString(1));
            }

            return liste;
        } catch (Exception e) {
            System.out.println("Mutfak kullanicilarini alirken hata olustu " + e);
            return liste;
        }
        finally{
            vb.con.close();
        }
    }

    public List<String> GarsonKullaniciAl() throws SQLException { //garson kullanicilari alinir
        baglanti vb = new baglanti();
        List<String> liste = new ArrayList<>();
        try {
            
            vb.baglan();
            String sorgu = "select kullanici_adi from kullanicilar where durum= 'GARSON'";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                liste.add(rs.getString(1));
            }

            return liste;
        } catch (Exception e) {
            System.out.println("Garson kullanicilarini alirken hata olustu " + e);
            return liste;
        }
        finally{
            vb.con.close();
        }
    }

    public boolean MasaSil(int masa_no) throws SQLException { //masa no ya gore silme islemi gerceklesir
        baglanti vb = new baglanti();

        try {
            vb.baglan();
        } catch (Exception e) {
            System.out.println("Bağlantı sağlanamadı" + e);
        }
        try {
            String sorgu3 = "DELETE m,i FROM masalar m LEFT JOIN ilisk_masa i ON m.masa_no=i.masa_no WHERE m.masa_no=" + masa_no + "";

            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        finally{
            vb.con.close();
        }
    }

    public boolean MasaGuncelle(String masa_adi, int kullanici_no, int oncekikullanici_no, int masa_no) {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "update masalar as m, ilisk_masa i "
                    + "set m.masa_adi='" + masa_adi + "', i.kullanici_no=" + kullanici_no
                    + " where m.masa_no = i.masa_no and m.masa_no = " + masa_no + " and i.kullanici_no= " + oncekikullanici_no + ";";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            System.out.println("güncellede");
            ps.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            try {
                vb.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int MasalarmasaEkle(String masa_adi) {
        //once masalar tablosuna ekleme yapilir ve ekleme yapildiktan sonra masa_no dondurur
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            int masa_no = 0;
            // masalar tablosundaki en son id ye gore masa_no yu getirir
            String sorgu = "select masa_no from masalar where idmasalar= (select idmasalar from masalar order by idmasalar desc limit 0, 1)";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                masa_no = rs.getInt(1);
            }
            masa_no = masa_no + 1;
            String sorgu2 = "insert into masalar (masa_no, masa_adi) values (" + masa_no + ", '" + masa_adi + "')";
            ps = vb.con.prepareStatement(sorgu2);
            ps.executeUpdate();
            String sorgu3 = "insert into masa_durum (masa_no, durum) values (" + masa_no + ", 0)";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            return masa_no;
        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
        finally{
            try {
                vb.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean iliskMasaEkleme(int masa_no, int kullanici_no) {
        //donen masa_no ya gore ilisk_masa tablosuna ekleme yapilir
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu3 = "insert into ilisk_masa (kullanici_no, masa_no) values (" + kullanici_no + ", " + masa_no + ")";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            vb.con.close();
            ps.close();
            
            return true;
        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public List<String> Mutfakkullanici(int masa_no) throws SQLException {
        //gelen masa_no ya gore mutfak kullanicilari alinir
        ArrayList<Integer> kull = new ArrayList<>();
        ArrayList<String> kullad = new ArrayList<>();
        sqlsorgular.baglanti vb = new baglanti();
        vb.baglan();
        try {

            String sorgu = "select kullanici_no from ilisk_masa where masa_no=" + masa_no + ";";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);

            while (rs.next()) {
                kull.add(rs.getInt(1));
            }
            System.out.println("mutfak kullanici girdi");
            System.out.println(kull);
        } catch (Exception e) {
            System.out.println("Mutfak kullanicisini alirken hata olustu");
            return null;
        }

        for (Integer kullanici_no : kull) {
            boolean durum = false;
            String deger = "";
            String sorgu2 = "select kullanici_adi from kullanicilar where kullanici_no=" + kullanici_no + " and durum='MUTFAK';";
            try {
                ps = vb.con.prepareStatement(sorgu2);
                rs1 = ps.executeQuery(sorgu2);
                while (rs1.next()) {
                    deger = rs1.getString(1);

                    if (deger != null) {
                        kullad.add(deger);
                        System.out.println("null");
                        System.out.println(deger);
                    }
                    System.out.println(kullad);
                    durum = true;
                }
            } catch (Exception e) {
                durum = false;
            }

            System.out.println(kullad);

        }
        vb.con.close();
        return kullad;

    }

    public List<String> Garsonkullanici(int masa_no) throws SQLException {
        //gelen masa_no ya gore garson kullanicilari alinir
        ArrayList<Integer> kull = new ArrayList<>();
        ArrayList<String> kullad = new ArrayList<>();
        sqlsorgular.baglanti vb = new baglanti();
        vb.baglan();
        try {

            String sorgu = "select kullanici_no from ilisk_masa where masa_no=" + masa_no + ";";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);

            while (rs.next()) {
                kull.add(rs.getInt(1));
            }
            System.out.println(kull);
        } catch (Exception e) {
            System.out.println("Garson kullanicisini alirken hata olustu");

        }

        for (Integer kullanici_no : kull) {
            String deger = " ";
            String sorgu2 = "select kullanici_adi from kullanicilar where kullanici_no=" + kullanici_no + " and durum='GARSON';";
            try {
                ps = vb.con.prepareStatement(sorgu2);
                rs = ps.executeQuery(sorgu2);
                while (rs.next()) {
                    deger = rs.getString(1);

                    if (deger != null) {
                        kullad.add(deger);
                    }
                }
            } catch (Exception e) {
                System.out.println("Garson kullanici Alinirken hata oldu");
            }

            System.out.println(kullad);

        }
        vb.con.close();
        return kullad;

    }

    public int Kullanicino_Bul(String kullanici_adi) throws SQLException {
        //gelen kullanici adina gore kullanici_nosu dondurulur
        baglanti vb = new baglanti();
        try {
            
            vb.baglan();
            int kullanicino = 0;
            String sorgu = "select kullanici_no from kullanicilar where kullanici_adi='" + kullanici_adi + "';";

            ps = vb.con.prepareStatement(sorgu);

            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                kullanicino = rs.getInt(1);
            }
            return kullanicino;

        } catch (Exception e) {
            Logger.getLogger(siparis.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
        finally{
            vb.con.close();
        }
    }

    public int Masaid_Bul(String masa_adi) throws SQLException {
        //gelen masa_adina gore masaidsi getirilir
        baglanti vb = new baglanti();
        try {
            
            vb.baglan();
            int masaid = 0;
            String sorgu = "select idmasalar from masalar where masa_adi='" + masa_adi + "';";

            ps = vb.con.prepareStatement(sorgu);

            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                masaid = rs.getInt(1);
            }

            return masaid;

        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
        finally{
            vb.con.close();
        }
    }

    public boolean iliskiMutfakEkleme(int kullanici_no, int urun_kodu) {
        //donen masa_no ya gore ilisk_masa tablosuna ekleme yapilir
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu3 = "insert into iliski_mutfak (kullanici_no, urun_kodu) values (" + kullanici_no + ", " + urun_kodu + ")";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            vb.con.close();
            ps.close();
            return true;
        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean iliskMasaSil(int kullanici_no) {
        //donen masa_no ya gore ilisk_masa tablosunda silme yapilir
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu3 = "delete ilisk_masa from ilisk_masa where kullanici_no=" + kullanici_no + "";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            vb.con.close();
            return true;
        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            try {
                vb.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    public boolean iliskMutfakSil(int kullanici_no) {
        //donen masa_no ya gore ilisk_masa tablosunda silme yapilir
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu3 = "delete iliski_mutfak from iliski_mutfak where kullanici_no=" + kullanici_no + "";
            ps = vb.con.prepareStatement(sorgu3);
            ps.executeUpdate();
            vb.con.close();
            return true;
        } catch (Exception e) {
            Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public String MasaAdi_Bul(int masa_no) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "select masa_adi from masalar where masa_no=" + masa_no + "";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            String masa_adi = null;
            while (rs.next()) {
                masa_adi = rs.getString(1);
            }
            System.out.println("masa adi = " + masa_adi);
            return masa_adi;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            return null;
        }
        finally{
            vb.con.close();
        }
    }

    public String getMasa_Adi() {
        return Masa_Adi;
    }

    public void setMasa_Adi(String Masa_Adi) {
        this.Masa_Adi = Masa_Adi;
    }

    public int getMasa_No() {
        return Masa_No;
    }

    public void setMasa_No(int Masa_No) {
        this.Masa_No = Masa_No;
    }

}
