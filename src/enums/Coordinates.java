package enums;

public enum Coordinates {

	TEXT_PANEL(50, 50),
	SKILL_COLUMN(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y() + Dimensions.GAP_BETWEEN_COLUMNS.y() + 3 * Dimensions.SKILL_COLUMN_TOKEN.y()),
	COIN(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y() + Dimensions.SKILL_COLUMN.y() + Dimensions.GAP_BETWEEN_COLUMNS.y() + 3 * Dimensions.SKILL_COLUMN_TOKEN.y() + Dimensions.GAP_BETWEEN_COLUMNS.y()),

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
