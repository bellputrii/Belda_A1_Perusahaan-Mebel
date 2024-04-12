import java.util.*;

public class Toko {
    private List<Pembeli> antrian;
    private Gudang gudangBarang;

    public Toko() {
        antrian = new ArrayList<>();
        gudangBarang = new Gudang();
        inisialisasiStokGudang(); // Panggil metode inisialisasiStokGudang() dari konstruktor
    }

    private void inisialisasiStokGudang() {
        gudangBarang.tambahBahan(Bahan.KAYU, 0);
        gudangBarang.tambahBahan(Bahan.BAUT, 0);
        gudangBarang.tambahBahan(Bahan.CAT, 0);
    }

    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void tambahAntrian(Pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("Berhasil menambah antrian");
    }

    public void selesaikanAntrian() {
        if (!antrian.isEmpty()) {
            Pembeli pembeli = antrian.get(0);
            TipeBarang barangDiBeli = pembeli.barangDiBeli();
            int jumlahBarang = pembeli.jumlahBarang();

            if (gudangBarang.getStokBarang(barangDiBeli) > 0) {
                if (gudangBarang.getStokBarang(barangDiBeli) >= jumlahBarang) {
                    gudangBarang.kurangiStokBarang(barangDiBeli, jumlahBarang);
                    System.out.println(jumlahBarang + " " + barangDiBeli + " berhasil di keluarkan dari gudang");
                    System.out.println("Antrian terdepan berhasil di selesaikan");
                    antrian.remove(0);
                } else {
                    System.out.println("Stok barang tidak mencukupi untuk antrian saat ini");
                    antrian.remove(1);
                }
            } 
            else {
                System.out.println("Antrian terdepan tidak dapat diselesaikan karena barang yang diminta tidak tersedia di gudang");
                antrian.remove(0); // Menghapus antrian yang tidak dapat diproses
            }
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void cekIsiAntrian() {
        if (!antrian.isEmpty()) {
            System.out.println("\nList Antrian:");
            for (int i = 0; i < antrian.size(); i++) {
                Pembeli pembeli = antrian.get(i);
                System.out.println((i + 1) + ". Nama: " + pembeli.getNama() +
                        ", Barang: " + pembeli.barangDiBeli() +
                        ", Jumlah: " + pembeli.jumlahBarang());
            }
        } else {
            System.out.println("Antrian kosong");
        }
    }
}
