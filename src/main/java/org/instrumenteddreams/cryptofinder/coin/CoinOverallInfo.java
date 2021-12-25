package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;
import java.util.Map;

import com.litesoftwares.coingecko.domain.Coins.MarketData;
import com.litesoftwares.coingecko.domain.Shared.Ticker;

public interface CoinOverallInfo {

    List<String> getAdditionalNotices();

    String getAssetPlatformId();

    long getBlockTimeInMinutes();

    List<Object> getCategories();

    long getCoingeckoRank();

    double getCoingeckoScore();

    CoinCommunityInfo getCommunityInfo();

    double getCommunityScore();

    String getContractAddress();

    String getCountryOrigin();

    Map<String, String> getDescription();

    CoinDeveloperInfo getDeveloperInfo();

    double getDeveloperScore();

    String getGenesisDate();

    String getHashingAlgorithm();

    CoinIcoInfo getIcoInfo();

    CoinPicture getPicture();

    CoinResources getResources();

    double getLiquidityScore();

    Map<String, String> getLocalization();

    MarketData getMarketData();

    Map<String, String> getPlatforms();

    double getPublicInterestScore();

    CoinOtherScores getOtherScores();

    String getPublicNotice();

    double getSentimentVotesDownPercentage();

    double getSentimentVotesUpPercentage();

    List<Object> getStatusUpdates();

    List<Ticker> getTickers();

}