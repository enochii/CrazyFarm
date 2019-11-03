import Adapter.ChickenAdapter;
import Farm.Farm;
import Farm.Menu;
import Interpreter.Parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Livings.Animals.Chicken.TableChicken;
import Observer.Observable.TimeCounter;
import junit.framework.JUnit4TestAdapter;
import mediator.AnimalMediator;

import java.util.Observable;
import java.util.Observer;
import Observer.AnimalsObserver;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Farm farm = Farm.getInstance();
//        ChickenAdapter.main();
//        Menu.main();
//        Parser.main();
//
//        //测试Mediator
//        AnimalMediator animalMediator = new AnimalMediator();
//        TableChicken tableChicken = new TableChicken();
////        farm.addAnimal(tableChicken);
//        tableChicken.setMediator(animalMediator);
//        tableChicken.setColleagueUpdated();
//
//
//
//        //测试State
//        tableChicken.setClock(6);
//        System.out.println(tableChicken.isHungry());
//        tableChicken.getFed(6);
//        System.out.println(tableChicken.isHungry());
//        tableChicken.setClock(7);
//        System.out.println(tableChicken.isHungry());
//        System.out.println(tableChicken._experience);
//        tableChicken.setClock(16);
//        System.out.println(tableChicken.isHungry());

        TimeCounter timeCounter = new TimeCounter();
        AnimalsObserver animalsObserver = new AnimalsObserver();




    }
}
