package Visitor;

import Livings.Animals.Animal;
import Livings.Plants.Plant;

/**
 * The interface Living visitor.
 * @className: LivingVisitor
 * @author: OY
 * @description: The interface Living visitor.
 * @designPattern: Visitor
 * @date: 19 :37 2019/10/25
 */
public interface LivingVisitor {
    /**
     * Visit function for animal.
     * @param animal the animal to be visited
     */
    public void visit(Animal animal);

    /**
     * Visit function for plant.
     * @param plant the plant to be visited
     */
    public void visit(Plant plant);
}
