package skillColumn;

import utils.ImageView;
import enums.Coordinates;
import enums.Dimensions;

public class SkillColumn {

	private int money;
	private ImageView imageView = null;
	private double x, y = Coordinates.SKILL_COLUMN.y();

	public SkillColumn(int money, double x) {

		this.money = money;
		this.x = x;
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
		return this.y - Dimensions.GAP_BETWEEN_COLUMNS.y()
				- totalTokensInColumn * Dimensions.SKILL_COLUMN_TOKEN.y();
	}

	public int getMoney() {
		return this.money;
	}

}
