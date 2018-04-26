package Yonetim;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UrunSil extends javax.swing.JFrame {

    public UrunSil() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        UrunSilAcilis();
        this.setTitle("Ürün Silme Ekranı");
         //----ToolTip Kodları-----
        
        jList1.setToolTipText("Ürün grupları listesi"); 
        jList2.setToolTipText("Seçili ürün grubuna ait ürünlerin listesi");
        grupNoCombobox.setToolTipText("Grup no seç");
        urunID.setToolTipText("Ürün ID giriniz");
        urunAdi.setToolTipText("Ürün adı giriniz");
        urunFiyati.setToolTipText("Ürün fiyatı giriniz");
        urunSil.setToolTipText("Ürün sil işlemlerini kaydetmek için tıklayın");
        Kapama1.setToolTipText("Kapat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama1 = new javax.swing.JLabel();
        Yazi1 = new javax.swing.JLabel();
        urunID = new javax.swing.JTextField();
        urunAdi = new javax.swing.JTextField();
        urunSil = new javax.swing.JButton();
        Label_urunid = new javax.swing.JLabel();
        Label_urunadi = new javax.swing.JLabel();
        Label_ustgrupno = new javax.swing.JLabel();
        grupNoCombobox = new javax.swing.JComboBox<>();
        Resim = new javax.swing.JLabel();
        Label_ustgrupno1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Label_ustgrupno2 = new javax.swing.JLabel();
        urunFiyati = new javax.swing.JTextField();
        Label_urunadi1 = new javax.swing.JLabel();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Kapama1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kapama1MouseClicked(evt);
            }
        });
        getContentPane().add(Kapama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 50, 50));

        Yazi1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        Yazi1.setForeground(new java.awt.Color(255, 255, 255));
        Yazi1.setText("Ürün Silme Paneli");
        getContentPane().add(Yazi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 14, -1, 60));

        urunID.setToolTipText("");
        urunID.setName(""); // NOI18N
        getContentPane().add(urunID, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 190, -1));
        getContentPane().add(urunAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 190, -1));

        urunSil.setBackground(new java.awt.Color(182, 95, 34));
        urunSil.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        urunSil.setForeground(new java.awt.Color(255, 255, 255));
        urunSil.setText("Ürünü Sil");
        urunSil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urunSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunSilActionPerformed(evt);
            }
        });
        getContentPane().add(urunSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 190, 40));

        Label_urunid.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunid.setText("Ürün ID:");
        getContentPane().add(Label_urunid, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 60, -1));

        Label_urunadi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunadi.setText("Ürün Adı:");
        getContentPane().add(Label_urunadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 80, 20));

        Label_ustgrupno.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno.setText("Ürün Üst Grup No:");
        getContentPane().add(Label_ustgrupno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 100, 20));

        grupNoCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(grupNoCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 190, -1));

        Resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/Arayuz/coffee-cup-green.png"))); // NOI18N
        getContentPane().add(Resim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        Label_ustgrupno1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno1.setText("Ürün Grupları");
        getContentPane().add(Label_ustgrupno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, 20));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 210, 270));

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 230, 270));

        Label_ustgrupno2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_ustgrupno2.setText("Seçili Ürün Grubuna Ait Ürünler");
        Label_ustgrupno2.setAlignmentY(0.0F);
        getContentPane().add(Label_ustgrupno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 200, 40));
        getContentPane().add(urunFiyati, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 190, -1));

        Label_urunadi1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunadi1.setText("Ürün Fiyatı:");
        getContentPane().add(Label_urunadi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 90, 20));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/urunArkaplan.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1066, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int seciliUrunGrupNo, seciliUrunNo;
    ArrayList<Integer> grupNumaralari;
    ArrayList<Integer> urunNumaralari;
    private void Kapama1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kapama1MouseClicked
        this.dispose();
    }//GEN-LAST:event_Kapama1MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        UrunlerListesiniGuncelle();
        grupNoCombobox.setSelectedIndex(jList1.getSelectedIndex());
    }//GEN-LAST:event_jList1MouseClicked
    private void UrunlerListesiniGuncelle(){
        urunNumaralari = new ArrayList<>();
        DefaultListModel listmodel = new DefaultListModel();
        List<sqlsorgular.urunler> urunList = null;
        seciliUrunGrupNo = grupNumaralari.get(jList1.getSelectedIndex());
        try {
            urunList = new sqlsorgular.urunler().UrunBulByUrunGrup(seciliUrunGrupNo);
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < urunList.size(); i++) {
            listmodel.add(i, urunList.get(i).getUrun_adi());
            urunNumaralari.add(urunList.get(i).getUrun_kodu());
        }
        jList2.setModel(listmodel);
        jList2.validate();
        jList2.repaint();
        this.repaint();
        this.revalidate();
    }
    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:

        seciliUrunNo = urunNumaralari.get(jList2.getSelectedIndex());
        List<sqlsorgular.urunler> urunList = null;
        try {
            urunList = new sqlsorgular.urunler().UrunDetayByUrunKodu(seciliUrunNo);
        } catch (SQLException ex) {
            Logger.getLogger(UrunDuzenle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<urunList.size();i++){
            urunID.setText(String.valueOf(urunList.get(i).getUrun_kodu()));
            urunAdi.setText(urunList.get(i).getUrun_adi());
            urunFiyati.setText(String.valueOf(urunList.get(i).getUrun_fiyat()));
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formComponentShown

    private void urunSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunSilActionPerformed
        // TODO add your handling code here:
        boolean durum = false;
        try {
            durum = new sqlsorgular.urunler().UrunSil(seciliUrunNo);
        } catch (SQLException ex) {
            Logger.getLogger(UrunSil.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(durum){
            UrunlerListesiniGuncelle();
            urunAdi.setText("");
            urunFiyati.setText("");
            urunID.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "SİLİNEMEDİ","HATA",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_urunSilActionPerformed
 public void UrunSilAcilis(){
        urunAdi.setEnabled(false);
        urunFiyati.setEnabled(false);
        urunID.setEnabled(false);
        grupNoCombobox.setEnabled(false);
        grupNumaralari = new ArrayList<>();
        grupNoCombobox.removeAllItems();
        List<sqlsorgular.urunler> grupList = null;
        DefaultListModel listmodel = new DefaultListModel();
        try {
            grupList = new sqlsorgular.urunler().UrunGruplari();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < grupList.size(); i++) {
            listmodel.add(i, grupList.get(i).getUrunGrup_adi());
            grupNumaralari.add(grupList.get(i).getUrunGrup_no());
            grupNoCombobox.addItem(grupList.get(i).getUrunGrup_adi());
        }
        jList1.setModel(listmodel);
        jList1.validate();
        jList1.repaint();
        this.repaint();
        this.revalidate();
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
            java.util.logging.Logger.getLogger(UrunSil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunSil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunSil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunSil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UrunSil urunsil = new UrunSil();
                urunsil.setTitle("Ürün Sil");
                urunsil.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel Kapama1;
    private javax.swing.JLabel Label_urunadi;
    private javax.swing.JLabel Label_urunadi1;
    private javax.swing.JLabel Label_urunid;
    private javax.swing.JLabel Label_ustgrupno;
    private javax.swing.JLabel Label_ustgrupno1;
    private javax.swing.JLabel Label_ustgrupno2;
    private javax.swing.JLabel Resim;
    private javax.swing.JLabel Yazi1;
    private javax.swing.JComboBox<String> grupNoCombobox;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField urunAdi;
    private javax.swing.JTextField urunFiyati;
    private javax.swing.JTextField urunID;
    private javax.swing.JButton urunSil;
    // End of variables declaration//GEN-END:variables
}
