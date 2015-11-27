package controller;

import skillColumn.SkillColumn;
import skillColumn.SkillColumnToken;
import utils.ArrayList;
import utils.Logger;
import enums.Coordinates;
import enums.DiceSideEnum;
import enums.Dimensions;

public class SkillColumnController {

	private ArrayList<SkillColumn> skillColumns = new ArrayList<>();

	public SkillColumnController() {

		createColumns();
		createTokens();

	}

	private void createColumns() {

		double x = Coordinates.SKILL_COLUMN.x();

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(0, x));

			x += Dimensions.SKILL_COLUMN.x();

		}

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(1, x));

			x += Dimensions.SKILL_COLUMN.x();

		}

		for (int counter = 1; counter <= 5; counter++) {

			this.skillColumns.add(new SkillColumn(2, x));

			x += Dimensions.SKILL_COLUMN.x();

		}

		for (int counter = 1; counter <= 2; counter++) {

			this.skillColumns.add(new SkillColumn(3, x));

			x += Dimensions.SKILL_COLUMN.x();

		}

	}

	private void createTokens() {

		SkillColumnToken skillColumnToken = null;

		skillColumnToken = new SkillColumnToken(DiceSideEnum.MUSIC);
		this.skillColumns.get(0).addTokenRelocate(skillColumnToken);

		skillColumnToken = new SkillColumnToken(DiceSideEnum.DANCE);
		this.skillColumns.get(0).addTokenRelocate(skillColumnToken);

		skillColumnToken = new SkillColumnToken(DiceSideEnum.CONVERSATION);
		this.skillColumns.get(0).addTokenRelocate(skillColumnToken);

	}

	public boolean advanceSkillColumnTokenAnimate(DiceSideEnum diceSideEnum,
			int times) {

		int indexSkillColumnFrom = -1;

		for (SkillColumn skillColumn : this.skillColumns) {

			if (!skillColumn.containsSkillColumnToken(diceSideEnum))
				continue;

			indexSkillColumnFrom = this.skillColumns.indexOf(skillColumn);
			break;

		}

		int indexSkillColumnTo = indexSkillColumnFrom + times;
		indexSkillColumnTo = (int) Math.min(this.skillColumns.size() - 1,
				indexSkillColumnTo);

		if (indexSkillColumnFrom == indexSkillColumnTo)
			return false;

		SkillColumnToken skillColumnToken = this.skillColumns.get(
				indexSkillColumnFrom).removeSkillColumnTokenRearrange(
				diceSideEnum);

		this.skillColumns.get(indexSkillColumnTo).addTokenAnimate(
				skillColumnToken);

		return true;

	}

	public boolean atLeastOneSkillTokenIsAtColumn5() {

		ArrayList<DiceSideEnum> diceSideEnumList = new ArrayList<>();

		diceSideEnumList.add(DiceSideEnum.CONVERSATION);
		diceSideEnumList.add(DiceSideEnum.DANCE);
		diceSideEnumList.add(DiceSideEnum.MUSIC);

		for (int counter = 5; counter <= this.skillColumns.size() - 1; counter++)
			for (DiceSideEnum diceSideEnum : diceSideEnumList)
				if (this.skillColumns.get(counter).containsSkillColumnToken(
						diceSideEnum))
					return true;

		return false;

	}

	public int getCoinsFromSkillColumnToken(DiceSideEnum diceSideEnum) {

		for (SkillColumn skillColumn : this.skillColumns)
			if (skillColumn.containsSkillColumnToken(diceSideEnum))
				return skillColumn.getMoney();

		Logger.logNewLine("getCoinsFromSkillColumnToken - didn't find skill token - "
				+ diceSideEnum);

		return -1;

	}

}
