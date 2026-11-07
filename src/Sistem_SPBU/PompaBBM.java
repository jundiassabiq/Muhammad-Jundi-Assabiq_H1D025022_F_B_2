package Sistem_SPBU;

public abstract class PompaBBM {
    public static final String NAMA_SPBU = "SPBU Pertamina 44.533.15";
    private final String kodePompa;

    private String namaBBM;
    private double hargaPerLiter;
    private double stokLiter;

    public PompaBBM(String kodePompa, String namaBBM, double hargaPerLiter, double stokLiter) {
        this.kodePompa = kodePompa;
        this.namaBBM = namaBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.stokLiter = stokLiter;
    }

    public PompaBBM(String kodePompa, String namaBBM, double hargaPerLiter) {
        this(kodePompa, namaBBM, hargaPerLiter, 500.0);
    }

    public double hitungTotalHarga(double liter) {
        return liter * this.hargaPerLiter;
    }

    public void tampilkanInfo() {
        System.out.println("[" + NAMA_SPBU + "] Kode Pompa: " + this.kodePompa);
        System.out.println("Jenis BBM : " + this.namaBBM + " | Harga: Rp" + this.hargaPerLiter + "/L | Stok: " + this.stokLiter + " L");
    }

    public abstract void isiBBM(double liter);

    public String getKodePompa() {
        return this.kodePompa;
    }

    public String getNamaBBM() {
        return this.namaBBM;
    }

    public void setNamaBBM(String namaBBM) {
        this.namaBBM = namaBBM;
    }

    public double getHargaPerLiter() {
        return this.hargaPerLiter;
    }

    public void setHargaPerLiter(double hargaPerLiter) {
        this.hargaPerLiter = hargaPerLiter;
    }

    public double getStokLiter() {
        return this.stokLiter;
    }

    public void setStokLiter(double stokLiter) {
        this.stokLiter = stokLiter;
    }
}
