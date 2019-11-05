import Tools.BigSize;
import Tools.Hoe;
import Tools.Shovel;
import Tools.SmallSize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BridgeTest {
    @Test
    public void test() {
        Hoe smallHoe = new Hoe(new SmallSize());
        assertEquals(smallHoe.doWorkTest(), 1);
        Hoe bigHoe = new Hoe(new BigSize());
        assertEquals(bigHoe.doWorkTest(), 2);
        Shovel smallShovel = new Shovel(new SmallSize());
        assertEquals(smallShovel.doWorkTest(), 1);
        Shovel bigShovel = new Shovel(new BigSize());
        assertEquals(bigShovel.doWorkTest(), 2);
    }
}
