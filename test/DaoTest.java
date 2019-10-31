import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import org.junit.Test;

public class DaoTest {
    @Test
    public void test(){
        FarmDao farmDao=new FarmDaoImpl();
        Farm farm=farmDao.getFarm();
        farmDao.deleteFarm();
        farmDao.updateFarm(farm);
    }
}
