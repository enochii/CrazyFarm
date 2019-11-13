package Livings.Animals.Chicken;

import Constant.Const;
import Farm.Farm;
import State.AnimalFullState;
import State.AnimalHungryState;
import action.ChickenEat;
import action.ChickenSound;
import mediator.Mediator;
import Farm.Owner;

import java.awt.*;

/**
 * The type Table chicken.
 */

/**
 * 肉鸡类
 */
public class TableChicken extends Chicken{
    private static double _value = Const.VALUE_TABLE_CHICKEN;
    private static String _name = Const.NAME_TABLE_CHICKEN;

    /**
     * @return 返回生物成熟后的价值
     */
    public double getValue(){
        return _value;
    }

    /**
     * @return 生物的名字
     */
    @Override
    public String getName(){
        return _name;
    }

    /**
     * 构造函数，初始化食量
     */
    public TableChicken(){
        this._appetite = 3;
    }

    /**
     * 构造函数，初始化中介者和食量
     */
    public TableChicken(Mediator mediator){
        this.setMediator(mediator);
        this._appetite = 3;
    }

    public TableChicken(boolean hungry_state, boolean mature_state){
        if(hungry_state==true) _state = AnimalHungryState.getInstance();
        else _state = AnimalFullState.getInstance();

        if(mature_state==true) _isMature = true;
        else _isMature = false;
    }

    /**
     * 发出叫声
     */
    @Override
    public void gobble(){
        makeSound();
    }

    /**
     * 随着时间改变动物的饥饿与否状态和成熟度
     */
    public void setClock(int currentTime){

            if(currentTime - _lastFedTime > 6){
                if(Farm.getInstance().foodCourt >= this._appetite)
                {
                    System.out.println(Const.NAME_TABLE_CHICKEN + "is eating");
                    this.getFed(currentTime);
                }
               else {
                    _state.getHungryState(this);
                }
            }
            else{
                _state.gainExperience(this);
            }

        if(this._maturityRate >= 10){
            this._isMature = true;
        }


    }

    /**
     * 动物进食的动作
     */
    @Override
    public void makeEat() {
        new ChickenEat().doAction();
    }

    /**
     * 动物发声
     */
    @Override
    public void makeSound() {
        new ChickenSound().doAction();
    }

    /**
     * 接收中介者发出的命令
     */
    public void setColleagueEnable(boolean enable)
    {

    }

    /**
     * 动物执行售卖
     */
    public void doSell() {
        if (this._isMature) {
            if (this.isSold) {
                System.out.println("This table chicken has been sold");
            } else {
                this.isSold = true;
                Owner.getInstance().makeMoney((int) (this.getValue()));
                Farm.getInstance().getAnimalMenu().erase(this);
                System.out.println("The table chicken has been sold successfully");
            }
        }
        else{
            System.out.println("The table chicken is not mature");
        }
    }
}
