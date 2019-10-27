package Tools;

/**
 * 大型
 */
public class BigSize implements Size {

	@Override
	public int getSize() {
		return 5;
	}

	public boolean isBig() { return true; }

	public boolean isSmall() { return false; }
	
}
