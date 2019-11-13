package othertest;

import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.NullAnimal;
import criteria.Criteria;
import criteria.CriteriaDuck;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NullObjectOtherTest {

    private Criteria criteriaDuck;
    private List<Animal> animals;
    @Before
    public void setUp() {
        System.out.println("======== 测试 Null Object 模式 ========");
        Animal chicken = new TableChicken();
        animals = new ArrayList<>();
        animals.add(chicken);
        criteriaDuck = new CriteriaDuck();
    }

    @Test
    public void nullObjectTest() {
        List<Animal> result = criteriaDuck.meetCriteria(animals);
        assertEquals(result.size(), 1);
        assertTrue(result.get(0) instanceof NullAnimal);

        result.get(0).getValue();
    }
}
