package Yonetim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListModel;

public class KategoriEkle extends javax.swing.JFrame {

    public KategoriEkle() {
        initComponents();
        sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        YeniKategoriEkleAcilis();
        OncekiListe = new ArrayList<>();

        //----ToolTip Kodları-----
        jList1.setToolTipText("Kategoriler");
        grupNoCombobox.setToolTipText("Grup numarası seçiniz");
        jButton1.setToolTipText("Geri");
        kategoriAdi.setToolTipText("Kategori adı giriniz");
        kategoriEkle.setToolTipText("Ekle");
        jButton2.setToolTipText("İptal");
        Kapama1.setToolTipText("Kapat");
        this.setTitle("Kategori Ekle");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama1 = new javax.swing.JLabel();
        Yazi1 = new javax.swing.JLabel();
        kategoriAdi = new javax.swing.JTextField();
        kategoriEkle = new javax.swing.JButton();
        Label_kategoriAdi = new javax.swing.JLabel();
        Label_ustgrupno = new javax.swing.JLabel();
        grupNoCombobox = new javax.swing.JComboBox<>();
        Resim = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        Yazi1.setText("Kategori Ekleme Paneli");
        getContentPane().add(Yazi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 50));

        kategoriAdi.setToolTipText("");
        kategoriAdi.setName(""); // NOI18N
        getContentPane().add(kategoriAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 190, -1));

        kategoriEkle.setBackground(new java.awt.Color(182, 95, 34));
        kategoriEkle.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        kategoriEkle.setForeground(new java.awt.Color(255, 255, 255));
        kategoriEkle.setText("Kategori Ekle");
        kategoriEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kategoriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriEkleActionPerformed(evt);
            }
        });
        getContentPane().add(kategoriEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 190, 40));

        Label_kategoriAdi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_kategoriAdi.setText("Kategori Adı:");
        getContentPane().add(Label_kategoriAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 120, 20));

        Label_ustgrupno.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Label_ustgrupno.setText("Kategori Üst Grup No:");
        getContentPane().add(Label_ustgrupno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 160, 20));

        grupNoCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(grupNoCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 190, -1));

        Resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/Arayuz/folder.png"))); // NOI18N
        getContentPane().add(Resim, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 230, 260));

        jButton1.setText("<Geri");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 70, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 97, 190, 20));

        jButton2.setText("İptal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 90, 40));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/urunArkaplan.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1066, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    ArrayList<Integer> grupNumaralari;
    List<Integer> sonGrup;
    ArrayList<Integer> OncekiListe;
    ArrayList<Integer> ComboGrupNoListe;

    HashMap<Integer, String> IlkList; //İlk Açılışta jList'e yüklenen ürün gruplari
    HashMap<Integer, String> TumGruplarList; //Veritabanına kayitli tum urunGruplarinin grupno ve isimleri
    ArrayList<Integer> AktifList; //O anda jlistte bulunan urungruplari
    ArrayList<Integer> GecmisList; //Tıklandığında hafızada tutulacak ürün grupları için. Geri butonunda kullanılıyor
    int SeciliGrupNo, Seviye;
    private boolean guncelle;
    private void Kapama1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kapama1MouseClicked
        this.dispose();
    }//GEN-LAST:event_Kapama1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_formComponentShown

    private void JlistTiklandi() {

        /**
         * Burada jliste tıklandığında gerçekleşecek olaylar kodlandı.
         * Algoritmasını kabaca şöyle açıklayabiliriz: AktifList o anda listede
         * bulunan nesnelerin grup_no'larını tutuyor AktifList'ten seçili
         * grupNoyu Ustgrupno'ya atıyoruz Seviyeyi arttırıyoruz çünkü arttık bir
         * üst seviyey geçtik GeçmişList'e Ustgrupno'yu ekliyoruz. Böylelikle
         * geri dönerken bu listedeki nesneleri kullanacagız Veritabanından
         * ustgrup ve seviye parametreleriyle verileri alıyoruz. Eğer
         * istediğimiz değerlerde veri var ise yeni değerleri listeye atıyoruz
         * ve artık listedeki nesneler değişeceği için aktiflistmizi de ona göre
         * güncelliyoruz Eğer liste boşsa yani sorgunun cevabı null ise seviyeyi
         * ve geçmişlisti eski haline çeviriyoruz
         *
         */
        jButton1.setEnabled(true);
        DefaultListModel listModel = new DefaultListModel();
        List<sqlsorgular.kategoriler> kategorilist = null;
        int secili = jList1.getSelectedIndex();
        String metin = jList1.getSelectedValue();
        grupNoCombobox.setSelectedItem(metin);
        int Ustgrupno = AktifList.get(secili); //Listede tıklanan urungrubumuz sorguya ustgrup olarak giriyor
        Seviye++;
        GecmisList.add(Ustgrupno);
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

        for (Integer ab : AktifList) {
            System.out.println("AktifList: " + ab);
        }
    }

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // LİSTE EYLEMLERİ
        JlistTiklandi();
        /* jButton1.setEnabled(true);
        DefaultListModel listmodel = new DefaultListModel();
        int secili = jList1.getSelectedIndex();
        String metin = jList1.getSelectedValue();

        List<sqlsorgular.urunler> gruplist = null;
        int grup = grupNumaralari.get(secili); //seçim yapılan grup kodu
        System.out.println("GrupNo:" + grupNumaralari.get(secili));
        SeciliGrupNo = grup;
        ///Seçili ürün grubu comboboxa yükleniyor
        int index = 0;
        for (int p = 0; p < ComboGrupNoListe.size(); p++) {
            if (ComboGrupNoListe.get(p) == grup) {
                index = p;
            }
        }
        grupNoCombobox.setSelectedIndex(index + 1);
        ///Combobox işlemlerinin sonu

        //seçili ürün grubunun alt ürün grupları bulunuyor
        try {
            gruplist = new sqlsorgular.urunler().AltUrunGruplariniBul(grup);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int alt = 0; alt < gruplist.size(); alt++) {
            System.out.println("AltGruplist:" + gruplist.get(alt).getUrunGrup_no());
        }

        //bulunan alt urun grupları listeye atanıyor
        if (gruplist.size() > 0) {
            grupNumaralari.clear();
            for (int i = 0; i < gruplist.size(); i++) {
                listmodel.add(i, gruplist.get(i).getUrunGrup_adi());
                grupNumaralari.add(gruplist.get(i).getUrunGrup_no());
            }
            String elimde = jLabel1.getText();
            jLabel1.setText(elimde + " / " + metin);
            jList1.setModel(listmodel);
            jList1.validate();
            jList1.repaint();
            OncekiListe.add(grup); //liste içinde yapılan her seçim bu listeye atanıyor. Bu liste geri butonunda 
            System.out.println("onceki liste" + OncekiListe); //kullanılıyor
        }
        this.repaint();
        this.revalidate();*/
    }//GEN-LAST:event_jList1MouseClicked
    private void GeriButon() {
        //Geri Butonuna Tıklandığında olacaklar
        /**
         * Geributon çalışma mantığı: Öncelikle seviyeyi bir azaltıyoruz
         * böylelikle bir üst grup seviyesine çıkıyoruz Geçmişlistin son elamanı
         * bizim UstGrup numaramızı ifade ediyor. Yani geldiğimiz grupno. O grup
         * numarasının üst grup numarsın buluyoruz. yani onun ait olduğu grup.
         * Dahil olduğu grubun numarsıyla veritabanı sorgusu yapıyoruz ve
         * tabloya yazdırıyoruz
         *
         */
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
            for (Entry<Integer, String> ent : IlkList.entrySet()) {
                listmodel.addElement(ent.getValue());
                grupNoCombobox.setSelectedIndex(0);
                
                AktifList.add(ent.getKey());
            }
        }

        jList1.setModel(listmodel);
        jList1.revalidate();
        jList1.repaint();
        for (Integer aktif : AktifList) {
            System.out.println("Aktiffiim: " + aktif);
        }
        GecmisList.remove(GecmisList.size() - 1);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GeriButon();
        /*DefaultListModel listmodel = new DefaultListModel();
        List<sqlsorgular.urunler> gruplist = null;
        System.out.println("oncekiList:" + OncekiListe);
        System.out.println("onceki son nesne" + OncekiListe.get(OncekiListe.size() - 1));
        if (OncekiListe.size() > 0) {
            try {
                gruplist = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(OncekiListe.get(OncekiListe.size() - 1));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            int ustgrup = gruplist.get(0).getUstUrunGrup_No();
            System.out.println("ustgrup:" + ustgrup);
            SeciliGrupNo = ustgrup;
            if (ustgrup == 0) {
                KategoriEkleAcilis();
            } else {
                for (int j = 0; j < gruplist.size(); j++) {
                    try {
                        gruplist = new sqlsorgular.urunler().AltUrunGruplariniBul(ustgrup);
                    } catch (SQLException ex) {
                        Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < gruplist.size(); i++) {
                    listmodel.add(i, gruplist.get(i).getUrunGrup_adi());
                }
                jList1.setModel(listmodel);
                jList1.validate();
                jList1.repaint();
            }

        } else {
            System.out.println("kategori");
            SeciliGrupNo = 0;
            KategoriEkleAcilis();
        }

        if (OncekiListe.size() != 0) {
            OncekiListe.remove(OncekiListe.size() - 1);
        }

        this.repaint();
        this.revalidate();*/
    }//GEN-LAST:event_jButton1ActionPerformed
    private void Kaydet(boolean guncelle) {
        int UstUrunGrubu = 0;
        if (grupNoCombobox.getSelectedIndex() > 0) {
            String secili = grupNoCombobox.getSelectedItem().toString();
            for (Entry<Integer, String> entry : TumGruplarList.entrySet()) {
                if (entry.getValue().equals(secili)) {
                    UstUrunGrubu = entry.getKey();
                }
            }
        }
        int seviyeYerel=1;
        if(UstUrunGrubu!=0){
            try {
                seviyeYerel = new sqlsorgular.kategoriler().SeviyeAl(UstUrunGrubu);
                seviyeYerel++;
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        String grupadi = kategoriAdi.getText();
        grupadi = new Metotlar().BasHarfleriniBuyut(grupadi);
        if (!guncelle) {
            boolean sonuc = false;
            try {
                sonuc = new sqlsorgular.urunler().UrunGrubuEkle(UstUrunGrubu, grupadi, seviyeYerel);
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (sonuc) {
                YeniKategoriEkleAcilis();
                kategoriAdi.setText("");
                kategoriEkle.setText("Kategori Ekle");
            } else {
                JOptionPane.showMessageDialog(this, "Eklenemedi", "HATA", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Güncelleme
            boolean durum = false;
            try {
                durum = new sqlsorgular.urunler().UrunGrubuGuncelle(SeciliGrupNo, UstUrunGrubu, grupadi, seviyeYerel);
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (durum) {
                System.out.println("Güncelleme başarılı");
                YeniKategoriEkleAcilis();
                kategoriAdi.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Hata oldu güncellenemedi", "HATA", JOptionPane.ERROR_MESSAGE);
            }
            kategoriEkle.setText("Kategori Ekle");
        }
       

    }

    public void YeniKategoriEkleAcilis() {
        Seviye = 1;
        guncelle = false;
        SeciliGrupNo = 0;
        jButton1.setEnabled(false);
        grupNumaralari = new ArrayList<>();
        sonGrup = new ArrayList<>();

        //Aktifler//
        ComboGrupNoListe = new ArrayList<>();
        IlkList = new HashMap<>();
        TumGruplarList = new HashMap<>();
        AktifList = new ArrayList<>();
        GecmisList = new ArrayList<>();
        TablePopUpMenu();
        List<sqlsorgular.urunler> grupList = null;
        List<Integer> ustgruplar = null;
        List<sqlsorgular.urunler> combolist = null;

        //Combobox'a tüm ürün grupları atanıyor
        grupNoCombobox.removeAllItems();
        DefaultComboBoxModel combomodel = new DefaultComboBoxModel();
        try {
            combolist = new sqlsorgular.urunler().UrunGruplari();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        combomodel.addElement("Kök Grup");
        for (int l = 0; l < combolist.size(); l++) {
            combomodel.addElement(combolist.get(l).getUrunGrup_adi());
            //ComboGrupNoListe.add(combolist.get(l).getUrunGrup_no());
            TumGruplarList.put(combolist.get(l).getUrunGrup_no(), combolist.get(l).getUrunGrup_adi());
        }
        grupNoCombobox.setModel(combomodel);
        grupNoCombobox.validate();
        grupNoCombobox.repaint();
        grupNoCombobox.setSelectedIndex(0);
        //////

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
    private void kategoriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriEkleActionPerformed
        // TODO add your handling code here:
        Kaydet(guncelle);
    }//GEN-LAST:event_kategoriEkleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        kategoriEkle.setText("Kategori Ekle");
        guncelle = false;
        kategoriAdi.setText("");
        grupNoCombobox.setSelectedIndex(0);
        YeniKategoriEkleAcilis();
    }//GEN-LAST:event_jButton2ActionPerformed
    

    private void TablePopUpMenu() {
        /**
         * Listeye sağ tıklandığında yapılacak işlemlerin tanımlandığı metot
         */
        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    jList1.setSelectedIndex(jList1.locationToIndex(e.getPoint()));
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem silMenu = new JMenuItem("Sil"); //Sağ tık sil butonu oluşturuluyor
                    silMenu.addActionListener(new ActionListener() { //sil butonuna tıklandığında yapılacaklar
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //System.out.println("jlist1: "+jList1.getModel().getElementAt(nokta));
                            int silGrpNo = AktifList.get(jList1.getSelectedIndex());
                            int a = JOptionPane.showConfirmDialog(KategoriEkle.this, "\n \t\t" + silGrpNo + " kodlu "
                                    + jList1.getSelectedValue() + " Silinecek. \n \t\t\t  Emin Misiniz?", "DİKKAT", JOptionPane.YES_NO_OPTION);
                            if (a == JOptionPane.YES_OPTION) {
                                boolean durum = false;
                                try {
                                    durum = new sqlsorgular.urunler().UrunGrubuSil(silGrpNo);
                                } catch (SQLException ex) {
                                    Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (durum) {
                                    YeniKategoriEkleAcilis();
                                } else {
                                    JOptionPane.showMessageDialog(KategoriEkle.this, "Hata oldu silinemedi", "HATA", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    });
                    menu.add(silMenu);
                    JMenuItem guncelleMenu = new JMenuItem("Güncelle"); //Sağ tık güncelle butonu oluşturuluyor
                    guncelleMenu.addActionListener(new ActionListener() { //Güncelle butonuna tıklandığında yapılacaklar
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int silGrpNo = AktifList.get(jList1.getSelectedIndex());
                            int ustgrup;
                            kategoriAdi.setText(jList1.getSelectedValue().trim());
                            kategoriAdi.repaint();
                            int index = 0;
                            List<sqlsorgular.urunler> ustGrupList = null;
                            try {
                                ustGrupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(silGrpNo);
                            } catch (SQLException ex) {
                                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ustgrup = ustGrupList.get(0).getUstUrunGrup_No();
                            if (ustgrup == 0) {
                                grupNoCombobox.setSelectedIndex(0);
                            } else {
                                grupNoCombobox.setSelectedItem(TumGruplarList.get(ustgrup));
                            }
                            SeciliGrupNo = silGrpNo;
                            System.out.println("secili:" + SeciliGrupNo);
                            kategoriEkle.setText("Güncelle");
                            guncelle = true;
                            kategoriEkle.repaint();
                        }
                    });
                    menu.add(guncelleMenu);
                    menu.show(jList1, e.getPoint().x, e.getPoint().y);
                }
            }

        });
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
            java.util.logging.Logger.getLogger(KategoriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KategoriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KategoriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KategoriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                KategoriEkle kat = new KategoriEkle();
                kat.setTitle("Kategori Ekleme Ekranı");
                kat.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel Kapama1;
    private javax.swing.JLabel Label_kategoriAdi;
    private javax.swing.JLabel Label_ustgrupno;
    private javax.swing.JLabel Resim;
    private javax.swing.JLabel Yazi1;
    private javax.swing.JComboBox<String> grupNoCombobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kategoriAdi;
    private javax.swing.JButton kategoriEkle;
    // End of variables declaration//GEN-END:variables
}
