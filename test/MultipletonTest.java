import Builder.FarmerMultipleton;
import Constant.Const;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipletonTest {
    @Before
    public void setUp(){
        System.out.println("Test for multipleton:");
    }

    @Test
    public void test(){
        for (int i = 0;i < Const.EACH_TYPE_NUM * Const.WorkType.values().length;i++){
            FarmerMultipleton farmerMultipleton = FarmerMultipleton.getRandomInstance();
            System.out.println(farmerMultipleton.getName());
            System.out.println(farmerMultipleton.farmer.getWorkType());
        }
    }
}
