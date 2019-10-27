package Tools;

public class Hoe extends FarmTool {

	public Hoe(Size s) {
		super(s);
	}

	@Override
	public TYPE getType() {
		return TYPE.Hoe;
	}
	
}
