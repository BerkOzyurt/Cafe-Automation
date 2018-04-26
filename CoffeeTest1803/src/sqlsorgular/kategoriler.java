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
public class kategoriler {
    PreparedStatement ps;
    ResultSet rs;
    private int Grup_No, Ust_Grup_No, Seviye;
    private String Grup_Adi;
    
    public List<kategoriler> UrunGrupListele(int seviye, int ustGrupNo) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        List<kategoriler> liste = new ArrayList<>();
       try{
           kategoriler[] ozellikliste;
           String sorgu;
        sorgu = "select * from urun_gruplari where seviye=" + seviye + " and ust_grup="+ustGrupNo+"";
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        int sayac = 0;
        while (rs.next()) {
            sayac++;
        }
        ozellikliste = new kategoriler[sayac];
        int i = 0;
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            ozellikliste[i] = new kategoriler();
            ozellikliste[i].setGrup_Adi(rs.getString("grup_adi"));
            ozellikliste[i].setGrup_No(rs.getInt("grup_no"));
            ozellikliste[i].setUst_Grup_No(rs.getInt("ust_grup"));
            ozellikliste[i].setSeviye(rs.getInt("seviye"));
            liste.add(ozellikliste[i]);
            i++;
        }     
       }catch(SQLException e){
           System.out.println("kategorilistede:"+e.getMessage());
       }
       vb.con.close();
        return liste;
    }
    public int UstGrupAl(int grupNo) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int ustGrup=-1;
        String sorgu;
        sorgu = "select ust_grup from urun_gruplari where grup_no=" + grupNo + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            ustGrup = rs.getInt(1);
        }
        vb.con.close();
        ps.close();
        rs.close();
        return ustGrup;
    }
    public int SeviyeAl(int grupNo) throws SQLException{
        baglanti vb = new baglanti();
        vb.baglan();
        int seviye=-1;
        String sorgu;
        sorgu = "select seviye from urun_gruplari where grup_no=" + grupNo + "";//Daha sonra masalar tablosundan çekilecek
        ps = vb.con.prepareStatement(sorgu);
        rs = ps.executeQuery(sorgu);
        while (rs.next()) {
            seviye = rs.getInt(1);
        }
        vb.con.close();
        ps.close();
        rs.close();
        return seviye;
    }
    public int getGrup_No() {
        return Grup_No;
    }

    public void setGrup_No(int Grup_No) {
        this.Grup_No = Grup_No;
    }

    public int getUst_Grup_No() {
        return Ust_Grup_No;
    }

    public void setUst_Grup_No(int Ust_Grup_No) {
        this.Ust_Grup_No = Ust_Grup_No;
    }

    public int getSeviye() {
        return Seviye;
    }

    public void setSeviye(int Seviye) {
        this.Seviye = Seviye;
    }

    public String getGrup_Adi() {
        return Grup_Adi;
    }

    public void setGrup_Adi(String Grup_Adi) {
        this.Grup_Adi = Grup_Adi;
    }
    
}
