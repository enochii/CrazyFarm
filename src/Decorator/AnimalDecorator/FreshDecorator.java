package Decorator.AnimalDecorator;

import Constant.Const;
import Livings.Animals.Animal;
import Livings.Plants.Plant;

public class FreshDecorator extends AnimalDecorator {
	public FreshDecorator(Animal animal){
		super(animal);
	}

	@Override
	public double getValue() {
		return obj.getValue()+Const.VALUE_ADDED_FRESH;
	}
}
