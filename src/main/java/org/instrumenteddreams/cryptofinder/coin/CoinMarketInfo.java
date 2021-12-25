package org.instrumenteddreams.cryptofinder.coin;

import java.util.Map;

import com.litesoftwares.coingecko.domain.Coins.CoinData.Roi;

public interface CoinMarketInfo {

    Map<String, Double> getAth();

    Map<String, Double> getAthChangePercentage();

    Map<String, String> getAthDate();

    Map<String, Double> getAtl();

    Map<String, Double> getAtlChangePercentage();

    Map<String, String> getAtlDate();

    double getCirculatingSupply();

    Map<String, Double> getCurrentPrice();

    String getFdvToTvlRatio();

    Map<String, Long> getFullyDilutedValuation();

    Map<String, Double> getHigh24h();

    String getLastUpdated();

    Map<String, Double> getLow24h();

    Map<String, Double> getMarketCap();

    double getMarketCapChange24h();

    Map<String, Double> getMarketCapChange24hInCurrency();

    double getMarketCapChangePercentage24h();

    Map<String, Double> getMarketCapChangePercentage24hInCurrency();

    long getMarketCapRank();

    double getMaxSupply();

    String getMcapToTvlRatio();

    double getPriceChange24h();

    Map<String, Double> getPriceChange24hInCurrency();

    double getPriceChangePercentage14d();

    Map<String, Double> getPriceChangePercentage14dInCurrency();

    Map<String, Double> getPriceChangePercentage1hInCurrency();

    double getPriceChangePercentage1y();

    Map<String, Double> getPriceChangePercentage1yInCurrency();

    double getPriceChangePercentage200d();

    Map<String, Double> getPriceChangePercentage200dInCurrency();

    double getPriceChangePercentage24h();

    Map<String, Double> getPriceChangePercentage24hInCurrency();

    double getPriceChangePercentage30d();

    Map<String, Double> getPriceChangePercentage30dInCurrency();

    double getPriceChangePercentage60d();

    Map<String, Double> getPriceChangePercentage60dInCurrency();

    double getPriceChangePercentage7d();

    Map<String, Double> getPriceChangePercentage7dInCurrency();

    Roi getRoi();

    double getTotalSupply();

    Map<String, Long> getTotalValueLocked();

    Map<String, Double> getTotalVolume();

}