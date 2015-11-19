package gameState;

import javafx.scene.input.KeyCode;
import dice.Dice;
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
	protected void handleDiceNonExpensePressed(Dice dice) {

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

	}

}
