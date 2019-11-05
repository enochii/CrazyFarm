package Builder;

import Constant.Const;
import Farm.Farmer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 多例(multipleton)模式
 */
public class FarmerMultipleton implements Serializable {
    private static final int TYPE_NUM = Const.WorkType.values().length;
    private String name;
    private boolean if_hired = false;
    public Farmer farmer;
    private static ArrayList<FarmerMultipleton> list = new ArrayList<>(Const.EACH_TYPE_NUM * TYPE_NUM);
    private int _age;

    /**
     * 构造函数
     * @param  name 农民的名字
     * @param director 导演类
     */
    private FarmerMultipleton(String name,Director director){
        this.name = name;
        farmer = director.getFarmer();
    }

    //添加农民实例
    static {
        ArrayList<FarmerBuilder> farmerBuilders = new ArrayList<>();
        farmerBuilders.add(new FreeFarmerBuilder());
        farmerBuilders.add(new FeedFarmerBuilder());
        farmerBuilders.add(new CultivateFarmerBuilder());
        Director director = new Director();
        for (int i = 0;i<TYPE_NUM;i++){
            director.setBuilder(farmerBuilders.get(i));
            director.constructFarmer();
            for (int j = 0;j<Const.EACH_TYPE_NUM;j++){
                list.add(new FarmerMultipleton(Const.FARMER_NAMES.get(i * Const.EACH_TYPE_NUM + j), director));
            }
        }
    }

    /**
     * 随机获得实例对象
      */
    public static FarmerMultipleton getRandomInstance(){
        System.out.println("========== 使用多例 Multipleton 模式 ===========");
        for (int i = 0;i<Const.EACH_TYPE_NUM * TYPE_NUM;i++){
            if (!list.get(i).if_hired){
                break;
            }
            if (i == Const.EACH_TYPE_NUM * TYPE_NUM -1){
                System.out.println("农民数量已达上限");
                return null;
            }
        }
        int num = (int) (Math.random() * (Const.EACH_TYPE_NUM * TYPE_NUM));
        while (list.get(num).if_hired) {
            num = (int) (Math.random() * (Const.EACH_TYPE_NUM * TYPE_NUM));
        }
        list.get(num).if_hired = true;
        System.out.println("获取到" + list.get(num).farmer.getWorkType() + "类农民:"+list.get(num).getName());
        return list.get(num);
    }

    /**
     *
     * @return 取得负责喂食的农民实例
     */
    public static FarmerMultipleton getFeedInstance(){
        System.out.println("========== 使用多例 Multipleton 模式 ===========");
        FarmerMultipleton result = null;
        for(int i = 0;i < Const.EACH_TYPE_NUM * TYPE_NUM;i++){
            if ((!list.get(i).if_hired) && list.get(i).farmer.getWorkType().equals(Const.WorkType.FEED)) {
                result = list.get(i);
                result.if_hired = true;
                break;
            }
        }
        if (result == null){
            System.out.println("喂食种类的农民数量已达上限");
        }
        else{
            System.out.println("获取到喂食类农民:"+result.getName());
        }
        return result;
    }

    /**
     *
     * @return 取得负责采办的农民实例
     */
    public static FarmerMultipleton getSpareInstance(){
        System.out.println("========== 使用多例 Multipleton 模式 ===========");
        FarmerMultipleton result = null;
        for(int i = 0;i < Const.EACH_TYPE_NUM * TYPE_NUM;i++){
            if ((!list.get(i).if_hired) && list.get(i).farmer.getWorkType().equals(Const.WorkType.SPARE)) {
                result = list.get(i);
                result.if_hired = true;
                break;
            }
        }
        if (result == null){
            System.out.println("采办种类的农民数量已达上限");
        }
        else{
            System.out.println("获取到采办类农民:"+result.getName());
        }

        return result;
    }

    /**
     *
     * @return 取得负责耕种的农民实例
     */
    public static FarmerMultipleton getCultivateInstance(){
        System.out.println("========== 使用多例 Multipleton 模式 ===========");
        FarmerMultipleton result = null;
        for(int i = 0;i < Const.EACH_TYPE_NUM * TYPE_NUM;i++){
            if ((!list.get(i).if_hired) && list.get(i).farmer.getWorkType().equals(Const.WorkType.CULTIVATE)) {
                result = list.get(i);
                result.if_hired = true;
                break;
            }
        }
        if (result == null){
            System.out.println("耕种种类的农民数量已达上限");
        }
        else{
            System.out.println("获取到耕种类农民:"+result.getName());
        }

        return result;
    }

    /**
     *
     * @return 农民的名字
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @param name 农民的名字
     */
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){return _age;}

    public void setAge(int age){
        this._age = age;
    }
}
