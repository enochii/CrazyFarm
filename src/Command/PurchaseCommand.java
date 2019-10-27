package Command;

import Farm.Farm;


public class PurchaseCommand implements Command{
    String _animalType;
    int _number;

    public PurchaseCommand(String animalType, int number){
        _animalType = animalType;
        _number = number;
    }

    public void execute(){
        Farm farm = Farm.getInstance();
        if(_animalType == "chicken"){
        }
    }
}
