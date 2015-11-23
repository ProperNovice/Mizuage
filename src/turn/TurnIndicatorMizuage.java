package turn;

public class TurnIndicatorMizuage extends TurnIndicator {

	@Override
	protected void createPath() {
		super.path = "z";
	}

	@Override
	public int servicesNeededForCoin() {
		return -1;
	}

}
