package org.instrumenteddreams.cryptofinder.coin;

public class CoinOracles {

	public static CoinOracle getDefault() {

		return new DefaultOracle();
	}

}
