package Livings.Animals;

import Livings.Living;
import State.State;
import State.AnimalHungryState;
//import com.sun.xml.internal.xsom.impl.AnnotationImpl;
import action.AnimalAction;
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

    //改变是否饥饿的状态
    @Override
    public void changeState(State state){
        this._state = state;
        if(isHungry()){
            setColleagueUpdated();


        }

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

    public void behave(AnimalAction action){
        action.doAction();
    }

    @Override
    public void setColleagueUpdated(){
        _animalMediator.colleagueChanged();
    }

    public void doSell(){



    }





}
