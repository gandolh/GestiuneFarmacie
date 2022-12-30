package gestiune.farmacie.components;

import javafx.scene.control.Alert;

public class MyDialog {
    public MyDialog(Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Credentiale incorecte");
        alert.setHeaderText("Credentiale incorecte");
        alert.setContentText("Va rugam verificati datele introduse, sau creati-va un cont nou");
        alert.showAndWait();
    }
}
