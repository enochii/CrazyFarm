package Decorator.PlantDecorator;

import Livings.Plants.Plant;

public abstract class PlantDecorator extends Plant {
	protected Plant obj;

	public PlantDecorator(Plant obj){
		this.obj = obj;
		System.out.println("Create: "+this.getClass()+" @"+this.hashCode());
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
}
