import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import mediator.AnimalMediator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TemplateMethodTest {

    private Duck duck;
    private Chicken chicken;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Template method 模式 ========");
        // 建立test所需对象
        AnimalMediator mediator = new AnimalMediator();
        duck = new SmallYellowDuck(mediator);
        chicken = new TableChicken(mediator);
    }

    @Test
    public void templateMethodTest() {
        duck.getFed(6);
        assertFalse(duck.isHungry());
        assertEquals(duck._lastFedTime, 6);
        chicken.getFed(6);
        assertFalse(chicken.isHungry());
        assertEquals(chicken._lastFedTime, 6 );
    }

}
