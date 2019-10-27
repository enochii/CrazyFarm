package Tools;

import Constant.Const;

public class Hoe extends FarmTool {

	public Hoe(Size s) {
		super(s);
		this._material = Const.Material.IRON;
	}

	@Override
	public TYPE getType() {
		return TYPE.Hoe;
	}

	public void testAbstractFactory() {
		String s_size = this.size.isBig()? "big" : "small";
		System.out.println("Create " + s_size + " iron hoe successfully.");
	}
}
