package SolveStarvation;

import Farm.Farm;
import Farm.Owner;

public class OwnerSolveStarvation extends SolveStarvation {
    public OwnerSolveStarvation(Farm farm){
        super("Owner", farm);
    }

    protected boolean resolve(Starvation starvation){
        return Owner.getInstance().solveStarvation(this, starvation);
    }
}
