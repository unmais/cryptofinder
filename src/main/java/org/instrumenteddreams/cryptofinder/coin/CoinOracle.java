package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

public interface CoinOracle {

    void start();

    boolean isStarted();

    List<CoinBasicInfo> getCoinBasicInfos(int pageNumber);

    CoinOverallInfo getCoinOverallInfo(String id);

    void shutDown();

    Coin completeCoinInfo(Coin coin, Coin.Info info);

    int getDefaultPageSize();

    CoinChartInfo getCoinCharInfo(String id, int days);

}
