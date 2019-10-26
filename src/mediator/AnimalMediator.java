package mediator;

import Farm.Farm;
import Farm.Menu;
import Livings.Animals.Animal;

public class AnimalMediator implements Mediator{

    private Menu<Animal> _animalMenu;
    private Farm _farm;

    public void createColleagues(){
        this._farm = Farm.getInstance();


    }

    public void colleagueChanged(){

    }

    public AnimalMediator(){
        createColleagues();
        System.out.println("AnimalMediator has been initialized");
    }





}
