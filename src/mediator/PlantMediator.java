package mediator;

import Farm.Farm;
import Farm.Menu;
import Livings.Plants.Plant;


public class PlantMediator implements Mediator{

    private Menu<Plant> _plantMenu;
    private Farm _farm;

    public void createColleagues(){
        this._farm = Farm.getInstance();


    }

    public void colleagueChanged(){

    }

    public PlantMediator(){
        createColleagues();
        System.out.println("PlantMediator has been initialized");
    }





}
