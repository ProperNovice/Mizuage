package gameState;

import skillColumn.SkillColumn;
import enums.Dimensions;
import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		double x = 50;
		double y = 50;

		for (int counter = 1; counter <= 5; counter++)
			new SkillColumn(0).relocate(x += 1.5 * Dimensions.SKILL_COLUMN.x(),
					y);

		for (int counter = 1; counter <= 5; counter++)
			new SkillColumn(1).relocate(x += 1.5 * Dimensions.SKILL_COLUMN.x(),
					y);

		for (int counter = 1; counter <= 5; counter++)
			new SkillColumn(2).relocate(x += 1.5 * Dimensions.SKILL_COLUMN.x(),
					y);

		for (int counter = 1; counter <= 2; counter++)
			new SkillColumn(3).relocate(x += 1.5 * Dimensions.SKILL_COLUMN.x(),
					y);

	}

}
