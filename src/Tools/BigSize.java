package Tools;

/**
 * 桥接(Bridge)模式
 * 实现不同规模的不同农具
 * 大型规模类
 */
public class BigSize implements Size {

	@Override
	public int getSize() {
		return 5;
	}

	public boolean isBig() { return true; }

	public boolean isSmall() { return false; }
	
}
