package Livings.Animals.Duck;

import Constant.Const;
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

        if(_lastFedTime > currentTime){
            if(currentTime + 24 - _lastFedTime > 7){
                _state.getHungryState(this);

            }
            else{
                _state.gainExperience(this);
            }
        }

        else{
            if(currentTime - _lastFedTime > 7){
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

    @Override
    public void makeEat() {
        new DuckEat().doAction();
    }

    @Override
    public void makeSound() {
        new DuckSound().doAction();
    }

    public void setColleagueEnable(boolean enable)
    {

    }

    @Override
    public void setColleagueUpdated(){
        _animalMediator.colleagueChanged();

    }

    public SmallYellowDuck(){

    }
}
