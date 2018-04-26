package GirisEkrani;

import coffeetest.*;
import GarsonEkrani.Masalar;
import GarsonEkrani.SiparisEkrani;
import Mutfak.MutfakEkrani;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GirisEkrani extends javax.swing.JFrame {
    
    
    public GirisEkrani() {
        initComponents();
        sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        
           //----ToolTip Kodları-----
        
        KullaniciAdi.setToolTipText("Kullanıcı adını giriniz"); 
        Sifre.setToolTipText("Şifreyi giriniz");
        SistemeGiris.setToolTipText("Sisteme giriş yapmak için tıklayınız");
        hakkinda.setToolTipText("Hakkında");
        
        Kapama.setToolTipText("Kapat");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KullaniciAdi = new javax.swing.JTextField();
        Sifre = new javax.swing.JPasswordField();
        SistemeGiris = new javax.swing.JLabel();
        hakkinda = new javax.swing.JLabel();
        Kapama = new javax.swing.JLabel();
        GirisHata = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        KullaniciAdi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        KullaniciAdi.setBorder(null);
        KullaniciAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KullaniciAdiActionPerformed(evt);
            }
        });
        getContentPane().add(KullaniciAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 312, 280, 30));

        Sifre.setBorder(null);
        getContentPane().add(Sifre, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 270, 30));

        SistemeGiris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SistemeGiris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SistemeGirisMouseClicked(evt);
            }
        });
        getContentPane().add(SistemeGiris, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 200, 30));

        hakkinda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hakkinda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hakkindaMouseClicked(evt);
            }
        });
        getContentPane().add(hakkinda, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 150, 30));

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 100, 40, 40));

        GirisHata.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        GirisHata.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(GirisHata, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 410, 20));

        jButton1.setText("Veritabanı Ayarı");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, -1, -1));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/girisArkaplan.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1277, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GirisDene(String K_Adi, String K_Sifre){
  
      sqlsorgular.giris giris = new sqlsorgular.giris();
      List<sqlsorgular.giris> girislist = null;
        try {
            girislist = giris.giris_yap();
        } catch (SQLException ex) {
            Logger.getLogger(GirisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean sonuc= false;
        int sira = 0;
        System.out.println(girislist.size());
      for(int i = 0; i<girislist.size();i++)
      {
          System.out.println(girislist.get(i).getKullaniciAdi());
          if(K_Adi.trim().equals(girislist.get(i).getKullaniciAdi()) && K_Sifre.trim().equals(girislist.get(i).getSifre())){
              sonuc = true;
              sira = i;
      }
     
      }
        System.out.println(sonuc);
      if(sonuc){
          if(girislist.get(sira).getDurum().equals("ADMIN")){
               Yonetim.KasaAnaSayfa yonetim = new Yonetim.KasaAnaSayfa();
                this.setVisible(false);
                
                yonetim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                yonetim.validate();
                yonetim.repaint();
                yonetim.pack();
                yonetim.revalidate();
                yonetim.setVisible(true);
            }
            else if(girislist.get(sira).getDurum().equals("GARSON")){
              Masalar masalar = new Masalar();
              this.setVisible(false);
              masalar.setVisible(true); 
              System.out.println("kşsldjfslkdjfşlskdjf");
          }
          else if(girislist.get(sira).getDurum().equals("MUTFAK")){
              MutfakEkrani mutfak = new MutfakEkrani();
              this.setVisible(false);
              mutfak.setVisible(true); 
          }
            
          
      }else{
          JOptionPane.showMessageDialog(this,"Yanlış Kullanıcı Adı/Şifre","Uyarı", JOptionPane.ERROR_MESSAGE);

      }
     
    }
    

    private void KullaniciAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KullaniciAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KullaniciAdiActionPerformed

    private void SistemeGirisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SistemeGirisMouseClicked
      sqlsorgular.giris giris = new sqlsorgular.giris();
      String KulAdi = KullaniciAdi.getText();
      String KulSifre = Sifre.getText();
      GirisDene(KulAdi, KulSifre);

    }//GEN-LAST:event_SistemeGirisMouseClicked

    private void hakkindaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hakkindaMouseClicked
        Hakkinda hk = new Hakkinda();
        hk.setVisible(true);
    }//GEN-LAST:event_hakkindaMouseClicked

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_KapamaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            ayarEkrani ayar = new ayarEkrani();
            ayar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            ayar.pack();
            ayar.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GirisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public static void main(String args[]) throws IOException {
        File f = new File("dosya.txt");
       
        FileReader fileReader = new FileReader(f); //Dosyayı oku.
        String line;BufferedReader br = new BufferedReader(fileReader);
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GirisEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel GirisHata;
    private javax.swing.JLabel Kapama;
    private javax.swing.JTextField KullaniciAdi;
    private javax.swing.JPasswordField Sifre;
    private javax.swing.JLabel SistemeGiris;
    private javax.swing.JLabel hakkinda;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
