package Sistem_SPBU;

public class PompaSubsidi extends PompaBBM implements LayananTransaksi, ManajemenTangki {
    private double kuotaMaksimal;

    public PompaSubsidi(String kodePompa, String namaBBM, double hargaPerLiter, double stokLiter, double kuotaMaksimal) {
        super(kodePompa, namaBBM, hargaPerLiter, stokLiter);
        this.kuotaMaksimal = kuotaMaksimal;
    }

    public PompaSubsidi(String kodePompa, String namaBBM, double hargaPerLiter, double kuotaMaksimal) {
        super(kodePompa, namaBBM, hargaPerLiter);
        this.kuotaMaksimal = kuotaMaksimal;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori  : BBM Subsidi (Batas Kuota: " + this.kuotaMaksimal + " L/transaksi)");
    }

    @Override
    public void isiBBM(double liter) {
        if (liter <= 0) {
            System.out.println("Gagal: Jumlah liter harus lebih dari 0.");
        } else if (liter > this.kuotaMaksimal) {
            System.out.println("Gagal: Pembelian " + liter + " L melebihi batas kuota subsidi (" + this.kuotaMaksimal + " L).");
        } else if (liter > this.getStokLiter()) {
            System.out.println("Gagal: Stok BBM tidak mencukupi.");
        } else {
            this.setStokLiter(this.getStokLiter() - liter);
            System.out.println("Berhasil mengisi " + liter + " L " + this.getNamaBBM() + ". Sisa stok: " + this.getStokLiter() + " L.");
        }
    }

    @Override
    public void cetakStruk(double liter) {
        System.out.println("--- STRUK TRANSAKSI SUBSIDI ---");
        System.out.println("BBM   : " + this.getNamaBBM() + " (" + liter + " L)");
        System.out.println("Total : Rp" + this.hitungTotalHarga(liter));
        System.out.println("-------------------------------");
    }

    @Override
    public void isiUlangTangki(double liter) {
        this.setStokLiter(this.getStokLiter() + liter);
        System.out.println("Tangki " + this.getNamaBBM() + " diisi ulang +" + liter + " L. Total stok sekarang: " + this.getStokLiter() + " L.");
    }

    public double getKuotaMaksimal() {
        return this.kuotaMaksimal;
    }

    public void setKuotaMaksimal(double kuotaMaksimal) {
        this.kuotaMaksimal = kuotaMaksimal;
    }
}
