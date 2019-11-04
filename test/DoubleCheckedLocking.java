import Farm.Farm;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author : SCH001
 * @description : 双重检查锁的测试，检查多线程情况下多重检查锁能否正常工作
 */


public class DoubleCheckedLocking {
    private Farm _farm;
    class MyThread implements Runnable{

        @Override
        public void run() {
            //确保农场并且只初始化了一次
            assertTrue(_farm == null || Farm.getInstance() == _farm);
            _farm = Farm.getInstance();
        }
    }

    @Test
    public void test(){
        MyThread[] threads = new MyThread[10];
        for(int i = 0;i<10;i++){
            threads[i] = new MyThread();
            threads[i].run();
        }
    }

}
