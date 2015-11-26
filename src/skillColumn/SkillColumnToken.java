package skillColumn;

import instances.Instances;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import enums.DiceSideEnum;
import enums.Dimensions;

public class SkillColumnToken implements EventHandlerAble {

	private ImageView imageView = null;
	private DiceSideEnum diceSideEnum = null;

	public SkillColumnToken(DiceSideEnum diceSideEnum) {

		this.diceSideEnum = diceSideEnum;
		createImageView();

	}

	private void createImageView() {

		String path = "tokens/" + this.diceSideEnum.fileName() + ".png";

		this.imageView = new ImageView(path);
		this.imageView.setWidth(Dimensions.SKILL_COLUMN.x());
		this.imageView.setEventHandler(this);

	}

	public DiceSideEnum getDiceSideEnum() {
		return this.diceSideEnum;
	}

	public void animate(double x, double y) {
		Animation.animate(this.imageView, x, y, AnimationSynch.SYNCHRONOUS);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		Instances.getControllerInstance().gameStateController()
				.handleSkillColumnTokenPressed(this);
	}

}
