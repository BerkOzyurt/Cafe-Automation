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
public class stokThread implements Runnable {
    List<sqlsorgular.stoklar> stoklist = null; 
    @Override
    public void run() {
        try {
            stoklist = new sqlsorgular.stoklar().GuncelStokDurumu();
            Thread.sleep(1500);
        } catch (SQLException ex) {
            Logger.getLogger(stokThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(stokThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<sqlsorgular.stoklar> stoklistem() {
        return stoklist;
    }
    
}
