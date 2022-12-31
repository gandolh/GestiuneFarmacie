package gestiune.farmacie.controllers;

import gestiune.farmacie.data.business.objects.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RedirectController {
    public void goToAplicationEntry(Stage stage)  {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/aplicationEntry.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/Home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToMyAccount(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/myAccount.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToManageUsers(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/ManageUsers.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCreateUser(Stage stage) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestiune/farmacie/controllers/CreateUpdateAccount.fxml"));
            root = loader.load();
            CreateUpdateAccountController controller = loader.getController();
            controller.initializeCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToUpdateUser(Stage stage, User user) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestiune/farmacie/controllers/CreateUpdateAccount.fxml"));
            root = loader.load();
            CreateUpdateAccountController controller = loader.getController();
            controller.initializeUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
