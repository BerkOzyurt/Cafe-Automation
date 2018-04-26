package GarsonEkrani;

import Listeners.MasalarActionListener;
import Yonetim.KasaAnaSayfa;
import com.sun.prism.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Masalar extends javax.swing.JFrame {

    public Masalar() {
        initComponents();
        MasalarAcilis();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 990, 480));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 80, 70));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/masalarArkaplan.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        setSize(new java.awt.Dimension(1280, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void MasalarAcilis(){
         JPanel panel = new JPanel(){
             public void paintComponents(java.awt.Graphics g) {
                 super.paintComponent(g);
                 try{
                Image image = Toolkit.getDefaultToolkit().createImage("hakkinda.png");
                g.drawImage(image,0,0,this);
               }catch(Exception e){
                   System.out.println(e);
               }
                
            }
        };
        //panel.setLayout(new GridLayout(50,80,50,100));
        sqlsorgular.masalar masa = new sqlsorgular.masalar();
        int adet = 0;
        try {
            adet = masa.MasaAdet();
        } catch (SQLException ex) {
            Logger.getLogger(Masalar.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<sqlsorgular.masalar> masaAdlari = null;
        try {
            masaAdlari = new sqlsorgular.masalar().MasaAdlari();
        } catch (SQLException ex) {
            Logger.getLogger(Masalar.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> doluMasalar = new ArrayList<>(); //Dolu masalarin listesini tutmak için bir liste oluşturuluyor
        doluMasalar = null;
        try {
            doluMasalar = new sqlsorgular.masalar().MusaitMasalar(); //Dolu masalarin listesi doluMasalar listesine atanıyor
        } catch (SQLException ex) {
            Logger.getLogger(KasaAnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ActionListener alisten = new MasalarActionListener();
        Image background = Toolkit.getDefaultToolkit().createImage("masalarArkaplan.png");
        panel.setLayout(new GridLayout(5,5,10,10));
        for(int i=0;i<adet;i++){
            JButton btn = new JButton(String.valueOf(masaAdlari.get(i).getMasa_Adi()));
            int masano = masaAdlari.get(i).getMasa_No();
            for(int j=0;j<doluMasalar.size();j++){
                if(doluMasalar.get(j)==masano){
                    btn.setBackground(java.awt.Color.red);
                }
            }
            btn.setPreferredSize(new Dimension(150,50));
            btn.addActionListener(alisten);
            panel.add(btn,LEFT_ALIGNMENT);
            panel.repaint();
            panel.revalidate();
            
        }
        //this.setContentPane(Arkaplan);
       // BackgroundPane background = new BackgroundPane();
        //this.setContentPane(fram.getContentPane());
        //this.setLayout(new GridLayout(5,5,20,50)); //
       // panel.setSize(this.getSize());
        //this.setContentPane(fram.getContentPane());
        panel.setSize(jPanel1.getSize());
        jPanel1.remove(this);
        jPanel1.removeAll();
        jPanel1.add(panel);
        jPanel1.validate();
        jPanel1.revalidate();
        jPanel1.repaint();
        this.repaint();
        this.revalidate();
    }
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_formComponentShown

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
    Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                MasalarAcilis();
            }
        });
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        Timer time =new Timer();
        TimerTask tims = new TimerTask() {
            @Override
            public void run() {
                MasalarAcilis();
            }
        };
       time.schedule(tims,0, 20000);
    }//GEN-LAST:event_formWindowGainedFocus

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Masalar mas = new Masalar();
                //new Masalar().setVisible(true);
                mas.setTitle("Masalar");
                mas.setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
