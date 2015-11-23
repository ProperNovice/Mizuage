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
				DiceSideEnum.CONVERSATION, DiceSideEnum.CONVERSATION,
				DiceSideEnum.CONVERSATION, DiceSideEnum.MUSIC,
				DiceSideEnum.DANCE);

		super.controller.flow().proceedToNextPhase();

	}

}
