package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

import org.instrumenteddreams.cryptofinder.coin.CFCoin.CoinInfoType;
import org.instrumenteddreams.cryptofinder.coin.impl.coingecko.CGOracle;

public class CFDefaultOracle implements CFCoinOracle {

	private CFCoinOracle coinGeckoOracle;

	@Override
	public void start() {

		coinGeckoOracle = new CGOracle();
		coinGeckoOracle.start();
	}

	@Override
	public void shutDown() {

		coinGeckoOracle.shutDown();
	}

	@Override
	public boolean isStarted() {

		return coinGeckoOracle.isStarted();
	}

	@Override
	public CFCoin completeCoinInfo(CFCoin coin, CoinInfoType info) {

		return coinGeckoOracle.completeCoinInfo(coin, info);
	}

	@Override
	public List<CFCoin> getAllCoins(int pageNumber) {

		return coinGeckoOracle.getAllCoins(pageNumber);
	}

	@Override
	public int getDefaultPageSize() {

		return coinGeckoOracle.getDefaultPageSize();
	}

}
