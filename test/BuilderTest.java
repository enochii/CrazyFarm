import Builder.*;
import Farm.Farmer;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void test() {
        System.out.println("测试Builder模式：");
        System.out.println("提示：根据调用关系，在Builder模式内创建农民时会用到私有类数据模式，为农民创建农具时还会用到抽象工厂模式、享元模式和桥接模式。");
        System.out.println("");

        Director director = new Director();

        // 使用Builder先后创建三种工种的农民
        FarmerBuilder freeFarmerBuilder = new FreeFarmerBuilder();
        director.setBuilder( freeFarmerBuilder );
        director.constructFarmer();
        Farmer farmer1 = director.getFarmer();
        System.out.println( director.toStringZh() );
        System.out.println("");

        FarmerBuilder cultivateFarmerBuilder = new CultivateFarmerBuilder();
        director.setBuilder( cultivateFarmerBuilder );
        director.constructFarmer();
        Farmer farmer2 = director.getFarmer();
        System.out.println( director.toStringZh() );
        System.out.println("");

        FarmerBuilder feedFarmerBuilder = new FeedFarmerBuilder();
        director.setBuilder( feedFarmerBuilder );
        director.constructFarmer();
        Farmer farmer3 = director.getFarmer();
        System.out.println( director.toStringZh() );
    }

}
