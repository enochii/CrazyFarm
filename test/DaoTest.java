import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import org.junit.Test;

/**
 * @program: crazyfarm->DaoTest
 * @description: 数据访问对象（DAO）模式的测试类
 * @author: oy
 * @create: 2019-11-04 16:42
 **/
public class DaoTest {
    @Test
    public void test(){
        FarmDao farmDao=new FarmDaoImpl();
        Farm farm=Farm.getInstance();
        System.out.println(farm.getAnimalMenu().getSize());
        System.out.println(farm.getPlantMenu().getSize());
        farmDao.updateFarm(farm);
    }
}
