package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

public interface CoinOracle {

	void start();

	boolean isStarted();

	List<Coin> getAllCoins(int pageNumber);

	void shutDown();

	Coin completeCoinInfo(Coin coin, Coin.CoinInfoType info);

	int getDefaultPageSize();

}
