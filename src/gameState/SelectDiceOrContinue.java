package gameState;

import javafx.scene.input.KeyCode;
import dice.Dice;
import enums.GameStateEnum;
import enums.TextEnum;

public class SelectDiceOrContinue extends GameState {

	public SelectDiceOrContinue(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		if (!super.controller.diceController()
				.diceActiveAreAllSelectedOrEmpty()) {

			super.controller.textController().showText(
					TextEnum.SELECT_DICE_TO_KEEP);
			super.controller.textController().showText(TextEnum.ROLL_DICE);

		} else
			super.controller.textController().showText(
					TextEnum.RESOLVE_DICE_ROLL);

	}

	@Override
	protected void handleDiceActivePressed(Dice dice) {

		super.controller.textController().concealText();

		dice.reverseSelected();

		handleGameStateChange();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.Q))
			proceedToNextPhase();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		switch (textEnum) {

		case ROLL_DICE:
			proceedToNextPhase();
			break;

		case RESOLVE_DICE_ROLL:
			proceedToResolveDiceRoll();
			break;

		default:
			break;

		}

	}

	private void proceedToNextPhase() {

		super.controller.diceController().rollDiceNonSelected();
		super.controller.flow().proceedToNextPhase();

	}

	private void proceedToResolveDiceRoll() {

		super.controller.flow().removeAllSelectDiceOrContinue();
		super.controller.flow().proceedToNextPhase();

	}

}
