import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import mediator.AnimalMediator;
import org.junit.Before;
import org.junit.Test;

public class StrategyTest {

    private Duck duck;
    private Chicken chicken;

    @Before
    public void setUp() {
        System.out.println("Test for strategy.");
        // 建立test所需对象
        AnimalMediator mediator = new AnimalMediator();
        duck = new SmallYellowDuck(mediator);
        chicken = new TableChicken(mediator);
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
