package gameState;

import enums.DiceSideEnum;
import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.diceController().testSetDiceRolls(
				DiceSideEnum.DANCE, DiceSideEnum.DANCE,
				DiceSideEnum.DANCE, DiceSideEnum.CONVERSATION,
				DiceSideEnum.EXPENCE);

		super.controller.flow().proceedToNextPhase();

	}

}
