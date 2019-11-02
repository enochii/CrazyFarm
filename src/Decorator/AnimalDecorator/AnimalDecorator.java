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
	public void makeEat() {	}

	@Override
	public void makeSound() { }

	@Override
	public String isMature() { return null; }

	@Override
	public void setColleagueEnable(boolean enable) {}

	@Override
	public void setColleagueUpdated() {	}
}
