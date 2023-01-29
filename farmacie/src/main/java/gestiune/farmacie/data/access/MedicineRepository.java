package gestiune.farmacie.data.access;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import gestiune.farmacie.data.business.objects.Provider;
import gestiune.farmacie.data.business.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repo pt medicine
 */
public class MedicineRepository {
    /**
     * Constructor implicit
     */
    public MedicineRepository() {
    }

    /**
     * Getter pt medicine
     * @return ret
     */
    public List<Medicine> getAllMedicine() {

        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
//        medicines.add(new Medicine());
//        medicines.add(new Medicine());
        String sql = "SELECT m.id idMedicament, price, stockCount, comentarii, mc.id idCategorie, titlu, descriere, cui, denumire,adresa, nrRegCom, telefon, codPostal, iban, dataInregistrare,codCAEN, email\n" +
                "  FROM [dbo].[Medicine] m\n" +
                "  JOIN [dbo].MedicineCategory mc on m.categorie=mc.id\n" +
                "  JOIN [dbo].ProviderFarmacie pf on pf.cui=m.providerMed\n";

        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            while (set.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(set.getString("idMedicament"));
                medicine.setPrice(set.getDouble("price"));
                medicine.setStockCount(set.getInt("stockCount"));
                medicine.setComentarii(set.getString("Comentarii"));
                medicine.getCategorie().setId(set.getString("idCategorie"));
                medicine.getCategorie().setTitlu(set.getString("titlu"));
                medicine.getCategorie().setDescriere(set.getString("descriere"));
                medicine.getProviderMed().setCui(set.getString("cui"));
                medicine.getProviderMed().setDenumire(set.getString("denumire"));
                medicine.getProviderMed().setAdresa(set.getString("adresa"));
                medicine.getProviderMed().setNrRegCom(set.getInt("nrRegCom"));
                medicine.getProviderMed().setTelefon(set.getString("telefon"));
                medicine.getProviderMed().setCodPostal(set.getString("codPostal"));
                medicine.getProviderMed().setIban(set.getString("iban"));
                medicine.getProviderMed().setDataInregistrare(set.getDate("dataInregistrare"));
                medicine.getProviderMed().setCodCAEN(set.getInt("codCAEN"));
                medicine.getProviderMed().setEmail(set.getString("email"));
                medicines.add(medicine);
            }
            return medicines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adauga cateogire
     * @param mc mc
     * @throws SQLException Eroare
     */
        public void addCategory(MedicineCategory mc) throws SQLException {
            String sql = "INSERT INTO [dbo].[MedicineCategory]\n" +
                    "           ([id]\n" +
                    "           ,[titlu]\n" +
                    "           ,[descriere])\n" +
                    "     VALUES\n" +
                    "           ('%s','%s','%s')";

                DatabaseConnection.executeNonQuerry(String.format(sql, mc.getId(),mc.getTitlu(),mc.getDescriere()));



        }

    /**
     * Getter pt toate mediamentele
     * @return ret
     */
    public List<MedicineCategory> getAllMedicineCategories() {
        String sql = "SELECT TOP (1000) [id]\n" +
                "      ,[titlu]\n" +
                "      ,[descriere]\n" +
                "  FROM [piiiproject].[dbo].[MedicineCategory]";
            List<MedicineCategory> categories = new ArrayList<>();
            ResultSet set = null;
            try {
                set = DatabaseConnection.executeQuerry(sql);
                while(set.next()){
                    MedicineCategory mc = new MedicineCategory();
                    mc.setId(set.getString("id"));
                    mc.setTitlu(set.getString("titlu"));
                    mc.setDescriere(set.getString("descriere"));
                    categories.add(mc);
                }
                return categories;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
    }

    /**
     * Delete medicamente
     * @param categoryId id
     * @throws SQLException Eroare
     */

    public void deleteMedicineCategory(String categoryId) throws SQLException {
        String sql ="DELETE FROM [dbo].[MedicineCategory]\n" +
                "      WHERE id='%s'";
        DatabaseConnection.executeNonQuerry(String.format(sql,categoryId));
    }

    /**
     * Update Categ
     * @param mc mc
     * @throws SQLException Eroare
     */

    public void updateCategory(MedicineCategory mc) throws SQLException {
        String sql ="UPDATE [dbo].[MedicineCategory]\n" +
                "   SET [titlu] = '%s'\n" +
                "      ,[descriere] = '%s'\n" +
                " WHERE id='%s'";
        DatabaseConnection.executeNonQuerry(String.format(sql, mc.getTitlu(), mc.getDescriere(), mc.getId()));

    }

    /**
     * Getter pt provideri
     * @return ret
     */

    public List<Provider> getAllProviders() {
        List<Provider> providers = new ArrayList<Provider>();
        String sql = "SELECT TOP (1000) [cui]\n" +
                "      ,[denumire]\n" +
                "      ,[adresa]\n" +
                "      ,[nrRegCom]\n" +
                "      ,[telefon]\n" +
                "      ,[codPostal]\n" +
                "      ,[iban]\n" +
                "      ,[dataInregistrare]\n" +
                "      ,[codCAEN]\n" +
                "      ,[email]\n" +
                "  FROM [piiiproject].[dbo].[ProviderFarmacie]";

        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            while(set.next()){
                Provider provider = new Provider();
                provider.setCui(set.getString("cui"));
                provider.setDenumire(set.getString("denumire"));
                provider.setAdresa(set.getString("adresa"));
                provider.setNrRegCom(set.getInt("nrRegCom"));
                provider.setTelefon(set.getString("telefon"));
                provider.setCodPostal(set.getString("codPostal"));
                provider.setIban(set.getString("iban"));
                provider.setDataInregistrare(set.getDate("dataInregistrare"));
                provider.setCodCAEN(set.getInt("codCAEN"));
                provider.setEmail(set.getString("email"));
                providers.add(provider);
            }
            return providers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return providers;
    }

    /**
     * Add provideri
     * @param provider provider
     * @throws SQLException Eroare
     */

    public void addProvider(Provider provider) throws SQLException {
        String sql = "\n" +
                "INSERT INTO [dbo].[ProviderFarmacie]\n" +
                "([cui]\n" +
                ",[denumire]\n" +
                ",[adresa]\n" +
                ",[nrRegCom]\n" +
                ",[telefon]\n" +
                ",[codPostal]\n" +
                ",[iban]\n" +
                ",[dataInregistrare]\n" +
                ",[codCAEN]\n" +
                ",[email])\n" +
                "VALUES\n" +
                "('%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s'\n" +
                ",'%s')";
        String formattedSql = String.format(sql, provider.getCui(),provider.getDenumire()
                ,provider.getAdresa(), provider.getNrRegCom(), provider.getTelefon(), provider.getCodPostal(), provider.getIban(),
                provider.getDataInregistrare(), provider.getCodCAEN(), provider.getEmail());
        DatabaseConnection.executeNonQuerry(formattedSql);
    }

    /**
     * Delet provider
     * @param cui cui
     * @throws SQLException Eroare
     */
    public void deleteProvider(String cui) throws SQLException {
        String sql = String.format("DELETE FROM [dbo].[ProviderFarmacie]\n" +
                "      WHERE cui ='%s'",cui);
        DatabaseConnection.executeNonQuerry(sql);
    }

    /**
     * Provider update
     * @param provider provdeer
     * @throws SQLException Eroare
     */
    public void updateProvider(Provider provider) throws SQLException {
        String sql = "UPDATE [dbo].[ProviderFarmacie]\n" +
                "   SET [denumire] = '%s'\n" +
                "      ,[adresa] = '%s'\n" +
                "      ,[nrRegCom] = '%s'\n" +
                "      ,[telefon] = '%s'\n" +
                "      ,[codPostal] = '%s'\n" +
                "      ,[iban] = '%s'\n" +
                "      ,[dataInregistrare] = '%s'\n" +
                "      ,[codCAEN] = '%s'\n" +
                "      ,[email] = '%s'\n" +
                " WHERE cui='%s'";
        String formattedSql = String.format(sql, provider.getDenumire(),provider.getAdresa(), provider.getNrRegCom(),
                provider.getTelefon(), provider.getCodPostal(), provider.getIban(), provider.getDataInregistrare(),
                provider.getCodCAEN(), provider.getEmail(),provider.getCui());
        DatabaseConnection.executeNonQuerry(formattedSql);
    }

    /**
     * Getter medicamente
     * @param medicineCategoryTitle da
     * @return ret
     */

    public MedicineCategory getMedicineCategory(String medicineCategoryTitle) {
        String sql = "SELECT TOP (1000) [id]\n" +
                "      ,[titlu]\n" +
                "      ,[descriere]\n" +
                "  FROM [piiiproject].[dbo].[MedicineCategory]\n" +
                "  where titlu='%s'";
        String formattedSql = String.format(sql, medicineCategoryTitle );
        try {
            ResultSet rs =  DatabaseConnection.executeQuerry(formattedSql);
            if(rs.next()){
                return new MedicineCategory( rs.getString("id"),rs.getString("titlu"),rs.getString("descriere"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;
    }

    /**
     * Getter provider
     * @param providerDenumire da
     * @return ret
     */
    public Provider getProvider(String providerDenumire) {
        String sql = "SELECT TOP (1000) [cui]\n" +
                "      ,[denumire]\n" +
                "      ,[adresa]\n" +
                "      ,[nrRegCom]\n" +
                "      ,[telefon]\n" +
                "      ,[codPostal]\n" +
                "      ,[iban]\n" +
                "      ,[dataInregistrare]\n" +
                "      ,[codCAEN]\n" +
                "      ,[email]\n" +
                "  FROM [piiiproject].[dbo].[ProviderFarmacie]\n" +
                "  where denumire='%s'";
        String formattedSql = String.format(sql, providerDenumire );
        try {
            ResultSet rs =  DatabaseConnection.executeQuerry(formattedSql);
            if(rs.next()){
                return new Provider( rs.getString("cui"),rs.getString("adresa"), rs.getString("denumire"),
                        rs.getInt("nrRegCom"), rs.getString("telefon"), rs.getString("codPostal"),
                        rs.getString("iban"), rs.getString("email"),rs.getInt("codCAEN"),
                        rs.getDate("dataInregistrare"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Adauga medicamente
     * @param med medicament
     * @throws SQLException eroare
      */
    public void addMedicine(Medicine med) throws SQLException {
        String sql = "INSERT INTO [dbo].[Medicine]\n" +
                "           ([id]\n" +
                "           ,[price]\n" +
                "           ,[stockCount]\n" +
                "           ,[categorie]\n" +
                "           ,[providerMed]\n" +
                "           ,[comentarii])\n" +
                "     VALUES\n" +
                "           ('%s'\n" +
                "           ,'%s'\n" +
                "           ,'%s'\n" +
                "           ,'%s'\n" +
                "           ,'%s'\n" +
                "           ,'%s')";

        DatabaseConnection.executeNonQuerry(String.format(sql, med.getId(),med.getPrice(),med.getStockCount(),
                med.getCategorie().getId(), med.getProviderMed().getCui(), med.getComentarii()));
    }

    /**
     * Update medicamente
     * @param med med
     * @throws SQLException Eroare
     */
    public void updateMedicine(Medicine med) throws SQLException {
        String sql = "\n" +
                "UPDATE [dbo].[Medicine]\n" +
                "   SET [price] = '%s'\n" +
                "      ,[stockCount] = '%s' \n" +
                "      ,[categorie] = '%s'\n" +
                "      ,[providerMed] = '%s'\n" +
                "      ,[comentarii] = '%s' \n" +
                " WHERE  id='%s'";
        String formattedSql = String.format(sql, med.getPrice(), med.getStockCount(), med.getCategorie().getId(),
                med.getProviderMed().getCui(), med.getComentarii());
        DatabaseConnection.executeNonQuerry(formattedSql);
    }

    /**
     * Delete medicamente
     * @param medicineId medid
     * @throws SQLException Eraore
     */
    public void deleteMedicine(String medicineId) throws SQLException {
            String sql = "\n" +
                    "DELETE FROM [dbo].[Medicine]\n" +
                    "      WHERE id='%s'";
            DatabaseConnection.executeQuerry(String.format(sql, medicineId));
    }
}
