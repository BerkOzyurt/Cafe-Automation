/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeetest;

import java.awt.Frame;
import java.awt.Toolkit;

/**
 *
 * @author ozkan
 */
public class FrameOrtala {
    
    public FrameOrtala() {
        
    }
    public void OrtayaAyarla(Frame frame){
        int genislik = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int yukseklik = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int ugenislik = frame.getWidth();
        int uyukseklik = frame.getHeight();
        frame.setLocation((genislik - ugenislik)/2,(yukseklik - uyukseklik)/2);
    }
    
}
