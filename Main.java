public class Main {
    public static void main(String[] args) {
        Toko toko = new Toko();
        
        // Tambahkan kursi ke gudang
        toko.getGudangBarang().tambahBahan(Bahan.KAYU, 20);
        toko.getGudangBarang().tambahBahan(Bahan.BAUT, 100);
        toko.getGudangBarang().tambahBahan(Bahan.CAT, 15);

        toko.getGudangBarang().buatBarang(TipeBarang.KURSI, 3); // Tambah 3 kursi ke gudang

        toko.getGudangBarang().cekStokBahan();
        
        toko.getGudangBarang().buatBarang(TipeBarang.KURSI, 5);
        
        toko.getGudangBarang().buatBarang(TipeBarang.MEJA, 5);
        
        toko.getGudangBarang().cekIsiGudang();

        toko.getGudangBarang().tambahBahan(Bahan.KAYU, 20);
        toko.getGudangBarang().tambahBahan(Bahan.BAUT, 100);
        toko.getGudangBarang().tambahBahan(Bahan.CAT, 15);
        toko.getGudangBarang().cekStokBahan();

        toko.getGudangBarang().buatBarang(TipeBarang.KURSI, 5);

        toko.getGudangBarang().cekIsiGudang();

        toko.tambahAntrian(new Pembeli("hanif", TipeBarang.KURSI, 10));
        toko.tambahAntrian(new Pembeli("muflih", TipeBarang.MEJA, 5));
        toko.tambahAntrian(new Pembeli("fabih", TipeBarang.LEMARI, 3));

        toko.cekIsiAntrian();
        System.out.println();

        toko.selesaikanAntrian();

        toko.cekIsiAntrian();
        System.out.println();

        toko.getGudangBarang().cekIsiGudang();
    }
}