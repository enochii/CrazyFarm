package Tools;

public class Shovel extends FarmTool {

	public Shovel(Size s) {
		super(s);
	}

	@Override
	public TYPE getType() {
		return TYPE.Shovel;
	}
	
}
