package criteria;

import Constant.Const;
import Livings.Animals.Animal;
import Livings.Animals.NullAnimal;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤得到所有成熟动物
 */
public class CriteriaMature implements Criteria {

    @Override
    public List<Animal> meetCriteria(List<Animal> animals) {
        List<Animal> matureAnimals = new ArrayList<Animal>();
        for(Animal animal : animals) {
            if(animal.getMature()) {
                matureAnimals.add(animal);
            }
        }
        if(matureAnimals.isEmpty()) {
            matureAnimals.add(new NullAnimal());
        }
        return matureAnimals;
    }
}
