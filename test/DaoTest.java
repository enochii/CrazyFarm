import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import org.junit.Test;

public class DaoTest {
    @Test
    public void test(){
        FarmDao farmDao=new FarmDaoImpl();
        Farm farm=Farm.getInstance();
        System.out.println(farm.getAnimalMenu().iterator().next().getName());
        farmDao.deleteFarm();
        farmDao.updateFarm(farm);
    }
}
