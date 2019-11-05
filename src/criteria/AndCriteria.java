package criteria;

import Livings.Animals.Animal;
import java.util.List;

/**
 * 筛选同时满足两个标准的动物集合
 */
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Animal> meetCriteria(List<Animal> animals) {
        List<Animal> firstCriteriaAnimals = criteria.meetCriteria(animals);
        return otherCriteria.meetCriteria(firstCriteriaAnimals);
    }
}
