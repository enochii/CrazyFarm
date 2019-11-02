/**
 * @program: crazyfarm->MvcTest
 * @description: MVC的测试类
 * @author: jh
 * @create: 2019-10-31 16:17
 **/

import Farm.Farm;
import Livings.Animals.Animal;
import MVC.FarmerController;
import MVC.FarmerView;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import Farm.Farmer;
import Farm.Menu;

import java.util.Iterator;

public class MvcTest {

    @Test
    public void test()throws Exception{
        Farm farm = Farm.getInstance();
        Menu<Farmer> farmerMenu = farm.getFarmerMenu();
        Iterator<Farmer> farmerIter = farmerMenu.iterator();
        while(farmerIter.hasNext()){
            Farmer farmer = farmerIter.next();
            FarmerView view = new FarmerView();
            FarmerController controller = new FarmerController(farmer, view);
            controller.updateView();
        }
    }
}
