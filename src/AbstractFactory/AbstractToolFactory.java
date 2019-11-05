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