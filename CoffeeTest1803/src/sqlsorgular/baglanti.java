/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsorgular;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ozkan
 */
   
public class baglanti {
    public Connection con;
     private String url = "jdbc:mysql://127.0.0.1:3306/";
    private String driver = "com.mysql.jdbc.Driver";
    private String dbname = "cafe1";
    private String giriskodu = "?useUnicode=true&characterEncoding=UTF-8";
    private String username = "root";
    private String password = "Ozkancinar";

    public baglanti() {
        File f = new File("dosya.txt");
        FileReader fileReader;
        ArrayList<String> gelenList = new ArrayList<>();
        try {
            fileReader = new FileReader(f); //Dosyayı oku.
        
        String line;BufferedReader br = new BufferedReader(fileReader);
        
        while ((line = br.readLine()) != null) {
           gelenList.add(line);
        }
        br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException e){
            
        }
        this.url = "jdbc:mysql://"+gelenList.get(0)+":"+gelenList.get(1)+"/";
        this.username = gelenList.get(2);
        this.password = gelenList.get(3);
    }
    
    public void baglan(){
         try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url+dbname+giriskodu,username,password);
            //JOptionPane.showMessageDialog(null, "baglandi");
        } catch (Exception ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hata: "+ex);
        }
    }
}
