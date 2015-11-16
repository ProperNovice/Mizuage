package controller;

import instances.Instances;
import utils.ArrayList;
import enums.GameStateEnum;

public class Flow {

	private ArrayList<GameStateEnum> gameStateTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public Flow() {

	}

	public void proceedToNextPhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addAll(this.gameStateTurn);

		Controller controller = Instances.getControllerInstance();

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		controller.gameStateController().setGameState(gameStateEnum);

	}

}
