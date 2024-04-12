import java.util.*;

// Enum untuk tipe barang
enum TipeBarang {
    MEJA,
    KURSI,
    LEMARI
}

// Enum untuk bahan
enum Bahan {
    KAYU,
    BAUT,
    CAT
}

// Class Gudang
class Gudang {
    private HashMap<Bahan, Integer> stokBahan;
    private HashMap<TipeBarang, Integer> stokBarang;

    public Gudang() {
        stokBahan = new HashMap<>();
        stokBarang = new HashMap<>();
    }

    public void cekStokBahan() {
        System.out.println("STOK BAHAN:");
        for (Map.Entry<Bahan, Integer> entry : stokBahan.entrySet()) {
            System.out.println("jumlah: " + entry.getKey() + ", saat ini adalah : " + entry.getValue() + " buah");
        }
        System.out.println();
    }

    public void cekIsiGudang() {
        System.out.println("ISI GUDANG:");
        for (TipeBarang tipeBarang : TipeBarang.values()) {
            int jumlah = stokBarang.getOrDefault(tipeBarang, 0);
            System.out.println("Jumlah: " + tipeBarang + ", saat ini adalah : " + jumlah + " buah");
        }
        System.out.println();
    }
    
    public void tambahBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.getOrDefault(bahan, 0) + jumlah);
    }

    public boolean bahanPembuatanMencukupi(TipeBarang tipeBarang, int jumlah) {
        int kayuNeeded = 0;
        int bautNeeded = 0;
        int catNeeded = 0;

        switch (tipeBarang) {
            case MEJA:
                kayuNeeded = 3 * jumlah;
                bautNeeded = 20 * jumlah;
                catNeeded = 2 * jumlah;
                break;
            case KURSI:
                kayuNeeded = 2 * jumlah;
                bautNeeded = 10 * jumlah;
                catNeeded = 1 * jumlah;
                break;
            case LEMARI:
                kayuNeeded = 5 * jumlah;
                bautNeeded = 30 * jumlah;
                catNeeded = 3 * jumlah;
                break;
        }

        return (stokBahan.containsKey(Bahan.KAYU) && stokBahan.get(Bahan.KAYU) >= kayuNeeded) &&
                (stokBahan.containsKey(Bahan.BAUT) && stokBahan.get(Bahan.BAUT) >= bautNeeded) &&
                (stokBahan.containsKey(Bahan.CAT) && stokBahan.get(Bahan.CAT) >= catNeeded);
    }

    public void buatBarang(TipeBarang tipeBarang, int jumlah) {
        if (bahanPembuatanMencukupi(tipeBarang, jumlah)) {
            switch (tipeBarang) {
                case MEJA:
                    stokBarang.put(tipeBarang, stokBarang.getOrDefault(tipeBarang, 0) + jumlah);
                    kurangiBahan(Bahan.KAYU, 3 * jumlah);
                    kurangiBahan(Bahan.BAUT, 20 * jumlah);
                    kurangiBahan(Bahan.CAT, 2 * jumlah);
                    System.out.println(jumlah + " MEJA berhasil ditambahkan ke gudang\n");
                    break;
                case KURSI:
                    stokBarang.put(tipeBarang, stokBarang.getOrDefault(tipeBarang, 0) + jumlah);
                    kurangiBahan(Bahan.KAYU, 2 * jumlah);
                    kurangiBahan(Bahan.BAUT, 10 * jumlah);
                    kurangiBahan(Bahan.CAT, jumlah);
                    System.out.println(jumlah + " KURSI berhasil ditambahkan ke gudang\n");
                    break;
                case LEMARI:
                    stokBarang.put(tipeBarang, stokBarang.getOrDefault(tipeBarang, 0) + jumlah);
                    kurangiBahan(Bahan.KAYU, 5 * jumlah);
                    kurangiBahan(Bahan.BAUT, 30 * jumlah);
                    kurangiBahan(Bahan.CAT, 3 * jumlah);
                    System.out.println(jumlah + " LEMARI berhasil ditambahkan ke gudang\n");
                    break;
            }
        } else {
            System.out.println("bahan tidak mencukupi\n");
        }
    }

    private void kurangiBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) - jumlah);
    }

    public int getStokBarang(TipeBarang tipeBarang) {
        return stokBarang.getOrDefault(tipeBarang, 0);
    }

    public void kurangiStokBarang(TipeBarang tipeBarang, int jumlah) {
        stokBarang.put(tipeBarang, stokBarang.get(tipeBarang) - jumlah);
    }
}