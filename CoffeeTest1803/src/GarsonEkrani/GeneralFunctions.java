/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GarsonEkrani;

import Yonetim.KategoriEkle;
import Yonetim.UrunEkle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ozkan
 */
public class GeneralFunctions {
    ArrayList<Integer> sonGrup;
    public HashMap<Integer, String> SiparisEkraniUrunGruplari(){
        List<Integer> ustgruplar = null; //Veritabaninda kayıtlı tüm üst gruplari tutmak icin
        HashMap<Integer, String> hashmap = new HashMap<>();
        sonGrup = new ArrayList<>(); //Listelenmiş grupların numaralarinin tutuldugu liste
        List<sqlsorgular.urunler> grupList = null;
    //Tüm üst gruplarin listesi aliniyor ustgruplar'a ataniyor
        try {
            ustgruplar = new sqlsorgular.urunler().UstGruplariGetir();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("heyhey");
        //
        for (int j = 0; j < ustgruplar.size(); j++) { //veritabanındaki üstgruplarin sayisi kadar dön
            try {
                //Tüm üst gruplarin tutuldugu listedeki her ustgrup no için arama yap listeyi gruplist'e at
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ustgruplar.get(j));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (grupList.get(0).getUstUrunGrup_No() == 0) { //Eğer üstgrup numarası 0 ise yani en üst grupta bulunuyorsa
                boolean esitlik = false;
                for (int k = 0; k < sonGrup.size(); k++) { 
                    if (Objects.equals(sonGrup.get(k), ustgruplar.get(j))) {
                        //songrup listesindeki tüm elemanlar ustgruba eşit olana kadar dön 
                        esitlik = true;
       
                    }
                }
                if (!esitlik) { //songrubun elemanı ustgrup numarasina eşit değilse listeye ekle
                    sonGrup.add(ustgruplar.get(j));
                }
            } else {
                boolean buldum = true;
                int ust;
                int sayac = 0;
                while (buldum) { //ustgrup numarasi 0 olana kadar dolaş
                    ust = grupList.get(0).getUstUrunGrup_No();
                    try {
                        grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ust);
                    } catch (SQLException ex) {
                        Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ust == 0) {
                        break;
                    }
                    if(sayac==20){
                        break;
                    }
                    sayac++;
                }
            }
        }
        //return sonGrup;
        System.out.println("hey");
         for (int i = 0; i < sonGrup.size(); i++) {
            try {
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(sonGrup.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            hashmap.put(sonGrup.get(i), grupList.get(0).getUrunGrup_adi());
        }
        return hashmap;
    }
  
    public HashMap<String, Integer> TumUrunGruplarininListesi() throws SQLException{
        List<sqlsorgular.urunler> grupList = null;
        HashMap<String, Integer> hash = new HashMap<>();
        grupList =  new sqlsorgular.urunler().UrunGruplari();
        for(int i=0;i<grupList.size();i++){
            hash.put(grupList.get(i).getUrunGrup_adi(), grupList.get(i).getUrunGrup_no());
        }
        return hash;
        
    }
    public List<sqlsorgular.urunler> SiparisEkraniUrunGruplariListeAl(){
        List<Integer> ustgruplar = null; //Veritabaninda kayıtlı tüm üst gruplari tutmak icin
        HashMap<Integer, String> hashmap = new HashMap<>();
         sonGrup = new ArrayList<>(); //Listelenmiş grupların numaralarinin tutuldugu liste
        List<sqlsorgular.urunler> grupList = null;
    //Tüm üst gruplarin listesi aliniyor ustgruplar'a ataniyor
        try {
            ustgruplar = new sqlsorgular.urunler().UstGruplariGetir();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("heyhey");
        //
        for (int j = 0; j < ustgruplar.size(); j++) { //veritabanındaki üstgruplarin sayisi kadar dön
            try {
                //Tüm üst gruplarin tutuldugu listedeki her ustgrup no için arama yap listeyi gruplist'e at
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ustgruplar.get(j));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (grupList.get(0).getUstUrunGrup_No() == 0) { //Eğer üstgrup numarası 0 ise yani en üst grupta bulunuyorsa
                boolean esitlik = false;
                for (int k = 0; k < sonGrup.size(); k++) { 
                    if (Objects.equals(sonGrup.get(k), ustgruplar.get(j))) {
                        //songrup listesindeki tüm elemanlar ustgruba eşit olana kadar dön 
                        esitlik = true;
       
                    }
                }
                if (!esitlik) { //songrubun elemanı ustgrup numarasina eşit değilse listeye ekle
                    sonGrup.add(ustgruplar.get(j));
                }
            } else {
                boolean buldum = true;
                int ust;
                int sayac = 0;
                while (buldum) { //ustgrup numarasi 0 olana kadar dolaş
                    ust = grupList.get(0).getUstUrunGrup_No();
                    try {
                        grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(ust);
                    } catch (SQLException ex) {
                        Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ust == 0) {
                        break;
                    }
                    if(sayac==20){
                        break;
                    }
                    sayac++;
                }
            }
        }
        //return sonGrup;
        System.out.println("hey");
         for (int i = 0; i < sonGrup.size(); i++) {
            try {
                grupList = new sqlsorgular.urunler().UrunUstGruplariByGrupNo(sonGrup.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(KategoriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
            //hashmap.put(sonGrup.get(i), grupList.get(0).getUrunGrup_adi());
        }
        return grupList;
    }
}
