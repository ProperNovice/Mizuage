package turn;

import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.Image;
import utils.ImageView;
import enums.Dimensions;

public abstract class TurnIndicator {

	private ImageView imageView = null;
	private Image active = null;
	private Image nonActive = null;
	protected String path = null;

	public TurnIndicator() {

		createPath();
		createImageView();

	}

	private void createImageView() {

		this.path = "turn/" + this.path;

		this.active = new Image(this.path + "Active.png");
		this.nonActive = new Image(this.path + "NonActive.png");

		this.imageView = new ImageView(this.nonActive);
		this.imageView.setWidth(Dimensions.TURN_INDICATOR.x());
		this.imageView.toBack();

	}

	protected void createPath() {

	}

	public void setActive() {
		this.imageView.setImage(this.active);
	}

	public void setVisibleFalse() {
		this.imageView.setVisible(false);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void animate(double endingX, double endingY) {
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public abstract int servicesNeededForCoin();

}
