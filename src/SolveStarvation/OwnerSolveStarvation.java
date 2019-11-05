package SolveStarvation;

import Farm.Farm;
import Farm.Owner;

/**
 * 责任链(chain of responsibility)模式
 */
public class OwnerSolveStarvation extends SolveStarvation {
    public OwnerSolveStarvation(Farm farm){
        super("Owner", farm);
    }

    /**
     * 调用农场主喂食的函数
     * @param starvation 需要解决的问题
     * @return 是否成功解决问题
     */
    @Override
    public boolean resolve(Starvation starvation){
        return Owner.getInstance().solveStarvation(this, starvation);
    }
}
