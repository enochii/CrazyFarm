package Observer;
import Farm.Farm;
import Farm.Menu;
import Livings.Animals.Animal;
import Observer.Observable.BaseObservable;
import Observer.Observable.TimeCounter;
import mediator.AnimalMediator;
import mediator.Mediator;

import java.util.Iterator;

/**
 * When time update,it will do something for all the
 * @className: AnimalsObserver
 * @author: OY
 * @description:
 * @designPattern: Observer
 * @date: 18:38 2019/10/25
 */
public class AnimalsObserver implements BaseObserver {
    @Override
    public void update(BaseObservable o) {
        TimeCounter timeCounter=(TimeCounter)o;
        Farm farm=Farm.getInstance();
        Menu<Animal> animalMenu =farm.getAnimalMenu();
        for (Iterator<Animal> it=animalMenu.iterator();it.hasNext();){
            Animal animal=it.next();
            animal.setClock(timeCounter.getCurrentTime());
        }
        Mediator mediator=farm.getAnimalMediator();
        mediator.colleagueChanged();
        System.out.println("Animals updated");
    }
}
