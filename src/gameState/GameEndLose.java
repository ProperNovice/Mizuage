package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class GameEndLose extends GameEnd {

	public GameEndLose(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
		super.textEnum = TextEnum.YOU_LOSE;
	}

}
