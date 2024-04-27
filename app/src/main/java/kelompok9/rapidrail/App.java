package kelompok9.rapidrail;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RapidRail App");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 2);

        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 3);

        Label phoneNumberLabel = new Label("Phone Number:");
        GridPane.setConstraints(phoneNumberLabel, 0, 4);

        // Text Fields
        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 2);

        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 3);

        TextField phoneNumberInput = new TextField();
        GridPane.setConstraints(phoneNumberInput, 1, 4);

        // Buttons
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 0, 5);
        registerButton.setOnAction(e -> {
            boolean registered = User.registerUser(usernameInput.getText(),
                                                   passwordInput.getText(),
                                                   nameInput.getText(),
                                                   addressInput.getText(),
                                                   phoneNumberInput.getText());
            if (registered) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Registration failed. Please try again.");
            }
        });

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 5);
        loginButton.setOnAction(e -> {
            boolean loggedIn = User.loginUser(usernameInput.getText(), passwordInput.getText());
            if (loggedIn) {
                // Perform actions upon successful login
                // For example: open a new window or display a message
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }
        });

        Button deleteButton = new Button("Delete Account");
        GridPane.setConstraints(deleteButton, 0, 6);
        deleteButton.setOnAction(e -> {
            boolean deleted = User.deleteUser(usernameInput.getText());
            if (deleted) {
                // Perform actions upon successful deletion
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Account not found. Deletion failed.");
            }
        });

        // Add components to grid
        grid.getChildren().addAll(usernameLabel, usernameInput,
                                   passwordLabel, passwordInput,
                                   nameLabel, nameInput,
                                   addressLabel, addressInput,
                                   phoneNumberLabel, phoneNumberInput,
                                   registerButton, loginButton, deleteButton);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
