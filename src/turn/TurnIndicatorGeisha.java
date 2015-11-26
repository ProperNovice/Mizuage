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

	@Override
	public int oneOfEachSkillIncrease() {
		return 2;
	}

	@Override
	public int ofKindSkillIncrease(int times) {

		switch (times) {

		case 3:
			return 3;

		case 4:
			return 4;

		case 5:
			return 5;

		default:
			return -1;

		}

	}

}
