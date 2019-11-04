package Livings;

import State.Context;
import State.AnimalHungryState;
import State.State;

import java.io.Serializable;

/**
 * 生物类，动物和植物的基类
 */
//TODO : 把生物类写成接口
public abstract class Living implements Context, Serializable {
    //生物成熟后的价值
    private double _value;
//    // 生物名字
    private String _name;


    /**
     * @return 返回生物成熟后的价值
     */
    public abstract double getValue();


    /**
     * 设置living的价值
     */
    public void setValue(double value){
        this._value = value;
    }

    /*
    
    /**
     * @return 生物的名字
     */
    public abstract String getName();

    //生物是否饥饿的状态
    public State _state = AnimalHungryState.getInstance();

    //生物是否成熟
    public boolean _isMature;

    public int _experience = 0;

    public abstract void doSell();



}
