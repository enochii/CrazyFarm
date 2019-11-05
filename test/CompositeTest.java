import Tools.*;
import org.junit.Test;

import java.util.Iterator;

/**
 * @program: crazyfarm->CompositeTest
 * @description: 组合模式的测试类
 * @author: oy
 * @create: 2019-11-04 16:42
 **/
public class CompositeTest {
    @Test
    public void test(){
        ToolPackage toolPackage=new ToolPackage(3);
        ToolPackage toolPackage1=new ToolPackage(2);
        System.out.println("size: "+toolPackage.getSize());
        toolPackage.addTool(toolPackage1);
        FarmTool hoe=new Hoe(new BigSize());
        FarmTool shovel=new Shovel(new SmallSize());
        toolPackage.addTool(hoe);
        toolPackage.addTool(shovel);
        System.out.println("isFull: "+toolPackage.isFull());
        for(Iterator<Tool>it=toolPackage.iterator();it.hasNext();){
            it.next();
            it.remove();
        }
        System.out.println("isFull: "+toolPackage.isFull());
    }
}
