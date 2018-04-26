/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 *
 * @author ozkan
 */
public class ortalametod {
    public void Ekranoralama(JFrame j,int genislik,int yukseklik){
        int ekrangenislik=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int ekranyukseklik=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        j.setLocation((ekrangenislik-genislik)/2, (ekranyukseklik-yukseklik)/2);
    }
}
