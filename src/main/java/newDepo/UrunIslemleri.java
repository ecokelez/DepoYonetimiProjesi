package newDepo;

import java.awt.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UrunIslemleri extends MenuIslemleri {
    static Scanner scan = new Scanner(System.in);

    private String urunAdi;
    private String ureticiAdi;
    private String birim;
    private static Integer id;
    private Integer miktar = 0;
    private String UrununBulunduguRaf = null;

    public UrunIslemleri(String urunAdi, String ureticiAdi, String birim) {
        this.urunAdi = urunAdi;
        this.ureticiAdi = ureticiAdi;
        this.birim = birim;
        id = (int) (Math.random() * 100000);
    }

    public static void urunTanimla() {
        System.out.println("==================================== URUN TANIMLAMA EKRANI ====================================");
        System.out.println();

        System.out.println("Lutfen eklenecek urunun adini giriniz:");
        String urunAdi = scan.next();
        scan.nextLine();

        System.out.println("Lutfen eklenecek urunun ureticisini giriniz");
        String ureticiAdi = scan.nextLine();

        System.out.println("Lutfen eklenecek urunun birimini giriniz");
        String urunBirimi = scan.next();

        UrunIslemleri urun = new UrunIslemleri(urunAdi, ureticiAdi, urunBirimi);
        UrunDatabase.urunuKaydet(id, urun);
        MenuIslemleri.menuyeDonButonu();
    }

    public static void urunGirisiYap() {
        System.out.println("==================================== URUN GIRIS EKRANI ====================================");
        System.out.println();

        System.out.println("Lutfen girisi yapilacak urun ID'sini giriniz");
        int userID = scan.nextInt();
        UrunIslemleri urun = UrunDatabase.urunIDKontrolEt(userID);

        do {
            if (urun == null) {
                System.out.println("Bu ID'ye sahip bir urun bulunmamatadir. Lutfen ID'yi yeniden giriniz.");
                userID = scan.nextInt();
                UrunDatabase.urunIDKontrolEt(userID);
            } else {
                System.out.println("Su anda depomuzda " + urun.getUrunAdi() + " urununden " +
                        urun.getMiktar() + " " + urun.getBirim() + " bulunmaktadir.");
                System.out.println("Lutfen eklemek istediginiz miktari giriniz");
                int userMiktar = scan.nextInt();
                urun.setMiktar(urun.getMiktar() + userMiktar);//Ekleme islemi yapildi.
                System.out.println("Yeni miktar " + urun.getMiktar() + " olarak guncellendi.");
                MenuIslemleri.menuyeDonButonu();
                break;
            }

        } while (true);


    }

    public static void rafBelirle() {
        System.out.println("==================================== RAF BELIRLEME EKRANI ====================================");
        System.out.println();

        System.out.println("Lutfen girisi yapilacak urun ID'sini giriniz");
        int userID = scan.nextInt();
        UrunIslemleri urun = UrunDatabase.urunIDKontrolEt(userID);

        do {
            if (urun == null) {
                System.out.println("Bu ID'ye sahip bir urun bulunmamatadir. Lutfen ID'yi yeniden giriniz.");
                userID = scan.nextInt();
                UrunDatabase.urunIDKontrolEt(userID);
            } else {
                if (urun.getUrununBulunduguRaf() == null) {
                    System.out.println("Su anda depomuzda " + urun.getUrunAdi() + " urunu hicbir rafa konulmamistir.");
                    System.out.println("Lutfen eklemek istediginiz rafi belirtiniz");
                    String userRaf = scan.next();
                    urun.setUrununBulunduguRaf(userRaf);
                    System.out.println("Raf belirleme islemi tamamlandi. Su anda " + urun.getUrunAdi() + " urunu " + urun.getUrununBulunduguRaf() + " rafinda bulunmaktadir.");
                    MenuIslemleri.menuyeDonButonu();
                    break;
                } else {
                    System.out.println("Su anda depomuzda " + urun.getUrunAdi() + " urunu " + urun.getUrununBulunduguRaf() + " rafinda bulunmaktadir.");
                    System.out.println("Urunun rafini guncellemek istiyorsaniz 'E' tusuna basiniz. Ana menuye donmek icin '1' tusuna basiniz");
                    String userRaf = scan.next();

                    do {
                        if (userRaf.equals("E")) {
                            System.out.println("Lutfen guncel raf bilgisini giriniz");
                            userRaf = scan.next();
                            urun.setUrununBulunduguRaf(userRaf);
                            System.out.println("Raf guncelleme islemi tamamlandi. Su anda urun " + urun.getUrununBulunduguRaf() + " rafinda bulunmaktadir.");
                            MenuIslemleri.menuyeDonButonu();
                            break;
                        } else if (userRaf.equals("1")) {
                            MenuIslemleri.menuyuGoster();
                            break;
                        } else {
                            System.out.println("Hatali giris!");
                            System.out.println("Urunun rafini guncellemek istiyorsaniz 'E' tusuna basiniz. Ana menuye donmek icin '1' tusuna basiniz");
                            userRaf = scan.next();
                        }
                    } while (true);
                }

            }

        } while (true);

    }


    public static void urunCikisiYap() {

        System.out.println("==================================== URUN CIKIS EKRANI ====================================");
        System.out.println();

        System.out.println("Lutfen cikisi yapilacak urun ID'sini giriniz");
        int userID = scan.nextInt();
        UrunIslemleri urun = UrunDatabase.urunIDKontrolEt(userID);

        do {
            if (urun == null) {
                System.out.println("Bu ID'ye sahip bir urun bulunmamatadir. Lutfen ID'yi yeniden giriniz.");
                userID = scan.nextInt();
                UrunDatabase.urunIDKontrolEt(userID);
            } else {
                System.out.println("Su anda depomuzda " + urun.getUrunAdi() + " urununden " +
                        urun.getMiktar() + " " + urun.getBirim() + " bulunmaktadir.");
                System.out.println("Lutfen cikisini yapmak istediginiz miktari giriniz");
                int userMiktar = scan.nextInt();
                if (userMiktar > urun.getMiktar()) {
                    System.out.println("Girdiginiz miktar depodaki miktardan fazladir.");
                    System.out.println("Urun Adi: " + urun.getUrunAdi() + " Urunun guncel miktari: " + urun.getMiktar());
                    System.out.println("Depodaki " + urun.getUreticiAdi() + " ureticisine ait " + urun.getUrunAdi() + " urununun tamaminin cikisini yapmak istiyorsaniz 'E' tusuna basiniz.\n" +
                            "Islemi iptal edip Ana Menuye donmek istiyorsaniz '1' tusuna basiniz");
                    String userInput = scan.next();

                    do {
                        if (userInput.equals("E")) {
                            urun.setMiktar(0);
                            System.out.println("Islem basariyla gerceklesitirildi.");
                            System.out.println("Urun Adi: " + urun.getUrunAdi() + " Urunun guncel miktari: " + urun.getMiktar());
                            MenuIslemleri.menuyeDonButonu();
                            break;
                        } else if (userInput.equals("1")) {
                            MenuIslemleri.menuyuGoster();
                            break;
                        } else {
                            System.out.println("Hatali giris yaptiniz...");
                            System.out.println("Depodaki " + urun.getUreticiAdi() + " ureticisine ait " + urun.getUrunAdi() + " urununun tamaminin cikisini yapmak istiyorsaniz 'E' tusuna basiniz.\n" +
                                    "Islemi iptal edip Ana Menuye donmek istiyorsaniz '1' tusuna basiniz");
                            userInput = scan.next();
                        }
                    } while (true);
                } else {
                    urun.setMiktar(urun.getMiktar() - userMiktar);
                    System.out.println("Islem basariyla gerceklesitirildi.");
                    System.out.println("Urun Adi: " + urun.getUrunAdi() + " Urunun guncel miktari: " + urun.getMiktar());
                    MenuIslemleri.menuyeDonButonu();
                    break;
                }
                break;
            }

        } while (true);

    }


    public String getUrunAdi() {
        return urunAdi;
    }

    public String getBirim() {
        return birim;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public String getUrununBulunduguRaf() {
        return UrununBulunduguRaf;
    }

    public void setUrununBulunduguRaf(String urununBulunduguRaf) {
        UrununBulunduguRaf = urununBulunduguRaf;
    }

    public String getUreticiAdi() {
        return ureticiAdi;
    }

    @Override
    public String toString() {
        return "Urun Ismi:'" + urunAdi + '\'' + ", Uretici: '" + ureticiAdi + '\'' + ", Birim: '" + birim + '\''
                + ", Miktar: '" + miktar + '\'' + ", Raf Bilgisi: '" + UrununBulunduguRaf + '\'' + '\n';
    }


}
