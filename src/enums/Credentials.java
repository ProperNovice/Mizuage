package enums;

public enum Credentials {

	TEXT_HEIGHT(40),
	COINS_PER_ROW(4),
	TURN_INDICATORS_PER_ROW(5),

	;

	private int credential;

	private Credentials(int credential) {
		this.credential = credential;
	}

	public int credential() {
		return this.credential;
	}

}
