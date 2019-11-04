import Constant.Const;
import Farm.Farm;
import Farm.Farmer;
import SolveStarvation.SolveStarvationFacade;
import org.junit.Test;

public class FacadeTest {
    @Test
    public void test() {
        Farm farm = Farm.getInstance();
        Farmer farmer = new Farmer();
        farmer.setType(Const.WorkType.SPARE);
        SolveStarvationFacade solveStarvationFacade = new SolveStarvationFacade(farm, farmer);
        solveStarvationFacade.solve(0);
    }
}
