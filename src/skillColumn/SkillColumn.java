package skillColumn;

import utils.Text;
import enums.Dimensions;

public class SkillColumn {

	private int money;
	private Text text = null;
	private double x, y;

	public SkillColumn(int money) {

		this.money = money;
		createText();

	}

	private void createText() {

		this.text = new Text(this.money);
		this.text.setWidth(Dimensions.SKILL_COLUMN.x());

	}

	public void relocate(double x, double y) {

		this.x = x;
		this.y = y;
		this.text.relocate(this.x, this.y);

	}

	public int getMoney() {
		return this.money;
	}

}
