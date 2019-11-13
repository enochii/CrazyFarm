import Tools.BigSize;
import Tools.Hoe;
import Tools.Shovel;
import Tools.SmallSize;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BridgeOtherTest {

    private Hoe smallHoe;
    private Hoe bigHoe;
    private Shovel smallShovel;
    private Shovel bigShovel;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Bridge 模式 ========");
        smallHoe = new Hoe(new SmallSize());
        bigHoe = new Hoe(new BigSize());
        smallShovel = new Shovel(new SmallSize());
        bigShovel = new Shovel(new BigSize());
    }

    @Test
    public void test() {
        System.out.println("======== 测试小锄头 ========");
        int shouldDo = 1, actuallyDo = smallHoe.doWorkTest();
        System.out.println("small hoe should do " + shouldDo + " work");
        System.out.println("small hoe actually do " + actuallyDo + " work");
        assertEquals(shouldDo, actuallyDo);

        System.out.println("======== 测试大锄头 ========");
        shouldDo = 2; actuallyDo = bigHoe.doWorkTest();
        System.out.println("big hoe should do " + shouldDo + " work");
        System.out.println("big hoe actually do " + actuallyDo + " work");
        assertEquals(shouldDo, actuallyDo);

        System.out.println("======== 测试小铲子 ========");
        shouldDo = 1; actuallyDo = smallShovel.doWorkTest();
        System.out.println("small shovel should do " + shouldDo + " work");
        System.out.println("small shovel actually do " + actuallyDo + " work");
        assertEquals(shouldDo, actuallyDo);

        System.out.println("======== 测试大铲子 ========");
        shouldDo = 2; actuallyDo = bigShovel.doWorkTest();
        System.out.println("big shovel should do " + shouldDo + " work");
        System.out.println("big shovel actually do " + actuallyDo + " work");
        assertEquals(shouldDo, actuallyDo);
    }
}
