package enums;

public enum DiceSideEnum {
	
	CONVERSATION("conversation"),
	DANCE("dance"),
	EXPENCE("expense"),
	MUSIC("music"),
	SERVICE("service");

	private String fileName = null;

	private DiceSideEnum(String fileName) {
		this.fileName = fileName;
	}

	public String fileName() {
		return this.fileName;
	}

}
