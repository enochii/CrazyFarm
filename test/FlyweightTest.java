import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import Tools.FarmTool;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlyweightTest {
    @Test
    public void test() {
        System.out.println("测试Flyweight模式：");
        System.out.println("提示：Flyweight模式在抽象工厂模式中实现，所以测试过程会设计抽象工厂模式，以及抽象工厂内的享元模式和桥接模式。");
        System.out.println("");

        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool firstIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_1 = firstIronBigHoe.hashCode();
        System.out.println("Hash code of the first object of Hoe is: " + hashCode_1);
        FarmTool secondIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_2 = secondIronBigHoe.hashCode();
        System.out.println("Hash code of the second object of Hoe is: " + hashCode_2);

        assertEquals(hashCode_1, hashCode_2);
        System.out.println("先后获取的两个实例对象的hashCode一样，说明共享同一份内存空间，测试成功！");


    }
}
