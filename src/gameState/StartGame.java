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
				DiceSideEnum.DANCE, DiceSideEnum.CONVERSATION,
				DiceSideEnum.MUSIC, DiceSideEnum.DANCE,
				DiceSideEnum.DANCE);
		
		super.controller.coinController().removeCoinsUpdatePanel(4);

		super.controller.flow().proceedToNextPhase();

	}

}
