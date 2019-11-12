import Builder.FarmerMultipleton;
import Farm.Farm;
import MVC.FarmerController;
import MVC.FarmerView;
import org.junit.Before;
import org.junit.Test;
import Farm.Menu;
import java.util.Iterator;
import static org.junit.Assert.*;

/**
 * @program: crazyfarm->MvcOtherTest
 * @description:
 * @create: 2019-11-11 19:54
 **/

public class MvcOtherTest {

    private Farm farm;
    private Menu<FarmerMultipleton> farmerMenu;

    @Before
    public void init()
    {
        //获取动物列表
        farm = Farm.getInstance();
        farmerMenu = farm.getFarmerMenu();
    }

    @Test
    public void mvcOtherTest()
    {

        //使用 MVC 模式
        System.out.println("======== 测试 MVC 模式 ========");
        Iterator<FarmerMultipleton> farmerIter = farmerMenu.iterator();
        int baseAge = 30;
        String baseName = "Farmer";
        int i = 0;

        while(farmerIter.hasNext()){
            FarmerMultipleton farmer = farmerIter.next();
            FarmerView view = new FarmerView();
            FarmerController controller = new FarmerController(farmer, view);
            //测试年龄是否设置成功
            controller.setFarmerAge(baseAge + i);
            assertEquals(farmer.getAge(), (baseAge + i));

            //测试姓名是否设置成功
            controller.setFarmerName(baseName + i);
            assertEquals(farmer.getName(), (baseName + i));

            //更新农民视图
            controller.updateView();
            i++;
        }
    }
}
