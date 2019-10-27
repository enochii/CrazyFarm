package mediator;

import Farm.Farm;
import Farm.Farmer;
import Farm.Menu;
import Livings.Animals.Animal;

import java.util.HashSet;
import java.util.Iterator;

public class AnimalMediator implements Mediator{

    private Menu<Animal> _animalMenu;
    private Farm _farm;

    //这是AnimalMediator收集到的所有饥饿的动物
    private HashSet<Animal> _starvedAnimals = new HashSet<>();


    public void createColleagues(){
        this._farm = Farm.getInstance();
        _animalMenu = _farm.getAnimalMenu();


    }


    public void colleagueChanged(){




    }

    public AnimalMediator(){
        createColleagues();
        System.out.println("AnimalMediator has been initialized");
    }





}
