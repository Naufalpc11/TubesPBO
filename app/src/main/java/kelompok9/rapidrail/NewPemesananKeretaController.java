package org.example.demo1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NewPemesananKeretaController {


        @FXML
        private AnchorPane rootPane;

        @FXML
        private Label pemesananKeretaLabel;

        @FXML
        private MenuButton keretaTujuanMenuButton;

        @FXML
        private MenuButton keretaAsalMenuButton;

        @FXML
        private DatePicker tanggalKeberangkatanDatePicker;

        @FXML
        private TextField jumlahPenumpangTextField;

        @FXML
        private Button cariTiketButton;

        @FXML
        public void cariTiket() throws IOException {
            keretaTujuanMenuButton.getItems().removeLast();
            keretaAsalMenuButton.getItems().removeLast();
            int jumlahPenumpang = Integer.parseInt(jumlahPenumpangTextField.getText());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/demo1/KonfirmasiPemesananPage.fxml")));
            Scene mainPageScene = new Scene(root);
            Stage stage = (Stage) cariTiketButton.getScene().getWindow();
            double prevWidth = stage.getWidth();
            double prevHeight = stage.getHeight();
            stage.setScene(mainPageScene);
            stage.setWidth(prevWidth);
            stage.setHeight(prevHeight);


        }
    }
