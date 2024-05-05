public class Pembayaran {
    private int idPembayaran;
    private Pemesanan pemesanan;
    private int jumlahPembayaran;
    private String metodePembayaran;
    private String statusPembayaran;

    public Pembayaran(int idPembayaran, Pemesanan pemesanan, int jumlahPembayaran, String metodePembayaran) {
        this.idPembayaran = idPembayaran;
        this.pemesanan = pemesanan;
        this.jumlahPembayaran = jumlahPembayaran;
        this.metodePembayaran = metodePembayaran;
        this.statusPembayaran = "Belum Dikonfirmasi";
    }

    public void tampilkanPembayaran() {
        System.out.println("ID Pembayaran: " + idPembayaran);
        System.out.println("ID Pemesanan: " + pemesanan.getIdPemesanan());
        System.out.println("Jumlah Pembayaran: " + jumlahPembayaran);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status Pembayaran: " + statusPembayaran);
    }

    public void konfirmasiPembayaran() {
        this.statusPembayaran = "Dikonfirmasi";
        System.out.println("Pembayaran dengan ID " + idPembayaran + " telah dikonfirmasi.");
    }

    // Getter dan Setter
    public int getIdPembayaran() {
        return idPembayaran;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public int getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }
}
