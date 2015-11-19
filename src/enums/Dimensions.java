package enums;

public enum Dimensions {

	FRAME(1366, 758),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(25, 25),
	GAP_BETWEEN_COLUMNS(1, 1),
	GAP_BETWEEN_DICE(2, 5),
	SKILL_COLUMN((Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x()) / 17, (Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x()) / 17),
	SKILL_COLUMN_TOKEN(SKILL_COLUMN.x(), SKILL_COLUMN.y()),
	DICE(SKILL_COLUMN.x(), SKILL_COLUMN.y()),
	DICE_SELECTED(2 * DICE.x() / 5, 2 * DICE.y() / 5),
	COIN(SKILL_COLUMN.x(), SKILL_COLUMN.y()),
	TURN_INDICATOR(SKILL_COLUMN.x(), SKILL_COLUMN.y()),
	
	;

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
