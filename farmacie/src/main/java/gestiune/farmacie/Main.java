package gestiune.farmacie;

import gestiune.farmacie.controllers.AplicationEntryController;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Punctul de pornire al aplicatiei JavaFX
 */
public class Main extends Application {
    /**
     * Entrypoint aplicatie javafx
     */
    public Main() {
    }

    /**
     * Pornire aplicatie FX
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException la citirea fisierului fxml
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicationEntryController.class.getResource("aplicationEntry.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Farmacie");
        stage.setScene(scene);
        stage.show();
        PlatformInstance.setHostedServices(getHostServices());
    }

    /**
     * Entrypoint aplicatie JavaFX
     * @param args console args
     */
    public static void main(String[] args) {
        launch();
    }
}