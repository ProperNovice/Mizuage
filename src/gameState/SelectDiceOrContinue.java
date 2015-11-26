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

		super.controller.textController()
				.showText(TextEnum.SELECT_DICE_TO_KEEP);
		super.controller.textController().showText(TextEnum.ROLL_DICE);

	}

	@Override
	protected void handleDiceActivePressed(Dice dice) {
		dice.reverseSelected();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.Q))
			proceed();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		proceed();
	}

	private void proceed() {

		super.controller.textController().concealText();
		super.controller.diceController().rollDiceNonSelected();
		super.controller.flow().proceedToNextPhase();

	}

}
