package Livings.Plants;

import Constant.Const;
import Livings.LivingCloneable;
import State.AnimalFullState;
import State.AnimalHungryState;
import mediator.PlantMediator;

public class Crop extends Plant implements LivingCloneable {
	private static double _value = Const.VALUE_CROP;
	private static String _name = Const.NAME_CROP;

	/**
	 * @return 返回生物成熟后的价值
	 */
	public double getValue(){
		return _value;
	}

	/**
	 * @return 生物的名字
	 */
	@Override
	public String getName(){
		return _name;
	}
	
	/**
	 * Crop 构造函数
	 */
	public Crop() {}

	public Crop(PlantMediator _plantMediator){

	}
	
	/**
	 * Prototype Pattern
	 * @return Crop的克隆
	 */
	public Crop clone() {
		System.out.println("======== 使用原型 Prototype 模式 ========");
		System.out.println("成功通过原型创建Crop");
		return new Crop();
	}

	public void setClock(int currentTime){
		_state.gainExperience(this);
		_maturityRate++;

		if(this._maturityRate >= 10)
		{
			this._isMature = true;
		}

	}

	@Override
	public boolean equals(Object o){
		Crop crop = null;
		try{
			crop = (Crop)o;
		}catch (ClassCastException e){
			System.out.println("Class Cast Error");
		}
		return this._isMature == crop._isMature &&
				this._experience == crop._experience &&
				this._state == crop._state;
	}

	/**
	 * 打印作物的状态
	 */
	public void printCrop(){
		System.out.println("-------作物的状态-------");
		System.out.println("experience ： " + _experience);
		System.out.println("maturityRate: " + _maturityRate);
		System.out.println("isMature: " + _isMature);
		System.out.println("state: " + _state);
	}

	/**
	 * 改变作物的状态
	 * 仅作为测试使用
	 */
	public void changeCropState(){
//		System.out.println("你使用测试函数改变了作物的状态");
		System.out.println("你使用魔法道具改变了作物的状态");
		_experience ++;
		_isMature = !_isMature;
		_maturityRate ++;
		_state = _state == AnimalHungryState.getInstance()?AnimalFullState.getInstance() : AnimalHungryState.getInstance();
	}
}
