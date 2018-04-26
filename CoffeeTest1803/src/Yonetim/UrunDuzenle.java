package Yonetim;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UrunDuzenle extends javax.swing.JFrame {

    public UrunDuzenle() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        UrunDuzenleAcilis();
        this.setTitle("Ürün Düzenle");
        //----ToolTip Kodları-----
        
        jList1.setToolTipText("Ürün grupları listesi"); 
        jList2.setToolTipText("Seçili ürün grubuna ait ürünlerin listesi");
        grupNoCombobox.setToolTipText("Ürün grubu seç");
        urunID.setToolTipText("Ürün ID giriniz");
        urunAdi.setToolTipText("Ürün adı giriniz");
        urunFiyat.setToolTipText("Ürün fiyatı giriniz");
        urunResim.setToolTipText("Ürün resmi için adres giriniz");
        urunEkle.setToolTipText("Ürün düzenleme işlemlerini kaydetmek için tıklayın");
        Kapama1.setToolTipText("Kapat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama1 = new javax.swing.JLabel();
        Yazi1 = new javax.swing.JLabel();
        urunID = new javax.swing.JTextField();
        urunAdi = new javax.swing.JTextField();
        urunFiyat = new javax.swing.JTextField();
        urunEkle = new javax.swing.JButton();
        Label_urunid = new javax.swing.JLabel();
        Label_urunadi = new javax.swing.JLabel();
        Label_urunfiyat = new javax.swing.JLabel();
        Label_ustgrupno = new javax.swing.JLabel();
        grupNoCombobox = new javax.swing.JComboBox<>();
        Resim = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Label_ustgrupno1 = new javax.swing.JLabel();
        Label_ustgrupno2 = new javax.swing.JLabel();
        urunResim = new javax.swing.JTextField();
        Label_urunfiyat1 = new javax.swing.JLabel();
        urunDuzenle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        Yazi1.setText("Ürün Düzenleme Paneli");
        getContentPane().add(Yazi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 50));

        urunID.setToolTipText("");
        urunID.setEnabled(false);
        urunID.setName(""); // NOI18N
        getContentPane().add(urunID, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 190, -1));
        getContentPane().add(urunAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 190, -1));
        getContentPane().add(urunFiyat, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 190, -1));

        urunEkle.setBackground(new java.awt.Color(182, 95, 34));
        urunEkle.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        urunEkle.setForeground(new java.awt.Color(255, 255, 255));
        urunEkle.setText("Ürün Düzenle");
        urunEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urunEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunEkleActionPerformed(evt);
            }
        });
        getContentPane().add(urunEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 190, 40));

        Label_urunid.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunid.setText("Ürün ID:");
        getContentPane().add(Label_urunid, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 60, -1));

        Label_urunadi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunadi.setText("Ürün Adı:");
        getContentPane().add(Label_urunadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 110, 20));

        Label_urunfiyat.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunfiyat.setText("Ürün Fiyatı:");
        getContentPane().add(Label_urunfiyat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 120, 20));

        Label_ustgrupno.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno.setText("Ürün Grubu");
        getContentPane().add(Label_ustgrupno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 100, 20));

        grupNoCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(grupNoCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 190, 30));

        Resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/Arayuz/coffee-cup.png"))); // NOI18N
        getContentPane().add(Resim, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 230, 270));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 210, 270));

        Label_ustgrupno1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno1.setText("Ürün Grupları");
        getContentPane().add(Label_ustgrupno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, 20));

        Label_ustgrupno2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_ustgrupno2.setText("Seçili Ürün Grubuna Ait Ürünler");
        Label_ustgrupno2.setAlignmentY(0.0F);
        getContentPane().add(Label_ustgrupno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 200, 40));
        getContentPane().add(urunResim, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 190, -1));

        Label_urunfiyat1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunfiyat1.setText("Ürün Resim:");
        getContentPane().add(Label_urunfiyat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 120, 20));

        urunDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/urunArkaplan.png"))); // NOI18N
        getContentPane().add(urunDuzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
     
        seciliUrunNo = urunNumaralari.get(jList2.getSelectedIndex());
        urunID.setText(String.valueOf(seciliUrunNo));
        List<sqlsorgular.urunler> urunList = null;
        try {
            urunList = new sqlsorgular.urunler().UrunDetayByUrunKodu(seciliUrunNo);
        } catch (SQLException ex) {
            Logger.getLogger(UrunDuzenle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(urunList.size());
        for(int i=0;i<urunList.size();i++){
            urunID.setText(String.valueOf(urunList.get(i).getUrun_kodu()));
            urunAdi.setText(urunList.get(i).getUrun_adi());
            urunFiyat.setText(String.valueOf(urunList.get(i).getUrun_fiyat()));
        }
          
        
    }//GEN-LAST:event_jList2MouseClicked

    private void urunEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunEkleActionPerformed
        // TODO add your handling code here:
           boolean durum = false;
        if (seciliUrunNo==0 && seciliUrunGrupNo == 0) {
            JOptionPane.showMessageDialog(this, "Bir ürün seçiniz", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!urunAdi.equals("") && !urunFiyat.equals("") && seciliUrunGrupNo != 0) {
                String urunadi = urunAdi.getText().trim();
               urunadi = new Metotlar().BasHarfleriniBuyut(urunadi); ////Urun ismi baş harfleri büyük olacak şekilde formatlanıyor
               
                float fiyat = Float.parseFloat(urunFiyat.getText().trim().replace(',', '.'));
                System.out.println(fiyat);
                String resimYolu = Resim.getText();
                durum = new sqlsorgular.urunler().UrunGuncelle(urunadi, seciliUrunNo, grupNumaralari.get(grupNoCombobox.getSelectedIndex()), fiyat, resimYolu);
            }
            if (durum) {
                urunAdi.setText("");
                urunFiyat.setText("");
                UrunlerListesiniGuncelle();
            } else {
                JOptionPane.showMessageDialog(this, "Bir hata oldu kaydedilemedi");
            }
          }
    }//GEN-LAST:event_urunEkleActionPerformed
    public void UrunDuzenleAcilis(){
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
            java.util.logging.Logger.getLogger(UrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UrunDuzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kapama1;
    private javax.swing.JLabel Label_urunadi;
    private javax.swing.JLabel Label_urunfiyat;
    private javax.swing.JLabel Label_urunfiyat1;
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
    private javax.swing.JLabel urunDuzenle;
    private javax.swing.JButton urunEkle;
    private javax.swing.JTextField urunFiyat;
    private javax.swing.JTextField urunID;
    private javax.swing.JTextField urunResim;
    // End of variables declaration//GEN-END:variables
}
