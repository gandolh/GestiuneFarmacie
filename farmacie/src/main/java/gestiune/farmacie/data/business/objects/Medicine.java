package gestiune.farmacie.data.business.objects;

import java.util.List;

public class Medicine {
    private double price;
    private int stockCount;
    private ShoeCategory categorie;
    private Provider providerMed;
    private List<String> comentarii;

    public Medicine(double price, int stockCount, ShoeCategory categorie, Provider providerMed, List<String> comentarii) {
        this.price = price;
        this.stockCount = stockCount;
        this.categorie = categorie;
        this.providerMed = providerMed;
        this.comentarii = comentarii;
    }

    public Medicine() {
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

    public ShoeCategory getCategorie() {
        return categorie;
    }

    public void setCategorie(ShoeCategory categorie) {
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
