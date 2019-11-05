package SolveStarvation;

import Farm.Farm;
import Farm.Farmer;

/**
 * 责任链(chain of responsibility)模式
 */
public class FarmerSolveStarvation extends SolveStarvation {
    private Farmer farmer;

    /**
     * 构造函数
     * @param farm s
     * @param farmer_ s
     */
    public FarmerSolveStarvation(Farm farm, Farmer farmer_){
        super("farmer", farm);
        farmer = farmer_;
    }

    /**
     * 调用农民喂食的函数
     * @param starvation
     * @return 是否成功解决
     */
    @Override
    public boolean resolve(Starvation starvation){
        Farmer farmer_ = farmer;
        return farmer_.solveStarvation(this, starvation);
    }
}
