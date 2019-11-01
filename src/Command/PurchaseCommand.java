package Command;

import CallBack.MoneyCallback;
import Farm.Farm;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;

/**
 * The type Purchase command.
 */
public class PurchaseCommand implements Command {
    String _animalType;
    int _number;
    private MoneyCallback _reduceMoneyCallBack;

    public PurchaseCommand(String animalType, int number, MoneyCallback callBack) {
        _animalType = animalType;
        _number = number;
        _reduceMoneyCallBack = callBack;
    }

    public void execute() {
        Farm farm = Farm.getInstance();
        if(_animalType == "TableChicken"){
            Animal animal = new TableChicken();
            farm.getAnimalMenu().add(animal);
            _reduceMoneyCallBack.setMoney(animal.getValue());
            _reduceMoneyCallBack.call();
        }
        else if(_animalType == "SmallYellowDuck"){
            for(int i = 0; i < _number; i++){
                Animal animal = new SmallYellowDuck();
                farm.getAnimalMenu().add(animal);
                _reduceMoneyCallBack.setMoney(animal.getValue());
                _reduceMoneyCallBack.call();
            }
        }
    }
}
