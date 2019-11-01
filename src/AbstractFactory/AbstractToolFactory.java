package AbstractFactory;

import Tools.FarmTool;

/**
 * @className: AbstractToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7:09 下午 2019/10/27
 */
public abstract class AbstractToolFactory {
    public abstract FarmTool createSmallHoe();
    public abstract FarmTool createBigHoe();
    public abstract FarmTool createSmallShovel();
    public abstract FarmTool createBigShovel();
}

class TestAbstractFactory {
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
        AbstractToolFactory stainlessToolFactory = new IronToolFactory();
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
