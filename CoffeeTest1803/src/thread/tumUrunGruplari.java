/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozkan
 */
public class tumUrunGruplari implements Runnable {
    List<sqlsorgular.urunler> grupList = null;
    @Override
    public void run() {
        try {
            grupList = new sqlsorgular.urunler().UrunGruplari();
        } catch (SQLException ex) {
            Logger.getLogger(tumUrunGruplari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<sqlsorgular.urunler> urungruplist(){
        return grupList;
    }
    
}
