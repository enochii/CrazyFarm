import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import Livings.Animals.Duck.SmallYellowDuck;
import mediator.AnimalMediator;
import org.junit.Before;
import org.junit.Test;

public class TemplateMethodTest {

    private Duck duck;
    private Chicken chicken;

    @Before
    public void setUp() {
        System.out.println("Test for template method.");
        // 建立test所需对象
        AnimalMediator mediator = new AnimalMediator();
        duck = new SmallYellowDuck(mediator);
        chicken = new TableChicken(mediator);
    }

    @Test
    public void templateMethodTest() {
        duck.getFed(6);
        chicken.getFed(6);
    }

}
