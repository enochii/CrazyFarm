package othertest;

import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import mediator.AnimalMediator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TemplateMethodOtherTest {
    private Duck duck;
    private Chicken chicken;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Template method 模式 ========");
        // 建立test所需对象
        duck = new SmallYellowDuck();
        chicken = new TableChicken();
    }

    @Test
    public void templateMethodTest() {
        duck.getFed(10);
        assertFalse(duck.isHungry());
        assertEquals(duck._lastFedTime, 10);
        chicken.getFed(10);
        assertFalse(chicken.isHungry());
        assertEquals(chicken._lastFedTime, 10);
    }
}
