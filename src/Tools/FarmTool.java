package Tools;

import Constant.Const;

public abstract class FarmTool extends Tool{
	
	protected Size size;
	protected Const.Material _material;
	
	public FarmTool(Size s) {
		this.size = s;
	}
	
	public static enum TYPE {
		Hoe, Shovel
	}
	
	public abstract TYPE getType();

	public abstract void testAbstractFactory();
	
}
