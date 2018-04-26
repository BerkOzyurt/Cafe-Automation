/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ozkan
 */
public class GrupButonAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("buradayım");
            GarsonEkrani.SiparisEkrani siparis = new GarsonEkrani.SiparisEkrani();
         JButton grupButon = (JButton) e.getSource();
            String grupAdi = grupButon.getText();
            int grupno = 0;
           
        try {
            grupno = new sqlsorgular.urunler().UrungrupNoByAd(grupAdi);
        } catch (SQLException ex) {
            Logger.getLogger(GrupButonAction.class.getName()).log(Level.SEVERE, null, ex);
        }  
            List<sqlsorgular.urunler> grupList = null;
            
        try {
            grupList = new sqlsorgular.urunler().AltUrunGruplariniBul(grupno);
        } catch (SQLException ex) {
            Logger.getLogger(GrupButonAction.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Grupbuton"+grupno);
           siparis.Ust_Urun_Grup_No.add(grupno);
            if(siparis.Ust_Urun_Grup_No.size()>0){
                siparis.jButton2.setEnabled(true);
            }
                List<sqlsorgular.urunler> urunListe=null;
                if(grupList.size()==0){
                   
                try {
                    urunListe=new sqlsorgular.urunler().UrunBulByUrunGrup(grupno);
                } catch (SQLException ex) {
                    Logger.getLogger(GrupButonAction.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
                    siparis.GrupNo=grupno;
                     siparis.urunButonlari(urunListe);
                     
                }
                else{
                    
                    siparis.grupButonlari(grupList); 
                }
    }
    
}
