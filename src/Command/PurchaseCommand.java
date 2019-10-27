package Command;

import Farm.Farm;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;
import Livings.LivingCloneable;

/**
 * The type Purchase command.
 */
public class PurchaseCommand implements Command{
    String _animalType;
    int _number;

    public PurchaseCommand(String animalType, int number){
        _animalType = animalType;
        _number = number;
    }

    public void execute(){
        Farm farm = Farm.getInstance();
        if(_animalType == "TableChicken"){
            farm.getAnimalMenu().add(new TableChicken());

            //To do:
            // 农场主减去购买的金钱
        }
        else if(_animalType == "SmallYellowDuck"){
            for(int i = 0; i < _number; i++){
                farm.getAnimalMenu().add(new SmallYellowDuck());
            }

            //To do:
            // 农场主减去购买的金钱
        }
    }
}
