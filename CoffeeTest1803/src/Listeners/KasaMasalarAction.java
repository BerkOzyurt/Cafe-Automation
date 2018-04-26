/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ozkan
 */
public class KasaMasalarAction  implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Yonetim.KasaAnaSayfa kasa = new Yonetim.KasaAnaSayfa();
        JButton btn = (JButton) e.getSource();
        String MasaAdi = btn.getText().trim();
        HashMap<Integer, String> hmap = kasa.MasaNoAd;
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        int masaNo=0;
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         if(mentry.getValue().equals(MasaAdi)){
             masaNo = (int) mentry.getKey();
         }
        }
        System.out.println("MasaNo: "+masaNo);
        Yonetim.Adisyon adisyon = new Yonetim.Adisyon();
        adisyon.AdisyonAcilis(masaNo);
        adisyon.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        adisyon.setVisible(true);

    }
    
}
