package Ext;

import Dao.IDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DaoImpl3 implements IDao {
    @Override
    public LocalDate getData() {
        String dateString = "29 05 2000";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        LocalDate dateNaissance = LocalDate.parse(dateString, formatter);
        return dateNaissance;
    }
}
