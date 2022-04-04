package org.instrumenteddreams.cryptofinder.coin;

import org.instrumenteddreams.cryptofinder.coin.impl.coingecko.CGConstants;
import org.instrumenteddreams.cryptofinder.coin.impl.selenium.SeleniumBrowserVisualizer;

public class CFCoinVisualizers {

	public static CFCoinVisualizer getDefault() {

		return new SeleniumBrowserVisualizer(CGConstants.COIN_GECKO_COIN_BASE_URL);
	}

}
