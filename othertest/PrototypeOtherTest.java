import Livings.Plants.Crop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @designPattern: Prototype
 */
public class PrototypeOtherTest {

    private Crop cropPrototype;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Prototype 模式 ========");
        cropPrototype = new Crop();
    }

    @Test
    public void test() {
        Crop cloneCrop = cropPrototype.clone();
        assertEquals(cropPrototype, cloneCrop);
        System.out.println("clone crop is same to crop prototype");
    }
}
