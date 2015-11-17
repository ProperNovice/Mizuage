package coin;

import enums.Dimensions;
import utils.ImageView;

public class Coin {

	private ImageView imageView = null;
	protected String path = null;

	protected Coin() {

		createPath();
		createCoin();

	}

	private void createCoin() {

		this.imageView = new ImageView(this.path);
		this.imageView.setWidth(Dimensions.COIN.x());
		this.imageView.setVisible(false);

	}

	public void setVisible(boolean visibility) {
		this.imageView.setVisible(visibility);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	protected void createPath() {

	}

}
