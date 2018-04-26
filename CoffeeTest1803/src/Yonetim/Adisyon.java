/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yonetim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ozkan
 */
public class Adisyon extends javax.swing.JFrame {

    /**
     * Creates new form Adisyon
     */
    public Adisyon() {
        initComponents();
        sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        
          //----ToolTip Kodları-----
        
        jTextField1.setToolTipText("Ödenecek tutar miktarını giriniz"); 
        jTextField2.setToolTipText("İndirim oranını giriniz");
        jButton1.setToolTipText("Nakit ile öde");
        jButton2.setToolTipText("Kredi kartı ile öde");
        jButton3.setToolTipText("İndirim Uygula");
        jButton4.setToolTipText("Siparişi sil");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Geri = new javax.swing.JLabel();
        Kapama = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Siparisler"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ürün Adı", "Adet", "Toplam Tutar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 520, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("NAKİT ÖDE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 241, 175, 97));

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setText("KREDİ KARTIYLA \nÖDE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 241, -1, 97));

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setText("İNDİRİM UYGULA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 356, 175, 97));

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setText("SİPARİŞİ SİL");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 356, 181, 97));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setText("Ödenen Tutar:");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setText("Kalan Tutar:");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel2.setText("Toplam Tutar:");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setText("0.00");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel7.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 23, -1, -1));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("İndirim Oranı:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 434, 36));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 280, -1));

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Ödenecek Tutar:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 620, 480));

        Geri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Geri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriMouseClicked(evt);
            }
        });
        getContentPane().add(Geri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 70));

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 60, 60));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MASA NO: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 1270, -1));

        arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/yonetimBos.png"))); // NOI18N
        getContentPane().add(arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1279, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int Masa_No;
    float ToplamFiyat;
    String Siparis_No;
    static boolean kapat;
    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    private void GeriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriMouseClicked
        this.dispose();
    }//GEN-LAST:event_GeriMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame jm = new JFrame();
        OdemeEkrani odeme = new OdemeEkrani();
        int indirim = 0;
        if (!jTextField2.getText().trim().equals("") && Integer.parseInt(jTextField2.getText().trim()) > 0) {
            indirim = Integer.parseInt(jTextField2.getText().trim());
        } else {
            indirim = 0;
        }

        if (!Siparis_No.trim().equals("")) {
            odeme.OdemeEkraniAcilis(Masa_No, "NAKIT", Float.parseFloat(jTextField1.getText().trim()), Siparis_No, indirim);
        } else {
            JOptionPane.showMessageDialog(this, "Hata", "HATA", JOptionPane.ERROR_MESSAGE);
        }
        //jm.add(odeme.getContentPane());
        //jm.pack();
        //jm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //jm.setVisible(true);
        odeme.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        odeme.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         JFrame menu = new JFrame();
        JPanel pan = new JPanel();
        pan.setSize(new Dimension(200, 50));
        pan.setLayout(new GridLayout());
        JLabel label = new JLabel("İndirim Oranı: %");
        JTextField txt = new JTextField();
        txt.setText("0");
        JButton btn = new JButton("UYGULA");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(txt.getText().trim());
                jTextField2.setText(String.valueOf(a));
                jTextField2.setVisible(true);
                jLabel9.setVisible(true);
                menu.dispose();
                // menu.setVisible(false);
            }
        });
        pan.add(label);
        pan.add(txt);
        pan.add(btn);
        pan.setBackground(Color.white);
        menu.add(pan);
        menu.setUndecorated(true);
        menu.setBackground(Color.white);
        menu.addWindowFocusListener(new WindowFocusListener() {
             @Override
             public void windowGainedFocus(WindowEvent e) {
             }

             @Override
             public void windowLostFocus(WindowEvent e) {
                 menu.dispose();
             }
         });
        menu.pack();
        menu.setLocation(jTextField1.getLocationOnScreen().x - 30, jTextField1.getLocationOnScreen().y + 30);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        if (kapat) {
            KasaAnaSayfa kasa = new KasaAnaSayfa();
            kasa.Yenile=true;
            this.dispose();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         OdemeEkrani odeme = new OdemeEkrani();
        int indirim = 0;
        if (!jTextField2.getText().trim().equals("") && Integer.parseInt(jTextField2.getText().trim()) > 0) {
            indirim = Integer.parseInt(jTextField2.getText().trim());
        } else {
            indirim = 0;
        }

        if (!Siparis_No.trim().equals("")) {
            odeme.OdemeEkraniAcilis(Masa_No, "KREDI KARTI", Float.parseFloat(jTextField1.getText().trim()), Siparis_No, indirim);
        } else {
            JOptionPane.showMessageDialog(this, "Hata", "HATA", JOptionPane.ERROR_MESSAGE);
        }
        odeme.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        odeme.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
     public void AdisyonGoster(ArrayList<String> odetip, String siparisnumara, ArrayList<Integer> adet, ArrayList<Float> fiyat, ArrayList<String> urunadi, ArrayList<Integer> Masano) {
        kapat = false;
        jTextField2.setVisible(false);
        jLabel9.setVisible(false);
        jLabel1.setText("Sipariş NO: " + siparisnumara); //MasaNo label'i guncellendi
        jLabel1.repaint();
        this.setTitle(" Muhasebe Detay"); //Frame'in title'i değişti

        DefaultTableModel siparisTablo = (DefaultTableModel) jTable1.getModel();
        siparisTablo.setRowCount(0);
        int i = 0;
        float toplamtutar = 0;
        Vector[] v = new Vector[fiyat.size()];
        for (i = 0; i < fiyat.size(); i++) {
            v[i] = new Vector();
            v[i].add(urunadi.get(i));
            v[i].add(adet.get(i));

            v[i].add(fiyat.get(i));
            toplamtutar = toplamtutar + fiyat.get(i);
            System.out.println(v[i]);
            siparisTablo.insertRow(0, v[i]);
        }

        jTable1.setModel(siparisTablo);
        jTable1.repaint();
        jTable1.revalidate();

        //jPanel3.setVisible(true);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jLabel6.setText("Ödeme Tipi");
        jLabel3.setText(String.valueOf(toplamtutar));
        jLabel7.setText(odetip.get(0));
        jTextField1.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel8.setVisible(false);
        this.revalidate();
        this.repaint();
    }
      public void AdisyonAcilis(int Masano) {
        kapat = false;
        
        jTextField2.setVisible(false);
        jLabel9.setVisible(false);
        jLabel1.setText("MASA NO: " + Masano); //MasaNo label'i guncellendi
        jLabel1.repaint();
        this.setTitle("MASA " + String.valueOf(Masano) + " ÖDEME"); //Frame'in title'i değişti
        Masa_No = Masano;
        //Veritabanında siparişi alıyoruz
        List<sqlsorgular.siparisler> siparisList = null;
        DefaultTableModel siparisTablo = (DefaultTableModel) jTable1.getModel();
        siparisTablo.setRowCount(0);
        try {
            siparisList = new sqlsorgular.siparisler().SiparisleriAlByMasaNo(Masano); //SİLİNEN SİPARİSLERDEN ALİNACAK
        } catch (SQLException ex) {
            Logger.getLogger(Adisyon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Siparis_No = siparisList.get(0).getSiparis_No();
          System.out.println("masa: "+Masano);
        Vector[] v = new Vector[siparisList.size()];
        for (int i = 0; i < siparisList.size(); i++) {
            v[i] = new Vector();
            v[i].add(siparisList.get(i).getUrun_Adi());
            v[i].add(siparisList.get(i).getUrun_Adet());
            float fiyat = 0.1f;
            fiyat = siparisList.get(i).getUrun_Fiyat();
            fiyat = fiyat * siparisList.get(i).getUrun_Adet();
            ToplamFiyat += fiyat;
            v[i].add(String.valueOf(fiyat));
            System.out.println(v[i]);
            siparisTablo.insertRow(0, v[i]);
        }
        jTable1.setModel(siparisTablo);
        jTable1.repaint();
        jTable1.revalidate();

        jLabel3.setText(String.valueOf(ToplamFiyat));
        jLabel7.setText(String.valueOf(ToplamFiyat));
        jTextField1.setText(String.valueOf(ToplamFiyat));
        this.revalidate();
        this.repaint();
    }

    public void AdisyonKapat() {
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Adisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Adisyon adisyon = new Adisyon();
                adisyon.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                adisyon.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Geri;
    private javax.swing.JLabel Kapama;
    private javax.swing.JLabel arkaplan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}