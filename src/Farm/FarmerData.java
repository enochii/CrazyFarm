package Farm;

import Constant.Const;
import Tools.Tool;
import Tools.ToolPackage;

import java.io.Serializable;

/**
 * 私有类数据(Private Class Data)模式
 * 将农民的数据保存在一个农民数据类中
 */
public class FarmerData implements Serializable {
    // 指定工作类型和背包，用于实现 Builder 模式
    private Const.WorkType _type;
    private ToolPackage _bag;
    //农民的工作状态
    private boolean _isWorking;
    //农民的年龄
    private int _age;
    //农民的名字
    private String _name;

    /**
     * 无参构造函数
     */
    public FarmerData() {
        System.out.println("======== 使用私有类数据 Private Class Data 模式 ========");
        this._type = Const.WorkType.SPARE;
        this._bag = new ToolPackage(2);
        this._isWorking = false;
        System.out.println("成功创建农民数据");
    }

    /**
     * 通过年龄和名字来初始化农民
     */
    public FarmerData(int age, String name){
        this();
        this._age = age;
        this._name = name;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Const.WorkType type) {this._type = type;}

    /**
     * Assign tool boolean.
     *
     * @param tool the tool
     * @return boolean isSuccessful
     */
    public boolean assignTool(Tool tool) {
        if (this._bag.isFull()) {
            return false;
        }
        else {
            this._bag.addTool(tool);
            return true;
        }
    }

    /**
     * get work type of the farmer
     * @return farmer work type
     */
    public Const.WorkType getWorkType() {
        return this._type;
    }

    /**
     * For TEST. Gets work type string.
     *
     * @return the work type string
     */
    public String getWorkTypeString() {
        if ( _type== Const.WorkType.SPARE ) return "Spare";
        else if ( _type== Const.WorkType.CULTIVATE ) return "Cultivate";
        else if ( _type== Const.WorkType.FEED ) return "Feed";
        else return "Invalid";
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge()
    {
        return _age;
    }

    /**
     * Set age.
     *
     * @param age the age
     */
    public void setAge(int age){
        this._age = age;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return _name;
    }

    /**
     * Set name.
     *
     * @param name the name
     */
    public void setName(String name){
        this._name = name;
    }

    /**
     * Get work status boolean.
     *
     * @return the boolean
     */
    public boolean getWorkStatus(){
        return _isWorking;
    }

    /**
     * Set work status boolean.
     *
     * @param status the status
     */
    public void setWorkStatus(boolean status){
        this._isWorking = status;
    }
}
