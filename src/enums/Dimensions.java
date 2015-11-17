package enums;

public enum Dimensions {

	FRAME(1366, 768),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	GAP_BETWEEN_COLUMNS(3, 3),
	SKILL_COLUMN((Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x() - 16 * GAP_BETWEEN_COLUMNS.x()) / 17, (Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x() - 16 * GAP_BETWEEN_COLUMNS.x()) / 17),
	SKILL_COLUMN_TOKEN(SKILL_COLUMN.x(), SKILL_COLUMN.y()),
	DICE(100, 100),
	
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
