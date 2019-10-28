package Builder;

import Farm.Farmer;

/**
 * @className: Director
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6:13 下午 2019/10/27
 */
public class Director {
    private FarmerBuilder _builder;

    public void setBuilder (FarmerBuilder builder) {
        this._builder = builder;
    }

    public Farmer getFarmer() {
        return _builder.getFarmer();
    }

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

class TestBuilder {
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
