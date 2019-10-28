package SolveStarvation;

import Farm.Farm;
import Farm.Farmer;

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

    @Override
    public boolean resolve(Starvation starvation){
        Farmer farmer_ = farmer;
        return farmer_.solveStarvation(this, starvation);
    }
}
