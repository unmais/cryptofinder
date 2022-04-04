package org.instrumenteddreams.cryptofinder.coin;

public class CFCoinOracles {

	public static CFCoinOracle getDefault() {

		return new CFDefaultOracle();
	}

}
