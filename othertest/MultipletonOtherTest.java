import Builder.FarmerMultipleton;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class MultipletonOtherTest {
    @Before
    public void setUp(){
        System.out.println("=========== 测试多态模式 =============");
    }

    @Test
    public void test(){
        List<FarmerMultipleton> farmerMultipletons = new ArrayList<>();
        farmerMultipletons.add(FarmerMultipleton.getRandomInstance());
        farmerMultipletons.add(FarmerMultipleton.getCultivateInstance());
        farmerMultipletons.add(FarmerMultipleton.getFeedInstance());
        farmerMultipletons.add(FarmerMultipleton.getSpareInstance());
        for (FarmerMultipleton f : farmerMultipletons){
            System.out.println(f.getName());
            System.out.println(f.farmer.getWorkType());
        }
    }
}
