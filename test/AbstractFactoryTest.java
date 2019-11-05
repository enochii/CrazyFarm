import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import AbstractFactory.StainlessSteelToolFactory;
import Tools.FarmTool;
import org.junit.Test;

public class AbstractFactoryTest {
    @Test
    public void test() {
        System.out.println("测试铁制农具抽象工厂：");
        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool ironBigHoe = ironToolFactory.createBigHoe();
        ironBigHoe.testAbstractFactory();
        FarmTool ironSmallHoe = ironToolFactory.createSmallHoe();
        ironSmallHoe.testAbstractFactory();
        FarmTool ironBigShovel = ironToolFactory.createBigShovel();
        ironBigShovel.testAbstractFactory();
        FarmTool ironSmallShovel = ironToolFactory.createSmallShovel();
        ironSmallShovel.testAbstractFactory();

        System.out.println("测试不锈钢制农具抽象工厂");
        AbstractToolFactory stainlessToolFactory = new StainlessSteelToolFactory();
        FarmTool stainlessBigHoe = stainlessToolFactory.createBigHoe();
        stainlessBigHoe.testAbstractFactory();
        FarmTool stainlessSmallHoe = stainlessToolFactory.createSmallHoe();
        stainlessSmallHoe.testAbstractFactory();
        FarmTool stainlessBigShovel = stainlessToolFactory.createBigShovel();
        stainlessBigShovel.testAbstractFactory();
        FarmTool stainlessSmallShovel = stainlessToolFactory.createSmallShovel();
        stainlessSmallShovel.testAbstractFactory();
    }
}
