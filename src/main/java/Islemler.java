import java.util.*;

public class Islemler {

    static Scanner scan = new Scanner(System.in);
    static Map<Integer, UrunTanimlama> urunListemiz = new HashMap<>();
    static Set<Map.Entry<Integer, UrunTanimlama>> urunler = urunListemiz.entrySet();
    static Set<Integer> keys = urunListemiz.keySet();

    public static void programiBaslat() {

        System.out.println("====================================\nDEPO YONETIM PANELI\n" + "====================================\n" +
                "1- BULUNDURULACAK URUN TANIMLAMA\n" +
                "2- URUN LİSTELE\n" +
                "3- DEPOYA URUN GİRİŞİ\n" +
                "4- URUNU RAFA KOY\n" +
                "5- DEPODAN URUN ÇIKIŞI\n" +
                "6- DEPO SİSTEMİNDEN ÇIKIŞ");

        System.out.println("Lutfen yapmak istediginiz islemi yukaridaki menuden seciniz");
        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                urunTanimlama();
                programiBaslat();
                break;
            case 2:
                urunListele();
                programiBaslat();
                break;
            case 3:
                urunGirisi();
                programiBaslat();
                break;
            case 4:
                rafBelirle();
                programiBaslat();
                break;
            case 5:
                urunCikisiYap();
                programiBaslat();
                break;
            case 6:
                cikisYap();
                break;
            default:
                System.out.println("Yanlis tusa bastiniz. Tekrar deneyiniz");
                programiBaslat();
        }
    }


    public static void urunTanimlama() {
        System.out.println("Urun ekleme ekranina hosgeldiniz.");
        System.out.println("Lutfen eklenecek urunun adini giriniz:");
        String urunAdi = scan.next();
        scan.nextLine();

        System.out.println("Lutfen eklenecek urunun ureticisini giriniz");
        String ureticiAdi = scan.nextLine();

        System.out.println("Lutfen eklenecek urunun birimini giriniz");
        String urunBirimi = scan.next();

        UrunTanimlama urun = new UrunTanimlama(urunAdi, ureticiAdi, urunBirimi);
        urunListemiz.put(urun.getId(), urun);
    }


    public static void urunListele() {

        for (Map.Entry<Integer, UrunTanimlama> w : urunler) {
            Integer urunKey = w.getKey();
            UrunTanimlama urunum = urunListemiz.get(urunKey);
            System.out.println("Urun ID: " + urunum.getId() + "--" +
                    " Urun Adi: " + urunum.getAd() + "--" +
                    " Urunun Ureticisi: " + urunum.getUretici() + "--" +
                    " Urun Miktari: " + urunum.getMiktar() + " " + urunum.getBirim() + "--" +
                    " Urunun Bulundugu Raf: " + urunum.getRaf());
        }
    }

    public static void urunGirisi() {
        System.out.println("Urun girisi ekranina hosgeldiniz...");
        System.out.println("Lutfen girisini yapmak istediginiz urun ID'sini giriniz");
        int userID = scan.nextInt();


        if (keys.contains(userID)) {
            System.out.println("Su anda depomuzda " + urunListemiz.get(userID).getAd() + " urununden " +
                    urunListemiz.get(userID).getMiktar() + " " + urunListemiz.get(userID).getBirim() + " bulunmaktadir.");
            System.out.println("ID'sini girdiginiz urun ile ilgili miktar bilgisi yukarida verilmistir. Bu urune ekleme yapmak istiyorsaniz 'E' tusuna basiniz.\n" +
                    "Ekleme yapmak istediginiz urun bu degilse herhangi bir tusa basarak ana menuye donebilirsiniz..");
            String userResponse = scan.next().toUpperCase();
            if (userResponse.equals("E")) {
                System.out.println("Lutfen eklemek istediginiz miktari giriniz:");
                Integer yeniMiktar = scan.nextInt();
                urunListemiz.get(userID).setMiktar(yeniMiktar);
            } else {
                programiBaslat();
            }
        } else {
            System.out.println("Boyle bir urun yok");
            programiBaslat();
        }
    }


    public static void rafBelirle() {
        System.out.println("Raf belirleme ekranina hosgeldiniz...");
        System.out.println("Lutfen rafini belirlemek istediginiz urun ID'sini giriniz");
        int userID = scan.nextInt();


        if (keys.contains(userID)) {
            if (urunListemiz.get(userID).getRaf().equals("****")) {
                System.out.println("Su anda depomuzda " + urunListemiz.get(userID).getAd() + " urunu hicbir rafa konulmamistir.");
            } else {
                System.out.println("Su anda depomuzda " + urunListemiz.get(userID).getAd() + " urunu " +
                        urunListemiz.get(userID).getRaf() + " rafinda bulunmaktadir.");
            }
            System.out.println("ID'sini girdiginiz urun ile ilgili raf bilgisi yukarida verilmistir. Bu urunun bulundugu rafi degistirmek istiyorsaniz 'E' tusuna basiniz.\n" +
                    "Rafini degistirmek istediginiz urun bu degilse herhangi bir tusa basarak urun girisi surecini yeniden baslatabilirsiniz.");
            String userResponse = scan.next().toUpperCase();
            if (userResponse.equals("E")) {
                System.out.println("Lutfen urunu tasimak istediginiz raf ismini giriniz:");
                String yeniRaf = scan.next();
                urunListemiz.get(userID).setRaf(yeniRaf);
            } else {
                urunGirisi();
            }

        } else {
            System.out.println("Boyle bir urun yok");
            programiBaslat();
        }
    }


    public static void urunCikisiYap() {
        System.out.println("Urun Cikisi ekranina hosgeldiniz...");
        System.out.println("Lutfen cikisini yapmak istediginiz urun ID'sini giriniz");
        int userID = scan.nextInt();
        UrunTanimlama urunum = urunListemiz.get(userID);
        if (keys.contains(userID)) {
            System.out.println("Su anda depomuzda " + urunListemiz.get(userID).getAd() + " urununden " +
                    urunListemiz.get(userID).getMiktar() + " " + urunListemiz.get(userID).getBirim() + " bulunmaktadir.");
            System.out.println("ID'sini girdiginiz urun ile ilgili miktar bilgisi yukarida verilmistir. Bu urunun cikisini yapmak istiyorsaniz 'E' tusuna basiniz.\n" +
                    "Cikisini yapmak istediginiz urun bu degilse herhangi bir tusa basarak ana menuye donebilirsiniz.");
            String userResponse = scan.next().toUpperCase();
            if (userResponse.equals("E")) {
                System.out.println("Lutfen cikis yapmak istediginiz miktari giriniz:");
                Integer userMiktar = scan.nextInt();
                Integer eskiMiktar = urunListemiz.get(userID).getMiktar();
                Integer guncelMiktar = eskiMiktar - userMiktar;
                if (guncelMiktar < 0) {
                    System.out.println("Cikisini yapmak istediginiz miktar depoda bulunan miktardan fazladir.\n" +
                            "Urun: " + urunum.getAd() + " Depoda bulunan miktar: " + urunum.getMiktar() + " " + urunum.getBirim() + "\n" +
                            "Cikisini yapmak istediginiz miktar: " + userMiktar + " " + urunum.getBirim() + "\n" +
                            "Depodaki tum malin cikisini yapmak istiyorsaniz 'E' tusuna basiniz. Veya harhangi bir tusa basarak ana menuye donebilirsiniz.");
                    userResponse = scan.next().toUpperCase();
                    if (userResponse.equals("E")) {
                        urunListemiz.get(userID).setMiktar(0);
                        System.out.println("Islem tamamlandi...");
                    } else {
                        programiBaslat();
                    }
                } else if (guncelMiktar == 0) {
                    System.out.println("Cikisini yapmak istediginiz urunun miktari: 0 " + urunum.getBirim());
                    System.out.println("Urun cikisi yapilamiyor...");
                } else {
                    System.out.println("Urun: " + urunum.getAd() + " Depoda bulunan miktar: " + urunum.getMiktar() + " " + urunum.getBirim() + "\n" +
                            "Cikisini yapmak istediginiz miktar: " + userMiktar + " " + urunum.getBirim());
                    urunListemiz.get(userID).setMiktar(guncelMiktar);
                    System.out.println("Islem gerceklestirildi... Guncel urun miktari: " + urunum.getMiktar() + " " + urunum.getBirim());
                }


            } else {
                programiBaslat();
            }
        } else {
            System.out.println("Depoda boyle bir urun bulunmamaktadir...");
            programiBaslat();
        }
    }


    public static void cikisYap() {
        System.out.println("Depo Yonetim Programini kullandiginiz icin tesekkurler.");
        System.out.println("Cikis yapildi...");
    }

}



























