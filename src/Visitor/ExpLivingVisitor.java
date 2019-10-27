package Visitor;

import Livings.Animals.Animal;
import Livings.Living;
import Livings.Plants.Plant;

/**
 * output the experience of livings
 * it implements of {@link LivingVisitor} interface
 * @className: ExpLivingVisitor
 * @author: OY
 * @description: output the experience of livings
 * @designPattern: Visitor
 * @date: 13:15 2019/10/27
 */
public class ExpLivingVisitor implements LivingVisitor {

    @Override
    public void visit(Animal animal) {
        System.out.println("the animal experience of "+animal.getName()+" is "+animal.getValue());
    }

    @Override
    public void visit(Plant plant) {
        System.out.println("the plant experience of "+plant.getName()+" is "+plant.getValue());
    }
}
