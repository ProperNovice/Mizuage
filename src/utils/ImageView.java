package utils;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class ImageView {

	private javafx.scene.image.ImageView imageView = null;
	private double scale = 1;

	public ImageView(String path, Parent parent) {

		String finalPath = "/images/" + path;

		this.imageView = new javafx.scene.image.ImageView(finalPath);
		addNode(parent);

	}

	public ImageView(Image image, Parent parent) {

		this.imageView = new javafx.scene.image.ImageView(image);
		addNode(parent);

	}

	private void addNode(Parent parent) {
		parent.addNode(this.imageView);
	}

	public final void setVisible(final boolean value) {
		this.imageView.setVisible(value);
	}

	public void toBack() {
		this.imageView.toBack();
	}

	public void toFront() {
		this.imageView.toFront();
	}

	public final double getLayoutX() {
		return this.imageView.getLayoutX();
	}

	public final double getLayoutY() {
		return this.imageView.getLayoutY();
	}

	public void relocate(final double x, final double y) {
		this.imageView.relocate(x, y);
	}

	public final void setRotate(double value) {
		this.imageView.setRotate(value);
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMouseEntered(value);
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMouseExited(value);
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		this.imageView.setOnMousePressed(value);
	}

	public final void setImage(final Image image) {
		this.imageView.setImage(image);
	}

	public final Image getImage() {
		return this.imageView.getImage();
	}

	public final void setScale(double scale) {

		this.scale = scale;
		
		this.imageView.setScaleX(this.scale);
		this.imageView.setScaleY(this.scale);

		double widthTotal = this.imageView.minWidth(0);
		double heightTotal = this.imageView.minHeight(0);

		double widthNew = this.scale * widthTotal;
		double heightNew = this.scale * heightTotal;

		double translateX = (widthNew - widthTotal) / 2;
		double translateY = (heightNew - heightTotal) / 2;

		this.imageView.setTranslateX(translateX);
		this.imageView.setTranslateY(translateY);

	}

	public void setWidth(double width) {

		double scale = width / this.imageView.minWidth(0);
		setScale(scale);

	}

	public void setHeight(double height) {

		double scale = height / this.imageView.minHeight(0);
		setScale(scale);

	}

	public double getWidht() {
		return this.imageView.minWidth(0) * this.scale;
	}

	public double getHeight() {
		return this.imageView.minHeight(0) * this.scale;
	}

}
