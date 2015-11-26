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

		super.controller.diceController().resetDiceImages();
		super.controller.diceController().diselectAllDice();

		int servicesNeededForCoin = super.controller.turnIndicatorController()
				.getServicesNeededForCoin();

		ArrayList<DiceResults> diceResults = super.controller.diceController()
				.getDiceResultsFromActiveDice(servicesNeededForCoin);

		if (diceResults.isEmpty()) {
			proceedToNextTurnPhase();
			return;
		}

		super.controller.textController().showText(TextEnum.USE_DICE);

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
			resolveOneOfEach();
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
			resolveService();
			break;

		case CONTINUE:
			proceedToNextTurnPhase();
			break;

		default:
			break;

		}

	}

	private void resolveOneOfEach() {

		super.controller.diceController().resolveOneOfEachAnimate();
		Lock.lock();

		super.controller.flow().addGameStateFirst(
				GameStateEnum.CHOOSE_SKILL_TO_INCREASE);
		super.controller.flow().proceedToNextPhase();

	}

	private void resolveService() {

		int servicesNeededForCoin = super.controller.turnIndicatorController()
				.getServicesNeededForCoin();

		super.controller.diceController().resolveServiceAnimate(
				servicesNeededForCoin);
		super.controller.coinController().addCoinsUpdatePanel(1);

		Lock.lock();

		handleGameStateChange();

	}

	private void resolveOfKind(int times) {

		DiceSideEnum diceSideEnum = super.controller.diceController()
				.resolveOfKindAnimate(times);

		int timesToAdvance = super.controller.turnIndicatorController()
				.getOfKindTornIndicatorPoints(times);

		if (super.controller.skillColumnController()
				.advanceSkillColumnTokenAnimate(diceSideEnum, timesToAdvance))
			Lock.lock();

		handleGameStateChange();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

	}

	private void proceedToNextTurnPhase() {
		super.controller.flow().proceedToNextPhase();
	}

}
