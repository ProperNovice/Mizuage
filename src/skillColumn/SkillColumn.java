package skillColumn;

import utils.ArrayList;
import utils.ImageView;
import enums.Coordinates;
import enums.DiceSideEnum;
import enums.Dimensions;

public class SkillColumn {

	private int money;
	private ImageView imageView = null;
	private double x, y = Coordinates.SKILL_COLUMN.y();
	private ArrayList<SkillColumnToken> skillColumnTokens = new ArrayList<>();

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

	public void addTokenRelocate(SkillColumnToken skillColumnToken) {

		this.skillColumnTokens.add(skillColumnToken);

		skillColumnToken.relocate(this.x,
				this.y - this.skillColumnTokens.size()
						* Dimensions.SKILL_COLUMN_TOKEN.y());

	}

	public void addTokenAnimate(SkillColumnToken skillColumnToken) {

		this.skillColumnTokens.add(skillColumnToken);
		rearrangeSkillColumnTokensAnimate();

	}

	private void rearrangeSkillColumnTokensAnimate() {

		double y = this.y - Dimensions.SKILL_COLUMN_TOKEN.y();

		for (SkillColumnToken skillColumnToken : this.skillColumnTokens) {

			skillColumnToken.animate(this.x, y);

			y -= Dimensions.SKILL_COLUMN_TOKEN.y();

		}

	}

	public boolean containsSkillColumnToken(DiceSideEnum diceSideEnum) {

		for (SkillColumnToken skillColumnToken : this.skillColumnTokens)
			if (skillColumnToken.getDiceSideEnum().equals(diceSideEnum))
				return true;

		return false;

	}

	public SkillColumnToken removeSkillColumnTokenRearrange(
			DiceSideEnum diceSideEnum) {

		SkillColumnToken skillColumnToken = null;

		for (SkillColumnToken skillColumnTokenTemp : this.skillColumnTokens)
			if (skillColumnTokenTemp.getDiceSideEnum().equals(diceSideEnum))
				skillColumnToken = skillColumnTokenTemp;

		this.skillColumnTokens.remove(skillColumnToken);
		rearrangeSkillColumnTokensAnimate();

		return skillColumnToken;

	}

	public int getMoney() {
		return this.money;
	}

}
