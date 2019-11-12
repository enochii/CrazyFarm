import Livings.Plants.Crop;
import Memento.CropStateMemento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author : SCH001
 * @description :
 */
public class MementoOtherTest {
    private Crop crop;
    private Crop cropCopy;
    private CropStateMemento state;

    @Before
    public void setup(){
        System.out.println("======== 测试 Memento 模式 ========");
        crop = new Crop();
        cropCopy = crop.clone();

        state = CropStateMemento.getMemento(crop);
        System.out.println("初始化结束");
    }
    @Test
    public void test(){
        crop.changeCropState();

        assertNotEquals(crop,cropCopy);
        CropStateMemento.setMemento(crop, state);
        assertEquals(crop, cropCopy);
    }
}
