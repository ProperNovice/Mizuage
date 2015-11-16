package model;

import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import enums.DiceSideEnum;
import enums.Dimensions;

public class Dice implements EventHandlerAble {

	private ArrayList<DiceSide> diceSides = new ArrayList<>();
	private DiceSide diceSideShowing = null;
	private ImageView imageView = null;
	private double x, y;

	public Dice() {

		createSides();
		createImageView();

	}

	private void createImageView() {

		this.imageView = new ImageView(this.diceSideShowing.getImage());
		this.imageView.setWidth(Dimensions.DICE.x());
		this.imageView.setEventHandler(this);

	}

	private void createSides() {

		for (DiceSideEnum diceSideEnum : DiceSideEnum.values())
			this.diceSides.add(new DiceSide(diceSideEnum));

		this.diceSideShowing = this.diceSides.getRandom();

	}

	public void relocate(double x, double y) {

		this.x = x;
		this.y = y;

		this.imageView.relocate(this.x, this.y);

	}

	public void roll() {

		this.diceSideShowing = this.diceSides.getRandom();
		this.imageView.setImage(this.diceSideShowing.getImage());

	}

	public DiceSideEnum diceSiceEnumShowing() {
		return this.diceSideShowing.getDiceSideEnum();
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

	}

}
