package gameState;

import javafx.scene.input.KeyCode;
import utils.ArrayList;
import utils.Lock;
import enums.DiceResults;
import enums.DiceSideEnum;
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

		if (diceResults.isEmpty()) {
			// TODO
			System.out.println("empty");
			return;

		}

		for (DiceResults diceResultsTemp : diceResults) {

			switch (diceResultsTemp) {

			case ONE_OF_EACH:
				super.controller.textController()
						.showText(TextEnum.ONE_OF_EACH);
				break;

			case THREE_OF_A_KIND:
				super.controller.textController().showText(
						TextEnum.THREE_OF_A_KIND);
				break;

			case FOUR_OF_A_KIND:
				super.controller.textController().showText(
						TextEnum.FOUR_OF_A_KIND);
				break;

			case FIVE_OF_A_KIND:
				super.controller.textController().showText(
						TextEnum.FIVE_OF_A_KIND);
				break;

			case SERVICE:
				super.controller.textController().showText(TextEnum.SERVICE);
				break;

			}

		}

		super.controller.textController().showText(TextEnum.CONTINUE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		switch (textEnum) {

		case ONE_OF_EACH:
			break;

		case THREE_OF_A_KIND:
			resolveOfKind(3);
			break;

		case FOUR_OF_A_KIND:
			resolveOfKind(4);
			break;

		case FIVE_OF_A_KIND:
			resolveOfKind(5);
			break;

		case SERVICE:
			break;

		case CONTINUE:
			break;

		default:
			break;

		}

	}

	private void resolveOfKind(int times) {

		DiceSideEnum diceSideEnum = super.controller.diceController()
				.resolveOfKindAnimate(times);

		super.controller.skillColumnController().advanceSkillColumnToken(
				diceSideEnum, times);

		Lock.lock();

		System.out.println("yo");

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

	}

}
