package MVC;

import Farm.Farmer;

/**
 * @program: crazyfarm->FarmerController
 * @description: 农民的控制器类
 * @author: jh
 * @create: 2019-10-30 23:29
 **/

public class FarmerController {
    private Farmer _model;
    private FarmerView _view;

    /**
     * Instantiates a new Farmer controller.
     *
     * @param model the model
     * @param view  the view
     */
    public FarmerController(Farmer model, FarmerView view){
        this._model = model;
        this._view = view;
    }

    /**
     * Set farmer name.
     *
     * @param name the name
     */
    public void setFarmerName(String name){
        _model.setName(name);
    }

    /**
     * Set farmer age.
     *
     * @param age the age
     */
    public void setFarmerAge(int age){
        _model.setAge(age);
    }

    /**
     * Get farmer name string.
     *
     * @return the string
     */
    public String getFarmerName(){
        return _model.getName();
    }


    /**
     * Update view.
     */
    public void updateView(){
        _view.printFarmerDetails(_model.getName(), _model.getAge());

    }

    /**
     * Get farmer age int.
     *
     * @return the int
     */
    public int getFarmerAge(){
        return _model.getAge();
    }


}
