package SolveStarvation;

import Farm.Farm;
import Farm.Farmer;

/**
 * 外观(Facade)模式
 * 解决动物饥饿问题的外观类，提供解决饥饿的接口
 */
public class SolveStarvationFacade {

    private Starvation _starvation;
	private FarmerSolveStarvation _farmer_solve;
    private OwnerSolveStarvation _owner_solve;

    /**
     * 构造外观类
     * @param farm 农场
     * @param farmer 农民
     */
	public SolveStarvationFacade(Farm farm, Farmer farmer) {
	    System.out.println("======== 使用外观 Facade 模式 ========");
        this._starvation = new Starvation();
		this._farmer_solve = new FarmerSolveStarvation(farm, farmer);
        this._owner_solve = new OwnerSolveStarvation(farm);
	}

    /**
     * 外观解决饥饿的接口，调用此函数解决饥饿问题
     * @param total_appetite_num 需要的食物数
     */
	public void solve(int total_appetite_num) {
	    System.out.println("使用外观模式解决饥饿问题");
        _starvation._required_food_amount = total_appetite_num;
        _farmer_solve.setNext(_owner_solve);
        _farmer_solve.solve(_starvation);
	}
	
}
