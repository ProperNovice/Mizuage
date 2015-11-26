package controller;

import dice.Dice;
import enums.GameStateEnum;
import enums.TextEnum;
import gameState.ChooseSkillToIncrease;
import gameState.GameState;
import gameState.MizuageTurn;
import gameState.ResolveDiceRolls;
import gameState.SelectDiceOrContinue;
import gameState.SelectDiceToKeep;
import gameState.StartGame;
import gameState.StartNextTurn;
import javafx.scene.input.KeyCode;
import skillColumn.SkillColumnToken;
import utils.ArrayList;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = null;
	private ArrayList<GameState> gameStates = new ArrayList<>();

	public GameStateController() {

		this.gameStates.add(new StartGame(GameStateEnum.START_GAME));
		this.gameStates.add(new StartNextTurn(GameStateEnum.START_NEXT_TURN));
		this.gameStates.add(new SelectDiceOrContinue(
				GameStateEnum.SELECT_DICE_OR_CONTINUE));
		this.gameStates.add(new ResolveDiceRolls(
				GameStateEnum.RESOLVE_DICE_ROLLS));
		this.gameStates.add(new ChooseSkillToIncrease(
				GameStateEnum.CHOOSE_SKILL_TO_INCREASE));
		this.gameStates.add(new SelectDiceToKeep(
				GameStateEnum.SELECT_DICE_TO_KEEP));
		this.gameStates.add(new MizuageTurn(GameStateEnum.MIZUAGE_TURN));

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

	public void handleSkillColumnTokenPressed(SkillColumnToken skillColumnToken) {
		this.currentGameState.handleSkillColumnTokenPressed(skillColumnToken);
	}

}
