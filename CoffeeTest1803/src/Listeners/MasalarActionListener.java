/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ozkan
 */
public class MasalarActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        GarsonEkrani.SiparisEkrani siparis = new GarsonEkrani.SiparisEkrani();
        GarsonEkrani.Masalar mas = new GarsonEkrani.Masalar();
         JButton o = (JButton) e.getSource();
        String name = o.getText();
        int masaNo = 0;
        try {
            masaNo = new sqlsorgular.masalar().Masaid_Bul(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasalarActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        siparis.MasaNo=masaNo;
        siparis.SiparisEkraniAcilis();
        //jfm.add(siparis.getContentPane());
        mas.setTitle("MASA "+name);
        mas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        siparis.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        siparis.setVisible(true);
        //mas.setVisible(false);
        siparis.validate();
       siparis.pack();
        siparis.repaint();
        siparis.revalidate();
        //jfm.setVisible(true);
        
    }
   
    
}
