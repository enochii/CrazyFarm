import Constant.Const;
import Farm.Farm;
import Farm.Farmer;
import SolveStarvation.SolveStarvationFacade;
import org.junit.Before;
import org.junit.Test;

public class FacadeOtherTest {

    private Farmer farmer;
    private SolveStarvationFacade solveStarvationFacade;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Facade 模式 ========");
        Farm farm = Farm.getInstance();
        farmer = new Farmer();
        solveStarvationFacade = new SolveStarvationFacade(farm, farmer);
    }

    @Test
    public void test() {
        farmer.setType(Const.WorkType.SPARE);
        solveStarvationFacade.solve(10);
        System.out.println("成功使用外观模式");
    }
}
