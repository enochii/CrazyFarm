import Builder.*;
import Farm.Farmer;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: BuilderOtherTest
 * @description:
 * @designPattern:
 * @date: 1:38 下午 2019/11/12
 */
public class BuilderOtherTest {

    private Director director;

    private FarmerBuilder freeFarmerBuilder;
    private FarmerBuilder cultivateFarmerBuilder;
    private FarmerBuilder feedFarmerBuilder;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Builder 模式 ========");
        // 创建 Director
        director = new Director();
        // 准备好创建三种农民的 Builder
        freeFarmerBuilder = new FreeFarmerBuilder();
        cultivateFarmerBuilder = new CultivateFarmerBuilder();
        feedFarmerBuilder = new FeedFarmerBuilder();
        System.out.println("");
    }

    @Test
    public void testForBuilder() {
        // 以此创建三种不同类型的农民
        director.setBuilder( freeFarmerBuilder );
        director.constructFarmer();
        Farmer freeFarmer = director.getFarmer();
        System.out.println( director.toStringZh() );
        System.out.println("");

        director.setBuilder( cultivateFarmerBuilder );
        director.constructFarmer();
        Farmer cultivateFarmer = director.getFarmer();
        System.out.println( director.toStringZh() );
        System.out.println("");

        director.setBuilder( feedFarmerBuilder );
        director.constructFarmer();
        Farmer feedFarmer = director.getFarmer();
        System.out.println( director.toStringZh() );
    }
}
