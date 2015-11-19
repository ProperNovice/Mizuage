package enums;

public enum Coordinates {

	SKILL_COLUMN(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y() + 3 * Dimensions.SKILL_COLUMN_TOKEN.y()),
	TURN_INDICATOR(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y() + Dimensions.SKILL_COLUMN.y() + Dimensions.GAP_BETWEEN_COLUMNS.y() + 3 * Dimensions.SKILL_COLUMN_TOKEN.y() + Dimensions.GAP_BETWEEN_COLUMNS.y()),
	COIN(TURN_INDICATOR.x() + 3 * Dimensions.TURN_INDICATOR.x(), TURN_INDICATOR.y()),
	DICE(COIN.x() + Dimensions.COIN.x() * Credentials.COINS_PER_ROW.credential(), TURN_INDICATOR.y() + Dimensions.COIN.y()),
	TEXT_PANEL(DICE.x() + 5 * (Dimensions.DICE.x() + Dimensions.GAP_BETWEEN_DICE.x()) + 5, DICE.y()),
	
	;

	private double x = -1, y = -1;

	private Coordinates(double x, double y) {
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
