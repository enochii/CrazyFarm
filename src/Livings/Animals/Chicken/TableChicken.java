package Livings.Animals.Chicken;

import Constant.Const;

/*
 * 肉鸡类
 */
public class TableChicken extends Chicken{
    private static double _value = Const.VALUE_TABLE_CHICKEN;
    private static String _name = Const.NAME_TABLE_CHICKEN;

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

    public TableChicken(){
    }
    @Override
    public void gobble(){
        System.out.println("Table Children!");
    }
}
