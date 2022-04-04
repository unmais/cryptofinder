package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.List;
import java.util.Map;

import org.instrumenteddreams.cryptofinder.coin.CFCoinCommunityInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinDeveloperInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinIcoInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinOtherScores;
import org.instrumenteddreams.cryptofinder.coin.CFCoinOverallInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinPicture;
import org.instrumenteddreams.cryptofinder.coin.CFCoinResources;

import com.litesoftwares.coingecko.domain.Coins.CoinFullData;
import com.litesoftwares.coingecko.domain.Coins.MarketData;
import com.litesoftwares.coingecko.domain.Shared.Ticker;

public class CGOCoinOverallInfo implements CFCoinOverallInfo {

	private final CoinFullData delegate;

	public CGOCoinOverallInfo(CoinFullData delegate) {

		super();
		this.delegate = delegate;
	}

	public boolean equals(Object o) {

		return delegate.equals(o);
	}

	public List<String> getAdditionalNotices() {

		return delegate.getAdditionalNotices();
	}

	public String getAssetPlatformId() {

		return delegate.getAssetPlatformId();
	}

	public long getBlockTimeInMinutes() {

		return delegate.getBlockTimeInMinutes();
	}

	public List<Object> getCategories() {

		return delegate.getCategories();
	}

	public long getCoingeckoRank() {

		return delegate.getCoingeckoRank();
	}

	public double getCoingeckoScore() {

		return delegate.getCoingeckoScore();
	}

	public CFCoinCommunityInfo getCommunityInfo() {

		return new CGCoinCommunityInfo(delegate.getCommunityData());
	}

	public double getCommunityScore() {

		return delegate.getCommunityScore();
	}

	public String getContractAddress() {

		return delegate.getContractAddress();
	}

	public String getCountryOrigin() {

		return delegate.getCountryOrigin();
	}

	public Map<String, String> getDescription() {

		return delegate.getDescription();
	}

	public CFCoinDeveloperInfo getDeveloperInfo() {

		return new CGCoinDeveloperInfo(delegate.getDeveloperData());
	}

	public double getDeveloperScore() {

		return delegate.getDeveloperScore();
	}

	public String getGenesisDate() {

		return delegate.getGenesisDate();
	}

	public String getHashingAlgorithm() {

		return delegate.getHashingAlgorithm();
	}

	public CFCoinIcoInfo getIcoInfo() {

		return new CGCoinIcoInfo(delegate.getIcoData());
	}

	public String getId() {

		return delegate.getId();
	}

	public CFCoinPicture getPicture() {

		return new CGCoinPicture(delegate.getImage());
	}

	public String getLastUpdated() {

		return delegate.getLastUpdated();
	}

	public CFCoinResources getResources() {

		return new CGCoinResources(delegate.getLinks());
	}

	public double getLiquidityScore() {

		return delegate.getLiquidityScore();
	}

	public Map<String, String> getLocalization() {

		return delegate.getLocalization();
	}

	public long getMarketCapRank() {

		return delegate.getMarketCapRank();
	}

	public MarketData getMarketData() {

		return delegate.getMarketData();
	}

	public String getName() {

		return delegate.getName();
	}

	public Map<String, String> getPlatforms() {

		return delegate.getPlatforms();
	}

	public double getPublicInterestScore() {

		return delegate.getPublicInterestScore();
	}

	public CFCoinOtherScores getOtherScores() {

		return new CGCoinOtherScores(delegate.getPublicInterestStats());
	}

	public String getPublicNotice() {

		return delegate.getPublicNotice();
	}

	public double getSentimentVotesDownPercentage() {

		return delegate.getSentimentVotesDownPercentage();
	}

	public double getSentimentVotesUpPercentage() {

		return delegate.getSentimentVotesUpPercentage();
	}

	public List<Object> getStatusUpdates() {

		return delegate.getStatusUpdates();
	}

	public String getSymbol() {

		return delegate.getSymbol();
	}

	public List<Ticker> getTickers() {

		return delegate.getTickers();
	}

	public int hashCode() {

		return delegate.hashCode();
	}

	public String toString() {

		return delegate.toString();
	}

}
