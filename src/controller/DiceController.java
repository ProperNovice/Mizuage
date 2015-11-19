package controller;

import utils.ArrayList;
import dice.Dice;
import dice.RollDiceImage;
import enums.Coordinates;
import enums.DiceSideEnum;
import enums.Dimensions;

public class DiceController {

	private ArrayList<Dice> dice = new ArrayList<>();
	private ArrayList<RollDiceImage> rollDiceImages = new ArrayList<>();

	public DiceController() {

		createDice();
		createRollDiceImages();

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

	private void createRollDiceImages() {

		for (int counter = 1; counter <= 3; counter++)
			this.rollDiceImages.add(new RollDiceImage());

		double x = Coordinates.TEXT_PANEL.x();
		double y = Coordinates.TEXT_PANEL.y()
				- this.rollDiceImages.getFirst().getHeight();

		for (RollDiceImage rollDiceImage : this.rollDiceImages) {

			rollDiceImage.relocate(x, y);
			x += Dimensions.DICE.x();

		}

	}

	public void rollDiceAll() {

		for (Dice dice : this.dice)
			dice.roll();

		updateRollTimeImages();

	}

	public void rollDiceNonExpenseNonSelected() {

		for (Dice dice : this.dice) {

			DiceSideEnum diceSideEnum = dice.getDiceSiceEnumShowing();

			if (diceSideEnum.equals(DiceSideEnum.EXPENCE))
				continue;

			if (dice.isSelected())
				continue;

			dice.roll();

		}

		updateRollTimeImages();

	}

	private void updateRollTimeImages() {

		for (RollDiceImage rollDiceImage : this.rollDiceImages) {

			if (rollDiceImage.isVisible())
				continue;

			rollDiceImage.setVisible(true);
			break;

		}

	}

	public void diselectAllDice() {

		for (Dice dice : this.dice)
			if (dice.isSelected())
				dice.reverseSelected();

	}

	public void testSetDiceRolls(DiceSideEnum... diceSideEnum) {

		int index = 0;
		Dice dice = null;

		for (DiceSideEnum sideEnum : diceSideEnum) {

			dice = this.dice.get(index);

			while (!dice.getDiceSiceEnumShowing().equals(sideEnum))
				dice.roll();

			index++;

		}

	}

}
