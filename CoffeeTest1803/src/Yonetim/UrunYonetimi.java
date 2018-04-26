package Yonetim;

import java.awt.Color;
import javax.swing.JFrame;

public class UrunYonetimi extends javax.swing.JFrame {

    public UrunYonetimi() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        this.setTitle("Ürün Yönetimi");
          //----ToolTip Kodları-----
        
        UrunEkle.setToolTipText("Ürün eklemek için tıklayın."); //ürün_ekle ekranı simgesi tooltip kodu
        UrunDuzenle.setToolTipText("Ürün düzenlemek için tıklayın.");
        UrunSil.setToolTipText("Ürün silmek için tıklayın.");
        GeriGit.setToolTipText("Geri git");
        KategoriEkle.setToolTipText("Kategori eklemek için tıklayın.");
        Kapama.setToolTipText("Kapat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama = new javax.swing.JLabel();
        GeriGit = new javax.swing.JLabel();
        UrunEkle = new javax.swing.JLabel();
        UrunDuzenle = new javax.swing.JLabel();
        UrunSil = new javax.swing.JLabel();
        KategoriEkle = new javax.swing.JLabel();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 70, 60));

        GeriGit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GeriGit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriGitMouseClicked(evt);
            }
        });
        getContentPane().add(GeriGit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        UrunEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UrunEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UrunEkleMouseClicked(evt);
            }
        });
        getContentPane().add(UrunEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 170));

        UrunDuzenle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UrunDuzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UrunDuzenleMouseClicked(evt);
            }
        });
        getContentPane().add(UrunDuzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 200, 180));

        UrunSil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UrunSil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UrunSilMouseClicked(evt);
            }
        });
        getContentPane().add(UrunSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 180, 170));

        KategoriEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KategoriEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KategoriEkleMouseClicked(evt);
            }
        });
        getContentPane().add(KategoriEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 180, 170));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/urunYonetim.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1280, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    private void GeriGitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriGitMouseClicked
        YonetimEkrani yonetim = new YonetimEkrani();
        this.setVisible(false);
        yonetim.setVisible(true);
    }//GEN-LAST:event_GeriGitMouseClicked

    private void UrunDuzenleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UrunDuzenleMouseClicked
        UrunDuzenle urunduzenle = new UrunDuzenle();
        urunduzenle.setVisible(true);
    }//GEN-LAST:event_UrunDuzenleMouseClicked

    private void UrunSilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UrunSilMouseClicked
        UrunSil urunsil = new UrunSil();
        urunsil.setVisible(true);
    }//GEN-LAST:event_UrunSilMouseClicked

    private void UrunEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UrunEkleMouseClicked
        UrunEkle urunekle = new UrunEkle();
        urunekle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        urunekle.setVisible(true);
    }//GEN-LAST:event_UrunEkleMouseClicked

    private void KategoriEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KategoriEkleMouseClicked
        KategoriEkle kategoriekle = new KategoriEkle();
        kategoriekle.setVisible(true);
    }//GEN-LAST:event_KategoriEkleMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UrunYonetimi yone = new UrunYonetimi();
                yone.setTitle("Ürün Yönetimi");
                yone.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel GeriGit;
    private javax.swing.JLabel Kapama;
    private javax.swing.JLabel KategoriEkle;
    private javax.swing.JLabel UrunDuzenle;
    private javax.swing.JLabel UrunEkle;
    private javax.swing.JLabel UrunSil;
    // End of variables declaration//GEN-END:variables
}
