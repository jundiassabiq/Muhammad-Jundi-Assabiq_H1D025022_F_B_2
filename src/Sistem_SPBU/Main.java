package Sistem_SPBU;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN SISTEM DISPENSI SPBU ===");
        System.out.println("Lokasi: " + PompaBBM.NAMA_SPBU + "\n");

        PompaSubsidi pertalite = new PompaSubsidi("P-01", "Pertalite", 10000, 300.0, 20.0);
        PompaNonSubsidi pertamax = new PompaNonSubsidi("P-02", "Pertamax", 15950);

        pertalite.tampilkanInfo();
        System.out.println();
        pertamax.tampilkanInfo();
        System.out.println();

        System.out.println("--- Uji Transaksi & Percabangan State ---");
        pertalite.isiBBM(25.0);
        pertalite.isiBBM(15.0);
        pertamax.isiBBM(10.0);
        System.out.println();

        System.out.println("--- Uji Polimorfisme Interface ---");
        LayananTransaksi strukSubsidi = new PompaSubsidi("P-03", "Bio Solar", 6800, 100.0, 30.0);
        strukSubsidi.cetakStruk(10.0);

        ManajemenTangki tangkiSubsidi = pertalite;
        tangkiSubsidi.isiUlangTangki(50.0);
    }
}
