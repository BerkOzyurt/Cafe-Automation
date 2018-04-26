/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutfak;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fadime
 */
public class mutfakthread extends Thread{
    volatile List<sqlsorgular.siparis> siparisgetir = new ArrayList<>();
    @Override
    
    public void run(){
        
        try{
            
            siparisgetir = new sqlsorgular.siparis().Siparis_al();
            
        }catch(SQLException e){
            Logger.getLogger(Mutfak.MutfakEkrani.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
    }
    public List<sqlsorgular.siparis> siparisdene(){
        
        run();
        
        return siparisgetir;
    }
}
