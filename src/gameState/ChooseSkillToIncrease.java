package gameState;

import skillColumn.SkillColumnToken;
import utils.Lock;
import enums.DiceSideEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseSkillToIncrease extends GameState {

	public ChooseSkillToIncrease(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_SKILL_TO_INCREASE);

	}

	@Override
	public void handleSkillColumnTokenPressed(SkillColumnToken skillColumnToken) {
		
		super.controller.textController().concealText();

		DiceSideEnum diceSideEnum = skillColumnToken.getDiceSideEnum();

		int timesToIncrease = super.controller.turnIndicatorController()
				.getOneOfEachSkillIncrease();

		super.controller.skillColumnController()
				.advanceSkillColumnTokenAnimate(diceSideEnum, timesToIncrease);

		Lock.lock();

		super.controller.flow().addGameStateFirst(
				GameStateEnum.RESOLVE_DICE_ROLLS);
		super.controller.flow().proceedToNextPhase();

	}

}
