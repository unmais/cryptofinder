package org.instrumenteddreams.cryptofinder.coin;

import org.instrumenteddreams.cryptofinder.coin.impl.DefaultOracle;

public class CoinOracles {

    public static CoinOracle getDefault() {

	return new DefaultOracle();
    }

}
