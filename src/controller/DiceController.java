package controller;

import utils.ArrayList;
import dice.Dice;
import enums.Coordinates;
import enums.Dimensions;

public class DiceController {

	private ArrayList<Dice> dice = new ArrayList<>();

	public DiceController() {

		createDice();

	}

	private void createDice() {

		Dice dice = null;
		double x = Coordinates.DICE.x();
		double y = Coordinates.DICE.y();

		for (int counter = 1; counter <= 5; counter++) {

			dice = new Dice();

			dice.relocate(x, y);
			this.dice.add(dice);

			x += Dimensions.DICE.x();
			x += Dimensions.GAP_BETWEEN_DICE.x();

		}

	}

}
