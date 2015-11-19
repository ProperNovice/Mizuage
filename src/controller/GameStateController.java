package controller;

import dice.Dice;
import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.GameState;
import gameState.ResolveDiceRolls;
import gameState.SelectDiceOrContinue;
import gameState.StartGame;
import gameState.StartNextTurn;
import javafx.scene.input.KeyCode;
import utils.ArrayList;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = null;
	private ArrayList<GameState> gameStates = new ArrayList<>();

	public GameStateController() {

		this.gameStates.add(new StartGame(GameStateEnum.START_GAME));
		this.gameStates.add(new Animating(GameStateEnum.ANIMATING));
		this.gameStates.add(new StartNextTurn(GameStateEnum.START_NEXT_TURN));
		this.gameStates.add(new SelectDiceOrContinue(
				GameStateEnum.SELECT_DICE_OR_CONTINUE));
		this.gameStates.add(new ResolveDiceRolls(
				GameStateEnum.RESOLVE_DICE_ROLLS));

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		for (GameState gameState : this.gameStates) {

			GameStateEnum gameStateEnumTemp = gameState.getGameStateEnum();

			if (!gameStateEnumTemp.equals(gameStateEnum))
				continue;

			this.currentGameState = gameState;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum);

		this.currentGameState.handleGameStateChange();

	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		this.currentGameState.handleTextOptionPressed(textEnum);
	}

	public void handleKeyPressed(KeyCode keyCode) {
		this.currentGameState.handleKeyPressed(keyCode);
	}

	public void handleDicePressed(Dice dice) {
		this.currentGameState.handleDicePressed(dice);
	}

}
