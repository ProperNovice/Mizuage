package gameState;

import skillColumn.SkillColumnToken;
import instances.Instances;
import javafx.scene.input.KeyCode;
import controller.Controller;
import dice.Dice;
import enums.DiceSideEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();
	private GameStateEnum gameStateEnum = null;

	public GameState(GameStateEnum gameStateEnum) {
		this.gameStateEnum = gameStateEnum;
	}

	public abstract void handleGameStateChange();

	public void handleDicePressed(Dice dice) {

		DiceSideEnum diceSideEnum = dice.getDiceSideEnumShowing();

		if (diceSideEnum.equals(DiceSideEnum.EXPENCE))
			return;

		handleDiceActivePressed(dice);

	}

	public void handleSkillColumnTokenPressed(SkillColumnToken skillColumnToken) {

	}

	protected void handleDiceActivePressed(Dice dice) {

	}

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public final GameStateEnum getGameStateEnum() {
		return this.gameStateEnum;
	}

}
