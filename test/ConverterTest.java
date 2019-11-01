import Converter.CropConverter;
import Livings.Plants.Crop;
import Memento.CropStateMemento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : SCH001
 * @description :
 */
public class ConverterTest {
    @Test
    public void test() {
        Crop crop = new Crop();
        CropStateMemento memento = CropStateMemento.getMemento(crop);

        CropConverter converter = new CropConverter();
        assertEquals(crop, converter.convertFromDto(memento));
        assertEquals(memento, converter.convertFromEntity(crop));
    }
}
