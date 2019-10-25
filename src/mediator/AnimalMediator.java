package mediator;

import Farm.Farm;
import Farm.Menu;
import Livings.Animals.Animal;

public class AnimalMediator implements Mediator{

    private Menu<Animal> AnimalMenu;
    private Farm farm;

    public void createColleagues(Farm farm){
        this.farm = farm;
    }

    public void colleagueChanged(){

    }



}
