import Livings.Plants.Crop;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrototypeTest {
    @Test
    public void test() {
        Crop cropProtorype = new Crop();
        assertEquals(cropProtorype, cropProtorype.clone());
    }
}
