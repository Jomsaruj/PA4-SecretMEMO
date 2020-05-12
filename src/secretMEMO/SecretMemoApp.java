package secretMEMO;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Secret MEMO application keep all of your messages safe!
 * @author Saruj Sattayanurak
 */

public class SecretMemoApp extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("SecretMEMO version 1.0.0");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
