package org.example.demo1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

        @FXML
        private Label rapidRailLabel;

        @FXML
        private Label usernameLabel, passwordLabel, warningLabel;

        @FXML
        private TextField usernameField, passwordField;

        @FXML
        private Button loginButton;

        @FXML
        public void handleLoginButtonAction(ActionEvent event) throws IOException {
            String username = usernameField.getText();
            String password = passwordField.getText();
            System.out.println("Anda sudah login!");

            if (username.isEmpty() || password.isEmpty()) {
                warningLabel.setVisible(true);
            } else {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/demo1/NewPemesananKereta.fxml")));
                Scene mainPageScene = new Scene(root);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                double prevWidth = stage.getWidth();
                double prevHeight = stage.getHeight();
                stage.setScene(mainPageScene);
                stage.setWidth(prevWidth);
                stage.setHeight(prevHeight);
            }
        }
    }

