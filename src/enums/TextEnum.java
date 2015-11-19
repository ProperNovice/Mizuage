package enums;

public enum TextEnum {
	
	START_NEXT_TURN("Start next turn", TextTypeEnum.OPTION),
	SELECT_DICE_TO_KEEP("Select dice to keep", TextTypeEnum.INDICATOR),
	ROLL_DICE("Roll dice", TextTypeEnum.OPTION),

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
