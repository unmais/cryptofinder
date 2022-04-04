package org.instrumenteddreams.cryptofinder.coin;

public class CFCoinFactory {

	public static CFCoin buildCoin(CFCoinInfoBasic info) {

		return new CFCoinImpl(info);
	}

}
