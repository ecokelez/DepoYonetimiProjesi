public class UrunTanimlama {

    private String ad;
    private String uretici;
    private Integer miktar = 0;
    private String birim;
    private String raf = "****";
    private Integer id;


    public UrunTanimlama(String ad, String uretici, String birim) {
        this.ad = ad;
        this.uretici = uretici;
        this.birim = birim;
        this.id = (int) (Math.random() * 100000);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Urun Ismi='" + ad + '\'' + ", uretici= '" + uretici + '\'' + ", birim= '" + birim + '\'' + ", Miktar= '" + miktar + '\'' + ", raf= '" + raf + '\'' + '\n';
    }
}
