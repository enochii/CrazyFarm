package criteria;

import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;

import java.util.ArrayList;
import java.util.List;

public class CriteriaChicken implements Criteria {

    @Override
    public List<Animal> meetCriteria(List<Animal> animals) {
        List<Animal> chickens = new ArrayList<Animal>();
        for(Animal animal : animals) {
            if(animal instanceof Chicken) {
                chickens.add(animal);
            }
        }
        return chickens;
    }
}
