import Farm.Owner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @program: crazyfarm->SingletonOtherTest
 * @description:
 * @create: 2019-11-13 23:56
 **/

public class SingletonOtherTest {
    @Before
    public void setUp(){
        System.out.println("======== Test for singleton ========");
    }

    @Test
    public void Test(){
        Owner owner1 = Owner.getInstance();
        Owner owner2 = Owner.getInstance();
        assertEquals(owner1, owner2);

    }
}
