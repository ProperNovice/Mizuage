package gameState;

import utils.ArrayList;
import dice.Dice;
import enums.DiceResults;
import enums.GameStateEnum;
import enums.TextEnum;

public class SelectDiceToKeep extends GameState {

	public SelectDiceToKeep(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController()
				.showText(TextEnum.SELECT_DICE_TO_KEEP);
		super.controller.textController().showText(TextEnum.CONTINUE);

	}

	@Override
	protected void handleDiceActivePressed(Dice dice) {

		dice.reverseSelected();

		int servicesNeededForCoin = super.controller.turnIndicatorController()
				.getServicesNeededForCoin();

		ArrayList<DiceResults> diceResults = super.controller.diceController()
				.getDiceResultsFromSelectedDice(servicesNeededForCoin);

		if (!diceResults.isEmpty())
			dice.reverseSelected();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		super.controller.flow().proceedToNextPhase();
	}

}
