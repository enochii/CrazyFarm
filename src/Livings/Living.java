package Livings;

/*
 * 生物类，动物和植物的基类
 */
abstract public class Living {
    //生物成熟后的价值
    private double value;
    // 生物名字
    private String _name;

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }
    
    /*
     * @return 生物的名字
     */
    public String getName() {
    	return _name;
    }
    
    /*
     * @param 生物的名字
     */
    public void setName(String n) {
    	_name = n;
    }
}
