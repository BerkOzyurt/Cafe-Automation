package GarsonEkrani;

import Listeners.GrupButonAction;
import Listeners.MasalarActionListener;
import Listeners.UrunButonListener;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import thread.urunthread;

public class SiparisEkrani extends javax.swing.JFrame {

    public SiparisEkrani() {
        initComponents();
        sqlsorgular.ortalametod ortala = new sqlsorgular.ortalametod();
        ortala.Ekranoralama(this, this.getWidth(), this.getHeight());
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //SiparisEkraniAcilis();
        Urun_Adlari = new ArrayList<>();
        urun_Ozellik = new ArrayList<>();
        Ust_Urun_Grup_No = new ArrayList<>();
        //UrunKodList = new ArrayList<>();
        UrunAltGrupList = new ArrayList<>();
        SiparisVer.addActionListener(siparisAct);
        siparisAct.Urun_Kod_List = new ArrayList<>(); //siparisactionlistenerdaki public dizi
        siparisAct.Urun_Adet_List = new ArrayList<>();
        siparisAct.Urun_Ozellik_List = new ArrayList<>();

        //----ToolTip Kodları-----
        jButton2.setToolTipText("Geri");
        AdetAzalt.setToolTipText("Yenile");
        AdetArttir.setToolTipText("Adet arttir");
        UrunuCikart.setToolTipText("Ürünü çıkartmak için tıklayın");
        SiparisVer.setToolTipText("Siparişi tamamlamak için tıklayın");
        GeriTusu.setToolTipText("Geri");
        jButton1.setToolTipText("Ara");
        Kapama.setToolTipText("Kapat");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToplamFiyat = new javax.swing.JLabel();
        ToplamLabel = new javax.swing.JLabel();
        AdetArttir = new javax.swing.JButton();
        AdetAzalt = new javax.swing.JButton();
        UrunuCikart = new javax.swing.JButton();
        SiparisVer = new javax.swing.JButton();
        Kapama = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SiparisListesi = new javax.swing.JTable();
        UrunPanel = new javax.swing.JPanel();
        GeriTusu = new javax.swing.JLabel();
        masaNo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ToplamFiyat.setText("0");
        getContentPane().add(ToplamFiyat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 50, 20));

        ToplamLabel.setText("Toplam:");
        getContentPane().add(ToplamLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        AdetArttir.setText("Adet Arttır");
        AdetArttir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdetArttirActionPerformed(evt);
            }
        });
        getContentPane().add(AdetArttir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 110, -1));

        AdetAzalt.setText("Yenile");
        AdetAzalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdetAzaltActionPerformed(evt);
            }
        });
        getContentPane().add(AdetAzalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 110, -1));

        UrunuCikart.setText("Ürünü Çıkart");
        getContentPane().add(UrunuCikart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 150, -1));

        SiparisVer.setText("Siparişi Tamamla");
        SiparisVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiparisVerActionPerformed(evt);
            }
        });
        getContentPane().add(SiparisVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 260, 50));

        Kapama.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 60, 60));

        SiparisListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İsim", "Adet", "Ek Özellik"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(SiparisListesi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 280, 330));

        javax.swing.GroupLayout UrunPanelLayout = new javax.swing.GroupLayout(UrunPanel);
        UrunPanel.setLayout(UrunPanelLayout);
        UrunPanelLayout.setHorizontalGroup(
            UrunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        UrunPanelLayout.setVerticalGroup(
            UrunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(UrunPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 930, 440));

        GeriTusu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GeriTusu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriTusuMouseClicked(evt);
            }
        });
        getContentPane().add(GeriTusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 50));

        masaNo.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        masaNo.setForeground(new java.awt.Color(255, 255, 255));
        masaNo.setText("x. Masa");
        getContentPane().add(masaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jButton1.setText("ARA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 90, 90, 40));

        jTextField1.setText("ARANACAK İFADE");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 750, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 70, 40));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/garsonArkaplan.png"))); // NOI18N
        Arkaplan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Arkaplan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ArkaplanFocusGained(evt);
            }
        });
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1284, 605));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //ActionListener siparisAction = new Listeners.SiparisVerAction(); //Siparis ver butonu için
    public int MasaNo;
    public ArrayList<Integer> Ust_Urun_Grup_No;
    public List<sqlsorgular.urunler> UrunAltGrupList;
    public ArrayList<Integer> UrunKodList = new ArrayList<>();
    static ArrayList<String> urun_Ozellik;
    ArrayList<String> Urun_Adlari;
    HashMap<Integer, String> Acilis_Listesi; //Açılışta gösterilecek butonlarin listesi
    public int GrupNo;
    public static String urun_Adi;
    public static int urun_Adet;
    ActionListener UrunAction = new UrunButonListener();
    Listeners.SiparisVerAction siparisAct = new Listeners.SiparisVerAction();

    //Ürün Grup Değişkenleri///
    HashMap<Integer, String> IlkList; //Yalnızca açılışta gelecek olan gruplar
    HashMap<Integer, String> TumGruplarList; //Tüm ürün gruplari
    HashMap<Integer, String> Butun_Urun_Gruplari; //Veritabanındaki tüm ürün gruplarinin listesi. Butonun adından urungrubuna erişirken kolaylık sağlaması için var

    ActionListener act = new ActionListener() {//Ürün gruplarının Actionlistenerı. Bunun classa alınması gerekiyor
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton grupButon = (JButton) e.getSource();
            String grupAdi = grupButon.getText();
            int grupno = 0;
            for (Entry<Integer, String> entry : Butun_Urun_Gruplari.entrySet()) {
                if (entry.getValue().equals(grupAdi)) {
                    grupno = entry.getKey();
                }
            }
            System.out.println("GrupNom: " + grupno);
            List<sqlsorgular.urunler> grupList = null;
            try {
                grupList = new sqlsorgular.urunler().AltUrunGruplariniBul(grupno);
            } catch (SQLException ex) {
                Logger.getLogger(MasalarActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            Ust_Urun_Grup_No.add(grupno);
            if (Ust_Urun_Grup_No.size() > 0) {
                jButton2.setEnabled(true);
            }
            List<sqlsorgular.urunler> urunListe = null;
            if (grupList.size() == 0) {
                try {
                    urunListe = new sqlsorgular.urunler().UrunBulByUrunGrup(grupno);
                } catch (SQLException ex) {
                    Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
                }
                GrupNo = grupno;
                urunButonlari(urunListe);
            } else {

                grupButonlari(grupList);
            }
        }

    };
    
    public void SiparisEkraniAcilis() {
        ////
        //Panel Tasarım Ayarları
        UrunPanel.setLayout(new GridLayout(5, 5, 20, 20));//Buton boyutları ve aralarındaki mesafeler buradan ayarlanıyor
        UrunPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        masaNo.setText(MasaNo + ". Masa");
        UrunPanel.removeAll();
        this.setTitle(MasaNo+". MASA");
        //
        /*
        Acilis_Listesi = new HashMap<>();
        Butun_Urun_Gruplari = new HashMap<>();
        try {
            Butun_Urun_Gruplari = new GeneralFunctions().TumUrunGruplarininListesi();
        } catch (SQLException ex) {
            Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Siparis listesini açılışta temizliyoruz
       /* DefaultTableModel tablo = (DefaultTableModel) SiparisListesi.getModel();
        tablo.setRowCount(0);
        SiparisListesi.setModel(tablo);*/
        SiparisListesi.validate();
        SiparisListesi.revalidate();
        SiparisListesi.repaint();
        ///////////////

        IlkList = new HashMap<>();

        //Threadler urungrup adeti ve urungrup bilgilerini almayı sağlıyor        
        thread.urunthread urungrup = new urunthread();
        Thread t = new Thread(urungrup);
        t.start();
        try {
            t.join();
        } catch (Exception ex) {
            System.out.println("join urun grup " + ex);
        }

        thread.urunthread urungrup2 = new urunthread();
        Thread t2 = new Thread(urungrup2);
        t2.start();

        try {
            t2.join();
        } catch (Exception ex) {
            System.out.println("join urun grup " + ex);
        }
        List<sqlsorgular.kategoriler> urunGrupList = urungrup2.urungruplist();
        int adet = urunGrupList.size();
        for (int i = 0; i < adet; i++) {
            JButton btn = new JButton(urunGrupList.get(i).getGrup_Adi()); //butonlarinin adlari
            IlkList.put(urunGrupList.get(i).getGrup_No(), urunGrupList.get(i).getGrup_Adi());
            btn.addActionListener(act); //urun gruplarinin action listenerı
            btn.setPreferredSize(new Dimension(300, 300));
            btn.setMaximumSize(new Dimension(100, 100));
            btn.setMinimumSize(new Dimension(100, 100));
            UrunPanel.add(btn, LEFT_ALIGNMENT);
            UrunPanel.repaint();
            UrunPanel.revalidate();
        }
        ButunUrunGruplariniAl();

        /*thread.urunthread uruna = new urunthread();
        Thread th = new Thread(uruna);
        th.start();
        try {
            th.join();
        } catch (Exception e) {
            System.out.println("join " + e);
        }

        thread.urunthread uruna2 = new urunthread();
        Thread th2 = new Thread(uruna2);
        th2.start();
        try {
            th2.join();
        } catch (Exception e) {
            System.out.println("join " + e);
        }

        int adet = uruna.urunadet(); //urun grup adeti

        //ürün grup bilgilerini aldığımız thread
        thread.urunthread urungrup = new urunthread();
        Thread t = new Thread(urungrup);
        t.start();
        try {
            t.join();
        } catch (Exception ex) {
            System.out.println("join urun grup " + ex);
        }

        thread.urunthread urungrup2 = new urunthread();
        Thread t2 = new Thread(urungrup2);
        t2.start();

        try {
            t2.join();
        } catch (Exception ex) {
            System.out.println("join urun grup " + ex);
        }
        //
        //Siparisekrani ilk açıldığında urungrup adeti kadar butonu ekrana basar ve bilgilerini yazar
        List<sqlsorgular.urunler> urunGrupList = urungrup2.urungruplist();
        int adet = urunGrupList.size();
        //Acilis_Listesi = new GeneralFunctions().SiparisEkraniUrunGruplari(); //Generalfunctionstan ilk açılışta gelmesi
        //gereken tüm veriler Acilis_Listesi'ne atili
       
        for(int i=0;i<adet;i++) {
            JButton btn = new JButton(urunGrupList.get(i).getUrunGrup_adi()); //butonlarinin adlari
            btn.addActionListener(act); //urun gruplarinin action listenerı
            btn.setPreferredSize(new Dimension(300, 300));
            btn.setMaximumSize(new Dimension(100, 100));
            btn.setMinimumSize(new Dimension(100, 100));
            UrunPanel.add(btn, LEFT_ALIGNMENT);
            UrunPanel.repaint();
            UrunPanel.revalidate();
        }*/
    }
    public void SiparisEkraniKapat(){
        System.out.println("Kapppaatt");
        
        this.setVisible(false);
        this.dispose();
        
    }
    private void ButunUrunGruplariniAl() {
        Butun_Urun_Gruplari = new HashMap<>();
        List<sqlsorgular.urunler> gruplist = null;
        thread.tumUrunGruplari urunGrup = new thread.tumUrunGruplari();
        Thread th1 = new Thread(urunGrup);
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
        gruplist = urunGrup.urungruplist();
        for (int i = 0; i < gruplist.size(); i++) {
            Butun_Urun_Gruplari.put(gruplist.get(i).getUrunGrup_no(), gruplist.get(i).getUrunGrup_adi());
        }

    }

    //Actionlistener act'te çağrılan metot
    //Eğer bir alt grubu var ise butonlar ekrana bu metot ile basılıyor
    public void grupButonlari(List<sqlsorgular.urunler> grupList) {
        GarsonEkrani.SiparisEkrani sip = new GarsonEkrani.SiparisEkrani();
        UrunAltGrupList = grupList;
        UrunPanel.removeAll();
        for (int i = 0; i < grupList.size(); i++) {
            JButton btn = new JButton(grupList.get(i).getUrunGrup_adi());
            btn.addActionListener(act);
            btn.setPreferredSize(new Dimension(300, 300));
            btn.setMaximumSize(new Dimension(100, 100));
            btn.setMinimumSize(new Dimension(100, 100));
            UrunPanel.add(btn, LEFT_ALIGNMENT);
            UrunPanel.repaint();
            UrunPanel.revalidate();
        }
    }

    //Actionlistener act'te çağrılan metot
    //Eğer bir alt grubu yok ise ürünler ekrana basılıyor
    public void urunButonlari(List<sqlsorgular.urunler> urunListe) {
        UrunPanel.removeAll();
        for (int i = 0; i < urunListe.size(); i++) {
            JButton btn = new JButton(urunListe.get(i).getUrun_adi());
            btn.addActionListener(UrunAction);
            btn.setPreferredSize(new Dimension(300, 300));
            btn.setMaximumSize(new Dimension(100, 100));
            btn.setMinimumSize(new Dimension(100, 100));
            UrunPanel.add(btn, LEFT_ALIGNMENT);
            UrunPanel.repaint();
            UrunPanel.revalidate();
        }
    }

    //UrunOzellikleri framinden siparis onayla butonuna basıldıktan sonra bu metot çalışıyor
    //Asıl tabloya ekleme işini TabloEkle metodu yapıyor. Bu metot onu çağırıoyr ve urun kodu ve bilgilerini
    //daha sonra siparis oluştururken kullanmak için dizilere atıyor
    public void SiparisTablosunaEkle() {
        System.out.println("Burada" + urun_Adi + urun_Adet + urun_Ozellik);
        // SiparisEkrani sip = new SiparisEkrani();
        TabloEkle(urun_Adi, urun_Adet, urun_Ozellik);

        Urun_Adlari.add(urun_Adi);

        try {
            UrunKodList.add(new sqlsorgular.urunler().UrunKoduByAd(urun_Adi));
        } catch (SQLException ex) {
            Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("listeye eklenmedi:" + ex.getMessage());
        }
        System.out.println("SiparisTablosunaEkle()" + UrunKodList.get(0));

        try {
            siparisAct.Urun_Kod_List.add(new sqlsorgular.urunler().UrunKoduByAd(urun_Adi));
        } catch (SQLException ex) {
            Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
        siparisAct.Urun_Adet_List.add(urun_Adet);
        siparisAct.Masa_No = String.valueOf(this.MasaNo);
        System.out.println("sipact" + siparisAct.Urun_Kod_List.get(0));
        urun_Adi = "";
        urun_Adet = 0;
        urun_Ozellik.clear();
        SiparisEkraniAcilis();
    }

    //siparis listesine verilerin eklendiği metot. Bu metot urunozelliklerinde onayla butonuna basıldıktan sonra çalışıyor    
    public void TabloEkle(String urunAdi, int adet, List<String> ozellik) {
        System.out.println("TabloEkle: " + urunAdi + adet + ozellik);
        DefaultTableModel siparisTablo = (DefaultTableModel) SiparisListesi.getModel();
        siparisTablo.fireTableDataChanged();
        Vector v = new Vector();
        v.add(urunAdi);
        v.add(adet);
        String ozellikler = "";
        if (ozellik.size() > 0) {
            for (int i = 0; i < ozellik.size(); i++) {
                if (ozellik.size() == 1) {
                    ozellikler = ozellik.get(i);
                } else {
                    ozellikler = ozellik.get(i) + " , " + ozellikler;
                }

            }
        } else {
            ozellikler = "";
        }
        siparisAct.Urun_Ozellik_List.add(ozellikler);
        v.add(ozellikler);
        Object[] obje = new Object[]{urunAdi, adet, ozellikler};
        siparisTablo.addRow(v);
        // siparisTablo.insertRow(0, obje);
        SiparisListesi.setModel(siparisTablo);
        SiparisListesi.validate();
        SiparisListesi.revalidate();
        SiparisListesi.repaint();

        this.validate();
        this.repaint();
        this.revalidate();

        System.out.println("sonunda");

    }
    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        // kapatma tuşu
        Masalar masalar = new Masalar();
        JFrame jf = new JFrame();
        //jf.add(masalar.getContentPane());
        //jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //jf.pack();
        // jf.setVisible(true); 
        this.setVisible(false); //
    }//GEN-LAST:event_KapamaMouseClicked

    private void GeriTusuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriTusuMouseClicked
        Masalar masalar = new Masalar();
        JFrame jf = new JFrame();
        jf.add(masalar.getContentPane());
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.pack();
        // jf.setVisible(true); 
        this.setVisible(false); //
    }//GEN-LAST:event_GeriTusuMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        SiparisEkraniAcilis();
        System.out.println("formComponentShown");

        if (!urun_Adi.equals("")) {
            SiparisTablosunaEkle();
            System.out.println("formComponentShown");
        }
    }//GEN-LAST:event_formComponentShown

    //Geri butonu. Her tıklanan butonu bir listeye atıyoruz geri giderken de o liste ile sorgulama yapıyoruz
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = Ust_Urun_Grup_No.size();
        System.out.println(Ust_Urun_Grup_No.size() + "---" + Ust_Urun_Grup_No.get(i - 1));
        List<sqlsorgular.urunler> grupList = null;
        try {
            grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(Ust_Urun_Grup_No.get(i - 1));
        } catch (SQLException ex) {
            Logger.getLogger(MasalarActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (grupList.get(0).getUstUrunGrup_No() == 0) {
            SiparisEkraniAcilis();
            Ust_Urun_Grup_No.remove(i - 1);
        } else {
            Ust_Urun_Grup_No.remove(i - 1);
            System.out.println(grupList.size());
            List<sqlsorgular.urunler> urunListe = null;
            if (grupList.size() == 0) {
                try {
                    urunListe = new sqlsorgular.urunler().UrunBulByUrunGrup(Ust_Urun_Grup_No.get(i - 1));
                } catch (SQLException ex) {
                    Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
                }
                urunButonlari(urunListe);
            } else {

                grupButonlari(grupList);
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_formMouseClicked

    private void AdetAzaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdetAzaltActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_AdetAzaltActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        //System.out.println("adet azalt btn");
        if (!urun_Adi.equals("")) {
            SiparisTablosunaEkle();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void SiparisVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiparisVerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SiparisVerActionPerformed

    private void ArkaplanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ArkaplanFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_ArkaplanFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        /* System.out.println("formWindowActivated");

        if (!urun_Adi.equals("")) {
            SiparisTablosunaEkle();
            System.out.println("formWindowActivated");
        }*/
    }//GEN-LAST:event_formWindowActivated

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        /*  System.out.println("formMouseMoved");

        if (!urun_Adi.equals("")) {
            SiparisTablosunaEkle();
            System.out.println("formMouseMoved");
        }*/
    }//GEN-LAST:event_formMouseMoved

    private void AdetArttirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdetArttirActionPerformed
        // TODO add your handling code here:
        for (Integer i : UrunKodList) {
            System.out.println("adetarrtır: " + i);
        }
        for (int j = 0; j < Urun_Adlari.size(); j++) {
            System.out.println("Adetarttr-urunadlari: " + Urun_Adlari.get(j));
        }

    }//GEN-LAST:event_AdetArttirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String urunad = jTextField1.getText();
        if (!urunad.equals("")) {
            List<sqlsorgular.urunler> urunListe = null;
            try {
                urunListe = new sqlsorgular.urunler().UrunBul(urunad);

            } catch (SQLException ex) {
                Logger.getLogger(SiparisEkrani.class.getName()).log(Level.SEVERE, null, ex);
            }
            AramaButonlari(urunListe);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MousePressed
    public void AramaButonlari(List<sqlsorgular.urunler> urunListe) {
        UrunPanel.removeAll();
        for (int i = 0; i < urunListe.size(); i++) {
            String urunad = urunListe.get(i).getUrunAdi();
            System.out.println(urunad);
            JButton btn = new JButton(urunad);
            btn.addActionListener(UrunAction);
            btn.setPreferredSize(new Dimension(300, 300));
            btn.setMaximumSize(new Dimension(100, 100));
            btn.setMinimumSize(new Dimension(100, 100));
            UrunPanel.add(btn, LEFT_ALIGNMENT);
            UrunPanel.repaint();
            UrunPanel.revalidate();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SiparisEkrani sip = new SiparisEkrani();
                sip.repaint();
                sip.setVisible(true);
                //new SiparisEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdetArttir;
    private javax.swing.JButton AdetAzalt;
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel GeriTusu;
    private javax.swing.JLabel Kapama;
    private javax.swing.JTable SiparisListesi;
    private javax.swing.JButton SiparisVer;
    public javax.swing.JLabel ToplamFiyat;
    public javax.swing.JLabel ToplamLabel;
    public javax.swing.JPanel UrunPanel;
    private javax.swing.JButton UrunuCikart;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel masaNo;
    // End of variables declaration//GEN-END:variables
}
