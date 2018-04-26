/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import GarsonEkrani.SiparisEkrani;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author ozkan
 */
public class UrunButonListener implements ActionListener {
   //GarsonEkrani.SiparisEkrani siparis1 = new GarsonEkrani.SiparisEkrani();
    public  int GrupKoduM;//=siparis1.GrupNo;
    @Override
    public void actionPerformed(ActionEvent e) {
            GarsonEkrani.UrunOzellikler ozellik = new GarsonEkrani.UrunOzellikler();
            ozellik.setVisible(true);
            ozellik.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            GarsonEkrani.SiparisEkrani siparis = new GarsonEkrani.SiparisEkrani();
            int urunKodu=0, grupKodu;
            String urunAdi;
            float fiyat;
            JButton but = (JButton) e.getSource();
            urunAdi = but.getText();
            grupKodu = siparis.GrupNo;
            System.out.println(grupKodu+"---");
        try {
            urunKodu = new sqlsorgular.urunler().UrunKoduByAd(urunAdi);
        } catch (SQLException ex) {
            Logger.getLogger(UrunButonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ozellik.UrunKoduOzellik=urunKodu;
        try {
            fiyat=new sqlsorgular.urunler().UrunFiyatiByUrunKodu(urunKodu);
        } catch (SQLException ex) {
            Logger.getLogger(UrunButonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ozellik.UrunAdiJLabel.setText(urunAdi);
        List<sqlsorgular.urunler> ozellikList=null;
        try {
            ozellikList = new sqlsorgular.urunler().UrunOzellikleriByUrunKodu(urunKodu);
        } catch (SQLException ex) {
            Logger.getLogger(UrunButonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ozellik.OzellikEkle(ozellikList);
        ozellik.ozellikPanel.setMaximumSize(new Dimension(560,200));
        ozellik.ozellikPanel.setPreferredSize(new Dimension(560, 200));
        ozellik.ozellikPanel.setLayout(new GridLayout(5, 5));
    }
    
    
}
