package Observer;

import Farm.*;
import Livings.Animals.Animal;
import Livings.Plants.Plant;
import Observer.Observable.BaseObservable;

import java.util.Iterator;

/**
 * @className: PlantsObserver
 * @author: OY
 * @description:
 * @designPattern: Observer
 * @date: 18:41 2019/10/25
 */
public class PlantsObserver implements BaseObserver {
    @Override
    public void update(BaseObservable o) {Farm farm=Farm.getInstance();
        Menu<Plant> plantMenu =farm.getPlantMenu();
        for (Iterator<Plant> it = plantMenu.iterator(); it.hasNext();){
            Plant plant=it.next();
            //do something
        }
    }
}
