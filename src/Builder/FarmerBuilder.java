package Builder;

import Farm.Farmer;

/**
 * @className: FarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 4:17 下午 2019/10/27
 */
public abstract class FarmerBuilder {
    protected Farmer _farmer;

    public Farmer getFarmer() { return _farmer; }
    public void createNewFarmer() { _farmer = new Farmer(); }

    public abstract void setWorkType();
    public abstract void assignTools();
}
