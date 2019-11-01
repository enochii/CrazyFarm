package Livings.Plants;

import Livings.Living;
import State.State;
import Visitor.LivingVisitor;
import mediator.Mediator;
import mediator.PlantMediator;

/**
 * 植物类
 */
public abstract class Plant extends Living {

    public void getFed(int currentTime){}

    protected PlantMediator _plantMediator;

    public void setMediator(Mediator mediator){
        _plantMediator = (PlantMediator) mediator;
    }

    public void changeState(State state){}

    public void doSell(){

    }
    public void accept(LivingVisitor livingVisitor){
        livingVisitor.visit(this);
    }

	
}
