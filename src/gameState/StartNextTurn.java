package gameState;

import enums.GameStateEnum;

public class StartNextTurn extends GameState {

	public StartNextTurn(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.diceController().clearDiceUsedAnimateLock();

		super.controller.turnIndicatorController().startNextTurn();

		super.controller.diceController().rollDiceNonSelected();
		super.controller.diceController().diselectAllDice();

		super.controller.flow().proceedToNextPhase();

	}

}
