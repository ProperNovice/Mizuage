package controller;

import interfaces.StartNextTurn;
import turn.TurnIndicator;
import turn.TurnIndicatorGeisha;
import turn.TurnIndicatorMaiko;
import turn.TurnIndicatorMizuage;
import utils.ArrayList;
import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;

public class TurnIndicatorController {

	private ArrayList<ArrayList<TurnIndicator>> turnIndicators = new ArrayList<>();
	private StartNextTurn startNextTurn = new StartFirstTurn();

	public TurnIndicatorController() {

		createTurnIndicators();

	}

	private void createTurnIndicators() {

		// Maiko

		ArrayList<TurnIndicator> arrayList = new ArrayList<>();
		this.turnIndicators.add(arrayList);

		for (int counter = 1; counter <= 10; counter++)
			arrayList.add(new TurnIndicatorMaiko());

		double firstX = Coordinates.TURN_INDICATOR.x();
		double x = firstX;
		double y = Coordinates.TURN_INDICATOR.y();
		int turnIndicatorsPerRow = Credentials.TURN_INDICATORS_PER_ROW
				.credential();

		for (int counter = 1; counter <= 10; counter++) {

			arrayList.get(counter - 1).relocate(x, y);

			x += Dimensions.TURN_INDICATOR.x() / 2;

			if (counter % turnIndicatorsPerRow > 0)
				continue;

			x = firstX;
			y += Dimensions.TURN_INDICATOR.y();

		}

		// Mizuage

		arrayList = new ArrayList<>();
		this.turnIndicators.add(arrayList);

		arrayList.add(new TurnIndicatorMizuage());

		x = firstX;

		arrayList.get(0).relocate(x, y);

		// Geisha

		arrayList = new ArrayList<>();
		this.turnIndicators.add(arrayList);

		for (int counter = 1; counter <= 9; counter++)
			arrayList.add(new TurnIndicatorGeisha());

		y += Dimensions.TURN_INDICATOR.y();

		for (int counter = 1; counter <= 9; counter++) {

			arrayList.get(counter - 1).relocate(x, y);

			x += Dimensions.TURN_INDICATOR.x() / 2;

			if (counter % turnIndicatorsPerRow > 0)
				continue;

			x = firstX;
			y += Dimensions.TURN_INDICATOR.y();

		}

	}

	public void startNextTurn() {
		this.startNextTurn.startNextTurn();
	}

	private class StartFirstTurn implements StartNextTurn {

		@Override
		public void startNextTurn() {

			turnIndicators.getFirst().getFirst().setActive();
			startNextTurn = new StartConsecutiveTurn();

		}

	}

	private class StartConsecutiveTurn implements StartNextTurn {

		@Override
		public void startNextTurn() {

			turnIndicators.getFirst().getFirst().setVisibleFalse();
			turnIndicators.getFirst().removeFirst();

			if (turnIndicators.getFirst().isEmpty())
				turnIndicators.removeFirst();

			turnIndicators.getFirst().getFirst().setActive();

		}

	}

	public int getServicesNeededForCoin() {
		return this.turnIndicators.getFirst().getFirst()
				.servicesNeededForCoin();
	}

	public int getOfKindTornIndicatorPoints(int times) {
		return this.turnIndicators.getFirst().getFirst()
				.ofKindSkillIncrease(times);
	}

	public int getOneOfEachSkillIncrease() {
		return this.turnIndicators.getFirst().getFirst()
				.oneOfEachSkillIncrease();
	}

	public boolean nextTurnIsMizuage() {

		TurnIndicator turnIndicator = this.turnIndicators.getFirst().getFirst();
		return (turnIndicator.getClass().equals(TurnIndicatorMizuage.class));

	}

	public boolean currentTurnIsGeisha() {
		TurnIndicator turnIndicator = this.turnIndicators.getFirst().getFirst();
		return (turnIndicator.getClass().equals(TurnIndicatorGeisha.class));
	}

}
