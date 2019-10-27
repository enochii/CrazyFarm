package Tools;

import Constant.Const;

public class Shovel extends FarmTool {

	public Shovel(Size s) {

		super(s);
		this._material = Const.Material.IRON;
	}

	@Override
	public TYPE getType() {
		return TYPE.Shovel;
	}

	public void testAbstractFactory() {
		String s_size = this.size.isBig()? "big" : "small";
		System.out.println("Create " + s_size + " iron shovel successfully.");
	}
}
