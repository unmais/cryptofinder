package org.instrumenteddreams.cryptofinder.coin;

import java.math.BigDecimal;

import com.litesoftwares.coingecko.domain.Coins.CoinData.Roi;
import com.litesoftwares.coingecko.domain.Coins.CoinData.SparklineIn7d;

public interface CoinBasicInfo {

    double getAth();

    double getAthChangePercentage();

    String getAthDate();

    double getAtl();

    double getAtlChangePercentage();

    String getAtlDate();

    double getCirculatingSupply();

    double getCurrentPrice();

    BigDecimal getFullyDilutedValuation();

    double getHigh24h();

    String getId();

    String getImageId();

    String getLastUpdated();

    double getLow24h();

    double getMarketCap();

    double getMarketCapChange24h();

    double getMarketCapChangePercentage24h();

    long getMarketCapRank();

    String getName();

    double getPriceChange24h();

    double getPriceChangePercentage14dInCurrency();

    double getPriceChangePercentage1hInCurrency();

    double getPriceChangePercentage1yInCurrency();

    double getPriceChangePercentage200dInCurrency();

    double getPriceChangePercentage24h();

    double getPriceChangePercentage24hInCurrency();

    double getPriceChangePercentage30dInCurrency();

    double getPriceChangePercentage7dInCurrency();

    Roi getRoi();

    SparklineIn7d getSparklineIn7d();

    String getSymbol();

    double getTotalSupply();

    double getTotalVolume();

}