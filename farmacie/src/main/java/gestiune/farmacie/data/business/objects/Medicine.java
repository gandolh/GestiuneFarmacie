package gestiune.farmacie.data.business.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa de medicamente
 */
public class Medicine {
    private String id;
    private double price;
    private int stockCount;
    private MedicineCategory categorie;
    private Provider providerMed;
    private String comentarii;

    /**
     * Getter pentur id
     * @return return
     */
    public String getId() {
        return id;
    }

    /**
     * Setter pt id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Consturcot
     * @param id id
     * @param price pret
     * @param stockCount stoc
     * @param categorie categ
     * @param providerMed provideer
     * @param comentarii comentrarii
     */
    public Medicine(String id, double price, int stockCount, MedicineCategory categorie, Provider providerMed, String comentarii) {
        this.id = id;
        this.price = price;
        this.stockCount = stockCount;
        this.categorie = categorie;
        this.providerMed = providerMed;
        this.comentarii = comentarii;
    }

    /**
     * Consturctor implict
     */
    public Medicine() {
        this.id = "";
        this.price = 0.0f;
        this.stockCount = 0;
        this.categorie =  new MedicineCategory();
        this.providerMed = new Provider();
        this.comentarii =  "comentariu";

    }

    /**
     * gettr pt pret
     * @return return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter pt pret
     * @param price pret
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter pt stoc
     * @return return
     */
    public int getStockCount() {
        return stockCount;
    }

    /**
     * Setter pt stoc
     * @param stockCount stoc
     */
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * Getter ppt categorie
     * @return return
     */

    public MedicineCategory getCategorie() {
        return categorie;
    }

    /**
     * Setter pt categoire
     * @param categorie categorie
     */
    public void setCategorie(MedicineCategory categorie) {
        this.categorie = categorie;
    }

    /**
     * Getter pt provider
     * @return ret
     */
    public Provider getProviderMed() {
        return providerMed;
    }

    /**
     * Setter pt provider
     * @param providerMed provider
     */
    public void setProviderMed(Provider providerMed) {
        this.providerMed = providerMed;
    }

    /**
     * Getter pt comentarii
     * @return return
     */
    public String getComentarii() {
        return comentarii;
    }

    /**
     * Setter pt comentarii
     * @param comentarii comentarii
     */
    public void setComentarii(String comentarii) {
        this.comentarii = comentarii;
    }
}
