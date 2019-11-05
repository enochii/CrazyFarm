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

    //植物被浇灌
    public void getFed(int currentTime){}

    protected PlantMediator _plantMediator;

    //植物设置中介者
    public void setMediator(Mediator mediator){
        _plantMediator = (PlantMediator) mediator;
    }

    //植物改变状态
    public void changeState(State state){}

    //植物执行售卖
    public void doSell(){

    }
    //植物接收中介者
    public void accept(LivingVisitor livingVisitor){
        livingVisitor.visit(this);
    }

    //成熟率
    public int _maturityRate = 0;

	
}
