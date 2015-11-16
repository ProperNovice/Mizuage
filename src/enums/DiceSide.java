package enums;

public enum DiceSide {
	
	CONVERSATION("conversation"),
	DANCE("dance"),
	EXPENCE("expense"),
	MUSIC("music"),
	SERVICE("service");

	private String fileName = null;

	private DiceSide(String fileName) {
		this.fileName = fileName;
	}

	public String fileName() {
		return this.fileName;
	}

}
