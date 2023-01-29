package gestiune.farmacie.data.business.objects;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
    private String id;
    private double price;
    private int stockCount;
    private MedicineCategory categorie;
    private Provider providerMed;
    private List<String> comentarii;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medicine(String id, double price, int stockCount, MedicineCategory categorie, Provider providerMed, List<String> comentarii) {
        this.id = id;
        this.price = price;
        this.stockCount = stockCount;
        this.categorie = categorie;
        this.providerMed = providerMed;
        this.comentarii = comentarii;
    }

    public Medicine() {
        this.id = "";
        this.price = 0.0f;
        this.stockCount = 0;
        this.categorie =  new MedicineCategory();
        this.providerMed = new Provider();
        this.comentarii =  List.of("comentariu", "comentariu2");

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public MedicineCategory getCategorie() {
        return categorie;
    }

    public void setCategorie(MedicineCategory categorie) {
        this.categorie = categorie;
    }

    public Provider getProviderMed() {
        return providerMed;
    }

    public void setProviderMed(Provider providerMed) {
        this.providerMed = providerMed;
    }

    public List<String> getComentarii() {
        return comentarii;
    }

    public void setComentarii(List<String> comentarii) {
        this.comentarii = comentarii;
    }
}
