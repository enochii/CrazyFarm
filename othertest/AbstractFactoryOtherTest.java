import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import AbstractFactory.StainlessSteelToolFactory;
import Tools.FarmTool;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: AbstractFactoryOtherTest
 * @description:
 * @designPattern:
 * @date: 1:36 下午 2019/11/12
 */
public class AbstractFactoryOtherTest {

    private AbstractToolFactory ironToolFactory;
    private AbstractToolFactory stainlessToolFactory;


    @Before
    public void setUp() {
        System.out.println("======== 测试 Abstract Factory 模式 ========");
        ironToolFactory = new IronToolFactory();
        stainlessToolFactory = new StainlessSteelToolFactory();
    }

    @Test
    public void testForAbstractFactory() {
        System.out.println("测试铁制农具抽象工厂：");
        FarmTool ironBigHoe = ironToolFactory.createBigHoe();
        ironBigHoe.testAbstractFactory();
        FarmTool ironSmallHoe = ironToolFactory.createSmallHoe();
        ironSmallHoe.testAbstractFactory();
        FarmTool ironBigShovel = ironToolFactory.createBigShovel();
        ironBigShovel.testAbstractFactory();
        FarmTool ironSmallShovel = ironToolFactory.createSmallShovel();
        ironSmallShovel.testAbstractFactory();

        System.out.println("");
        System.out.println("测试不锈钢制农具抽象工厂：");
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
