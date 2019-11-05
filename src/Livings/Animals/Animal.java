package Livings.Animals;

import Constant.Const;
import Farm.Farm;
import Livings.Living;
import State.State;
import State.AnimalFullState;
import State.AnimalHungryState;
//import com.sun.xml.internal.xsom.impl.AnnotationImpl;
import Visitor.LivingVisitor;
import mediator.AnimalMediator;
import mediator.Colleague;
import mediator.Mediator;


public abstract class Animal extends Living implements Colleague {
    //maybe useless
//    abstract void makeSound();

    protected AnimalMediator _animalMediator;

    //上次喂食的时间
    public int _lastFedTime = 0;

    //动物每次喂食需要的食物
    public int _appetite = 0;

    //成熟率
    public int _maturityRate = 0;




    //改变是否饥饿的状态
    @Override
    public void changeState(State state){
        this._state = state;
        if(isHungry()){
            setColleagueUpdated();

        }

    }

    //判断是否成熟
    public boolean getMature(){
        return _isMature;
    }

    //判断是否饥饿
    public boolean isHungry(){
        return this._state == AnimalHungryState.getInstance();
    }

    @Override
    public void setMediator(Mediator mediator){
        _animalMediator = (AnimalMediator) mediator;
    }


    //获取动物的食量
    public int getAppetite(){
        return _appetite;
    }

    //动物进行发声动作
    public abstract void makeSound();

    //动物进行进食动作
    public abstract void makeEat();

    //进食动作
    public final void getFed(int currentTime) {
        this._state = AnimalFullState.getInstance();
        _lastFedTime = currentTime;

        Farm farm = Farm.getInstance();

        makeEat();
        makeSound();
        _maturityRate++;
        farm.foodCourt -= this._appetite;

    }

    @Override
    public void setColleagueUpdated(){
        _animalMediator.colleagueChanged();
    }

    public void doSell(){

    }

    public void accept(LivingVisitor livingVisitor){
        livingVisitor.visit(this);
    }



}
