package gameState;

import javafx.scene.input.KeyCode;
import enums.GameStateEnum;
import enums.TextEnum;

public class StartNextTurn extends GameState {

	public StartNextTurn(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.START_NEXT_TURN);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.Q))
			proceedStartNextTurn();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		proceedStartNextTurn();

	}

	private void proceedStartNextTurn() {

		super.controller.textController().concealText();

		super.controller.turnIndicatorController().startNextTurn();
		super.controller.diceController().rollDiceNonSelected();
		super.controller.diceController().clearDiceUsedAnimateLock();
		super.controller.flow().proceedToNextPhase();

	}

}
