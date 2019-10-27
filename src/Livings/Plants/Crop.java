package Livings.Plants;

import Constant.Const;
import Livings.LivingCloneable;
import mediator.PlantMediator;

public class Crop extends Plant implements LivingCloneable {
	private static double _value = Const.VALUE_CROP;
	private static String _name = Const.NAME_CROP;

	/*
	 * @return 返回生物成熟后的价值
	 */
	public double getValue(){
		return _value;
	}

	/*
	 * @return 生物的名字
	 */
	@Override
	public String getName(){
		return _name;
	}
	
	/*
	 * Crop 构造函数
	 */
	public Crop() {}

	public Crop(PlantMediator _plantMediator){

	}
	
	/*
	 * Prototype Pattern
	 * @return Crop的克隆
	 */
	public Crop clone() {
		return new Crop();
	}

	public void setClock(int currentTime){
		_state.gainExperience(this);

	}


	
}
