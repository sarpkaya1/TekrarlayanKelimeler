package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------------------------------------------------------------------------------------------------
        // Görev 1: Tekrar eden kelimeleri bulun ve yazdırın
        //---------------------------------------------------------------------------------------------------------------------------------

        // Verilen kelime dizisi
        String[] kelimeDizisi = { "kalem", "elalem", "kelam", "kelime", "kalem", "melek", "emeklemek" };

        //Tekrar eden kelimeler listesi
        List<String> tekrarEdenKelimelerListesi = new ArrayList<>();
        //Tum kelimelerin listesi
        List<String> kelimeListesi = new ArrayList<>();

        //Tek tek tum kelime dizisi icerisindeki kelimeleri gez.
        for (String kelime : kelimeDizisi) {
            //kelimeListesi listesinde dongudeki kelimenin olup olmadigini kontrol et, eger yoksa kelimeListesi listesine ekle
            if (!kelimeListesi.contains(kelime)) {
                kelimeListesi.add(kelime);
            } else {
                //tekrarEdenKelimelerListesi listesinde dongudeki kelimenin olup olmadigini kontrol et, eger yoksa listeye ekle
                if (!tekrarEdenKelimelerListesi.contains(kelime)) {
                    tekrarEdenKelimelerListesi.add(kelime);
                }
            }
        }

        System.out.println("\n------------------------------------------------------------------------------------------------------------");
        System.out.println("Görev 1: Tekrar eden kelimeleri bulun ve yazdırın.");
        System.out.println("Tekrar eden kelime sayısı: " + tekrarEdenKelimelerListesi.size());
        System.out.println("Tekrar eden kelimeler: " + tekrarEdenKelimelerListesi);
        System.out.println("------------------------------------------------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------------------------------------------------
        // Görev 2: Tekrar eden karakterlere sahip kelimeleri bulun ve yazdırın
        //---------------------------------------------------------------------------------------------------------------------------------

        List<String> tekrarEdenHarfliKelimeler = new ArrayList<>();

        //Kelime dizisiyle dongu olustur, kelimeleri tek tek gez.
        for (String kelime : kelimeDizisi) {
            //Her kelimeyi karakterlerine yani harflerine ayir ve yeni bir karakter dizisi olustur.
            char[] karakterDizisi = kelime.toCharArray();
            boolean tekrarEdenHarfVar = false;

            for (int i = 0; i < karakterDizisi.length; i++) {
                for (int j = i + 1; j < karakterDizisi.length; j++) {
                    if (karakterDizisi[i] == karakterDizisi[j]) {
                        tekrarEdenHarfliKelimeler.add(kelime);
                        tekrarEdenHarfVar = true;
                        break;
                    }
                }
                if (tekrarEdenHarfVar) {
                    break;
                }
            }
        }

        System.out.println("\n------------------------------------------------------------------------------------------------------------");
        System.out.println("Görev 2: Tekrar eden karakterlere sahip kelimeleri bulun ve yazdırın.");
        System.out.println("Tekrar eden harflerin oldugu kelimeler: " + tekrarEdenHarfliKelimeler);
        System.out.println("------------------------------------------------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------------------------------------------------
        // Görev 3: Tekrar eden karakterlere sahip kelimeler 2 adet olunca aramayi durdur ve harf listesini yazdir.
        //---------------------------------------------------------------------------------------------------------------------------------

        List<String> tekrarEdenHarfleriOlanIlkIkiKelime = new ArrayList<>();
        List<Character> tumHarfListesi = new ArrayList<>();

        int sayac = 0;
        //Kelime dizisiyle dongu olustur, kelimeleri tek tek gez.
        for (String kelime : kelimeDizisi) {
            //Her kelimeyi karakterlerine yani harflerine ayir ve yeni bir karakter dizisi olustur.
            char[] karakterDizisi = kelime.toCharArray();
            boolean tekrarEdenHarfVar = false;

            for (int i = 0; i < karakterDizisi.length; i++) {
                for (int j = i + 1; j < karakterDizisi.length; j++) {
                    if (karakterDizisi[i] == karakterDizisi[j]) {
                        //Tekrar eden kelimeyi listeye ekle
                        tekrarEdenHarfleriOlanIlkIkiKelime.add(kelime);
                        //Tekrar eden kelimenin harflerini harflistesine ekle
                        for (char c : kelime.toCharArray()) {
                            tumHarfListesi.add(c);
                        }
                        tekrarEdenHarfVar = true;
                        sayac++;
                        //en icteki for dan cik
                        break;
                    }
                }
                if (tekrarEdenHarfVar) {
                    //ortadaki for'dan cik
                    break;
                }
            }
            if (sayac > 1) {
                //ilk for'dan cik
                break;
            }
        }

        System.out.println("\n------------------------------------------------------------------------------------------------------------");
        System.out.println("Görev 3: Tekrar eden karakterlere sahip kelimeler 2 adet olunca aramayi durdur ve harf listesini yazdir.");
        System.out.println("Tekrar eden harfleri olan ilk iki kelime: " + tekrarEdenHarfleriOlanIlkIkiKelime);
        System.out.println("Tekrar eden harfleri olan ilk iki kelimenin tum harfleri: " + tumHarfListesi);
        Set<Character> benzersizKarakterler = new HashSet<>(tumHarfListesi);
        System.out.println("Tekrar eden harfleri olan ilk iki kelimenin benzersiz harfleri: " + benzersizKarakterler);
        System.out.println("------------------------------------------------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------------------------------------------------
        // Görev 4: Tekrar eden tum harflerden rastgele metin olustur.
        //---------------------------------------------------------------------------------------------------------------------------------

        StringBuilder rastgeleMetin = new StringBuilder();

        Random rand = new Random();
        while (tumHarfListesi.size() > 0) { //Tum harf listesi bosalana kadar while dongusunu calistir
            // Rastgele bir numara olustur
            int numara = rand.nextInt(tumHarfListesi.size());

            // Rastgele olusturulan numara ile tumHarfListesinden bu numaradaki karakteri rastgeleMetin'e ekle
            rastgeleMetin.append(tumHarfListesi.get(numara));

            // Sonra tumHarfListesi'nden yukarida kullanilmis olan karakteri sil. Takii, tumHarfListesi bosalana kadar devam et.
            tumHarfListesi.remove(numara);
        }

        System.out.println("\n------------------------------------------------------------------------------------------------------------");
        System.out.println("Görev 4: Tekrar eden tum harflerden rastgele metin olustur.");
        System.out.println("Rastgele Metin: " + rastgeleMetin);
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

}