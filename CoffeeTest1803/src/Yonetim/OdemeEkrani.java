package Yonetim;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ozkan
 */
public class OdemeEkrani extends javax.swing.JFrame {

    /**
     * Creates new form OdemeEkrani
     */
    public OdemeEkrani() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        this.setTitle("ÖDEME ONAYLA");
        OnayButon.setToolTipText("Onayla");
        IptalButon.setToolTipText("İptal");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama = new javax.swing.JLabel();
        MasaNo = new javax.swing.JLabel();
        OdemeTipi = new javax.swing.JLabel();
        OdenenTutarYazi = new javax.swing.JLabel();
        OdenenTutar = new javax.swing.JLabel();
        OnayButon = new javax.swing.JButton();
        IptalButon = new javax.swing.JButton();
        arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 30, 30));

        MasaNo.setFont(new java.awt.Font("Noto Sans", 3, 18)); // NOI18N
        MasaNo.setForeground(new java.awt.Color(255, 255, 255));
        MasaNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MasaNo.setText("Masa No:");
        getContentPane().add(MasaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 420, -1));

        OdemeTipi.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        OdemeTipi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OdemeTipi.setText("Ödeme Tipi:");
        getContentPane().add(OdemeTipi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, -1));

        OdenenTutarYazi.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        OdenenTutarYazi.setText("Ödenen Tutar:");
        getContentPane().add(OdenenTutarYazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        OdenenTutar.setFont(new java.awt.Font("Noto Sans", 3, 18)); // NOI18N
        OdenenTutar.setText("0.00");
        getContentPane().add(OdenenTutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        OnayButon.setBackground(new java.awt.Color(26, 104, 25));
        OnayButon.setText("ONAYLA");
        OnayButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnayButonActionPerformed(evt);
            }
        });
        getContentPane().add(OnayButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 213, 40));

        IptalButon.setBackground(java.awt.Color.red);
        IptalButon.setText("İPTAL");
        getContentPane().add(IptalButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 213, 40));

        arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kucukPanelBos.png"))); // NOI18N
        getContentPane().add(arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(498, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    private void OnayButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnayButonActionPerformed
        // TODO add your handling code here:
         boolean durum = true;
        System.out.println("Odeme olusutr: "+siparisNo+"-"+odemeTipi+"-"+indirim);
        try {
            durum = new sqlsorgular.siparisler().OdemeYap(siparisNo, odemeTipi,indirim);
        } catch (SQLException ex) {
            Logger.getLogger(OdemeEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(durum){
            boolean durum2;
            try{
                durum2 = new sqlsorgular.siparisler().OdenenlerTablosunaEkle(siparisNo, Masa_No);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Tablo Güncellenirken Hata","Hata",JOptionPane.ERROR_MESSAGE);
            }
            
            Adisyon adisyon = new Adisyon();
            adisyon.kapat=true;
            this.dispose();
            
        }
    }//GEN-LAST:event_OnayButonActionPerformed

     String siparisNo; String odemeTipi; int indirim, Masa_No;                              

    /**
     * @param args the command line arguments
     */
    public void OdemeEkraniAcilis(int masano, String odemetipi, float tutar, String siparisno, int indirim){
        MasaNo.setText("MASA NO: "+String.valueOf(masano));
        OdemeTipi.setText(odemetipi);
        OdenenTutar.setText(String.valueOf(tutar));
        this.siparisNo=siparisno;
        this.odemeTipi=odemetipi;
        this.indirim = indirim;
        this.Masa_No = masano;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OdemeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OdemeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OdemeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OdemeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OdemeEkrani odeme = new OdemeEkrani();
                odeme.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                odeme.setTitle("ÖDEME ONAYLA");
                odeme.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IptalButon;
    private javax.swing.JLabel Kapama;
    private javax.swing.JLabel MasaNo;
    private javax.swing.JLabel OdemeTipi;
    private javax.swing.JLabel OdenenTutar;
    private javax.swing.JLabel OdenenTutarYazi;
    private javax.swing.JButton OnayButon;
    private javax.swing.JLabel arkaplan;
    // End of variables declaration//GEN-END:variables
}
