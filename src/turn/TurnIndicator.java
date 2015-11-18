package turn;

import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;
import enums.Dimensions;

public class TurnIndicator {

	private ImageView imageView = null;
	protected String path = null;

	protected TurnIndicator() {

		createPath();
		createImageView();

	}

	private void createImageView() {

		this.imageView = new ImageView(this.path);
		this.imageView.setWidth(Dimensions.TURN_INDICATOR.x());
		this.imageView.toBack();

	}

	protected void createPath() {

	}

	public void setVisible(boolean visibility) {
		this.imageView.setVisible(visibility);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void animate(double endingX, double endingY) {
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

}
