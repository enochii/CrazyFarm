package Livings.Animals.Duck;

import Constant.Const;

public class SmallYellowDuck extends Duck{
    private static double _value = Const.VALUE_YELLOW_DUCK;
    private static String _name = Const.NAME_YELLOW_DUCK;

    /*
     * @return 返回生物成熟后的价值
     */
    public double getValue(){
        return _value;
    }

    /*
     * @return 生物的名字
     */
    @Override
    public String getName(){
        return _name;
    }
    @Override
    public void quack(){
        System.out.println("Yellow Duck!");
    }
}
