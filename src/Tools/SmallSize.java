package Tools;

/**
 * 桥接(Bridge)模式
 * 实现不同规模的不同农具
 * 小型规模类
 */
public class SmallSize implements Size {

	@Override
	public int getSize() {
		return 3;
	}

	public boolean isBig() { return false; }

	public boolean isSmall() { return true; }
}
