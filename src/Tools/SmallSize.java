package Tools;

public class SmallSize implements Size {

	@Override
	public int getSize() {
		return 3;
	}

	public boolean isBig() { return false; }

	public boolean isSmall() { return true; }
}
