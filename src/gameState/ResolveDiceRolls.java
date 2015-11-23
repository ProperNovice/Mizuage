package gameState;

import javafx.scene.input.KeyCode;
import utils.ArrayList;
import enums.DiceResults;
import enums.GameStateEnum;
import enums.TextEnum;

public class ResolveDiceRolls extends GameState {

	public ResolveDiceRolls(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.diceController().diselectAllDice();

		int servicesNeededForCoin = super.controller.turnIndicatorController()
				.getServicesNeededForCoin();

		ArrayList<DiceResults> diceResults = super.controller.diceController()
				.getDiceResults(servicesNeededForCoin);

		for (DiceResults diceResultsTemp : diceResults) {

			switch (diceResultsTemp) {

			case FIVE_OF_A_KIND:
				break;

			case FOUR_OF_A_KIND:
				break;

			case ONE_OF_EACH:
				break;

			case SERVICE:
				break;

			case THREE_OF_A_KIND:
				break;

			}

		}

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

	}

}
