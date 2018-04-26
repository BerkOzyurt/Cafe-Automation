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
public class giris {
    PreparedStatement ps;
    ResultSet rs;
    public boolean admin;
    public String sifre, kullaniciAdi, Durum;
    
    public List<giris> giris_yap() throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        List<giris> liste = new ArrayList<>();
        giris[] kullanicidurum;
        String sorgu;
        sorgu = "select * from kullanicilar";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        kullanicidurum = new giris[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            kullanicidurum[i] = new giris();
            kullanicidurum[i].setKullaniciAdi(rs.getString("kullanici_adi"));
            kullanicidurum[i].setSifre(rs.getString("sifre"));
            kullanicidurum[i].setDurum(rs.getString("durum"));
            liste.add(kullanicidurum[i]);
            i++;
        }
        vb.con.close();
        return liste;
    }

    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getDurum() {
        return Durum;
    }

    public void setDurum(String Durum) {
        this.Durum = Durum;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
}
