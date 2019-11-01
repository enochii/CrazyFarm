package Specification.DetailedSpecification;

import Livings.Animals.Animal;
import Specification.CompositeSpecification;

public class HungrySpecification extends CompositeSpecification {
	@Override
	public boolean isSatisfiedBy(Object params) {
		Animal animal = (Animal) params;
		return animal.isHungry();
	}
}