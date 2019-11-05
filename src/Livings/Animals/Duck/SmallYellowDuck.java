package Livings.Animals.Duck;

import Constant.Const;
import Farm.Farm;
import action.DuckEat;
import action.DuckSound;
import mediator.Mediator;

public class SmallYellowDuck extends Duck{
    private static double _value = Const.VALUE_YELLOW_DUCK;
    private static String _name = Const.NAME_YELLOW_DUCK;

    /*
     * @return 返回生物成熟后的价值
     */
    public double getValue(){
        return _value;
    }

    /*
     * @return 生物的名字
     */
    @Override
    public String getName(){
        return _name;
    }
    @Override
    public void quack(){
        makeSound();
    }

    public SmallYellowDuck(Mediator mediator){
        this.setMediator(mediator);
        this._appetite = 4;
    }

    public void setClock(int currentTime){




        if(currentTime - _lastFedTime > 7){
            if(Farm.getInstance().foodCourt >= this._appetite)
            {
                System.out.println(Const.NAME_YELLOW_DUCK+ "is eating");
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

    @Override
    public void makeEat() {
        new DuckEat().doAction();
    }

    @Override
    public void makeSound() {
        new DuckSound().doAction();
    }

    @Override
    public String isMature() {
        if(_maturityRate > 4)
            _mature = Const.MATURE;
        return _mature;
    }

    public void setColleagueEnable(boolean enable)
    {

    }

    @Override
    public void setColleagueUpdated(){
        _animalMediator.colleagueChanged();

    }

    public SmallYellowDuck(){
        this._appetite = 4;
    }
}
