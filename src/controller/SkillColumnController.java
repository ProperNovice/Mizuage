package controller;

import skillColumn.SkillColumn;
import skillColumn.SkillColumnToken;
import utils.ArrayList;
import utils.HashMap;
import enums.Coordinates;
import enums.DiceSideEnum;
import enums.Dimensions;

public class SkillColumnController {

	private ArrayList<SkillColumn> skillColumns = new ArrayList<>();
	private HashMap<SkillColumnToken, Integer> skillColumnTokens = new HashMap<>();

	public SkillColumnController() {

		createColumns();
		createTokens();

	}

	private void createColumns() {

		double x = Coordinates.SKILL_COLUMN.x();

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(0, x));

			x += Dimensions.SKILL_COLUMN.x()
					+ Dimensions.GAP_BETWEEN_COLUMNS.x();

		}

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(1, x));

			x += Dimensions.SKILL_COLUMN.x()
					+ Dimensions.GAP_BETWEEN_COLUMNS.x();

		}

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(2, x));

			x += Dimensions.SKILL_COLUMN.x()
					+ Dimensions.GAP_BETWEEN_COLUMNS.x();

		}

		for (int counter = 1; counter <= 2; counter++) {

			this.skillColumns.add(new SkillColumn(3, x));

			x += Dimensions.SKILL_COLUMN.x()
					+ Dimensions.GAP_BETWEEN_COLUMNS.x();

		}

	}

	private void createTokens() {

		SkillColumnToken skillColumnToken = null;

		skillColumnToken = new SkillColumnToken(DiceSideEnum.MUSIC);
		this.skillColumnTokens.addEntry(skillColumnToken, 0);
		this.skillColumns.get(0).relocateToken(skillColumnToken, 1);

		skillColumnToken = new SkillColumnToken(DiceSideEnum.DANCE);
		this.skillColumnTokens.addEntry(skillColumnToken, 0);
		this.skillColumns.get(0).relocateToken(skillColumnToken, 2);

		skillColumnToken = new SkillColumnToken(DiceSideEnum.CONVERSATION);
		this.skillColumnTokens.addEntry(skillColumnToken, 0);
		this.skillColumns.get(0).relocateToken(skillColumnToken, 3);

	}

}
