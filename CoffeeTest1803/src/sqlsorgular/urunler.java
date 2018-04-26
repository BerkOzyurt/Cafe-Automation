/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

import Yonetim.KategoriEkle;
import Yonetim.UrunEkle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ozkan
 */
public class urunler {

    /**
     * bu classta yapılanlar
     */

    PreparedStatement ps;
    ResultSet rs;
    private int UrunGrup_adet, Urun_adet;
    private String UrunGrup_adi, Ozellik_adi;
    private int UrunGrup_no, grup_no, UstUrunGrup_No;
    private String Urun_adi;
    private int Urun_kodu;
    private int Ozellik_kodu;
    private float Ozellik_fiyat, Urun_fiyat;
    private String UrunAdi;
    private String urun_adi;

    public List<urunler> UrunDetayByUrunKodu(int urunKodu) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> liste = new ArrayList<>();
        urunler[] urungrup;
        String sorgu;
        sorgu = "SELECT u.urun_adi, u.ust_grup_no, f.fiyat FROM urunler u, fiyatlar f where u.urun_kodu=f.urun_kodu and u.urun_kodu=" + urunKodu + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urungrup = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urungrup[i] = new urunler();
            urungrup[i].setUrun_adi(rs.getString(1));
            urungrup[i].setUrun_kodu(urunKodu);
            urungrup[i].setUrunGrup_no(rs.getInt(2));
            urungrup[i].setUrun_fiyat(rs.getFloat(3));
            liste.add(urungrup[i]);
            i++;
        }
        vb.con.close();
        return liste;
    }

    //Ürün Gruplarının Sayısını Alan Metot
    public int UrunGrupAdet() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int adet = 0;
        String sorgu = "SELECT COUNT(*) FROM urun_gruplari u;";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        while (rs.next()) {
            adet = rs.getInt(1);
        }
        vb.con.close();
        return adet;
    }

    /**
     * ürün gruplarının tam listesini alıyoruz
     *
     *
     */
    public List<urunler> UrunGruplari() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> liste = new ArrayList<>();
        urunler[] urungrup;
        String sorgu;
        sorgu = "select * from urun_gruplari";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urungrup = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urungrup[i] = new urunler();
            urungrup[i].setUrunGrup_adi(rs.getString("grup_adi"));
            urungrup[i].setUrunGrup_no(rs.getInt("grup_no"));
            liste.add(urungrup[i]);
            i++;
        }
        vb.con.close();
        return liste;
    }

    public List<urunler> UrunGrupNoFromUrunler() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> gruplist = new ArrayList<>();
        String sorgu = "SELECT DISTINCT(ust_grup_no), ug.grup_adi FROM urunler u INNER JOIN urun_gruplari ug ON u.ust_grup_no=ug.grup_no";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery();
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urunler[] urun;
        urun = new urunler[sayac];
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int i = 0;
        while (rs.next()) {
            urun[i] = new urunler();
            urun[i].setUrunGrup_no(rs.getInt(1));
            urun[i].setUrunGrup_adi(rs.getString(2));
            gruplist.add(urun[i]);
            i++;
        }
        ps.close();
        rs.close();
        vb.con.close();
        return gruplist;
    }

    public List<urunler> urunadi() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        String urun_adi;
        Statement st = vb.con.createStatement();
        List<urunler> liste = new ArrayList<>();
        urunler[] urun;
        String sorgu;
        sorgu = "select urun_adi from urunler";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urun = new urunler[sayac];
        int i = 0;
        String sorgu2 = "select urun_adi from urunler";
        ps = vb.con.prepareStatement(sorgu2);
        rs = ps.executeQuery(sorgu2);
        while (rs.next()) {
            urun[i] = new urunler();
            urun[i].setUrun_adi(rs.getString("urun_adi"));
            liste.add(urun[i]);
            i++;
        }
        vb.con.close();
        return liste;

    }

    public List<urunler> UrunBulByUrunGrup(int GrupNo) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        String urun_adi;
        Statement st = vb.con.createStatement();
        List<urunler> liste = new ArrayList<>();
        urunler[] urunliste;
        String sorgu;
        sorgu = "select * from urunler where ust_grup_no=" + GrupNo + "";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urunliste = new urunler[sayac];
        int i = 0;

        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urunliste[i] = new urunler();
            urunliste[i].setUrun_adi(rs.getString("urun_adi"));
            urunliste[i].setUrun_kodu(rs.getInt("urun_kodu"));
            liste.add(urunliste[i]);
            i++;
        }
        return liste;

    }

    //Ürüngrubunun adina göre grup numarasini döndürür
    public int UrungrupNoByAd(String ad) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int grupno = 0;
        String sorgu;
        sorgu = "select grup_no from urun_gruplari where grup_adi='" + ad + "'";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            grupno = rs.getInt(1);
        }
        return grupno;
    }

    //Ürüngrup numarasına göre alt gruplarını liste olarak döndürür
    public List<urunler> AltUrunGruplariniBul(int GrupNo) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> liste = new ArrayList<>();
        urunler[] urungrup;
        String sorgu;
        sorgu = "select * from urun_gruplari where ust_grup=" + GrupNo + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urungrup = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urungrup[i] = new urunler();
            urungrup[i].setUrunGrup_adi(rs.getString("grup_adi"));
            urungrup[i].setUrunGrup_no(rs.getInt("grup_no"));
            liste.add(urungrup[i]);
            i++;
        }
        return liste;
    }

    public List<urunler> UrunUstGruplariByGrupNo(int GrupNo) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> liste = new ArrayList<>();
        urunler[] urungrup;
        String sorgu;
        sorgu = "select * from urun_gruplari where grup_no=" + GrupNo + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urungrup = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urungrup[i] = new urunler();
            urungrup[i].setUrunGrup_adi(rs.getString("grup_adi"));
            urungrup[i].setUstUrunGrup_No(rs.getInt("ust_grup"));

            liste.add(urungrup[i]);
            i++;
        }
        vb.con.close();
        ps.close();
        rs.close();
        return liste;
    }

    public List<Integer> UstGruplariGetir() throws SQLException {
        //Tüm üst gruplarin listesi
        baglanti vb = new baglanti();
        vb.baglan();
        List<Integer> liste = new ArrayList<>();
        String sorgu;
        sorgu = "select ust_grup from urun_gruplari";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            if (rs.getInt(1) != 0) {
                liste.add(rs.getInt(1));
            }
        }
        vb.con.close();
        ps.close();
        rs.close();
        return liste;
    }

    public int UrunKoduByAd(String ad, int grupNo) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int urunkodu = 0;
        String sorgu;
        sorgu = "select urun_kodu from urunler where urun_adi='" + ad + "' and ust_grup_no=" + grupNo + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urunkodu = rs.getInt(1);
        }
        vb.con.close();
        ps.close();
        rs.close();
        return urunkodu;

    }

    public int UrunKoduByAd(String ad) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int urunkodu = 0;
        String sorgu;
        sorgu = "select urun_kodu from urunler where urun_adi='" + ad + "'";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urunkodu = rs.getInt(1);
        }
        vb.con.close();
        ps.close();
        rs.close();
        return urunkodu;

    }

    public float UrunFiyatiByUrunKodu(int urunKodu) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        float fiyat = 0.0f;
        String sorgu;
        sorgu = "select fiyat from fiyatlar where urun_kodu=" + urunKodu + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            fiyat = rs.getFloat(1);
        }
        vb.con.close();
        ps.close();
        rs.close();
        return fiyat;
    }

    public List<sqlsorgular.urunler> UrunOzellikleriByUrunKodu(int urunKodu) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        List<urunler> liste = new ArrayList<>();
        urunler[] ozellikliste;
        String sorgu;
        sorgu = "select * from urun_ozellikler where urun_kodu=" + urunKodu + "";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        ozellikliste = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            ozellikliste[i] = new urunler();
            ozellikliste[i].setOzellik_kodu(rs.getInt("ozellik_kodu"));
            ozellikliste[i].setOzellik_adi(rs.getString("ozellik_adi"));
            ozellikliste[i].setOzellik_fiyat(rs.getFloat("fiyat"));
            liste.add(ozellikliste[i]);
            i++;
        }
        vb.con.close();
        ps.close();
        rs.close();
        return liste;
    }

    public boolean UrunEkle(int GrupNo, String UrunAdi, float fiyat, String resimYolu) throws SQLException {//Ürün resimleri eklenecek
        baglanti vb = new baglanti();
        vb.baglan();
        int urunkodu = UrunKoduOlusturucu(GrupNo);
        System.out.println("UrunKodu:"+urunkodu);
        String sorgu = "INSERT INTO urunler (urun_adi, urun_kodu, ust_grup_no) VALUES ('" + UrunAdi + "'," + urunkodu + "," + GrupNo + ")";
        try {
             ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            ps.close();
            UrunFiyatKaydet(urunkodu, fiyat,UrunAdi);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            vb.con.close();
            ps.close();
            return false;
        }

    }

    public boolean UrunFiyatKaydet(int urunKodu, float fiyat, String urunadi) {
        baglanti vb = new baglanti();
        vb.baglan();
        String sorgu = "INSERT INTO fiyatlar (urun_adi, urun_kodu, fiyat) VALUES ('" + urunadi + "'," + urunKodu + "," + fiyat + ")";
        try {
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            vb.con.close();
            ps.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

    }

    public boolean UrunGuncelle(String urunAdi, int urunKodu, int grupNo, float fiyat, String resimYolu) {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "UPDATE urunler SET urun_adi='" + urunAdi + "', urun_kodu=" + urunKodu + ", ust_grup_no=" + grupNo + " where urun_kodu=" + urunKodu + "";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(urunler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            String sorgu2 = "UPDATE fiyatlar SET urun_adi='" + urunAdi + "', urun_kodu=" + urunKodu + ", fiyat=" + fiyat + " where urun_kodu=" + urunKodu + "";
            ps = vb.con.prepareStatement(sorgu2);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(urunler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int UrunKoduOlusturucu(int grupNo) throws SQLException {
        int urunkodu = 0;
        int adet = 0;
        baglanti vb = new baglanti();
        vb.baglan();
        String sorgu;
        while (true) {
            grupNo++;
            sorgu = "SELECT COUNT(*) from urunler where urun_kodu=" + grupNo + "";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            while (rs.next()) {
                adet = rs.getInt(1);
            }
            if(adet==0)
                break;
        }
        return grupNo;
    }

    public boolean UrunSil(int urunKodu) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        String sorgu = "DELETE u,f FROM urunler u LEFT JOIN fiyatlar f ON u.urun_kodu = f.urun_kodu WHERE u.urun_kodu=" + urunKodu + "";
        try {
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "HATA", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean UrunGrubuEkle(int ustGrupno, String grupadi, int seviye) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int grupkodu = 0;
        String sorgu = "";
        try {
            grupkodu = UrunGrupKoduOlusturucu();
        } catch (SQLException ex) {
            Logger.getLogger(urunler.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("GrupKodu oluştururken hata");
        }
        if (grupkodu == 0) {
            System.err.println("GrupKodu oluştururken hata");
        } else {
            sorgu = "INSERT INTO urun_gruplari (grup_adi, grup_no, ust_grup, seviye) VALUES ('" + grupadi + "'," + grupkodu + "," + ustGrupno + ", " + seviye + ")";
        }
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

    public boolean UrunGrubuSil(int grupno) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        String sorgu = "DELETE FROM urun_gruplari WHERE grup_no=" + grupno + "";
        try {
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "HATA", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean UrunGrubuGuncelle(int grupno, int ust_grup, String isim, int seviye) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "UPDATE urun_gruplari SET grup_adi='" + isim + "', grup_no=" + grupno + ", ust_grup=" + ust_grup + ", seviye=" + seviye + " where grup_no=" + grupno + "";
            ps = vb.con.prepareStatement(sorgu);
            ps.executeUpdate();
            ps.close();
            vb.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(urunler.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "HATA", JOptionPane.ERROR_MESSAGE);
            ps.close();
            vb.con.close();
            return false;
        }
    }

    public int Urunkodu_Bul(String urunadi) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "select urun_kodu from urunler where urun_adi='" + urunadi + "'";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            int urunkod = 0;
            while (rs.next()) {
                urunkod = rs.getInt(1);
            }
            System.out.println("urun kodu = " + urunkod);
            return urunkod;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            vb.con.close();
            ps.close();
            return 0;
        }
    }

    private int UrunGrupKoduOlusturucu() throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        int maxGrupKodu = 0;
        String sorgu = "SELECT MAX(grup_no) from urun_gruplari";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            maxGrupKodu = rs.getInt(1);
        }
        return maxGrupKodu + 100;
    }

    public List<sqlsorgular.urunler> SiparisEkraniUrunGruplariListeAl() {
        List<Integer> ustgruplar = null; //Veritabaninda kayıtlı tüm üst gruplari tutmak icin
        HashMap<Integer, String> hashmap = new HashMap<>();
        ArrayList<Integer> sonGrup = new ArrayList<>(); //Listelenmiş grupların numaralarinin tutuldugu liste
        List<sqlsorgular.urunler> grupList = null;
        //Tüm üst gruplarin listesi aliniyor ustgruplar'a ataniyor
        try {
            ustgruplar = new sqlsorgular.urunler().UstGruplariGetir();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("heyhey");
        //
        for (int j = 0; j < ustgruplar.size(); j++) { //veritabanındaki üstgruplarin sayisi kadar dön
            try {
                //Tüm üst gruplarin tutuldugu listedeki her ustgrup no için arama yap listeyi gruplist'e at
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ustgruplar.get(j));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (grupList.get(0).getUstUrunGrup_No() == 0) { //Eğer üstgrup numarası 0 ise yani en üst grupta bulunuyorsa
                boolean esitlik = false;
                for (int k = 0; k < sonGrup.size(); k++) {
                    if (Objects.equals(sonGrup.get(k), ustgruplar.get(j))) {
                        //songrup listesindeki tüm elemanlar ustgruba eşit olana kadar dön 
                        esitlik = true;

                    }
                }
                if (!esitlik) { //songrubun elemanı ustgrup numarasina eşit değilse listeye ekle
                    sonGrup.add(ustgruplar.get(j));
                }
            } else {
                boolean buldum = true;
                int ust;
                int sayac = 0;
                while (buldum) { //ustgrup numarasi 0 olana kadar dolaş
                    ust = grupList.get(0).getUstUrunGrup_No();
                    try {
                        grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ust);
                    } catch (SQLException ex) {
                        Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ust == 0) {
                        break;
                    }
                    if (sayac == 20) {
                        break;
                    }
                    sayac++;
                }
            }
        }
        //return sonGrup;
        System.out.println("hey");
        urunler[] urungrup;
        List<sqlsorgular.urunler> songruplistim = new ArrayList<>();
        urungrup = new urunler[sonGrup.size()];
        for (int i = 0; i < sonGrup.size(); i++) {
            urungrup[i] = new urunler();
            try {
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(sonGrup.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            urungrup[i].setUrunGrup_adi(grupList.get(0).getUrunGrup_adi());
            urungrup[i].setUrunGrup_no(grupList.get(0).getUrunGrup_no());
            songruplistim.add(urungrup[i]);
            //hashmap.put(sonGrup.get(i), grupList.get(0).getUrunGrup_adi());
        }
        
        return songruplistim;
    }

    public List<sqlsorgular.urunler> UrunBul(String UrunAdi) throws SQLException {
        System.out.println("urun_adi");
        baglanti vb = new baglanti();
        vb.baglan();
        List<sqlsorgular.urunler> liste = new ArrayList<>();
        urunler[] urunadibul;
        String sorgu;
        sorgu = "select * from urunler where urun_adi like '%" + UrunAdi + "%'";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        urunadibul = new urunler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            urunadibul[i] = new urunler();
            urunadibul[i].setUrunAdi(rs.getString("urun_adi"));
            liste.add(urunadibul[i]);
            i++;
        }
        return liste;
    }

    public String UrunAdi_Bul(int urun_kodu) throws SQLException {
        baglanti vb = new baglanti();
        vb.baglan();
        try {
            String sorgu = "select urun_adi from urunler where urun_kodu=" + urun_kodu + "";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery(sorgu);
            String urun_adi = null;
            while (rs.next()) {
                urun_adi = rs.getString(1);
            }
            System.out.println("urun adi = " + urun_adi);
            return urun_adi;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            return null;
        }
        finally{
            vb.con.close();
        }
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getUrunGrup_adi() {
        return UrunGrup_adi;
    }

    public void setUrunGrup_adi(String UrunGrup_adi) {
        this.UrunGrup_adi = UrunGrup_adi;
    }

    public int getUrunGrup_no() {
        return UrunGrup_no;
    }

    public float getUrun_fiyat() {
        return Urun_fiyat;
    }

    public void setUrun_fiyat(float Urun_fiyat) {
        this.Urun_fiyat = Urun_fiyat;
    }

    public void setUrunGrup_no(int UrunGrup_no) {
        this.UrunGrup_no = UrunGrup_no;
    }

    public String getUrunAdi() {
        return UrunAdi;
    }

    public void setUrunAdi(String UrunAdi) {
        this.UrunAdi = UrunAdi;
    }

    public int getUrun_adet() {
        return Urun_adet;
    }

    public String getOzellik_adi() {
        return Ozellik_adi;
    }

    public void setOzellik_adi(String Ozellik_adi) {
        this.Ozellik_adi = Ozellik_adi;
    }

    public int getOzellik_kodu() {
        return Ozellik_kodu;
    }

    public void setOzellik_kodu(int Ozellik_kodu) {
        this.Ozellik_kodu = Ozellik_kodu;
    }

    public float getOzellik_fiyat() {
        return Ozellik_fiyat;
    }

    public void setOzellik_fiyat(float Ozellik_fiyat) {
        this.Ozellik_fiyat = Ozellik_fiyat;
    }

    public void setUrun_adet(int Urun_adet) {
        this.Urun_adet = Urun_adet;
    }

    public int getUrun_kodu() {
        return Urun_kodu;
    }

    public void setUrun_kodu(int Urun_kodu) {
        this.Urun_kodu = Urun_kodu;
    }

    public int getUstUrunGrup_No() {
        return UstUrunGrup_No;
    }

    public void setUstUrunGrup_No(int UstUrunGrup_No) {
        this.UstUrunGrup_No = UstUrunGrup_No;
    }

}
