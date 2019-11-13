package othertest;

import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import mediator.AnimalMediator;
import org.junit.Before;
import org.junit.Test;

public class StrategyOtherTest {

    private Duck duck;
    private Chicken chicken;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Strategy 模式 ========");
        // 建立test所需对象
        duck = new SmallYellowDuck();
        chicken = new TableChicken();
    }

    @Test
    public void testForAnimalAction() {
        // 发出声音
        duck.makeSound();
        chicken.makeSound();

        // 进食
        duck.makeEat();
        chicken.makeEat();
    }
}
