import Tools.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * @className: CompositeOtherTest
 * @description:
 * @designPattern:
 * @date: 2019/11/12 22:10
 */
public class CompositeOtherTest {
    ToolPackage toolPackage,toolPackage1;
    @Before
    public void setUp() {
        System.out.println("======== 测试 Composite 模式 ========");
        System.out.println("测试不同大小背包创建：");
        toolPackage=new ToolPackage(3);
        toolPackage1=new ToolPackage(2);
    }

    @Test
    public void testForVisitor() {
        System.out.println("size: "+toolPackage.getSize());
        System.out.println("测试将工具加入背包：");
        toolPackage.addTool(toolPackage1);
        FarmTool shovel=new Shovel(new BigSize());
        FarmTool smallshovel=new Shovel(new SmallSize());
        FarmTool hoe=new Hoe(new SmallSize());
        toolPackage.addTool(hoe);
        toolPackage.addTool(shovel);
        System.out.println("测试背包是否已经满了：");
        System.out.println("isFull: "+toolPackage.isFull());
        for(Iterator<Tool> it = toolPackage.iterator(); it.hasNext();){
            it.next();
            it.remove();
        }
        System.out.println("测试背包是否已经满了：");
        System.out.println("isFull: "+toolPackage.isFull());
    }
}
