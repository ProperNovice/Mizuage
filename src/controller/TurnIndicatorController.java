package controller;

import turn.TurnIndicator;
import turn.TurnIndicatorGeisha;
import turn.TurnIndicatorMaiko;
import turn.TurnIndicatorMizuage;
import utils.ArrayList;
import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;

public class TurnIndicatorController {

	ArrayList<ArrayList<TurnIndicator>> turnIndicators = new ArrayList<>();

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

	public Class<? extends TurnIndicator> getCurrentTurnIndicator() {
		return this.turnIndicators.getFirst().getFirst().getClass();
	}

}
