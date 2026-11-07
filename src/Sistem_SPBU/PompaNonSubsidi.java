package Sistem_SPBU;

public class PompaNonSubsidi extends PompaBBM implements LayananTransaksi {
    private int poinMember;

    public PompaNonSubsidi(String kodePompa, String namaBBM, double hargaPerLiter, double stokLiter) {
        super(kodePompa, namaBBM, hargaPerLiter, stokLiter);
        this.poinMember = 0;
    }

    public PompaNonSubsidi(String kodePompa, String namaBBM, double hargaPerLiter) {
        super(kodePompa, namaBBM, hargaPerLiter);
        this.poinMember = 0;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori  : BBM Non-Subsidi | Poin Terkumpul: " + this.poinMember);
    }

    @Override
    public void isiBBM(double liter) {
        if (liter <= 0) {
            System.out.println("Gagal: Jumlah liter tidak valid.");
        } else if (liter > this.getStokLiter()) {
            System.out.println("Gagal: Stok " + this.getNamaBBM() + " tidak cukup.");
        } else {
            this.setStokLiter(this.getStokLiter() - liter);
            int tambahanPoin = (int) (liter / 2);
            this.poinMember += tambahanPoin;
            System.out.println("Berhasil mengisi " + liter + " L " + this.getNamaBBM() + ". Sisa stok: " + this.getStokLiter() + " L (+Poin: " + tambahanPoin + ").");
        }
    }

    @Override
    public void cetakStruk(double liter) {
        System.out.println("--- STRUK TRANSAKSI NON-SUBSIDI ---");
        System.out.println("BBM   : " + this.getNamaBBM() + " (" + liter + " L)");
        System.out.println("Total : Rp" + this.hitungTotalHarga(liter));
        System.out.println("Poin  : " + this.poinMember + " poin");
        System.out.println("-----------------------------------");
    }

    public int getPoinMember() {
        return this.poinMember;
    }

    public void setPoinMember(int poinMember) {
        this.poinMember = poinMember;
    }
}
