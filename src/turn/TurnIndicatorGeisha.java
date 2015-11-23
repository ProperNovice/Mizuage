package turn;

public class TurnIndicatorGeisha extends TurnIndicator {

	@Override
	protected void createPath() {
		super.path = "g";
	}

	@Override
	public int servicesNeededForCoin() {
		return 1;
	}

}
