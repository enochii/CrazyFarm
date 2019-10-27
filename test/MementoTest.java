import Livings.Plants.Crop;
import Memento.CropStateMemento;
import State.AnimalFullState;
import State.AnimalHungryState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MementoTest {
    @Test
    public void test(){
        Crop crop = new Crop();
        Crop cropCopy = crop.clone();

        CropStateMemento state = CropStateMemento.getMemento(crop);
        changeCropState(crop);

        assertNotEquals(crop,cropCopy);
        CropStateMemento.setMemento(crop, state);
        assertEquals(crop, cropCopy);
    }

    private void changeCropState(Crop crop){
        crop._state = (crop._state == AnimalFullState.getInstance())?
                AnimalHungryState.getInstance() : AnimalFullState.getInstance();
        crop._experience = 0;
        crop._isMature = !crop._isMature;
    }
}
