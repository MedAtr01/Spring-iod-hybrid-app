import Metier.MetierImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Dao.IDao;
import Metier.IMetier;

import java.time.LocalDate;
import java.time.Period;

public class CalculeAgeTest {

    @Test
    public void testCalculeAge() {
        IDao dao = new TestDao();
        TestMetier metier = new TestMetier();
        metier.setDao(dao);
         int expected = 23;
        Assertions.assertEquals(metier.calculAge(), expected);
    }

    class TestDao implements IDao {
        @Override
        public LocalDate getData() {
            return LocalDate.parse("2000-09-09");
        }
    }

    static class TestMetier extends MetierImpl {
        private IDao dao;

        @Override
        public void setDao(IDao dao) {
            this.dao = dao;
        }

        @Override
        public int calculAge() {
            LocalDate dateNaissance = dao.getData();
            LocalDate currentDate = LocalDate.now();
            int diff = Period.between(dateNaissance,currentDate).getYears();
            return diff;
        }
    }
}