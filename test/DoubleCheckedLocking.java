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
        private int _id;
        MyThread(int id){
            _id = id;
        }
        @Override
        public void run() {
            System.out.println("线程 " + _id + " 开始启动");
            //确保农场并且只初始化了一次
            assertTrue(_farm == null || Farm.getInstance() == _farm);
            _farm = Farm.getInstance();
            System.out.println("线程 "+ _id +" 获取了农场实例并结束了它短暂的一生");
        }
    }

    @Test
    public void test(){
        MyThread[] threads = new MyThread[10];
        for(int i = 0;i<10;i++){
            threads[i] = new MyThread(i);
        }

        for(MyThread thread : threads){
            thread.run();
        }
    }

}
