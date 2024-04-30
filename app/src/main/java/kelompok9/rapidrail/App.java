package kelompok9.rapidrail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RapidRail");

        Pane loginPane = createLoginPane(primaryStage);

        Scene loginScene = new Scene(loginPane, 1200, 700);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private Pane createLoginPane(Stage primaryStage) {
        Pane loginPane = new Pane();
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setLayoutX(450);
        usernameField.setLayoutY(300);
        usernameField.setPrefWidth(300);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutX(450);
        passwordField.setLayoutY(350);
        passwordField.setPrefWidth(300);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(450);
        loginButton.setLayoutY(400);
        loginButton.setPrefWidth(300);

        Button registerButton = new Button("Register");
        registerButton.setLayoutX(450);
        registerButton.setLayoutY(450);
        registerButton.setPrefWidth(300);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean loginSuccess = User.loginUser(username, password);
            if (loginSuccess) {
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Username atau password salah.");
            }
        });

        registerButton.setOnAction(e -> {
            Pane registrationPane = createRegistrationPane(primaryStage);
            Scene registrationScene = new Scene(registrationPane, 1200, 700);
            primaryStage.setScene(registrationScene);
        });

        loginPane.getChildren().addAll(usernameField, passwordField, loginButton, registerButton);
        return loginPane;
    }

    private Pane createRegistrationPane(Stage primaryStage) {
        Pane registrationPane = new Pane();
        
        TextField newUsernameField = new TextField();
        newUsernameField.setPromptText("Username");
        newUsernameField.setLayoutX(450);
        newUsernameField.setLayoutY(200);
        newUsernameField.setPrefWidth(300);

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("Password");
        newPasswordField.setLayoutX(450);
        newPasswordField.setLayoutY(250);
        newPasswordField.setPrefWidth(300);

        TextField newNameField = new TextField();
        newNameField.setPromptText("Full Name");
        newNameField.setLayoutX(450);
        newNameField.setLayoutY(300);
        newNameField.setPrefWidth(300);

        TextField newAddressField = new TextField();
        newAddressField.setPromptText("Address");
        newAddressField.setLayoutX(450);
        newAddressField.setLayoutY(350);
        newAddressField.setPrefWidth(300);

        TextField newPhoneField = new TextField();
        newPhoneField.setPromptText("Phone Number");
        newPhoneField.setLayoutX(450);
        newPhoneField.setLayoutY(400);
        newPhoneField.setPrefWidth(300);

        Button backButton = new Button("Back");
        backButton.setLayoutX(450);
        backButton.setLayoutY(500);
        backButton.setPrefWidth(300);

        Button registerButton = new Button("Register");
        registerButton.setLayoutX(450);
        registerButton.setLayoutY(450);
        registerButton.setPrefWidth(300);

        backButton.setOnAction(e -> {
            Pane loginPane = createLoginPane(primaryStage);
            Scene loginScene = new Scene(loginPane, 1200, 700);
            primaryStage.setScene(loginScene);
        });

        registerButton.setOnAction(e -> {
            String username = newUsernameField.getText();
            String password = newPasswordField.getText();
            String name = newNameField.getText();
            String address = newAddressField.getText();
            String phoneNumber = newPhoneField.getText();
            User.registerUser(username, password, name, address, phoneNumber);

            Pane loginPane = createLoginPane(primaryStage);
            Scene loginScene = new Scene(loginPane, 1200, 700);
            primaryStage.setScene(loginScene);
        });

        registrationPane.getChildren().addAll(newUsernameField, newPasswordField, newNameField, newAddressField, newPhoneField, backButton, registerButton);
        return registrationPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
