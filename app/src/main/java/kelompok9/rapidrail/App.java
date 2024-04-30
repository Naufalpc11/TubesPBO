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

        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 700);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setLayoutX(450);
        usernameField.setLayoutY(300);
        usernameField.setPrefWidth(300);
        root.getChildren().add(usernameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutX(450);
        passwordField.setLayoutY(350);
        passwordField.setPrefWidth(300);
        root.getChildren().add(passwordField);

        Button logButton = new Button("Login");
        logButton.setPrefSize(300, 30);
        logButton.setLayoutX(450);
        logButton.setLayoutY(400);
        root.getChildren().add(logButton);

        logButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean loginSuccess = User.loginUser(username, password);
                if (loginSuccess) {
                System.out.println("Login berhasil!");
                } else {
                System.out.println("Username atau password salah.");
                }
        });
        Button regButton = new Button("Register");
        regButton.setPrefSize(300, 30);
        regButton.setLayoutX(450);
        regButton.setLayoutY(450);
        root.getChildren().add(regButton);

        Button delButton = new Button("Delete Account");
        delButton.setPrefSize(300, 30);
        delButton.setLayoutX(450);
        delButton.setLayoutY(500);
        root.getChildren().add(delButton);

        regButton.setOnAction(event1 -> {
            
            root.getChildren().clear();
        
            TextField newUsernameField = new TextField();
            newUsernameField.setPromptText("Username");
            newUsernameField.setLayoutX(450);
            newUsernameField.setLayoutY(200);
            newUsernameField.setPrefWidth(300);
            root.getChildren().add(newUsernameField);
        
            PasswordField newPasswordField = new PasswordField();
            newPasswordField.setPromptText("Password");
            newPasswordField.setLayoutX(450);
            newPasswordField.setLayoutY(250);
            newPasswordField.setPrefWidth(300);
            root.getChildren().add(newPasswordField);
        
            TextField newNameField = new TextField();
            newNameField.setPromptText("Full Name");
            newNameField.setLayoutX(450);
            newNameField.setLayoutY(300);
            newNameField.setPrefWidth(300);
            root.getChildren().add(newNameField);
        
            TextField newAddressField = new TextField();
            newAddressField.setPromptText("Address");
            newAddressField.setLayoutX(450);
            newAddressField.setLayoutY(350);
            newAddressField.setPrefWidth(300);
            root.getChildren().add(newAddressField);
        
            TextField newPhoneField = new TextField();
            newPhoneField.setPromptText("Phone Number");
            newPhoneField.setLayoutX(450);
            newPhoneField.setLayoutY(400);
            newPhoneField.setPrefWidth(300);
            root.getChildren().add(newPhoneField);

            Button backButton = new Button("Back");
            backButton.setPrefSize(300, 30);
            backButton.setLayoutX(450);
            backButton.setLayoutY(500);
            root.getChildren().add(backButton);

            Button registerButton = new Button("Register");
            registerButton.setPrefSize(300, 30);
            registerButton.setLayoutX(450);
            registerButton.setLayoutY(450);
            root.getChildren().add(registerButton);
            registerButton.setOnAction(event2 -> {
                String username = newUsernameField.getText();
                String password = newPasswordField.getText();
                String name = newNameField.getText();
                String address = newAddressField.getText();
                String phoneNumber = newPhoneField.getText();
                User.registerUser(username, password, name, address, phoneNumber);
            });
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
