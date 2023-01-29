package gestiune.farmacie.data.access;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import gestiune.farmacie.data.business.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineRepository {
    public MedicineRepository() {
    }

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
                medicine.setComentarii(List.of(set.getString("Comentarii").split(",")));
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

        public void addCategory(MedicineCategory mc) throws SQLException {
            String sql = "INSERT INTO [dbo].[MedicineCategory]\n" +
                    "           ([id]\n" +
                    "           ,[titlu]\n" +
                    "           ,[descriere])\n" +
                    "     VALUES\n" +
                    "           ('%s','%s','%s')";

                DatabaseConnection.executeNonQuerry(String.format(sql, mc.getId(),mc.getTitlu(),mc.getDescriere()));



        }

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

    public void deleteMedicineCategory(String categoryId) throws SQLException {
        String sql ="DELETE FROM [dbo].[MedicineCategory]\n" +
                "      WHERE id='%s'";
        DatabaseConnection.executeNonQuerry(String.format(sql,categoryId));
    }

    public void updateCategory(MedicineCategory mc) throws SQLException {
        String sql ="UPDATE [dbo].[MedicineCategory]\n" +
                "   SET [titlu] = '%s'\n" +
                "      ,[descriere] = '%s'\n" +
                " WHERE id='%s'";
        DatabaseConnection.executeNonQuerry(String.format(sql, mc.getTitlu(), mc.getDescriere(), mc.getId()));

    }
}
