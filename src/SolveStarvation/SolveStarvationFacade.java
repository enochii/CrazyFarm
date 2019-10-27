package SolveStarvation;

import Farm.Farm;
import Farm.Farmer;

/**
 * 外观(Facade)模式
 */
public class SolveStarvationFacade {

    private Starvation starvation;
	private SolveStarvation farmer_solve;
    private SolveStarvation owner_solve;
	
	public SolveStarvationFacade(Farm farm, Farmer farmer) {
        Starvation starvation = new Starvation();
		SolveStarvation farmer_solve = new FarmerSolveStarvation(farm, farmer);
        SolveStarvation owner_solve = new OwnerSolveStarvation(farm);
	}
	
	public void solve(int total_appetite_num) {
        starvation._required_food_amount = total_appetite_num;
        farmer_solve.setNext(owner_solve);
        farmer_solve.solve(starvation);
	}
	
}
