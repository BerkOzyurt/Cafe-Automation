package Yonetim;

import GarsonEkrani.*;
import Listeners.MasalarActionListener;
import Yonetim.YonetimEkrani;
import com.sun.prism.Graphics;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicButtonListener;
import sqlsorgular.masalar;


public class MasalarYonetim extends javax.swing.JFrame {
    public MasalarYonetim(){
        initComponents();
        
         //----ToolTip Kodları-----
        
        //not kapat ve geri butonları aktif olmadığı için tooltipleri eksik
        
        jButton10.setToolTipText("Ekle");
        jButton11.setToolTipText("Sil");
        jButton9.setToolTipText("Ekle");
        jButton8.setToolTipText("Sil");
      
        jTextField1.setToolTipText("Masa adı giriniz");
        
        jButton2.setToolTipText("Kaydet");
        this.setTitle("Masa Yönetimi");
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        Kapama = new javax.swing.JLabel();
        Geri = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 610, 490));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Masa Adı         : ");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 118, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 227, -1));

        jScrollPane3.setViewportView(jList3);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 130, 170));

        jScrollPane4.setViewportView(jList4);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 136, 170));

        jLabel3.setText("Garsonlar");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jButton8.setText(">");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 85, -1));

        jButton9.setText(">>");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 85, -1));

        jLabel5.setText("İlişkilendirilen Garsonlar");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("KAYDET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 160, 32));

        jScrollPane5.setViewportView(jList1);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 130, 168));

        jLabel4.setText("Mutfaklar");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 50, -1));

        jButton10.setText(">>");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 85, -1));

        jButton11.setText(">");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 85, -1));

        jScrollPane6.setViewportView(jList2);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 136, 168));

        jLabel6.setText("İlişkilendirilen Mutfak");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 600, 490));

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 50, 50));

        Geri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Geri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriMouseClicked(evt);
            }
        });
        getContentPane().add(Geri, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, 50, 60));

        Label.setFont(new java.awt.Font("Calibri", 1, 55)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label.setText("Masalar Yönetim Ekranı");
        getContentPane().add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1270, 70));

        arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/yonetimBos.png"))); // NOI18N
        getContentPane().add(arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1281, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    ArrayList<String> mutfak_kullanicilar = new ArrayList<>();
    ArrayList<String> garson_kullanicilar = new ArrayList<>();
    String masa_ad;
    HashMap<String, Integer> masano = new HashMap<String, Integer>(); //masa_adindan masa_no ya ulasmak icin
    JPanel panel = new JPanel();
    JButton btn = new JButton();
    String Btn_Masa_ad;
    List<String> kullaniciAdList=null;// guncelle butonuna basildigi an alinan garson kullanicilari
    List<String> kullaniciAdList1=null; //guncelle butonuna basildigi an alinan mutfak kullanicilari
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
        jPanel6.setVisible(false);
        acilis();
        MasalarList();
        
    }//GEN-LAST:event_formComponentShown

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultListModel listmodel = new DefaultListModel(); // garson kullanicilarin hepsini yan tarafa gecirir
        for(int i=0;i<garson_kullanicilar.size();i++){
            listmodel.add(i, garson_kullanicilar.get(i));
        }
        jList4.setModel(listmodel);
        jList4.validate();
        jList4.repaint();
        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultListModel listmodel = new DefaultListModel();  //secilen garson kullanicilari yan tarafa gecirir
        ArrayList<String> garson_kullanici = new ArrayList<>();
        try{
            garson_kullanici = (ArrayList<String>) jList3.getSelectedValuesList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "İlişkilendirilecek Garsonu seçiniz");
        }
        for(int i=0; i<garson_kullanici.size();i++){
            listmodel.add(i, garson_kullanici.get(i));
        }
        jList4.setModel(listmodel);
        jList4.validate();
        jList4.repaint();
        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        DefaultListModel listmodel = new DefaultListModel(); // tüm mutfak kullanicilarini yan tarafa gecirir
        for(int i=0;i<mutfak_kullanicilar.size();i++){
            listmodel.add(i, mutfak_kullanicilar.get(i));
        }
        jList2.setModel(listmodel);
        jList2.validate();
        jList2.repaint();
        this.repaint();
        this.revalidate();
   
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        DefaultListModel listmodel = new DefaultListModel(); //secilen mutfak kullanicilarini yan tarafa alir
        ArrayList<String> mutfak_kullanici = new ArrayList<>();
        try{
            mutfak_kullanici = (ArrayList<String>) jList1.getSelectedValuesList();
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, "İlişkilendirilecek Mutfağı seçiniz");
        }
        for(int i=0; i<mutfak_kullanici.size();i++){
            listmodel.add(i, mutfak_kullanici.get(i));
        }
        jList2.setModel(listmodel);
        jList2.validate();
        jList2.repaint();
        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sqlsorgular.masalar mas=new masalar();
        String masaad= jTextField1.getText(); // masa_adi cekilir
        // onceki kullanici_no lara ulasmak icin bir liste
        int size = jList2.getModel().getSize(); 
        
        int size1 = jList4.getModel().getSize();
        String[] AlinankullaniciListe = new String[(size+size1)]; // lisviewlere alinan kullanicilar icin liste
        System.out.println("kaydet");
        System.out.println(size); 
        for(int i=0;i<size;i++){ //mutfak kullanicilari listeye ekleniyor
            AlinankullaniciListe[i] = jList2.getModel().getElementAt(i).toString();
            System.out.println("ad: "+AlinankullaniciListe[i]);
        }
        for(int k=size;k<(size+size1);k++){ // garson kullanicilari listeye ekleniyor
            System.out.println("yazi");
            AlinankullaniciListe[k] = jList4.getModel().getElementAt((k-size)).toString();
            System.out.println(AlinankullaniciListe[k]);
            System.out.println("yazi2");
        }
        
        System.out.println("masaad: "+Btn_Masa_ad);
        int masaid=0;
        try {
            masaid=mas.Masaid_Bul(Btn_Masa_ad); // masa_idsi bulunur
        } catch (SQLException ex) {
            Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println("masaid: "+masaid);
        if(masaid==0){ // eger masaid veritabaninda yoksa ekleme islemi yapilsin
            System.out.println("masa ad bos geldi ekleme yapilacak kisimda ");
            boolean dur=false;
            sqlsorgular.masalar m=new masalar();
            int kullanicino;
            try{
                int masanumarasi=m.MasalarmasaEkle(masaad); //masalar tablosuna ekleme
                for(int i=0;i<AlinankullaniciListe.length;i++){
                    kullanicino=m.Kullanicino_Bul(AlinankullaniciListe[i]); //iliski_masa tablosuna ekleme
                    System.out.println("kullno: "+kullanicino);
                    dur=m.iliskMasaEkleme(masanumarasi, kullanicino);
                }
                if(dur){
                    acilis();
                    jPanel6.setVisible(false);
                }
                else
                    System.out.println("kullanici eklenemedi");
            }catch(Exception e){
                Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, e);
              
            }
        }
        else if(masaid!=0){ // masaid veritabaninda bulunuyorsa guncelleme islemi yapilsin
            
            String[] oncekikullanicilar = new String[(kullaniciAdList.size()+kullaniciAdList1.size())];
        
            for(int j = 0; j<kullaniciAdList1.size();j++){ //once mutfak kullanicilari aliniyor
                oncekikullanicilar[j]=kullaniciAdList1.get(j);
            }
        
            for(int j = kullaniciAdList1.size(); j<kullaniciAdList.size();j++){ //garson kullanicilari dahil ediliyor
                oncekikullanicilar[j]=kullaniciAdList.get((j-kullaniciAdList1.size()));
            }
            
            boolean durum=false;
            int masanum=masano.get(Btn_Masa_ad); //masa_numarası alinir
            int kullanci_no=0,oncekikullanicino=0;
            for(int i=0;i<AlinankullaniciListe.length;i++){
                try {
                    kullanci_no=mas.Kullanicino_Bul(AlinankullaniciListe[i]); //secilen kullanicilarin kullanici_noları bulunur
                    System.out.println("kullno: "+kullanci_no);
                    oncekikullanicino=mas.Kullanicino_Bul(oncekikullanicilar[i]);
                    System.out.println("onceki"+oncekikullanicino);
                    durum=mas.MasaGuncelle(masaad, kullanci_no,oncekikullanicino, masanum); //masa guncellemesi yapılır
                    if(durum)
                        jPanel6.setVisible(false);
                } catch (SQLException ex) {
                    System.out.println("mutfak guncelleme1");
                    Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            acilis();
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
      this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    private void GeriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriMouseClicked
        YonetimEkrani yonetim = new YonetimEkrani();
        this.dispose();
        yonetim.setVisible(true);
    }//GEN-LAST:event_GeriMouseClicked
    public void acilis(){
        jPanel1.removeAll();
        panel = new JPanel(){
             public void paintComponents(java.awt.Graphics g) {
                 super.paintComponent(g);
                 try{
                Image image = Toolkit.getDefaultToolkit().createImage("Resimler.hakkinda.png");
                g.drawImage(image,0,0,this);
               }catch(Exception e){
                   System.out.println("Masalar açılış"+e);
               }
                
            }
        };
        
        
        //panel.setLayout(new GridLayout(50,80,50,100));
        sqlsorgular.masalar masa = new sqlsorgular.masalar();
        int adet = 0;
        try {
            adet = masa.MasaAdet(); 
        } catch (SQLException ex) {
            Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, "Masaadet\n", ex);
        }
        List<sqlsorgular.masalar> masaAdlari = null;
        try {
            masaAdlari = new sqlsorgular.masalar().MasaAdlari();
        } catch (SQLException ex) {
            Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, "masaadlari\n", ex);
        }
        
        
        Image background = Toolkit.getDefaultToolkit().createImage("Resimler.masalarArkaplan.png");
        panel.setLayout(new GridLayout(5,5,10,10));
        
        for(int i=0;i<adet;i++){ //masa sayisina gore buton olusturur
            btn = new JButton(String.valueOf(masaAdlari.get(i).getMasa_Adi()));
            btn.setPreferredSize(new Dimension(150,50));
            btn.addMouseListener(mouselisten);
            panel.add(btn,LEFT_ALIGNMENT);
            panel.repaint();
            panel.revalidate();
            masano.put(masaAdlari.get(i).getMasa_Adi(), masaAdlari.get(i).getMasa_No());
            // hashmap e masaadi ve masa_no su eklenir
            
        }
        
        
        
        
        JButton btn = new JButton("+");
        btn.setPreferredSize(new Dimension(150,50));
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel6.setVisible(true);
            }
        });
        panel.add(btn,LEFT_ALIGNMENT);
        panel.repaint();
        panel.revalidate();
        panel.setSize(jPanel1.getSize());
        jPanel1.add(panel);
        jPanel1.validate();
        jPanel1.revalidate();
        jPanel1.repaint();
        this.repaint();
        this.revalidate();
    }
    
    MouseListener mouselisten = new MouseAdapter() {
        //Sag tiklandiginda sil ve guncelleme islemlerinin gelmesi icin

        @Override
        public void mousePressed(MouseEvent e) {
            JButton bt = (JButton) e.getSource();
                Btn_Masa_ad =bt.getText(); //basilan butonun adi
                if(e.isPopupTrigger()){
                 JPopupMenu popup = new JPopupMenu();
                 popup.add(new JMenuItem(new AbstractAction("Masayı Sil") { // Sile basildiginda yapilacak islem
                public void actionPerformed(ActionEvent e) {
                    sqlsorgular.masalar masa=new masalar();
                    Btn_Masa_ad =bt.getText();
                    System.out.println(Btn_Masa_ad);
                    boolean durum = false;
                    
                    try {
                       int a = JOptionPane.showConfirmDialog(MasalarYonetim.this, "Silinecek Emin Misin?","Siliniyor",JOptionPane.YES_NO_OPTION);
                       // Cevabi evet ise silme islemi gerceklesir
                       if(a==1){ 
                            int masanum=masano.get(Btn_Masa_ad); //masaadina gore numarasina ulasilir
                            durum = masa.MasaSil(masanum); //sil metodu cagirilir
                            
                            if(durum){ // eger basariyla silme islemi yapilirsa panel temizlenir
                                panel.remove(btn);
                                panel.revalidate();
                                panel.repaint();
                                jPanel1.add(panel);
                                jPanel1.validate();
                                jPanel1.revalidate();
                                jPanel1.repaint();
                            }
                       }
                    } catch (SQLException ex) {
                        Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }));
            //Masa Güncelleme -------------------
            popup.add(new JMenuItem(new AbstractAction("Masayı Güncelle") { //masa guncellemesinde yapilacak islemler
                public void actionPerformed(ActionEvent e) {
                    jPanel6.setVisible(true);
                    sqlsorgular.masalar masa=new masalar();
                    Btn_Masa_ad =bt.getText(); //buton adi yani masa adi alinir
                    jTextField1.setText(Btn_Masa_ad); //textfield da masa adi yazilir 
                    int masa_no= masano.get(Btn_Masa_ad); //masanın numarasi cekilir 
                    try {
                        kullaniciAdList1=masa.Mutfakkullanici(masa_no); //bu masaya ait mutfak kullanicilari jlist2 ye eklenir
                    } catch (SQLException ex) {
                        Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DefaultListModel listmodel = new DefaultListModel();
                    for(String kullaniciad: kullaniciAdList1){
                        listmodel.add(0, kullaniciad);
                    }
                    //
                    jList2.setModel(listmodel);
                    jList2.validate();
                    jList2.repaint();
                    try {
                        kullaniciAdList=masa.Garsonkullanici(masa_no); //bu masaya ait garson kullanicilari jlist4 e eklenir
                    } catch (SQLException ex) {
                        Logger.getLogger(MasalarYonetim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   DefaultListModel listmodel1 = new DefaultListModel();
                    for(String garsonkullaniciad: kullaniciAdList){
                        listmodel1.add(0, garsonkullaniciad);
                        System.out.println("dlkanflk"+ garsonkullaniciad);
                    }
                    jList4.setModel(listmodel1);
                    jList4.validate();
                    jList4.repaint();
                    
                    
                }
            }));
            
            
            
            //popup.setLocation(bt.getLocationOnScreen().x, bt.getLocationOnScreen().y);
            popup.show(panel, e.getPoint().x, e.getPoint().y);
               }
            }
            
        
        
        
    };
   public void MasalarList(){
        DefaultListModel mutfaklistmodel = new DefaultListModel();
        DefaultListModel garsonlistmodel = new DefaultListModel();
        sqlsorgular.masalar m= new masalar();
        try{// veritabanındaki tum mutfak ve garson kullanicilari cekilir
            mutfak_kullanicilar=(ArrayList<String>) m.MutfakKullaniciAl();
            garson_kullanicilar=(ArrayList<String>) m.GarsonKullaniciAl();
        }catch(SQLException e){
        }
        
        //tum mutfak kullanicilari jlist1 e eklenir
        for(int i=0;i<mutfak_kullanicilar.size();i++){
            mutfaklistmodel.add(i, mutfak_kullanicilar.get(i));
            
        }
        jList1.setModel(mutfaklistmodel);
        jList1.validate();
        jList1.repaint();
        this.repaint();
        this.revalidate();
        // tum garson kullanicilari jlist3 e eklenir
        for(int i=0;i<garson_kullanicilar.size();i++){
            garsonlistmodel.add(i, garson_kullanicilar.get(i));
            
        }
        jList3.setModel(garsonlistmodel);
        jList3.validate();
        jList3.repaint();
        this.repaint();
        this.revalidate();

    }
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MasalarYonetim m = new MasalarYonetim();
                m.setTitle("Masa Yönetimi");
                m.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Geri;
    private javax.swing.JLabel Kapama;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel arkaplan;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
