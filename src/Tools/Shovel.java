package Tools;

import Constant.Const;

/**
 * 桥接(Bridge)模式
 * 实现不同规模的不同农具
 * 农具铲子
 */
public class Shovel extends FarmTool {

	public Shovel(Size s) {

		super(s);
		this._material = Const.Material.IRON;
	}

	@Override
	public TYPE getType() {
		return TYPE.Shovel;
	}

	@Override
	public void doWork() {

	}

	public void testAbstractFactory() {
		String s_size = this.size.isBig()? "big" : "small";
		System.out.println("Create " + s_size + " iron shovel successfully.");
	}
}
