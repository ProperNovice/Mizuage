package dice;

import utils.ImageView;
import enums.Dimensions;

public class RollDiceImage {

	private ImageView imageView = null;

	public RollDiceImage() {
		create();
	}

	private void create() {

		this.imageView = new ImageView("/dice/roll.png");
		this.imageView.setHeight(Dimensions.DICE.y());
		this.imageView.setVisible(false);

	}

	public double getHeight() {
		return this.imageView.getHeight();
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean visibility) {
		this.imageView.setVisible(visibility);
	}

	public boolean isVisible() {
		return this.imageView.isVisible();
	}

}
