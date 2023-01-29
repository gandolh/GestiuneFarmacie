package gestiune.farmacie.components;

import javafx.scene.control.Alert;


/**
 * Dialog-ul meu custom pentru javaFX pentru diverse afisari de eroare, warning, etc
 */
public class MyDialog {

    /**
     * Construieste un dialog custom in functie de datele de intrare
     * @param alertType tipul de alerta
     */
    public MyDialog(Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Credentiale incorecte");
        alert.setHeaderText("Credentiale incorecte");
        alert.setContentText("Va rugam verificati datele introduse, sau creati-va un cont nou");
        alert.showAndWait();
    }


    /**
     * Ceva dialog de ce sa va mint
     * @param titlu tiltu
     * @param header cap
     * @param content continut detinut
     */

    public MyDialog(String titlu, String header, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titlu);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
