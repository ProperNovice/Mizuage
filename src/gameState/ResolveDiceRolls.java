package gameState;

import javafx.scene.input.KeyCode;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveDiceRolls extends GameState {

	public ResolveDiceRolls(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.diceController().diselectAllDice();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

	}

}
