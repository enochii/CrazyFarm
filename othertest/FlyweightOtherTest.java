import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import Tools.FarmTool;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @className: FlyweightOtherTest
 * @description:
 * @designPattern:
 * @date: 1:39 下午 2019/11/12
 */
public class FlyweightOtherTest {
    private AbstractToolFactory ironToolFactory = new IronToolFactory();

    @Before
    public void setUp() {
        System.out.println("======== 测试 Flyweight 模式 ========");
        ironToolFactory = new IronToolFactory();
    }

    @Test
    public void testForFlyweight() {
        FarmTool firstIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_1 = firstIronBigHoe.hashCode();
        FarmTool secondIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_2 = secondIronBigHoe.hashCode();

        System.out.println("Hash code of the first object of Hoe is: " + hashCode_1);
        System.out.println("Hash code of the second object of Hoe is: " + hashCode_2);

        assertEquals(hashCode_1, hashCode_2);
    }
}
