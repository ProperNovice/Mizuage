package gameState;

import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		// super.controller.diceController().testSetDiceRolls(DiceSideEnum.CONVERSATION,
		// DiceSideEnum.EXPENCE, DiceSideEnum.MUSIC, DiceSideEnum.SERVICE,
		// DiceSideEnum.DANCE);
		//
		// super.controller.coinController().removeCoinsUpdatePanel(19);
		//
		// for (int counter = 1; counter <= 15; counter++)
		// super.controller.turnIndicatorController().startNextTurn();
		//
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.MUSIC, 8);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.CONVERSATION, 12);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.DANCE, 2);
		// Lock.lock();

		super.controller.flow().proceedToNextPhase();

	}

}
