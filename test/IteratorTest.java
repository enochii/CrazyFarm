import Farm.Menu;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
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
public class IteratorTest {
    @Test
    public void test(){
        Menu<Animal> animalMenu = new Menu<Animal>();
        List<Animal> animals = new ArrayList<>();

        for(int i=0;i<5;i++){
            Chicken chicken = new TableChicken();
            animalMenu.add(chicken);
            animals.add(chicken);
//            animalMenu.erase(chicken);
        }
        Iterator<Animal> iterator = animalMenu.iterator();
        for (Animal animal : animals) {
            assertTrue(iterator.hasNext());
            assertEquals(iterator.next(), animal);
        }
    }
}
