package controller;

import instances.Instances;
import utils.ArrayList;
import enums.GameStateEnum;

public class Flow {

	private ArrayList<GameStateEnum> gameStateTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public Flow() {

		createGameStateTurn();

	}

	public void proceedToNextPhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addAll(this.gameStateTurn);

		Controller controller = Instances.getControllerInstance();

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		controller.gameStateController().setGameState(gameStateEnum);

	}

	public void addGameStateFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

	public void createGameStateTurn() {

		this.gameStateTurn.add(GameStateEnum.START_NEXT_TURN);
		this.gameStateTurn.add(GameStateEnum.SELECT_DICE_OR_CONTINUE);
		this.gameStateTurn.add(GameStateEnum.SELECT_DICE_OR_CONTINUE);
		this.gameStateTurn.add(GameStateEnum.RESOLVE_DICE_ROLLS);

	}

}
