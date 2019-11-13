import Farm.Menu;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author : SCH001
 * @description :
 */
public class IteratorOtherTest {
    Menu<Animal> animalMenu;
    List<Animal> animals;

    @Before
    public void setup(){
        System.out.println("======== 测试 Iterator 模式 ========");
        animalMenu = new Menu<Animal>();
        animals = new ArrayList<>();
        for(int i=0;i<5;i++){
            Chicken chicken = new TableChicken();
            animalMenu.add(chicken);
            animals.add(chicken);
        }
        System.out.println("所有的动物已经成功载入");
    }

    @Test
    public void test(){
        Iterator<Animal> iterator = animalMenu.iterator();
        for (Animal animal : animals) {
            assertTrue(iterator.hasNext());
            assertEquals(iterator.next(), animal);
        }
        System.out.println("Iterator模式测试结束");
    }
}
