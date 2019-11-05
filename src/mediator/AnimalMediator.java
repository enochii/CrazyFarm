package mediator;

import Farm.Farm;
import Farm.Farmer;
import Farm.Menu;
import Livings.Animals.Animal;
import SolveStarvation.SolveStarvation;
import SolveStarvation.SolveStarvationFacade;
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

    /**
     * 动物中介者创建组员
     */
    @Override
    public void createColleagues(){
       // this._farm = Farm.getInstance();
        _animalMenu = _farm.getAnimalMenu();


    }

    /**
     * 给动物喂食
     */
    @Override
    public void colleagueChanged(){

        System.out.println("======== 使用 Mediator 模式 ========");
        System.out.println("Mediator : " + this.hashCode() +  " :colleagueChanged: check the hungry animals");
        //每检查一次需要清空上一次的饥饿动物列表
        _starvedAnimals.clear();
        if(_animalMenu == null){
            System.out.println("_animalmenu is null");
        }
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
                SolveStarvationFacade solveStarvationFacade = 
                	new SolveStarvationFacade(this._farm, free_farmer);
                solveStarvationFacade.solve(total_appetite_num);
            } else {
                System.out.println("No free farmer available to feed animals !");
            }
        }

    }


    /**
     * 初始化一个新的AnimalMediator
     */
    public AnimalMediator(){
        _starvedAnimals = new HashSet<>();
        _num_starved_animals = 5;

        //createColleagues();
        System.out.println("AnimalMediator has been initialized");
    }

    /**
     * 获取饥饿的动物
     */
    public Set<Animal> getStarvedAnimals(){
        return _starvedAnimals;
    }

    /**
     * 动物中介者管整个农场的动物
     */
    public void setFarm(Farm farm){
        this._farm = farm;
        createColleagues();
        if(_animalMenu == null){
            System.out.println("animalmenu is null in createcolleagues");
        }
    }



}
