import Farm.Farmer;
import Farm.FarmerData;
import org.junit.Test;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;

public class PrivateClassDataTest {
    @Test
    public void test() {
        Farmer farmer = new Farmer();
        try {
            Field field = farmer.getClass().getDeclaredField("_farmerData");
            field.setAccessible(true);
            ((FarmerData)field.get(farmer)).setName("PCD Test");
            assertEquals(farmer.getName(), "PCD Test");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
