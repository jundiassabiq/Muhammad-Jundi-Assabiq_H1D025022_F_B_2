package Sistem_SPBU;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN & TRANSAKSI SPBU ===");
        System.out.println("Cabang : " + PompaBBM.NAMA_SPBU);
        System.out.println("=========================================\n");

        // Inisialisasi data pompa BBM
        PompaSubsidi pertalite = new PompaSubsidi("P-01", "Pertalite", 10000, 300.0, 20.0);
        PompaNonSubsidi pertamax = new PompaNonSubsidi("P-02", "Pertamax", 15950);

        // Menampilkan status awal pompa
        System.out.println("[STATUS POMPA BBM]");
        pertalite.tampilkanInfo();
        System.out.println();
        pertamax.tampilkanInfo();
        System.out.println();

        // Proses transaksi pengisian BBM pelanggan
        System.out.println("[RIWAYAT TRANSAKSI PENGISIAN]");
        pertalite.isiBBM(25.0); // Transaksi ditolak (melebihi kuota)
        pertalite.isiBBM(15.0); // Transaksi berhasil
        pertamax.isiBBM(10.0);  // Transaksi berhasil + dapat poin
        System.out.println();

        // Pencetakan struk dan pengisian ulang tangki
        System.out.println("[LAYANAN STRUK & LOGISTIK TANGKI]");
        LayananTransaksi strukSolar = new PompaSubsidi("P-03", "Bio Solar", 6800, 100.0, 30.0);
        strukSolar.cetakStruk(10.0);

        ManajemenTangki tangkiPertalite = pertalite;
        tangkiPertalite.isiUlangTangki(50.0);
    }
}