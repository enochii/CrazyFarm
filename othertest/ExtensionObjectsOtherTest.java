import Tools.BigSize;
import Tools.Extension.AugmentedHoe;
import Tools.Hoe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtensionObjectsOtherTest {

    private Hoe bigHoe;
    private AugmentedHoe augmentedHoe;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Extension objects 模式 ========");
        bigHoe = new Hoe(new BigSize());
        augmentedHoe = new AugmentedHoe();
    }

    @Test
    public void test() {
        int big = bigHoe.doWorkTest();
        int aug = augmentedHoe.doMoreWorkTest();
        System.out.println("big hoe do " + big + " work");
        System.out.println("augmented hoe do " + aug + " work");
        assertEquals(big*2, aug);
    }
}
