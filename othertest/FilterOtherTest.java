package othertest;

import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import criteria.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilterOtherTest {
    private List<Animal> animals = new ArrayList<>();

    @Before
    public void setUp() {
        System.out.println("======== 测试 Filter 模式 ========");
        Animal matureChicken = new TableChicken();
        Animal chicken = new TableChicken();
        Animal matureDuck = new SmallYellowDuck();
        Animal duck = new SmallYellowDuck();

        //使动物成熟
        for (int i = 0; i < 20; i++) {
            matureChicken.getFed(i);
            matureDuck.getFed(i);
        }

        animals.add(matureChicken);
        animals.add(matureDuck);
        animals.add(chicken);
        animals.add(duck);

        for (Animal animal : animals) {
            animal.setClock(15);
        }
    }

    @Test
    public void testForFilter() {
        Criteria criteriaChicken = new CriteriaChicken();
        Criteria criteriaDuck = new CriteriaDuck();
        Criteria criteriaMature = new CriteriaMature();

        //Criteria for chicken
        List<Animal> result_1 = criteriaChicken.meetCriteria(animals);
        assertEquals(result_1.size(), 2);
        assertTrue(result_1.get(0) instanceof Chicken);

        //Criteria for duck
        List<Animal> result_2 = criteriaDuck.meetCriteria(animals);
        assertEquals(result_2.size(), 2);
        assertTrue(result_2.get(0) instanceof Duck);

        //Criteria for mature animals
        List<Animal> result_3 = criteriaMature.meetCriteria(animals);
        assertEquals(result_3.size(), 2);
        assertTrue(result_2.get(0).getMature());
        assertTrue(result_3.get(0).getMature());

        //Criteria for two criteria
        Criteria andCriteria = new AndCriteria(criteriaChicken, criteriaMature);
        List<Animal> result_4 = andCriteria.meetCriteria(animals);
        assertEquals(result_4.size(), 1);
        assertTrue(result_4.get(0) instanceof Chicken);
        assertTrue(result_4.get(0).getMature());
    }
}
