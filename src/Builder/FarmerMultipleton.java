package Builder;

import Constant.Const;
import Farm.Farmer;

import java.util.ArrayList;

public class FarmerMultipleton {
    private static final int TYPE_NUM = Const.WorkType.values().length;
    private String name;
    private boolean if_hired = false;
    public Farmer farmer;
    private static ArrayList<FarmerMultipleton> list = new ArrayList<>(Const.EACH_TYPE_NUM * TYPE_NUM);

    private FarmerMultipleton(String name,Director director){
        this.name = name;
        farmer = director.getFarmer();
    }

    // 添加农民实例
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
        int num = (int) (Math.random() * (Const.EACH_TYPE_NUM * TYPE_NUM));
        while (list.get(num).if_hired) {
            num = (int) (Math.random() * (Const.EACH_TYPE_NUM * TYPE_NUM));
        }
        list.get(num).if_hired = true;
        return list.get(num);
    }

    public String getName(){
        return name;
    }
}
