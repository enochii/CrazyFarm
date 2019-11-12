import Converter.CropConverter;
import Livings.Plants.Crop;
import Memento.CropStateMemento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : SCH001
 * @description :
 */
public class ConverterOtherTest {
    private Crop crop;
    private CropStateMemento memento;

    @Before
    public void setup(){
        System.out.println("======== 测试 Converter 模式 ========");
        crop = new Crop();
        memento = CropStateMemento.getMemento(crop);
        System.out.println("初始化结束");
    }

    @Test
    public void test() {
        CropConverter converter = new CropConverter();
        assertEquals(crop, converter.convertFromDto(memento));
        assertEquals(memento, converter.convertFromEntity(crop));
    }
}
