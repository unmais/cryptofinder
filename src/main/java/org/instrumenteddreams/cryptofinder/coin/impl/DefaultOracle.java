package org.instrumenteddreams.cryptofinder.coin.impl;

import java.util.List;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinChartInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinOracle;
import org.instrumenteddreams.cryptofinder.coin.CoinOverallInfo;
import org.instrumenteddreams.cryptofinder.coin.Coin.Info;
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
	public Coin completeCoinInfo(Coin coin, Info info) {

		return coinGeckoOracle.completeCoinInfo(coin, info);
	}

	@Override
	public List<CoinBasicInfo> getCoinBasicInfos(int pageNumber) {

		return coinGeckoOracle.getCoinBasicInfos(pageNumber);
	}

	@Override
	public int getDefaultPageSize() {

		return coinGeckoOracle.getDefaultPageSize();
	}

	@Override
	public CoinOverallInfo getCoinOverallInfo(String id) {

		return coinGeckoOracle.getCoinOverallInfo(id);
	}

	@Override
	public CoinChartInfo getCoinCharInfo(String id, int days) {

		return coinGeckoOracle.getCoinCharInfo(id, days);
	}

}
