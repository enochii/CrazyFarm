import Tools.BigSize;
import Tools.Extension.AugmentedHoe;
import Tools.Hoe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtensionObjectsTest {
    @Test
    public void test() {
        Hoe bigHoe = new Hoe(new BigSize());
        AugmentedHoe augmentedHoe = new AugmentedHoe();
        int big = bigHoe.doWorkTest();
        int aug = augmentedHoe.doMoreWorkTest();
        assertEquals(big*2, aug);
    }
}
