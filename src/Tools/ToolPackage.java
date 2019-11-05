package Tools;


import java.util.*;

/**
 * ToolPackage can store tools and tool packages
 * It is a subclass of {@link Tool}
 * @className: ToolPackage
 * @author: OY
 * @description: ToolPackage can store tools and tool packages
 * @designPattern: Composite
 * @date: 12 :03 2019/10/27
 */
public class ToolPackage extends Tool{
    private int size;
    private List<Tool> toolList;

    /**
     * Instantiates a new Tool package.
     * @param size the max size of package
     */
    public ToolPackage(int size){
        //使用 组合Composite 模式
        System.out.println("使用组合模式Composite，初始化了一个工具背包,容量为："+size);
        if(size<=0){
            size=1;
        }
        this.size=size;
        toolList=new ArrayList<>(Arrays.asList(new Tool[size]));
    }

    /**
     * Add tool.
     * @param tool the tool to be added
     */
    public void addTool(Tool tool){

        if (isFull() || tool==this){
            //throw exception
            return;
        }
        toolList.add(tool);
    }

    /**
     * Iterator iterator.
     * @return the iterator of ToolPackage
     */
    public Iterator<Tool> iterator(){
        return toolList.iterator();
    }

    /**
     * Gets max size of tool package
     * @return the max size of tool package
     */
    public int getSize() {
        return size;
    }

    /**
     * Is full boolean.
     * @return true if the tool package is full
     */
    public boolean isFull(){
        return toolList.size()<getSize();
    }

}
