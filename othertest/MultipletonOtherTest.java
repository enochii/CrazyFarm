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
        //获取一个任意类别的农民
        farmerMultipletons.add(FarmerMultipleton.getRandomInstance());
        //获取一个耕种类型的农民
        farmerMultipletons.add(FarmerMultipleton.getCultivateInstance());
        //获取一个喂养类型的农民
        farmerMultipletons.add(FarmerMultipleton.getFeedInstance());
        //获取一个空闲类别的农民
        farmerMultipletons.add(FarmerMultipleton.getSpareInstance());
        //输出各农民的名字和类别
        for (FarmerMultipleton f : farmerMultipletons){
            System.out.println(f.getName());
            System.out.println(f.farmer.getWorkType());
        }
    }
}
