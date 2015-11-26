package gameState;

import enums.DiceSideEnum;
import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.diceController().testSetDiceRolls(DiceSideEnum.DANCE,
				DiceSideEnum.DANCE, DiceSideEnum.DANCE, DiceSideEnum.DANCE,
				DiceSideEnum.DANCE);

		super.controller.coinController().removeCoinsUpdatePanel(4);

		for (int counter = 1; counter <= 9; counter++)
			super.controller.turnIndicatorController().startNextTurn();

		super.controller.flow().proceedToNextPhase();

	}

}
