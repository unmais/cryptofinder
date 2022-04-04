package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

import org.instrumenteddreams.cryptofinder.coin.Coin.CoinInfoType;
import org.instrumenteddreams.cryptofinder.coin.impl.coingecko.CGOracle;

public class DefaultOracle implements CoinOracle {

	private CoinOracle coinGeckoOracle;

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
	public Coin completeCoinInfo(Coin coin, CoinInfoType info) {

		return coinGeckoOracle.completeCoinInfo(coin, info);
	}

	@Override
	public List<Coin> getAllCoins(int pageNumber) {

		return coinGeckoOracle.getAllCoins(pageNumber);
	}

	@Override
	public int getDefaultPageSize() {

		return coinGeckoOracle.getDefaultPageSize();
	}

}
