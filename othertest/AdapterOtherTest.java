import Adapter.ChickenAdapter;
import Adapter.MakeDuckQuack;
import Livings.Animals.Chicken.TableChicken;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : SCH001
 * @description :
 */
public class AdapterOtherTest {
    private ChickenAdapter adapter;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Adapter 模式 ========");
        adapter = new ChickenAdapter((new TableChicken()));
    }

    @Test
    public void test(){
        MakeDuckQuack.makeDuckQuack(adapter);
    }
}
