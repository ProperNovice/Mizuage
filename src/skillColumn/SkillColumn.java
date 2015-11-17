package skillColumn;

import utils.ImageView;
import enums.Dimensions;

public class SkillColumn {

	private int money;
	private ImageView imageView = null;
	private double x, y;

	public SkillColumn(int money, double x, double y) {

		this.money = money;
		this.x = x;
		this.y = y;
		createImageView();

	}

	private void createImageView() {

		String path = "numbers/" + this.money + ".png";

		this.imageView = new ImageView(path);
		this.imageView.setWidth(Dimensions.SKILL_COLUMN.x());
		this.imageView.relocate(this.x, this.y);

	}

	public void relocateToken(SkillColumnToken skillColumnToken,
			int totalTokensInColumn) {

		double y = getCoordinateY(totalTokensInColumn);

		skillColumnToken.relocate(this.x, y);

	}

	public void addTokenAnimate(SkillColumnToken skillColumnToken,
			int totalTokensInColumn) {

		double y = getCoordinateY(totalTokensInColumn);

		skillColumnToken.animate(this.x, y);

	}

	private double getCoordinateY(int totalTokensInColumn) {
		return this.y + Dimensions.SKILL_COLUMN.y()
				+ Dimensions.GAP_BETWEEN_COLUMNS.y()
				+ (totalTokensInColumn - 1) * Dimensions.SKILL_COLUMN_TOKEN.y();
	}

	public int getMoney() {
		return this.money;
	}

}
