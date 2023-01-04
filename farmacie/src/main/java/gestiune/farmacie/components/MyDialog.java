package gestiune.farmacie.components;

import javafx.scene.control.Alert;


/**
 * Dialog-ul meu custom pentru javaFX pentru diverse afisari de eroare, warning, etc
 */
public class MyDialog {

    /**
     * Construieste un dialog custom in functie de datele de intrare
     * @param alertType
     */
    public MyDialog(Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Credentiale incorecte");
        alert.setHeaderText("Credentiale incorecte");
        alert.setContentText("Va rugam verificati datele introduse, sau creati-va un cont nou");
        alert.showAndWait();
    }
}
