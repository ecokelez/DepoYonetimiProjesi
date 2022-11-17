package newDepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UrunDatabase {

    static Map<Integer, UrunIslemleri> urunlerListesi = new HashMap<>();
    static Set<Map.Entry<Integer, UrunIslemleri>> urunlerSet = urunlerListesi.entrySet();
    static Set<Integer> keys = urunlerListesi.keySet();

    public static void urunuKaydet(Integer id, UrunIslemleri urun) {
        urunlerListesi.put(id, urun);
        System.out.println("Urun ekleme islemi basariyla gerceklesti...");
    }

    public static void databasedenUrunleriGoster() {

        System.out.println("==================================== URUNLER LISTESI ====================================");
        System.out.println("");
        for (Map.Entry<Integer, UrunIslemleri> w : urunlerSet) {
            System.out.println("Urun ID: " + w.getKey() + ", " + w.getValue());
        }
        MenuIslemleri.menuyeDonButonu();

    }

    public static UrunIslemleri urunIDKontrolEt(Integer id) {
        if (keys.contains(id)) {
            return urunlerListesi.get(id);
        } else {
            return null;
        }
    }

}
