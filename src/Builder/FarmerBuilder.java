package Builder;

import Farm.Farmer;

/**
 * The type Farmer builder.
 *
 * @className: FarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 4 :17 下午 2019/10/27
 */
public abstract class FarmerBuilder {
    /**
     * The Farmer.
     */
    protected Farmer _farmer;

    /**
     * Gets farmer.
     * 获取当前 Builder 内的农民
     *
     * @return the farmer
     */
    public Farmer getFarmer() { return _farmer; }

    /**
     * Create new farmer.
     * 创建一个新的农民
     */
    public void createNewFarmer() { _farmer = new Farmer(); }

    /**
     * Sets work type.
     * 抽象方法：为农民设置工作类型
     */
    public abstract void setWorkType();

    /**
     * Assign tools.
     * 抽象方法：为农民分配农具
     */
    public abstract void assignTools();
}
