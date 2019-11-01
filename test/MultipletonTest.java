import Builder.FarmerMultipleton;
import Constant.Const;
import org.junit.Before;
import org.junit.Test;

public class MultipletonTest {
    @Before
    public void setUp(){
        System.out.println("Test for multipleton:");
    }

    @Test
    public void test(){
        for (int i = 0;i < Const.EACH_TYPE_NUM;i++){
            FarmerMultipleton farmerMultipleton = FarmerMultipleton.getRandomInstance();
            System.out.println(farmerMultipleton.getName());
            System.out.println(farmerMultipleton.farmer.getWorkType());
        }
    }
}
