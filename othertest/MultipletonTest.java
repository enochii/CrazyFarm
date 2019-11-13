import Builder.FarmerMultipleton;
import Constant.Const;
import org.junit.Before;
import org.junit.Test;

public class MultipletonTest {
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
