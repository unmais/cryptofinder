package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;
import java.util.Map;

import com.litesoftwares.coingecko.domain.Coins.MarketData;
import com.litesoftwares.coingecko.domain.Shared.Ticker;

public interface CFCoinOverallInfo {

	List<String> getAdditionalNotices();

	String getAssetPlatformId();

	long getBlockTimeInMinutes();

	List<Object> getCategories();

	long getCoingeckoRank();

	double getCoingeckoScore();

	CFCoinCommunityInfo getCommunityInfo();

	double getCommunityScore();

	String getContractAddress();

	String getCountryOrigin();

	Map<String, String> getDescription();

	CFCoinDeveloperInfo getDeveloperInfo();

	double getDeveloperScore();

	String getGenesisDate();

	String getHashingAlgorithm();

	CFCoinIcoInfo getIcoInfo();

	CFCoinPicture getPicture();

	CFCoinResources getResources();

	double getLiquidityScore();

	Map<String, String> getLocalization();

	MarketData getMarketData();

	Map<String, String> getPlatforms();

	double getPublicInterestScore();

	CFCoinOtherScores getOtherScores();

	String getPublicNotice();

	double getSentimentVotesDownPercentage();

	double getSentimentVotesUpPercentage();

	List<Object> getStatusUpdates();

	List<Ticker> getTickers();

}