package Yonetim;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UrunEkle extends javax.swing.JFrame {

    public UrunEkle() {
        initComponents();
         sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        UrunEkleAcilis();
        this.setTitle("Yeni Ürün Ekle");
         //----ToolTip Kodları-----
        
        jList1.setToolTipText("Ürün grupları listesi"); 
        jList2.setToolTipText("Seçili ürün grubuna ait ürünlerin listesi");
        urunGrubu.setToolTipText("Ürün grubu giriniz");
       
        urunAdi.setToolTipText("Ürün adı giriniz");
        urunFiyat.setToolTipText("Ürün fiyatı giriniz");
        urunResim.setToolTipText("Ürün resmi için adres giriniz");
        jButton1.setToolTipText("Ürün resmi ara");
        urunEkle.setToolTipText("Ürün ekle işlemlerini kaydetmek için tıklayın");
        Kapama1.setToolTipText("Kapat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama1 = new javax.swing.JLabel();
        Yazi1 = new javax.swing.JLabel();
        Label_ustgrupno = new javax.swing.JLabel();
        Resim = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Label_ustgrupno2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Label_urunid = new javax.swing.JLabel();
        urunResim = new javax.swing.JTextField();
        urunAdi = new javax.swing.JTextField();
        Label_urunadi = new javax.swing.JLabel();
        Label_urunfiyat = new javax.swing.JLabel();
        urunFiyat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        urunEkle = new javax.swing.JButton();
        Label_urunadi1 = new javax.swing.JLabel();
        urunGrubu = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Arkaplan = new javax.swing.JLabel();

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
        Yazi1.setText("Ürün Ekleme Paneli");
        getContentPane().add(Yazi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 14, -1, 60));

        Label_ustgrupno.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno.setText("Ürün Grupları");
        getContentPane().add(Label_ustgrupno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, 20));

        Resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/Arayuz/coffee.png"))); // NOI18N
        getContentPane().add(Resim, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 190, 240));

        jList2.setEnabled(false);
        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 170, 270));

        Label_ustgrupno2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_ustgrupno2.setText("Seçili Ürün Grubuna Ait Ürünler");
        Label_ustgrupno2.setAlignmentY(0.0F);
        getContentPane().add(Label_ustgrupno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 200, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Yeni Ürün Ekle"));

        Label_urunid.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunid.setText("Ürün Resmi:");

        urunResim.setToolTipText("");
        urunResim.setName(""); // NOI18N

        Label_urunadi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunadi.setText("Ürün Adı:");

        Label_urunfiyat.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunfiyat.setText("Ürün Fiyatı:");

        jButton1.setText("ARA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        urunEkle.setBackground(new java.awt.Color(182, 95, 34));
        urunEkle.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        urunEkle.setForeground(new java.awt.Color(255, 255, 255));
        urunEkle.setText("Ürünü Ekle");
        urunEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urunEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunEkleActionPerformed(evt);
            }
        });

        Label_urunadi1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_urunadi1.setText("Ürün Grubu");

        urunGrubu.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Label_urunid)
                                .addGap(20, 20, 20)
                                .addComponent(urunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(Label_urunadi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Label_urunadi1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(urunGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Label_urunfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(urunResim, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(urunFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_urunadi1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urunGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_urunadi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urunFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_urunfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Label_urunid))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(urunResim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(urunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 410, 270));

        jButton2.setText("<Geri");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/urunArkaplan.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 480));

        setSize(new java.awt.Dimension(1085, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //ArrayList<Integer> grupNumaralari;
    int seciliUrunGrupNo = 0;
      HashMap<Integer, String> IlkList; //İlk Açılışta jList'e yüklenen ürün gruplari
    HashMap<Integer, String> TumGruplarList; //Veritabanına kayitli tum urunGruplarinin grupno ve isimleri
    ArrayList<Integer> AktifList; //O anda jlistte bulunan urungruplari
    ArrayList<Integer> GecmisList; //Tıklandığında hafızada tutulacak ürün grupları için. Geri butonunda kullanılıyor
    int Seviye;
    private boolean guncelle;
    private void Kapama1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kapama1MouseClicked
        this.dispose();
    }//GEN-LAST:event_Kapama1MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        
        
        jButton2.setEnabled(true);
        DefaultListModel listModel = new DefaultListModel();
        List<sqlsorgular.kategoriler> kategorilist = null;
        int secili = jList1.getSelectedIndex();
        String metin = jList1.getSelectedValue();
        urunGrubu.setText(metin);
        int Ustgrupno = AktifList.get(secili); //Listede tıklanan urungrubumuz sorguya ustgrup olarak giriyor
        seciliUrunGrupNo = Ustgrupno;
        System.out.println("Seçtim: "+seciliUrunGrupNo);
        Seviye++;
        GecmisList.add(Ustgrupno);
        UrunlerListesiniGuncelle();
        try {
            kategorilist = new sqlsorgular.kategoriler().UrunGrupListele(Seviye, Ustgrupno);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hata");
        }
        if (kategorilist.size() > 0 && kategorilist != null) {
            AktifList.clear();
            for (int i = 0; i < kategorilist.size(); i++) {
                listModel.addElement(kategorilist.get(i).getGrup_Adi());
                AktifList.add(kategorilist.get(i).getGrup_No());
            }
            jList1.setModel(listModel);
            jList1.revalidate();
            jList1.repaint();
        } else { //Eğer altgrup yok ise seviyeyi eski duruma döndür, geçmişlisti eski durumununa döndür
            Seviye--;
            GecmisList.remove(GecmisList.size() - 1);
        }
    }//GEN-LAST:event_jList1MouseClicked
    private void UrunlerListesiniGuncelle(){
        DefaultListModel listmodel = new DefaultListModel();
        List<sqlsorgular.urunler> urunList = null;
        //seciliUrunGrupNo = grupNumaralari.get(jList1.getSelectedIndex());
        try {
            urunList = new sqlsorgular.urunler().UrunBulByUrunGrup(seciliUrunGrupNo);
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < urunList.size(); i++) {
            listmodel.add(i, urunList.get(i).getUrun_adi());
        }
        urunGrubu.setText(jList1.getSelectedValue());
        jList2.setModel(listmodel);
        jList2.validate();
        jList2.repaint();
        this.repaint();
        this.revalidate();
    }
    private void urunEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunEkleActionPerformed
        // TODO add your handling code here:
        boolean durum = false;
        if (urunGrubu.getText().equals("") && seciliUrunGrupNo == 0) {
            JOptionPane.showMessageDialog(this, "Bir ürün grubu seçiniz", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!urunAdi.equals("") && !urunFiyat.equals("") && seciliUrunGrupNo != 0) {
                String urunadi = urunAdi.getText().trim();
                urunadi = new Metotlar().BasHarfleriniBuyut(urunadi); //Urun ismi baş harfleri büyük olacak şekilde formatlanıyor
                
                float fiyat = Float.parseFloat(urunFiyat.getText().trim().replace(',', '.'));
                System.out.println(fiyat);
                //Veritabanına kayıt gerçekleştiriliyor
                try {
                    durum = new sqlsorgular.urunler().UrunEkle(seciliUrunGrupNo, urunadi, fiyat, urunResim.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (durum) {
                urunAdi.setText("");
                urunFiyat.setText("");
                urunResim.setText("");
                UrunlerListesiniGuncelle();
                //Kaydet();
            } else {
                JOptionPane.showMessageDialog(this, "Bir hata oldu kaydedilemedi");
            }
        }

    }//GEN-LAST:event_urunEkleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         //Resmin yolunu alma işlemi. 
        String secilenYer = "Resimler.UrunResimleri";
        File f=null;
        String path=null;
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        f=fileChooser.getSelectedFile();
        path=f.getAbsolutePath();
        urunResim.setText(path);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (Seviye != 1) {
            Seviye--;
        }
        DefaultListModel listmodel = new DefaultListModel();
        int UstGrup = GecmisList.get(GecmisList.size() - 1); //Bir üst grup numarasi. Bu grup numarasının üst_grup numarasına ihtiyaç var
        int UstUstGrup = 0; //Geldiğimiz listeyi almak için ihtiyaç duyduğumuz üst grup no
        try {
            UstUstGrup = new sqlsorgular.kategoriler().UstGrupAl(UstGrup);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        seciliUrunGrupNo = UstUstGrup;
        System.out.println("secili:"+seciliUrunGrupNo);
        List<sqlsorgular.kategoriler> kategoriList = null; //Seviye ve ustGruba göre grupları al
        try {
            kategoriList = new sqlsorgular.kategoriler().UrunGrupListele(Seviye, UstUstGrup);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ustunustu:" + UstUstGrup);
        AktifList.clear();
        //Veriler HashMap'ten alınarak listeye yükleniyor
        if (UstUstGrup != 0) {
            for (int j = 0; j < kategoriList.size(); j++) {
                listmodel.addElement(kategoriList.get(j).getGrup_Adi());
                AktifList.add(kategoriList.get(j).getGrup_No());
            }
        } else {
            for (Map.Entry<Integer, String> ent : IlkList.entrySet()) {
                listmodel.addElement(ent.getValue());
                urunGrubu.setText("Kök Grup");
                seciliUrunGrupNo=0;
                AktifList.add(ent.getKey());
            }
        }

        jList1.setModel(listmodel);
        jList1.revalidate();
        jList1.repaint();
        GecmisList.remove(GecmisList.size() - 1);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UrunEkle urunekle = new UrunEkle();
                urunekle.setTitle("Ürün Ekle");
                urunekle.setVisible(true);
            }
        });
    }
    public void Kaydet(){//Resim yolu alınıyor fakat Resimler.UrunResimleri klasörüne aktarılmıyor.
        String yol="Resimler.UrunResimleri";
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) {  
	File transferedFile=new File(fc.getSelectedFile().getAbsolutePath()+yol);
	
            try {
                transferedFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
    

    public void UrunEkleAcilis() {
        Seviye = 1;
        guncelle = false;
        seciliUrunGrupNo = 0;
        jButton2.setEnabled(false);
        //grupNumaralari = new ArrayList<>();

        //Aktifler//
        IlkList = new HashMap<>();
        TumGruplarList = new HashMap<>();
        AktifList = new ArrayList<>();
        GecmisList = new ArrayList<>();
        List<sqlsorgular.urunler> grupList = null;
        List<Integer> ustgruplar = null;
        
        DefaultListModel listmodel = new DefaultListModel();
        List<sqlsorgular.kategoriler> kategoriList = null;
        try {
            kategoriList = new sqlsorgular.kategoriler().UrunGrupListele(Seviye, 0);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < kategoriList.size(); i++) {
            listmodel.addElement(kategoriList.get(i).getGrup_Adi());
            IlkList.put(kategoriList.get(i).getGrup_No(), kategoriList.get(i).getGrup_Adi());
            AktifList.add(kategoriList.get(i).getGrup_No());
        }
        jList1.setModel(listmodel);
        jList1.revalidate();
        jList1.repaint();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel Kapama1;
    private javax.swing.JLabel Label_urunadi;
    private javax.swing.JLabel Label_urunadi1;
    private javax.swing.JLabel Label_urunfiyat;
    private javax.swing.JLabel Label_urunid;
    private javax.swing.JLabel Label_ustgrupno;
    private javax.swing.JLabel Label_ustgrupno2;
    private javax.swing.JLabel Resim;
    private javax.swing.JLabel Yazi1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField urunAdi;
    private javax.swing.JButton urunEkle;
    private javax.swing.JTextField urunFiyat;
    private javax.swing.JTextField urunGrubu;
    private javax.swing.JTextField urunResim;
    // End of variables declaration//GEN-END:variables
}
