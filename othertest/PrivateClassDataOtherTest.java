import Farm.Farmer;
import Farm.FarmerData;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class PrivateClassDataOtherTest {

    private Farmer farmer;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Private Class Data 模式 ========");
        farmer = new Farmer();
    }

    @Test
    public void test() {
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
