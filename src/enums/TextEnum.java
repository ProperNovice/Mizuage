package enums;

public enum TextEnum {
	
	START_NEXT_TURN("Start next turn", TextTypeEnum.OPTION),
	SELECT_DICE_TO_KEEP("Select dice to keep", TextTypeEnum.INDICATOR),
	ROLL_DICE("Roll dice", TextTypeEnum.OPTION),
	ONE_OF_EACH("One of each", TextTypeEnum.OPTION),
	THREE_OF_A_KIND("Three of a kind", TextTypeEnum.OPTION),
	FOUR_OF_A_KIND("Four or a kind", TextTypeEnum.OPTION),
	FIVE_OF_A_KIND("Five of a kind", TextTypeEnum.OPTION),
	SERVICE("Service", TextTypeEnum.OPTION),
	CONTINUE("Continue", TextTypeEnum.OPTION),
	CHOOSE_SKILL_TO_INCREASE("Choose skill\nto increase", TextTypeEnum.INDICATOR),
	USE_DICE("Use dice", TextTypeEnum.INDICATOR),
	RESOLVE_DICE_ROLL("Resolve dice roll", TextTypeEnum.OPTION),
	YOU_WIN("You win", TextTypeEnum.INDICATOR),
	YOU_LOSE("You lose", TextTypeEnum.INDICATOR),
	MIZUAGE("Mizuage", TextTypeEnum.INDICATOR),
	EARN_MONEY("Earn money", TextTypeEnum.OPTION),
	CHOOSE_SKILL("Choose skill", TextTypeEnum.INDICATOR),
	
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
