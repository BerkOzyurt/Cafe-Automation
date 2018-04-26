/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import GarsonEkrani.SiparisEkrani;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fadime
 */
public class urunthread implements Runnable{
    public urunthread(){
        
    }
    private volatile int adet;
    List<sqlsorgular.kategoriler> urunGrupList = null;
    GarsonEkrani.GeneralFunctions ge = new GarsonEkrani.GeneralFunctions();
    public void run(){
        try {
            adet=new sqlsorgular.urunler().UrunGrupAdet(); //Urun gruplarının adetleri
            //urunGrupList = new sqlsorgular.urunler().UrunGruplari(); 
            urunGrupList = new sqlsorgular.kategoriler().UrunGrupListele(1, 0);
            //urunGrupList = ge.SiparisEkraniUrunGruplariListeAl();
            
        } catch (SQLException ex) {
            Logger.getLogger(GarsonEkrani.SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
         // Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int urunadet(){
        return adet;
    }
    public List<sqlsorgular.kategoriler> urungruplist(){
        return urunGrupList;
    }
   
}
