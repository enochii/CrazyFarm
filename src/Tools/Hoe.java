package Tools;

import Constant.Const;

/**
 * 农具锄头
 */
public class Hoe extends FarmTool {

	public Hoe(Size s) {
		super(s);
		this._material = Const.Material.IRON;
	}

	@Override
	public TYPE getType() {
		return TYPE.Hoe;
	}

	@Override
	public void doWork() {

	}

	public void testAbstractFactory() {
		String s_size = this.size.isBig()? "big" : "small";
		System.out.println("Create " + s_size + " iron hoe successfully.");
	}
}
