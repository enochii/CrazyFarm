import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import Tools.FarmTool;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlyweightTest {
    @Test
    public void test() {
        System.out.println("测试Flyweight模式：");
        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool firstIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_1 = firstIronBigHoe.hashCode();
        System.out.println("Hash code of the first object of Hoe is: " + hashCode_1);
        FarmTool secondIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_2 = secondIronBigHoe.hashCode();
        System.out.println("Hash code of the second object of Hoe is: " + hashCode_2);

        assertEquals(hashCode_1, hashCode_2);
        System.out.println("测试成功！");


    }
}
