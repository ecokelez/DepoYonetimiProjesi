package newDepo;

import java.util.Scanner;
import java.util.Set;

public class MenuIslemleri {

    static Scanner scan = new Scanner(System.in);

    public static void menuyuGoster() {

        System.out.println("==================================== OZKARDESLER DEPO YONETIM PANELI ====================================\n" +
                "1- URUN TANIMLAMA EKRANI\n" +
                "2- URUN LİSTELEME EKRANI\n" +
                "3- URUN GİRİŞ EKRANI\n" +
                "4- RAF EKRANI\n" +
                "5- URUN ÇIKIŞ EKRANI\n" +
                "6- DEPO SİSTEMİNDEN ÇIKIŞ");

        System.out.println("Lutfen yapmak istediginiz islemi yukaridaki menuden seciniz");
        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                UrunIslemleri.urunTanimla();
                break;
            case 2:
                UrunDatabase.databasedenUrunleriGoster();
                break;
            case 3:
                UrunIslemleri.urunGirisiYap();
                break;
            case 4:
                UrunIslemleri.rafBelirle();
                break;
            case 5:
                UrunIslemleri.urunCikisiYap();
                break;
            case 6:
                programiKapat();
                break;
            default:
                System.out.println("Yanlis tusa bastiniz. Tekrar deneyiniz");
                menuyuGoster();
        }
    }


    public static void menuyeDonButonu() {
        System.out.println("Ana menuye donmek icin 'D' tusuna basiniz");
        String secim = scan.next().toUpperCase();
        do {
            if (secim.equals("D")) {
                menuyuGoster();
                break;
            } else {
                System.out.println("Hatali giris! Tekrar deneyiniz...");
                System.out.println("Ana menuye donmek icin 'D' tusuna basiniz");
                secim = scan.next().toUpperCase();
            }
        } while (true);
    }

    public static void programiKapat() {
        System.out.println("Sistemi kapatmak istediginize emin misiniz? Eminseniz 'E' tusuna basiniz. Islemi iptal edip Ana Menuye donmek icin '1' tusuna basiniz");
        String secim = scan.next().toUpperCase();
        do {
            if (secim.equals("E")) {
                System.out.println("OZKARDESLER DEPO YONETIM SISTEMINI KULLANDIGINIZ ICIN TESEKKURLER!");
                System.out.println("Sistem kapatildi...");
                break;
            } else if (secim.equals("1")) {
                menuyuGoster();
                break;
            } else {
                System.out.println("Hatali giris yaptiniz!");
                System.out.println("Sistemi kapatmak istediginize emin misiniz? Eminseniz 'E' tusuna basiniz. Islemi iptal edip Ana Menuye donmek icin '1' tusuna basiniz");
                secim = scan.next().toUpperCase();
            }
        } while (true);

    }
}

