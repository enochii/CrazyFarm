import Builder.*;
import Farm.Farmer;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void test() {
        System.out.println("测试Builder模式：");

        Director director = new Director();
        FarmerBuilder freeFarmerBuilder = new FreeFarmerBuilder();
        FarmerBuilder cultivateFarmerBuilder = new CultivateFarmerBuilder();
        FarmerBuilder feedFarmerBuilder = new FeedFarmerBuilder();

        // 使用Builder先后创建三种工种的农民
        director.setBuilder( freeFarmerBuilder );
        director.constructFarmer();
        Farmer farmer1 = director.getFarmer();
        System.out.println( director.toString() );

        director.setBuilder( cultivateFarmerBuilder );
        director.constructFarmer();
        Farmer farmer2 = director.getFarmer();
        System.out.println( director.toString() );

        director.setBuilder( feedFarmerBuilder );
        director.constructFarmer();
        Farmer farmer3 = director.getFarmer();
        System.out.println( director.toString() );
    }

}
