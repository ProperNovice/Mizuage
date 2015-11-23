package turn;

public class TurnIndicatorMaiko extends TurnIndicator {

	@Override
	protected void createPath() {
		super.path = "m";
	}

	@Override
	public int servicesNeededForCoin() {
		return 2;
	}

}
