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

class TestAbstractFactory {
    public static void main(String[] args) {
        System.out.println("======== 使用抽象工厂 Abstract Factory 模式和享元 Flyweight 模式 ========");

        System.out.println("创建铁制农具抽象工厂");
        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool ironBigHoe = ironToolFactory.createBigHoe();
        ironBigHoe.testAbstractFactory();
        FarmTool ironSmallHoe = ironToolFactory.createSmallHoe();
        ironSmallHoe.testAbstractFactory();
        FarmTool ironBigShovel = ironToolFactory.createBigShovel();
        ironBigShovel.testAbstractFactory();
        FarmTool ironSmallShovel = ironToolFactory.createSmallShovel();
        ironSmallShovel.testAbstractFactory();

        System.out.println("创建不锈钢制农具抽象工厂");
        AbstractToolFactory stainlessToolFactory = new StainlessSteelToolFactory();
        FarmTool stainlessBigHoe = stainlessToolFactory.createBigHoe();
        stainlessBigHoe.testAbstractFactory();
        FarmTool stainlessSmallHoe = stainlessToolFactory.createSmallHoe();
        stainlessSmallHoe.testAbstractFactory();
        FarmTool stainlessBigShovel = stainlessToolFactory.createBigShovel();
        stainlessBigShovel.testAbstractFactory();
        FarmTool stainlessSmallShovel = stainlessToolFactory.createSmallShovel();
        stainlessSmallShovel.testAbstractFactory();


        FarmTool firstIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_1 = firstIronBigHoe.hashCode();
        System.out.println("Hash code of the first object of Iron Hoe is: " + hashCode_1);
        FarmTool secondIronBigHoe = ironToolFactory.createBigHoe();
        int hashCode_2 = secondIronBigHoe.hashCode();
        System.out.println("Hash code of the second object of Iron Hoe is: " + hashCode_2);
    }
}
