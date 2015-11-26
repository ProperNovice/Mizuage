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

	public void rollDiceAll() { // TODO

		for (Dice dice : this.diceActive)
			dice.roll();

		updateRollTimeImages();
		addDiceExpenseToUsedAnimateLock();

	}

	public void rollDiceNonSelected() {

		for (Dice dice : this.diceActive) {

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

			addDiceFromActiveToUsedAnimate(dice);

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

	public ArrayList<DiceResults> getDiceResultsFromSelectedDice(
			int servicesNeeded) {

		ArrayList<Dice> diceList = new ArrayList<>();

		for (Dice dice : this.diceActive)
			if (dice.isSelected())
				diceList.add(dice);

		return getDiceResultsFromDice(servicesNeeded, diceList);

	}

	public ArrayList<DiceResults> getDiceResultsFromActiveDice(
			int servicesNeeded) {
		return getDiceResultsFromDice(servicesNeeded, this.diceActive);
	}

	private ArrayList<DiceResults> getDiceResultsFromDice(int servicesNeeded,
			ArrayList<Dice> diceList) {

		ArrayList<DiceResults> diceResults = new ArrayList<>();

		if (isResolvedOfKind(5, diceList))
			diceResults.add(DiceResults.FIVE_OF_A_KIND);

		if (isResolvedOfKind(4, diceList))
			diceResults.add(DiceResults.FOUR_OF_A_KIND);

		if (isResolvedOfKind(3, diceList))
			diceResults.add(DiceResults.THREE_OF_A_KIND);

		if (isResolvedOneOfEach(diceList))
			diceResults.add(DiceResults.ONE_OF_EACH);

		if (isResolvedServices(servicesNeeded, diceList))
			diceResults.add(DiceResults.SERVICE);

		return diceResults;

	}

	private boolean isResolvedServices(int servicesNeeded,
			ArrayList<Dice> diceList) {

		int services = 0;

		for (Dice dice : diceList)
			if (dice.getDiceSiceEnumShowing().equals(DiceSideEnum.SERVICE))
				services++;

		if (services >= servicesNeeded)
			return true;
		else
			return false;

	}

	private boolean isResolvedOneOfEach(ArrayList<Dice> diceList) {

		int conversation = 0;
		int dance = 0;
		int music = 0;

		for (Dice dice : diceList) {

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

	private boolean isResolvedOfKind(int times, ArrayList<Dice> diceList) {

		int conversation = 0;
		int dance = 0;
		int music = 0;

		for (Dice dice : diceList) {

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

	private void addOfKindDiceToUsed(DiceSideEnum diceSideEnum, int times) {

		ArrayList<Dice> diceActiveTemp = new ArrayList<>(this.diceActive);

		for (Dice dice : diceActiveTemp) {

			if (!dice.getDiceSiceEnumShowing().equals(diceSideEnum))
				continue;

			times--;

			addDiceFromActiveToUsedAnimate(dice);

			if (times > 0)
				continue;

			break;

		}

	}

	public void resolveOneOfEachAnimate() {

		ArrayList<DiceSideEnum> diceSideEnumList = new ArrayList<>();

		diceSideEnumList.add(DiceSideEnum.CONVERSATION);
		diceSideEnumList.add(DiceSideEnum.DANCE);
		diceSideEnumList.add(DiceSideEnum.MUSIC);

		ArrayList<Dice> diceActiveTemp = new ArrayList<>(this.diceActive);

		DiceSideEnum diceSideEnum = null;

		for (Dice dice : diceActiveTemp) {

			diceSideEnum = dice.getDiceSiceEnumShowing();

			if (!diceSideEnumList.contains(diceSideEnum))
				continue;

			diceSideEnumList.remove(diceSideEnum);
			addDiceFromActiveToUsedAnimate(dice);

			if (!diceSideEnumList.isEmpty())
				continue;

			break;

		}

	}

	public void resolveServiceAnimate(int servicesNeeded) {

		ArrayList<Dice> diceActiveTemp = new ArrayList<>(this.diceActive);

		for (Dice dice : diceActiveTemp) {

			if (!dice.getDiceSiceEnumShowing().equals(DiceSideEnum.SERVICE))
				continue;

			servicesNeeded--;

			addDiceFromActiveToUsedAnimate(dice);

			if (servicesNeeded == 0)
				break;

		}

	}

	public DiceSideEnum resolveOfKindAnimate(int times) {

		DiceSideEnum diceSideEnum = null;
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

		if (conversation >= times) {

			addOfKindDiceToUsed(DiceSideEnum.CONVERSATION, times);
			diceSideEnum = DiceSideEnum.CONVERSATION;

		} else if (dance >= times) {

			addOfKindDiceToUsed(DiceSideEnum.DANCE, times);
			diceSideEnum = DiceSideEnum.DANCE;

		} else if (music >= times) {

			addOfKindDiceToUsed(DiceSideEnum.MUSIC, times);
			diceSideEnum = DiceSideEnum.MUSIC;

		}

		return diceSideEnum;

	}

	private void addDiceFromActiveToUsedAnimate(Dice dice) {

		this.diceActive.remove(dice);
		this.diceUsed.add(dice);
		dice.animateDown();

	}

	public boolean isAcive(Dice dice) {
		return this.diceActive.contains(dice);
	}

}
