package criteria;

import Livings.Animals.Animal;

import java.util.List;

public interface Criteria {
    public List<Animal> meetCriteria(List<Animal> animals);
}
