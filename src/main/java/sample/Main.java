package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "/fxml/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        primaryStage.setTitle("[Telegram] Керування замовленнями");
        primaryStage.setScene(new Scene(root, 750, 320));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
