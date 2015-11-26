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

//		super.controller.coinController().removeCoinsUpdatePanel(19);

//		for (int counter = 1; counter <= 10; counter++)
//			super.controller.turnIndicatorController().startNextTurn();

		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.MUSIC, 4);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.CONVERSATION, 5);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.DANCE, 2);
		// Lock.lock();

		super.controller.flow().proceedToNextPhase();

	}

}
