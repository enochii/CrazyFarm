package Tools;

/*
 * 农具锄头
 */
public class Hoe extends FarmTool {

	public Hoe(Size s) {
		super(s);
	}

	@Override
	public TYPE getType() {
		return TYPE.Hoe;
	}
	
}
