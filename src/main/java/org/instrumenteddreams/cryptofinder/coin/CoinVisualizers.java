package org.instrumenteddreams.cryptofinder.coin;

import org.instrumenteddreams.cryptofinder.coin.impl.coingecko.CGConstants;
import org.instrumenteddreams.cryptofinder.coin.impl.selenium.SeleniumBrowserVisualizer;

public class CoinVisualizers {

    public static CoinVisualizer getDefault() {

	return new SeleniumBrowserVisualizer(CGConstants.COIN_GECKO_COIN_BASE_URL);
    }

}
