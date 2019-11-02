package Decorator.PlantDecorator;

import Constant.Const;
import Livings.Plants.Plant;

public class TransgenosisDecorator extends PlantDecorator {
	public TransgenosisDecorator(Plant plant) {
		super(plant);
	}

	@Override
	public double getValue() {
		return obj.getValue() + Const.VALUE_ADDED_TRANSGENOSIS;
	}
}
