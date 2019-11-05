package Livings.Animals.Chicken;

import Constant.Const;
import Farm.Farm;
import State.AnimalFullState;
import State.AnimalHungryState;
import action.ChickenEat;
import action.ChickenSound;
import mediator.Mediator;


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

        if(mature_state==true) _maturityRate = 4;
        else _maturityRate = 0;
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

        if(this._maturityRate >= 20){
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

    @Override
    public String isMature() {
        if(_maturityRate > 3)
            _mature = Const.MATURE;
        return _mature;
    }


    /**
     * 接收中介者发出的命令
     */
    public void setColleagueEnable(boolean enable)
    {

    }
}
