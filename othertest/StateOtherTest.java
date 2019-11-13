import Livings.Animals.Chicken.TableChicken;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @program: crazyfarm->StateOtherTest
 * @description:
 * @create: 2019-11-12 13:21
 **/

public class StateOtherTest {

    private TableChicken tableChicken;

    @Before
    public void init(){
        //初始化一直用于测试的tablechicken
        tableChicken = new TableChicken();
    }

    @Test
    public void test(){
        System.out.println("======== 测试 State 模式 ========");

        //初始化时为饥饿状态
        tableChicken.setClock(5);
        assertEquals(tableChicken.isHungry(), true);


        //在第六个时间会进食
        tableChicken.setClock(7);
        assertEquals(tableChicken.isHungry(), false);

    }
}
