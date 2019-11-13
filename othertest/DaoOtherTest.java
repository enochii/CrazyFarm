import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: DaoOtherTest
 * @description:
 * @designPattern:
 * @date: 2019/11/12 22:05
 */
public class DaoOtherTest {
    private Farm farm;
    private FarmDao farmDao;
    @Before
    public void setUp() {
        System.out.println("======== 测试 DAO 模式 ========");
        farmDao=new FarmDaoImpl();
    }

    @Test
    public void testForDAO() {
        System.out.println("测试农场初始化：");
        farm=Farm.getInstance();
        System.out.println("测试农场数据：");
        System.out.println("农场动物个数："+farm.getAnimalMenu().getSize());
        System.out.println("农场植物个数："+farm.getPlantMenu().getSize());
        System.out.println("测试农场数据更新：");
        farmDao.updateFarm(farm);
    }
}
