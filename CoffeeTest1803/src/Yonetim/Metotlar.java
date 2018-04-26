/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yonetim;

import java.util.Locale;

/**
 *
 * @author ozkan
 */
public class Metotlar {

    public String BasHarfleriniBuyut(String metin) {
        String urunadi = metin.trim();
        String[] temp = urunadi.split(" ");
        urunadi = "";
        //Giriş tipleri formatlanıyor
        for (int j = 0; j < temp.length; j++) {
            temp[j] = temp[j].toLowerCase(Locale.getDefault());
            String ab = temp[j].substring(0, 1).toUpperCase(Locale.getDefault());
            urunadi = urunadi.concat(ab) + temp[j].substring(1) + " ";
        }
        return urunadi;
    }
}
