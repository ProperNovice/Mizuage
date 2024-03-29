package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.START_GAME);

		// super.controller.diceController().testSetDiceRolls(
		// DiceSideEnum.CONVERSATION, DiceSideEnum.CONVERSATION,
		// DiceSideEnum.MUSIC, DiceSideEnum.SERVICE, DiceSideEnum.DANCE);

		// super.controller.coinController().removeCoinsUpdatePanel(19);
		// super.controller.coinController().addCoinsUpdatePanel(1);

		// for (int counter = 1; counter <= 19; counter++)
		// super.controller.turnIndicatorController().startNextTurn();

		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.MUSIC, 8);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.CONVERSATION, 12);
		// super.controller.skillColumnController()
		// .advanceSkillColumnTokenAnimate(DiceSideEnum.DANCE, 2);
		// Lock.lock();

		// super.controller.flow().proceedToNextPhase();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();
		super.controller.flow().proceedToNextPhase();

	}

}
