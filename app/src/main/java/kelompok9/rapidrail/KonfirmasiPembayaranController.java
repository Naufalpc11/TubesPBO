package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

    public class KonfirmasiPembayaranController {

        @FXML
        private Button lanjutBayar;

        @FXML
        private Button batalPesan;

        @FXML
        public void initialize() {

        }

        @FXML
        public void lanjutkanPembayaran() {
            System.out.println("Silahkan dibayar");
        }

        @FXML
        public void batalkanPesanan() {
            System.out.println("Pesanan anda telah dibatalkan");
        }
    }

