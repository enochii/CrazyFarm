import Livings.Plants.Crop;
import Memento.CropStateMemento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MementoTest {
    @Test
    public void test(){
        Crop crop = new Crop();
        Crop cropCopy = crop.clone();

        CropStateMemento state = CropStateMemento.getMemento(crop);
        crop.changeCropState();

        assertNotEquals(crop,cropCopy);
        CropStateMemento.setMemento(crop, state);
        assertEquals(crop, cropCopy);
    }
}
