package Livings.Animals.Chicken;

import Constant.Const;
import Livings.Animals.Animal;
import State.AnimalFullState;
import mediator.Mediator;


/**
 * The type Table chicken.
 */
/*
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
    }

    public TableChicken(Mediator mediator){
        this.setMediator(mediator);
        this._appetite = 3;
    }
    @Override
    public void gobble(){
        System.out.println("Table Children!");
    }

    public void setClock(int currentTime){

        if(_lastFedTime > currentTime){
            if(currentTime + 24 - _lastFedTime > 6){
                _state.getHungryState(this);

            }
            else{
                _state.gainExperience(this);
            }
        }

        else{
            if(currentTime - _lastFedTime > 6){
                _state.getHungryState(this);
            }

            else{
                _state.gainExperience(this);
            }

        }

        if(this._experience >= 100){
            this._isMature = true;
        }


    }

    public void getFed(int currentTime){
        this._state = AnimalFullState.getInstance();
        _lastFedTime = currentTime;
        //等待写喂食过后的反应

    }

    public void setColleagueEnable(boolean enable)
    {

    }
}
