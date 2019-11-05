import Adapter.ChickenAdapter;
import Adapter.MakeDuckQuack;
import Livings.Animals.Chicken.TableChicken;
import org.junit.Test;

/**
 * @author : SCH001
 * @description :
 */
public class AdapterTest {
    @Test
    public void test(){
        ChickenAdapter adapter = new ChickenAdapter(new TableChicken());
        MakeDuckQuack.makeDuckQuack(adapter);
    }
}
