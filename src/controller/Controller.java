package controller;

import instances.Instances;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private Flow flow = null;
	private SkillColumnController skillColumnController = null;
	private CoinController coinController = null;
	private TurnIndicatorController turnIndicatorController = null;
	private DiceController diceController = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.flow = new Flow();
		this.skillColumnController = new SkillColumnController();
		this.coinController = new CoinController();
		this.turnIndicatorController = new TurnIndicatorController();
		this.diceController = new DiceController();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public Flow flow() {
		return this.flow;
	}

	public SkillColumnController skillColumnController() {
		return this.skillColumnController;
	}

	public CoinController coinController() {
		return this.coinController;
	}

	public TurnIndicatorController turnIndicatorController() {
		return this.turnIndicatorController;
	}

	public DiceController diceController() {
		return this.diceController;
	}

}
