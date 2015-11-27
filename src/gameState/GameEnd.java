package gameState;

import instances.Instances;
import enums.GameStateEnum;
import enums.TextEnum;

public abstract class GameEnd extends GameState {

	protected TextEnum textEnum = null;

	public GameEnd(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(this.textEnum);
		super.controller.textController().showText(TextEnum.RESTART);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		Instances.getPanelGameInstance().restartGame();
	}

}
