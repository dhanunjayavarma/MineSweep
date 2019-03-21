package board;

public class Square {
	int value=-1;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public boolean isMine() {
		if(value==9) {
			return true;
		}
		return false;
	}
}
