package kelompok9.rapidrail;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {
    
    private static final String filePath = "D:/Semester 2/PBO/Praktikum/TubesPBO/app/account.json";
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RapidRail");
        User.loadUsersFromJson(filePath);

        primaryStage.setResizable(false);
        Pane loginPane = createLoginPane(primaryStage);
        Scene loginScene = new Scene(loginPane, 1200, 700);
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }

    private Pane createLoginPane(Stage primaryStage) {
        Pane loginPane = new Pane();
    
        // Tambahkan gambar latar belakang
        Image backgroundImage = new Image(getClass().getResource("/desainRR.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(700);
        loginPane.getChildren().add(backgroundImageView);
    
        // Tambahkan elemen-elemen lain setelah gambar latar belakang
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
    
        Button deleteButton = new Button("Delete Account");
        deleteButton.setLayoutX(450);
        deleteButton.setLayoutY(500);
        deleteButton.setPrefWidth(300);
    
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean loginSuccess = User.loginUser(username, password);
            if (loginSuccess) {
                Pane selectTrainServicePane = createSelectTrainService(primaryStage);
                Scene selectTrainServiceScene = new Scene(selectTrainServicePane, 1200, 700);
                primaryStage.setScene(selectTrainServiceScene);
            }
        });
        registerButton.setOnAction(e -> {
            Pane registrationPane = createRegistrationPane(primaryStage);
            Scene registrationScene = new Scene(registrationPane, 1200, 700);
            primaryStage.setScene(registrationScene);
        });
        deleteButton.setOnAction(e -> {
            Pane deleteAccountPane = createDeleteAccountPane(primaryStage);
            Scene deleteAccountScene = new Scene(deleteAccountPane, 1200, 700);
            primaryStage.setScene(deleteAccountScene);
        });

        loginPane.getChildren().addAll(usernameField, passwordField, loginButton, registerButton, deleteButton);
    
        return loginPane;
    }
    

    private Pane createRegistrationPane(Stage primaryStage) {
        Pane registrationPane = new Pane();
        
        Image backgroundImage = new Image(getClass().getResource("/desainRR.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(700);
        registrationPane.getChildren().add(backgroundImageView);

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
            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
                Alert empty = new Alert(Alert.AlertType.ERROR);
                empty.setTitle("Error");
                empty.setHeaderText(null);
                empty.setContentText("Please complete all fields to register");
                empty.showAndWait();
                return;
            } else if (password.length() < 8) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Password must be at least 8 characters");
                alert.showAndWait();
                return;
            } else {
            User.registerUser(username, password, name, address, phoneNumber);
            }
            Pane loginPane = createLoginPane(primaryStage);
            Scene loginScene = new Scene(loginPane, 1200, 700);
            primaryStage.setScene(loginScene);
        });

        registrationPane.getChildren().addAll(newUsernameField, newPasswordField, newNameField, newAddressField, newPhoneField, backButton, registerButton);
        return registrationPane;
    }
    private Pane createDeleteAccountPane(Stage primaryStage) {
        Pane deleteAccountPane = new Pane();

        Image backgroundImage = new Image(getClass().getResource("/desainRR.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1200);
        backgroundImageView.setFitHeight(700);
        deleteAccountPane.getChildren().add(backgroundImageView);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter the Username want to delete");
        usernameField.setLayoutX(450);
        usernameField.setLayoutY(350);
        usernameField.setPrefWidth(300);

        Button deleteButton = new Button("Delete");
        deleteButton.setLayoutX(450);
        deleteButton.setLayoutY(400);
        deleteButton.setPrefWidth(300);

        Button backButton = new Button("Back");
        backButton.setLayoutX(450);
        backButton.setLayoutY(450);
        backButton.setPrefWidth(300);

        deleteButton.setOnAction(e -> {
            String username = usernameField.getText();
            User.deleteUser(username);
        });
        backButton.setOnAction(e -> {
            Pane loginPane = createLoginPane(primaryStage);
            Scene loginScene = new Scene(loginPane, 1200, 700);
            primaryStage.setScene(loginScene);
        });
        deleteAccountPane.getChildren().addAll(usernameField, deleteButton, backButton);
        return deleteAccountPane;
    }

    private Pane createSelectTrainService(Stage primaryStage) {
        VBox selectTrainServiceVBox = new VBox();
        selectTrainServiceVBox.setSpacing(40);
        selectTrainServiceVBox.setAlignment(Pos.BOTTOM_CENTER);

        Button lrtButton = new Button("LRT");
        lrtButton.setPrefSize(150, 150);
        lrtButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lrtButton.setStyle("-fx-background-radius: 75em; " + 
                            "-fx-min-width: 150px; " + 
                            "-fx-min-height: 150px; " + 
                            "-fx-max-width: 150px; " + 
                            "-fx-max-height: 150px;");
        lrtButton.setOnAction(e -> {
            Pane trainLRTPane = createTrainLRT(primaryStage);
            Scene trainLokalScene = new Scene(trainLRTPane, 1200, 700);
            primaryStage.setScene(trainLokalScene);
        });

        Button bandaraButton = new Button("Bandara");
        bandaraButton.setPrefSize(150, 150);
        bandaraButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        bandaraButton.setStyle("-fx-background-radius: 75em; " + 
                                "-fx-min-width: 150px; " + 
                                "-fx-min-height: 150px; " + 
                                "-fx-max-width: 150px; " + 
                                "-fx-max-height: 150px;");
        bandaraButton.setOnAction(e -> {
            Pane trainBandaraPane = createTrainBandara(primaryStage);
            Scene trainLokalScene = new Scene(trainBandaraPane, 1200, 700);
            primaryStage.setScene(trainLokalScene);
        });
        Button mrtButton = new Button("MRT");
        mrtButton.setPrefSize(150, 150);
        mrtButton.setStyle("-fx-background-radius: 75em; " + 
                            "-fx-min-width: 150px; " + 
                            "-fx-min-height: 150px; " + 
                            "-fx-max-width: 150px; " + 
                            "-fx-max-height: 150px;");
        mrtButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mrtButton.setOnAction(e -> {
            Pane trainMRTPane = createTrainMRT(primaryStage);
            Scene trainLokalScene = new Scene(trainMRTPane, 1200, 700);
            primaryStage.setScene(trainLokalScene);
        });
        Button lokalButton = new Button("Lokal");
        lokalButton.setPrefSize(150, 150);
        lokalButton.setStyle("-fx-background-radius: 75em; " + 
                                "-fx-min-width: 150px; " + 
                                "-fx-min-height: 150px; " + 
                                "-fx-max-width: 150px; " + 
                                "-fx-max-height: 150px;");
        lokalButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lokalButton.setOnAction(e -> {
            Pane trainLokalPane = createTrainLokal(primaryStage);
            Scene trainLokalScene = new Scene(trainLokalPane, 1200, 700);
            primaryStage.setScene(trainLokalScene);
        });
        Button logOut = new Button("log Out");
        logOut.setPrefSize(150, 150);
        logOut.setStyle("-fx-background-radius: 75em; " + 
                                "-fx-min-width: 150px; " + 
                                "-fx-min-height: 150px; " + 
                                "-fx-max-width: 150px; " + 
                                "-fx-max-height: 150px;");
        logOut.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Button aboutUs = new Button("?");
        aboutUs.setPrefSize(150, 150);
        aboutUs.setStyle("-fx-background-radius: 75em; " + 
                                "-fx-min-width: 150px; " + 
                                "-fx-min-height: 150px; " + 
                                "-fx-max-width: 150px; " + 
                                "-fx-max-height: 150px;");
                                aboutUs.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        HBox row1 = new HBox(40, lrtButton, bandaraButton, mrtButton, lokalButton);
        HBox row2 = new HBox(40, logOut, aboutUs);

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        selectTrainServiceVBox.getChildren().addAll(row1, row2);
        Insets margin = new Insets(0, 0, 50, 0); 
        VBox.setMargin(row2, margin);

        return selectTrainServiceVBox;
    }

    private Pane createTrainLRT(Stage primaryStage) {
        Pane trainLokal = new Pane();

        return trainLokal;
    }

    private Pane createTrainBandara(Stage primaryStage) {
        Pane trainLokal = new Pane();

        return trainLokal;
    }

    private Pane createTrainMRT(Stage primaryStage) {
        Pane trainLokal = new Pane();

        return trainLokal;
    }

    private Pane createTrainLokal(Stage primaryStage) {
        Pane trainLokal = new Pane();

        return trainLokal;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
