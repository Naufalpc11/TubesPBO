package org.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PemesananKeretaController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void cariTiket() {

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/project/tubespbo/Views/LandingPageView.fxml")));
            Scene mainPageScene = new Scene(root);
            Stage stage = (Stage) rootPane.getScene().getWindow();
            double prevWidth = stage.getWidth();
            double prevHeight = stage.getHeight();
            stage.setScene(mainPageScene);
            stage.setWidth(prevWidth);
            stage.setHeight(prevHeight);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
