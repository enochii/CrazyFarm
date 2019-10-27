package Decorator.AnimalDecorator;

import Livings.Animals.Animal;

public abstract class AnimalDecorator extends Animal {
	protected Animal obj;

	public AnimalDecorator(Animal obj){
		this.obj = obj;
	}

	/**
	 * Decorator重写不相干的方法
	 */
	@Override
	public void setClock(int currentTime) {
	}

	@Override
	public String getName() {
		return obj.getName();
	}

	@Override
	public void getFed(int currentTime) {
	}

	@Override
	public void setColleagueEnable(boolean enable) {}

	@Override
	public void setColleagueUpdated() {	}
}
