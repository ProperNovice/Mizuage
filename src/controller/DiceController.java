package controller;

import utils.ArrayList;
import utils.Lock;
import dice.Dice;
import dice.RollDiceImage;
import enums.Coordinates;
import enums.DiceResults;
import enums.DiceSideEnum;
import enums.Dimensions;

public class DiceController {

	private ArrayList<Dice> diceActive = new ArrayList<>();
	private ArrayList<Dice> diceUsed = new ArrayList<>();
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
			this.diceActive.add(dice);

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

		for (Dice dice : this.diceActive)
			dice.roll();

		updateRollTimeImages();
		addDiceExpenseToUsedAnimateLock();

	}

	public void rollDiceNonExpenseNonSelected() {

		for (Dice dice : this.diceActive) {

			DiceSideEnum diceSideEnum = dice.getDiceSiceEnumShowing();

			if (diceSideEnum.equals(DiceSideEnum.EXPENCE))
				continue;

			if (dice.isSelected())
				continue;

			dice.roll();

		}

		updateRollTimeImages();
		addDiceExpenseToUsedAnimateLock();

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

		for (Dice dice : this.diceActive)
			if (dice.isSelected())
				dice.reverseSelected();

	}

	public void testSetDiceRolls(DiceSideEnum... diceSideEnum) {

		int index = 0;
		Dice dice = null;

		for (DiceSideEnum sideEnum : diceSideEnum) {

			dice = this.diceActive.get(index);

			while (!dice.getDiceSiceEnumShowing().equals(sideEnum))
				dice.roll();

			index++;

		}

		addDiceExpenseToUsedAnimateLock();

	}

	private void addDiceExpenseToUsedAnimateLock() {

		boolean lock = false;

		ArrayList<Dice> diceActiveTemp = new ArrayList<>(this.diceActive);

		for (Dice dice : diceActiveTemp) {

			if (!dice.getDiceSiceEnumShowing().equals(DiceSideEnum.EXPENCE))
				continue;

			lock = true;
			this.diceActive.remove(dice);
			this.diceUsed.add(dice);
			dice.animateDown();

		}

		if (lock)
			Lock.lock();

	}

	public void clearDiceUsedAnimateLock() {

		if (this.diceUsed.isEmpty())
			return;

		this.diceActive.addAll(this.diceUsed);
		this.diceUsed.clear();

		for (Dice dice : this.diceActive)
			dice.animateUp();

		Lock.lock();

	}

	public ArrayList<DiceResults> getDiceResults(int servicesNeeded) {

		ArrayList<DiceResults> diceResults = new ArrayList<>();

		if (resolveServices(servicesNeeded))
			diceResults.add(DiceResults.SERVICE);

		if (resolveOneOfEach())
			diceResults.add(DiceResults.ONE_OF_EACH);

		if (resolveOfKind(5))
			diceResults.add(DiceResults.FIVE_OF_A_KIND);

		if (resolveOfKind(4))
			diceResults.add(DiceResults.FOUR_OF_A_KIND);

		if (resolveOfKind(3))
			diceResults.add(DiceResults.THREE_OF_A_KIND);

		return diceResults;

	}

	private boolean resolveServices(int servicesNeeded) {

		int services = 0;

		for (Dice dice : this.diceActive)
			if (dice.getDiceSiceEnumShowing().equals(DiceSideEnum.SERVICE))
				services++;

		if (services >= servicesNeeded)
			return true;
		else
			return false;

	}

	private boolean resolveOneOfEach() {

		int conversation = 0;
		int dance = 0;
		int music = 0;

		for (Dice dice : this.diceActive) {

			switch (dice.getDiceSiceEnumShowing()) {

			case CONVERSATION:
				conversation++;
				continue;

			case DANCE:
				dance++;
				continue;

			case MUSIC:
				music++;
				continue;

			default:
				continue;

			}

		}

		if (conversation == 0)
			return false;

		if (dance == 0)
			return false;

		if (music == 0)
			return false;

		return true;

	}

	public boolean resolveOfKind(int times) {

		int conversation = 0;
		int dance = 0;
		int music = 0;

		for (Dice dice : this.diceActive) {

			switch (dice.getDiceSiceEnumShowing()) {

			case CONVERSATION:
				conversation++;
				continue;

			case DANCE:
				dance++;
				continue;

			case MUSIC:
				music++;
				continue;

			default:
				continue;

			}

		}

		if (conversation >= times)
			return true;

		if (dance >= times)
			return true;

		if (music >= times)
			return true;

		return false;

	}
}
