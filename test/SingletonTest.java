import Farm.Owner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @program: crazyfarm->SingletonTest
 * @description: 这是单例模式的测试类
 * @author: jh
 * @create: 2019-11-05 16:57
 **/

public class SingletonTest {

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
