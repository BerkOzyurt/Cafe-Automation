/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutfak;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sqlsorgular.siparis;

/**
 *
 * @author fadime
 */
public class Timerdeneme extends TimerTask{
    public  Timerdeneme(){
        
}
    
    @Override
    
    public void run(){
        
        try{
            
            mutfakthread mt = new mutfakthread();
            Thread t = new Thread(mt);
            t.start();
            t.join();
            MutfakEkrani me= new MutfakEkrani();
            me.SiparisCagir();
            me.repaint();
            me.revalidate();
            
        }catch(Exception e){
            Logger.getLogger(MutfakEkrani.class.getName()).log(Level.SEVERE, null, e);
        }      
    }

}
