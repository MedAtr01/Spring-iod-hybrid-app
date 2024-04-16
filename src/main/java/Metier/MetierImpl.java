package Metier;

import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;
    @Override
    public int calculAge() {

        LocalDate dateNaissance = dao.getData();
        LocalDate currentDate = LocalDate.now();
        Period difference = Period.between(dateNaissance,currentDate);
        return difference.getYears();

    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
