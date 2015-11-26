package gameState;

import skillColumn.SkillColumnToken;
import utils.Lock;
import enums.DiceSideEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class MizuageTurn extends GameState {

	public MizuageTurn(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		if (super.controller.skillColumnController()
				.atLeastOneSkillTokenIsAtColumn5())
			handleAtLeastOneSkillTokenIsAtColumn5();
		else
			handleGameIsLost();

	}

	@Override
	public void handleSkillColumnTokenPressed(SkillColumnToken skillColumnToken) {

		super.controller.textController().concealText();

		DiceSideEnum diceSideEnum = skillColumnToken.getDiceSideEnum();

		super.controller.skillColumnController()
				.advanceSkillColumnTokenAnimate(diceSideEnum, 1);
		Lock.lock();

		super.controller.textController().showText(TextEnum.START_NEXT_TURN);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		super.controller.flow()
				.addGameStateFirst(GameStateEnum.START_NEXT_TURN);
		super.controller.flow().proceedToNextPhase();

	}

	private void handleAtLeastOneSkillTokenIsAtColumn5() {

		super.controller.coinController().addCoinsUpdatePanel(5);

		super.controller.textController().showText(TextEnum.MIZUAGE);
		super.controller.textController().showText(
				TextEnum.CHOOSE_SKILL_TO_INCREASE);

	}

	private void handleGameIsLost() {

		super.controller.flow().addGameStateFirst(GameStateEnum.LOSE);
		super.controller.flow().proceedToNextPhase();

	}

}
