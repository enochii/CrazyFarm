import Constant.Const;
import Farm.Farm;
import Farm.Farmer;
import Farm.Owner;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import SolveStarvation.SolveStarvationFacade;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class FacadeTest {
    @Test
    public void test() {
        Farm farm = Farm.getInstance();
        Farmer farmer = new Farmer();
        farmer.setType(Const.WorkType.SPARE);
        SolveStarvationFacade solveStarvationFacade = new SolveStarvationFacade(farm, farmer);
        solveStarvationFacade.solve(10);
    }
}
