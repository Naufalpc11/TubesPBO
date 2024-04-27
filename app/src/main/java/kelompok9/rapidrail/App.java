package kelompok9.rapidrail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RapidRail");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1200, 700);

        Button logButton = new Button("Login");
        logButton.setPrefSize(300, 50);
        logButton.setTranslateX(0);
        logButton.setTranslateY(80);
        root.getChildren().add(logButton);

        Button regButton = new Button("Register");
        regButton.setPrefSize(300, 50);
        regButton.setTranslateX(0);
        regButton.setTranslateY(150);
        root.getChildren().add(regButton);

        Button delButton = new Button("Delete Account");
        delButton.setPrefSize(300, 50);
        delButton.setTranslateX(0);
        delButton.setTranslateY(220);
        root.getChildren().add(delButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
