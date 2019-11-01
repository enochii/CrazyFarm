package criteria;

import Livings.Animals.Animal;
import Livings.Animals.Duck.Duck;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDuck implements Criteria {

    @Override
    public List<Animal> meetCriteria(List<Animal> animals) {
        List<Animal> ducks = new ArrayList<Animal>();
        for(Animal animal : animals) {
            if(animal instanceof Duck) {
                ducks.add(animal);
            }
        }
        return ducks;
    }
}
