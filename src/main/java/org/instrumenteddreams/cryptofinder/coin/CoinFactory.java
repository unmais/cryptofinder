package org.instrumenteddreams.cryptofinder.coin;

import org.instrumenteddreams.cryptofinder.coin.impl.CoinImpl;

public class CoinFactory {

    public static Coin buildCoin(CoinBasicInfo info) {

	return new CoinImpl(info);
    }

}
