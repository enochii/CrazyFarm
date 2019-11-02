package Decorator.PlantDecorator;

import Constant.Const;
import Livings.Plants.Plant;

public class OrganicDecorator extends PlantDecorator {
	public OrganicDecorator(Plant plant){
		super(plant);
	}

	@Override
	public double getValue() {
		return obj.getValue()+Const.VALUE_ADDED_ORGANIC;
	}
}
