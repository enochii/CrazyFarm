package Livings;

/*
 * 生物类，动物和植物的基类
 */
public abstract class Living {
    //生物成熟后的价值
    private double _value;

    /*
     * @return 返回生物成熟后的价值
     */
    public double getValue(){
        return _value;
    }

    public void setValue(double value){
        this._value = value;
    }
}
