package mediator;

import Farm.Farm;
import Farm.Menu;
import Livings.Plants.Plant;


public class PlantMediator implements Mediator{

    private Menu<Plant> _plantMenu;
    private Farm _farm;

    /**
     * 植物中介者创建植物组员
     *
     * @param
     */
    public void createColleagues(){
        this._farm = Farm.getInstance();
        _plantMenu = _farm.getPlantMenu();


    }

    /**
     * 中介者去检查组员
     *
     * @param
     */
    public void colleagueChanged(){

    }

    /**
     * 中介者的构造函数
     *
     * @param
     */
    public PlantMediator(){
        //createColleagues();
        System.out.println("PlantMediator has been initialized");
    }

    /**
     * Sets farm.
     *
     * @param farm the farm
     */
    public void setFarm(Farm farm)
    {
        this._farm = farm;
    }







}
