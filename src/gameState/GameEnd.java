package gameState;

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

	}

}
