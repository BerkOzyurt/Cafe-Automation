package Yonetim;

import GarsonEkrani.Masalar;
import GirisEkrani.GirisEkrani;
import javax.swing.JFrame;

public class YonetimEkrani extends javax.swing.JFrame {

    public YonetimEkrani() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        this.setTitle("Yönetici Ekranı");
        //----ToolTip Kodları-----
        
        Eleman.setToolTipText("Eleman ekranına gitmek için tıklayın."); //eleman ekranı simgesi tooltip kodu
        Masalar.setToolTipText("Masalar ekranına gitmek için tıklayın.");
        Muhasebe.setToolTipText("Muhasebe ekranına gitmek için tıklayın.");
        Urun.setToolTipText("Ürün ekranına gitmek için tıklayın.");
        Kapama.setToolTipText("Kapat");
        Geri.setToolTipText("Geri git");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Karsilama = new javax.swing.JLabel();
        Eleman = new javax.swing.JLabel();
        Masalar = new javax.swing.JLabel();
        Muhasebe = new javax.swing.JLabel();
        Urun = new javax.swing.JLabel();
        Kapama = new javax.swing.JLabel();
        Geri = new javax.swing.JLabel();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Karsilama.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        Karsilama.setText("Hoşgeldiniz, ");
        getContentPane().add(Karsilama, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        Eleman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eleman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElemanMouseClicked(evt);
            }
        });
        getContentPane().add(Eleman, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 220, 180));

        Masalar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Masalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasalarMouseClicked(evt);
            }
        });
        getContentPane().add(Masalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 230, 200));

        Muhasebe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Muhasebe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MuhasebeMouseClicked(evt);
            }
        });
        getContentPane().add(Muhasebe, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 270, 170));

        Urun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Urun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UrunMouseClicked(evt);
            }
        });
        getContentPane().add(Urun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 240, 180, 180));

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 70, 60));

        Geri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Geri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriMouseClicked(evt);
            }
        });
        getContentPane().add(Geri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/yoneticiEkrani.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1280, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    private void GeriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriMouseClicked
        KasaAnaSayfa kasa = new KasaAnaSayfa();
        kasa.pack();
        kasa.setVisible(true);
        kasa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //kasa.KasaAcilis();
        this.setVisible(false);
        
    }//GEN-LAST:event_GeriMouseClicked

    private void ElemanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElemanMouseClicked
        KullaniciYonetimi yonetim = new KullaniciYonetimi();
        this.setVisible(true);
        yonetim.setVisible(true);
        yonetim.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_ElemanMouseClicked

    private void MasalarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasalarMouseClicked
        MasalarYonetim masalar = new MasalarYonetim();
        this.setVisible(true);
        masalar.setVisible(true);
        masalar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_MasalarMouseClicked

    private void MuhasebeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MuhasebeMouseClicked
        Muhasebe muhasebe = new Muhasebe();
        this.setVisible(true);
        muhasebe.setVisible(true);
        muhasebe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_MuhasebeMouseClicked

    private void UrunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UrunMouseClicked
        UrunYonetimi urun = new UrunYonetimi();
        this.setVisible(true);
        urun.setVisible(true);
        urun.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_UrunMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                YonetimEkrani yonetim = new YonetimEkrani();
                yonetim.setTitle("Yönetim Ekranı");
                yonetim.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                yonetim.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel Eleman;
    private javax.swing.JLabel Geri;
    private javax.swing.JLabel Kapama;
    private javax.swing.JLabel Karsilama;
    private javax.swing.JLabel Masalar;
    private javax.swing.JLabel Muhasebe;
    private javax.swing.JLabel Urun;
    // End of variables declaration//GEN-END:variables
}
