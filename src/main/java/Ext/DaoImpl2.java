package Ext;

import Dao.IDao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
@Component("dao")
public class DaoImpl2 implements IDao {
    @Override
    public LocalDate getData() {
        Scanner sc = new Scanner(System.in);

        LocalDate dateNaissance = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Entrez une date de naissance (DD-MM-YYYY) : ");
            String input = sc.nextLine();

            try {
                dateNaissance = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Format invalide. Respectez le format DD-MM-YYYY.");
            }
        }

        sc.close();

        return dateNaissance;
    }
}
