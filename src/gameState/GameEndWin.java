package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class GameEndWin extends GameEnd {

	public GameEndWin(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
		super.textEnum = TextEnum.YOU_WIN;
	}

}
