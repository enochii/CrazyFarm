package Tools;

public abstract class FarmTool extends Tool{
	
	private Size size;
	
	public FarmTool(Size s) {
		this.size = s;
	}
	
	static enum TYPE {
		Hoe, Shovel
	}
	
	public abstract TYPE getType();
	
}
