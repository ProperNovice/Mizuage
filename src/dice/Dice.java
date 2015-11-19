package dice;

import instances.Instances;
import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import enums.DiceSideEnum;
import enums.Dimensions;

public class Dice implements EventHandlerAble {

	private ArrayList<DiceSide> diceSides = new ArrayList<>();
	private DiceSide diceSideShowing = null;
	private ImageView dice = null, selected = null;
	private double x, y;
	private boolean isSelected = false;

	public Dice() {

		createSides();
		createImageView();

	}

	private void createImageView() {

		this.dice = new ImageView(this.diceSideShowing.getImage());
		this.dice.setWidth(Dimensions.DICE.x());
		this.dice.setEventHandler(this);

		this.selected = new ImageView("dice/selected.png");
		this.selected.setWidth(Dimensions.DICE_SELECTED.x());
		this.selected.setVisible(false);

	}

	private void createSides() {

		this.diceSides.add(new DiceSide(DiceSideEnum.CONVERSATION));
		this.diceSides.add(new DiceSide(DiceSideEnum.DANCE));
		this.diceSides.add(new DiceSide(DiceSideEnum.EXPENCE));
		this.diceSides.add(new DiceSide(DiceSideEnum.EXPENCE));
		this.diceSides.add(new DiceSide(DiceSideEnum.MUSIC));
		this.diceSides.add(new DiceSide(DiceSideEnum.SERVICE));

		this.diceSideShowing = this.diceSides.getRandom();

	}

	public void relocate(double x, double y) {

		this.x = x;
		this.y = y;

		this.dice.relocate(this.x, this.y);
		this.selected.relocate(this.x, this.y);

	}

	public void roll() {

		this.diceSideShowing = this.diceSides.getRandom();
		this.dice.setImage(this.diceSideShowing.getImage());

	}

	public DiceSideEnum getDiceSiceEnumShowing() {
		return this.diceSideShowing.getDiceSideEnum();
	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		Instances.getControllerInstance().gameStateController()
				.handleDicePressed(this);
	}

	public void reverseSelected() {

		boolean value = true;

		if (this.isSelected)
			value = false;

		this.isSelected = value;
		this.selected.setVisible(value);

	}

	public boolean isSelected() {
		return this.isSelected;
	}

}
