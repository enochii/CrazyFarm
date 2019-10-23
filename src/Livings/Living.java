package Livings;

/*
 * 生物类，动物和植物的基类
 */
abstract public class Living {
    //生物成熟后的价值
    private double value;

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }
}
