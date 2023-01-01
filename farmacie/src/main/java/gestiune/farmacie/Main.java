package gestiune.farmacie;

import gestiune.farmacie.controllers.AplicationEntryController;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicationEntryController.class.getResource("aplicationEntry.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Farmacie");
        stage.setScene(scene);
        stage.show();
        PlatformInstance.setHostedServices(getHostServices());
    }

    public static void main(String[] args) {
        launch();
    }
}