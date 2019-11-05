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

    public TableChicken(){
        this._appetite = 3;
    }

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

    @Override
    public void gobble(){
        makeSound();
    }

    public void setClock(int currentTime){

            if(currentTime - _lastFedTime > 6){
                if(Farm.getInstance().foodCourt >= this._appetite)
                {
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

    @Override
    public void makeEat() {
        new ChickenEat().doAction();
    }

    @Override
    public void makeSound() {
        new ChickenSound().doAction();
    }

    public void setColleagueEnable(boolean enable)
    {

    }


}
