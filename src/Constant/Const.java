package Constant;

import java.util.ArrayList;
import java.util.Arrays;

public class Const {
    //生物的价值
    public final static double VALUE_TABLE_CHICKEN = 20.0;
    public final static double VALUE_YELLOW_DUCK = 30.0;

    public final static double VALUE_CROP = 10.0;

    //生物的名字
    public final static String NAME_TABLE_CHICKEN = "TableChicken";
    public final static String NAME_YELLOW_DUCK = "SmallYellowDuck";
    public final static String NAME_CROP = "CROP";

    //生物的成熟状态
    public final static String MATURE = "Mature";
    public final static String NOT_MATURE = "Not Mature";

    // 土地的类型
    public final static String TYPE_FIELD = "Field";
    public final static String TYPE_LARGE_FIELD = "LargeField";

    // 工具的类型
    public final static String TYPE_HOE = "Hoe";
    public final static String TYPE_SHOVEL = "Shovel";

    // Factory的类型
    public final static String TYPE_TOOL = "Tool";
    public final static String TYPE_LAND = "Land";

    // Farmer的工种：空闲的、耕种、喂食
    public enum WorkType {
        SPARE, CULTIVATE, FEED
    }

    // 工具的材质类型
    public enum Material {
        IRON, STAINLESS_STEEL
    }

    // 业务代表模式提供的业务服务
    public final static String SERVICE_CNT_FARMER = "CountFarmer";
    public final static String SERVICE_DISPLAY_PLANT = "DisplayPlant";

    // 农民的名字
    public final static ArrayList<String> FARMER_NAMES = new ArrayList<>(Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"));

    // 每种农民的数量
    public static final int EACH_TYPE_NUM = 4;
}
