package gameState;

import utils.Lock;
import dice.Dice;
import enums.DiceSideEnum;
import enums.GameStateEnum;
import enums.TextEnum;

public class EarnMoney extends GameState {

	public EarnMoney(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController()
				.showText(TextEnum.SELECT_DICE);

	}

	@Override
	protected void handleDiceActivePressed(Dice dice) {

		DiceSideEnum diceSideEnum = dice.getDiceSideEnumShowing();

		if (diceSideEnum.equals(DiceSideEnum.SERVICE))
			return;

		super.controller.textController().concealText();

		super.controller.diceController().addDiceFromActiveToUsedAnimate(dice);

		int cointToAdd = super.controller.skillColumnController()
				.getCoinsFromSkillColumnToken(diceSideEnum);

		super.controller.coinController().addCoinsUpdatePanel(cointToAdd);
		Lock.lock();

		super.controller.flow().addGameStateFirst(
				GameStateEnum.RESOLVE_DICE_ROLLS);
		super.controller.flow().proceedToNextPhase();

	}

}
