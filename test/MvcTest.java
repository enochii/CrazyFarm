/**
 * @program: crazyfarm->MvcTest
 * @description: MVC的测试类
 * @author: jh
 * @create: 2019-10-31 16:17
 **/

import Builder.FarmerMultipleton;
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
//        Menu<Farmer> farmerMenu = farm.getFarmerMenu();
//        Iterator<Farmer> farmerIter = farmerMenu.iterator();
//        while(farmerIter.hasNext()){
//            Farmer farmer = farmerIter.next();
//            FarmerView view = new FarmerView();
//            FarmerController controller = new FarmerController(farmer, view);
//            controller.updateView();
     //   }

        //使用 MVC 模式
        System.out.println("======== 测试 MVC 模式 ========");
        Menu<FarmerMultipleton> farmerMenu = farm.getFarmerMenu();
        Iterator<FarmerMultipleton> farmerIter = farmerMenu.iterator();
        int baseAge = 30;
        String baseName = "Farmer";
        int i = 0;

        while(farmerIter.hasNext()){
            FarmerMultipleton farmer = farmerIter.next();
            FarmerView view = new FarmerView();
            FarmerController controller = new FarmerController(farmer, view);
            System.out.println("classname: (controller) :setFarmerAge: set a new age for a farmer");
            controller.setFarmerAge(30 + i);
            System.out.println("classname: (controller) :setFarmerAge: set a new name for a farmer");
            controller.setFarmerName(baseName + i);
            System.out.println("classname: (controller) : updateView: update and show the farmer's information");
            controller.updateView();
            i++;
        }
    }
}
