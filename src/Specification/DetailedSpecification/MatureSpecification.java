package Specification.DetailedSpecification;

import Constant.Const;
import Livings.Animals.Animal;
import Specification.CompositeSpecification;

public class MatureSpecification extends CompositeSpecification {
	@Override
	public boolean isSatisfiedBy(Object params) {
		Animal animal = (Animal) params;
		return animal.getMature();
	}
}
