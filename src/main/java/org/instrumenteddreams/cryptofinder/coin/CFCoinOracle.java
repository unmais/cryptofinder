package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

public interface CFCoinOracle {

	void start();

	boolean isStarted();

	List<CFCoin> getAllCoins(int pageNumber);

	void shutDown();

	CFCoin completeCoinInfo(CFCoin coin, CFCoin.CoinInfoType info);

	int getDefaultPageSize();

}
