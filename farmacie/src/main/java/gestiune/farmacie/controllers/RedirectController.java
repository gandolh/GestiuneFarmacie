package gestiune.farmacie.controllers;

import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import gestiune.farmacie.data.business.objects.Provider;
import gestiune.farmacie.data.business.objects.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller-ul specific redirectionarii catre diverse ferestre
 */
public class RedirectController {
    /**
     * Constructorul gol
     */
    public RedirectController() {
    }

    /**
     * Redirectionare catre punctul de pornire al aplicatiei
     * @param stage referinta la fereastra curenta
     */
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

    /**
     * Redirectionare catre pagina de acasa
     * @param stage referinta la fereastra curenta
     */
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

    /**
     * Redirectionare catre contul meu
     * @param stage referinta la fereastra curenta
     */
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

    /**
     * Redirectionare catre gestionare utilizatori
     * @param stage referinta la fereastra curenta
     */
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


    /**
     * Redirectionare catre creare utilizatori
     * @param stage referinta la fereastra curenta
     */
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

    /**
     * Redirectionare catre actualizare utilizator specific
     * @param stage referinta la fereastra curenta
     * @param user Un utilizator de aplicatie al caror date trebuie editate
     */
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

    public void goToReportProblem(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/IssueProblem.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToApplicationSettings(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/ApplicationSettings.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToMedicamenteView(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/MedicamenteView.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToFurnizori(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/FurnizorMedicamenteView.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCategoriiMedicamenteView(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/CategoriiMedicamenteView.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCreateMedicine(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/CreateMed.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCreateMedCategory(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/CreateCateg.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToUpdateMedicineCategory(Stage stage, MedicineCategory category) {

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestiune/farmacie/controllers/CreateCateg.fxml"));
            root = loader.load();
            CreateCategController controller = loader.getController();
            controller.initializeUpdate(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAddFurnizor(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/CreateProvider.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToUpdateProvider(Stage stage, Provider provider) {

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestiune/farmacie/controllers/CreateProvider.fxml"));
            root = loader.load();
            CreateProviderController controller = loader.getController();
            controller.initializeUpdate(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToUpdateMedicine(Stage stage, Medicine medicine) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestiune/farmacie/controllers/CreateMed.fxml"));
            root = loader.load();
            CreateMedController controller = loader.getController();
            controller.initializeUpdate(medicine);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
