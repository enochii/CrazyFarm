package Command;

import Livings.Animals.Animal;

/**
 * @program: crazyfarm->SellCommand
 * @description: A command to sell animals
 * @author: jh
 * @create: 2019-10-27 20:09
 **/

public class SellCommand implements Command {

    protected Animal _animal;

    public SellCommand(Animal animal){
        this._animal = animal;
    }

    public void execute(){
        _animal.doSell();


    }

}
