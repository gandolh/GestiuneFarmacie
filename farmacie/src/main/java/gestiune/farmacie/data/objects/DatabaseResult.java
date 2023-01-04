package gestiune.farmacie.data.objects;


/**
 * Clasa pentru rezultat-ul din urma interogarii bazei de date
 */
public class DatabaseResult {
    /**
     * Constructorul gol
     */
    public DatabaseResult() {
    }

    /**
     * Constructorul cu parametrii
     * @param status status
     * @param message mesajul de eroare, in cazul in care exista
     * @param rowsAffected numarul de linii afectate
     */
    public DatabaseResult(String status, String message, int rowsAffected) {
        this.status = status;
        this.message = message;
        this.rowsAffected = rowsAffected;
    }



    /**
     * status reprezinta un cod de 3 cifre ca in cazul request-urilor HTTP.
     * 200 insemnand ok, 404 insemnand not found, iar orice cod cu 5xx inseamna
     * eroare interna la server.
     */
    private String status;
    /**
     * mesajul de eroare in cazul in care acesta este prezent
     */
    private String message;
    /**
     * numarul de linii afectate in urma unei inserari, actualizari sau stergeri
     */
    private int rowsAffected;

    /**
     * Intoarce status-ul cererii
     * @return status-ul cererii
     */
    public String getStatus() {
        return status;
    }

    /**
     * Seteaza status-ul cererii
     * @param status status-ul cererii
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Intoarce mesajul de eroare
     * @return mesajul de eroare
     */
    public String getMessage() {
        return message;
    }

    /**
     * Seteaza mesajul de eroare
     * @param message mesajul de eroare
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * intoarce numarul de linii afectate
     * @return numarul de linii afectate
     */
    public int getRowsAffected() {
        return rowsAffected;
    }

    /**
     * seteaza numarul de linii afectate
     * @param rowsAffected numarul de linii afectate
     */
    public void setRowsAffected(int rowsAffected) {
        this.rowsAffected = rowsAffected;
    }
}
