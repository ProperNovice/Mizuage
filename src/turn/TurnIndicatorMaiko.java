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

	@Override
	public int oneOfEachSkillIncrease() {
		return 1;
	}

	@Override
	public int ofKindSkillIncrease(int times) {

		switch (times) {

		case 3:
			return 2;

		case 4:
			return 3;

		case 5:
			return 4;

		default:
			return -1;

		}

	}

}
