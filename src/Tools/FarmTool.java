package Tools;

/**
 * 桥接(Bridge)模式
 * 农具类
 */
public abstract class FarmTool extends Tool {
	
	/**
	 * 农具的Size
	 */
	private Size size;
	
	public FarmTool(Size s) {
		this.size = s;
	}
	
	/**
	 * 农具的类型
	 */
	static enum TYPE {
		Hoe, Shovel
	}
	
	/**
	 * @return 农具的类型
	 */
	public abstract TYPE getType();
	
}
