package AbstractFactory;

import Tools.FarmTool;

/**
 * 农具抽象工厂
 *
 * @className: AbstractToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7 :09 下午 2019/10/27
 */
public abstract class AbstractToolFactory {
    /**
     * Create small hoe farm tool.
     * 创建小锄头
     *
     * @return the farm tool
     */
    public abstract FarmTool createSmallHoe();

    /**
     * Create big hoe farm tool.
     * 创建大锄头
     *
     * @return the farm tool
     */
    public abstract FarmTool createBigHoe();

    /**
     * Create small shovel farm tool.
     * 创建小铲子
     *
     * @return the farm tool
     */
    public abstract FarmTool createSmallShovel();

    /**
     * Create big shovel farm tool.
     * 创建大铲子
     *
     * @return the farm tool
     */
    public abstract FarmTool createBigShovel();
}

/**
 * The type Test abstract factory.
 */
class TestAbstractFactory {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
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
