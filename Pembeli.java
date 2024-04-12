class Pembeli {
    private String nama;
    private TipeBarang barangDiBeli;
    private int jumlahBarang;

    public Pembeli(String nama, TipeBarang barangDiBeli, int jumlahBarang) {
        this.nama = nama;
        this.barangDiBeli = barangDiBeli;
        this.jumlahBarang = jumlahBarang;
    }

    public String getNama() {
        return nama;
    }

    public TipeBarang barangDiBeli() {
        return barangDiBeli;
    }

    public int jumlahBarang() {
        return jumlahBarang;
    }
}
