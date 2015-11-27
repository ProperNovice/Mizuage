package controller;

import utils.ArrayList;
import coin.Coin;
import coin.CoinMinus;
import coin.CoinPlus;
import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;

public class CoinController {

	private ArrayList<Coin> coinsPlus = new ArrayList<>();
	private ArrayList<Coin> coinsMinus = new ArrayList<>();
	private int coinsCurrent = 0;

	public CoinController() {

		create();
		relocate();

	}

	private void create() {

		for (int counter = 1; counter <= 20; counter++) {

			this.coinsPlus.add(new CoinPlus());
			this.coinsMinus.add(new CoinMinus());

		}

	}

	private void relocate() {

		double firstX = Coordinates.COIN.x();
		double x = firstX;
		double y = Coordinates.COIN.y();
		int coinsInRow = Credentials.COINS_PER_ROW.credential();

		for (int counter = 0; counter <= 19; counter++) {

			this.coinsPlus.get(counter).relocate(x, y);
			this.coinsMinus.get(counter).relocate(x, y);

			x += Dimensions.COIN.x();

			if (counter % coinsInRow != coinsInRow - 1)
				continue;

			x = firstX;
			y += Dimensions.COIN.y();

		}

	}

	public void addCoinsUpdatePanel(int coins) {

		this.coinsCurrent += coins;
		updatePanel();

	}

	public void removeCoinsUpdatePanel(int coins) {

		this.coinsCurrent -= coins;
		updatePanel();

	}

	private void updatePanel() {

		if (this.coinsCurrent > 0) {

			setVisibleFalse(this.coinsMinus);
			setVisibleTrue(this.coinsPlus);

		} else if (this.coinsCurrent < 0) {

			setVisibleFalse(this.coinsPlus);
			setVisibleTrue(this.coinsMinus);

		} else {

			setVisibleFalse(this.coinsMinus);
			setVisibleFalse(this.coinsPlus);

		}

	}

	private void setVisibleFalse(ArrayList<Coin> list) {

		for (Coin coin : list)
			coin.setVisible(false);

	}

	private void setVisibleTrue(ArrayList<Coin> list) {

		boolean visibility = true;

		int coinsVisible = (int) Math.abs(this.coinsCurrent);

		for (int counter = 1; counter <= 20; counter++) {

			if (counter <= coinsVisible)
				visibility = true;
			else
				visibility = false;

			list.get(counter - 1).setVisible(visibility);

		}

	}

	public boolean gameIsLost() {
		return this.coinsCurrent < -20;
	}

	public boolean gameIsWon() {
		return this.coinsCurrent > 0;
	}

}
