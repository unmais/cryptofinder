package org.instrumenteddreams.cryptofinder.coin;

public class CoinFactory {

	public static Coin buildCoin(CoinInfoBasic info) {

		return new CoinImpl(info);
	}

}
