import Farm.Farm;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @description :
 */
public class DoubleCheckedLockingOtherTest {
    private Farm _farm;
    MyThread[] threads;

    class MyThread implements Runnable{
        private int _id;
        MyThread(int id){
            _id = id;
        }
        @Override
        public void run() {
            System.out.println("线程 " + _id + " 尝试获取农场");
            //确保农场并且只初始化了一次
            Farm tmp = Farm.getInstance();
            assertTrue(_farm == null || tmp == _farm);
            _farm = tmp;
            System.out.println("线程 "+ _id +" 成功获取农场");
        }
    }

    @Before
    public void setup(){
        System.out.println("======== 测试 Double Checked Locking 模式 ========");
        threads = new MyThread[10];
        for(int i = 0;i<10;i++){
            threads[i] = new MyThread(i);
        }
    }

    @Test
    public void test(){
        for(MyThread thread : threads){
            thread.run();
        }
    }
}
