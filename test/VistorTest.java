import Farm.Menu;
import Farm.Farm;
import Livings.Animals.Animal;
import Livings.Plants.Plant;
import Visitor.ExpLivingVisitor;
import org.junit.Test;

import java.util.Iterator;

/**
 * @program: crazyfarm->VistorTest
 * @description: 访问者模式的测试类
 * @author: oy
 * @create: 2019-11-04 16:42
 **/
public class VistorTest {
    @Test
    public void test(){
        ExpLivingVisitor expLivingVisitor=new ExpLivingVisitor();
        Farm farm=Farm.getInstance();
        Menu<Animal> animalmenu=farm.getAnimalMenu();
        Menu<Plant> plantmenu=farm.getPlantMenu();
        for(Iterator<Animal>it=animalmenu.iterator();it.hasNext(); ){
            Animal animal=it.next();
            animal.accept(expLivingVisitor);
        }

        for(Iterator<Plant>it=plantmenu.iterator();it.hasNext(); ){
            Plant plant=it.next();
            plant.accept(expLivingVisitor);
        }
    }
}
