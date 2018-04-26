/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ozkan
 */
public class SiparisVerAction implements ActionListener {
    public static  ArrayList<Integer> Urun_Kod_List; 
    public static ArrayList<Integer> Urun_Adet_List;
    public static ArrayList<String> Urun_Ozellik_List;
    public static String Masa_No;
    boolean durum = false;
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
       ///System.out.println("urunkodlist: "+Urun_Kod_List.get(0)+"urunAdetlist: "+Urun_Adet_List.get(0)+"urunozelliklist: "+
           //     Urun_Ozellik_List.get(0));
        System.out.println("masano: "+Masa_No);
        for(int i=0;i<Urun_Kod_List.size();i++){
            System.out.println("urunkodu "+Urun_Kod_List.get(i));
        }
        int[] urunKodlari = new int[Urun_Kod_List.size()];
        int[] adetler = new int[Urun_Kod_List.size()];
        String[] ozellikler = new String[Urun_Kod_List.size()];
        //System.out.println("siparisver action al:"+Urun_Kod_List.get(0)+"size:"+Urun_Kod_List.size());
        for(int i=0;i<Urun_Kod_List.size();i++){
            urunKodlari[i] = Urun_Kod_List.get(i);
            adetler[i] = Urun_Adet_List.get(i);
            ozellikler[i] = Urun_Ozellik_List.get(i);
            System.out.println("siparisveraction: "+urunKodlari[i]+adetler[i]+ozellikler[i]);
        }
        durum = new sqlsorgular.siparisler().SiparisOlustur(urunKodlari, adetler, ozellikler, Integer.parseInt(Masa_No));
        if(durum){
                    GarsonEkrani.SiparisEkrani sip = new GarsonEkrani.SiparisEkrani();

             JButton btn = (JButton)e.getSource();
             sip.SiparisEkraniKapat();
             
        }else{
            System.out.println("hata kaydedilmedi");
        }
    }
    
}
