package Livings;

/*
 * 生物类，动物和植物的基类
 */
//TODO : 把生物类写成接口
public abstract class Living {
    //生物成熟后的价值
//    private double _value;
//    // 生物名字
//    private String _name;

    /*
     * @return 返回生物成熟后的价值
     */
    public abstract double getValue();
    
    /*
     * @return 生物的名字
     */
    public abstract String getName();

}
