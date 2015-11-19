package dice;

import utils.Image;
import enums.DiceSideEnum;

public class DiceSide {

	private DiceSideEnum diceSideEnum = null;
	private Image image = null;

	public DiceSide(DiceSideEnum diceSideEnum) {

		this.diceSideEnum = diceSideEnum;
		createImage();

	}

	private void createImage() {

		String path = "dice/side/" + this.diceSideEnum.fileName() + ".png";
		this.image = new Image(path);

	}

	public Image getImage() {
		return this.image;
	}

	public DiceSideEnum getDiceSideEnum() {
		return this.diceSideEnum;
	}

}
