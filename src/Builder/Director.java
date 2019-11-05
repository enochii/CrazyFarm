package Builder;

import Farm.Farmer;

/**
 * 使用 Builder 模式创建农民的 Director
 *
 * @className: Director
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6 :13 下午 2019/10/27
 */
public class Director {
    private FarmerBuilder _builder;

    /**
     * Sets builder.
     * 设置Director具体使用的Builder类型
     *
     * @param builder the builder
     */
    public void setBuilder (FarmerBuilder builder) {
        this._builder = builder;
    }

    /**
     * Gets farmer.
     * 从Builder中取出农民
     *
     * @return the farmer
     */
    public Farmer getFarmer() {
        return _builder.getFarmer();
    }

    /**
     * Construct farmer.
     * 利用Builder模式建造一个农民。首先指定农民的工作类型，再根据工作类型为农民分配农具。
     */
    public void constructFarmer() {
        _builder.createNewFarmer();
        _builder.setWorkType();
        _builder.assignTools();
    }

    @Override
    public String toString() {
        String result = _builder.getFarmer().getWorkTypeString();
        return "Build a farmer engaged in " + result + " work.";
    }
}

/**
 * The type Test builder.
 */
class TestBuilder {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Director director = new Director();
        FarmerBuilder freeFarmerBuilder = new FreeFarmerBuilder();
        FarmerBuilder cultivateFarmerBuilder = new CultivateFarmerBuilder();
        FarmerBuilder feedFarmerBuilder = new FeedFarmerBuilder();

        // 使用Builder先后创建三种工种的农民
        director.setBuilder( freeFarmerBuilder );
        director.constructFarmer();
        Farmer farmer1 = director.getFarmer();
        System.out.println( director.toString() );

        director.setBuilder( cultivateFarmerBuilder );
        director.constructFarmer();
        Farmer farmer2 = director.getFarmer();
        System.out.println( director.toString() );

        director.setBuilder( feedFarmerBuilder );
        director.constructFarmer();
        Farmer farmer3 = director.getFarmer();
        System.out.println( director.toString() );

    }
}
