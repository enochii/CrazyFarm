package mediator;

import Farm.Farm;
import Farm.Farmer;
import Farm.Menu;
import Livings.Animals.Animal;
import SolveStarvation.SolveStarvation;
import SolveStarvation.Starvation;
import SolveStarvation.FarmerSolveStarvation;
import SolveStarvation.OwnerSolveStarvation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import java.util.HashSet;
import java.util.Iterator;

public class AnimalMediator implements Mediator{

    private Menu<Animal> _animalMenu;
    private Farm _farm;


    private HashSet<Animal> _starvedAnimals = new HashSet<>();
    private int _num_starved_animals = 0;

    @Override
    public void createColleagues(){
        this._farm = Farm.getInstance();
        _animalMenu = _farm.getAnimalMenu();


    }

    /**
     * 给动物喂食
     */
    @Override
    public void colleagueChanged(){
        Iterator<Animal> animal_iter = _animalMenu.iterator();
        while (animal_iter.hasNext()){
            Animal animal = animal_iter.next();
            if(animal.isHungry()){
                _starvedAnimals.add(animal);
            }
        }

        /**
         * 饥饿的动物数量超过既定数目后喂食
         */
        if(_starvedAnimals.size()>_num_starved_animals){
            Iterator<Animal> starved_animal_iter = _starvedAnimals.iterator();
            int total_appetite_num  = 0;
            while (starved_animal_iter.hasNext()){
                Animal starved_animal = starved_animal_iter.next();
                total_appetite_num += starved_animal._appetite;
            }

            Farmer free_farmer =_farm.getFreeFarmer();

            if (free_farmer != null){
                SolveStarvation farmer_solve = new FarmerSolveStarvation(this._farm, free_farmer);
                SolveStarvation owner_solve = new OwnerSolveStarvation(this._farm);

                Starvation starvation = new Starvation();
                starvation._required_food_amount = total_appetite_num;
                farmer_solve.setNext(owner_solve);
                farmer_solve.solve(starvation);
            } else {
                System.out.println("No free farmer available to feed animals !");
            }
        }

    }

    public AnimalMediator(){
        _starvedAnimals = new HashSet<>();
        _num_starved_animals = 5;

        createColleagues();
        System.out.println("AnimalMediator has been initialized");
    }

    public Set<Animal> getStarvedAnimals(){
        return _starvedAnimals;
    }



}
