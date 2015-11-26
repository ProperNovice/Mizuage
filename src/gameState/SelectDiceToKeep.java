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

		super.controller.diceController().resetDiceImages();

		if (!super.controller.diceController()
				.diceActiveAreAllSelectedOrEmpty())
			super.controller.textController().showText(
					TextEnum.SELECT_DICE_TO_KEEP);

		super.controller.textController().showText(TextEnum.START_NEXT_TURN);

	}

	@Override
	protected void handleDiceActivePressed(Dice dice) {

		if (!super.controller.diceController().isAcive(dice))
			return;

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
		handleStartNextTurn();
	}

	private void handleStartNextTurn() {

		super.controller.textController().concealText();

		int diceExpense = super.controller.diceController().getDiceExpence();
		super.controller.coinController().removeCoinsUpdatePanel(diceExpense);
		
		if (super.controller.coinController().gameIsLost())
			super.controller.flow().addGameStateFirst(GameStateEnum.LOSE);

		super.controller.flow().proceedToNextPhase();

	}

}
