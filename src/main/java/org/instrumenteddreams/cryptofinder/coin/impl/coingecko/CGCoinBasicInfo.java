package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.math.BigDecimal;

import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;

import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;
import com.litesoftwares.coingecko.domain.Coins.CoinData.Roi;
import com.litesoftwares.coingecko.domain.Coins.CoinData.SparklineIn7d;

public class CGCoinBasicInfo implements CoinBasicInfo {

	private CoinMarkets coinMarketsDelegate;

	public CGCoinBasicInfo(CoinMarkets coinMarketsDelegate) {

		super();
		this.coinMarketsDelegate = coinMarketsDelegate;
	}

	public boolean equals(Object o) {

		return coinMarketsDelegate.equals(o);
	}

	public double getAth() {

		return coinMarketsDelegate.getAth();
	}

	public double getAthChangePercentage() {

		return coinMarketsDelegate.getAthChangePercentage();
	}

	public String getAthDate() {

		return coinMarketsDelegate.getAthDate();
	}

	public double getAtl() {

		return coinMarketsDelegate.getAtl();
	}

	public double getAtlChangePercentage() {

		return coinMarketsDelegate.getAtlChangePercentage();
	}

	public String getAtlDate() {

		return coinMarketsDelegate.getAtlDate();
	}

	public double getCirculatingSupply() {

		return coinMarketsDelegate.getCirculatingSupply();
	}

	public double getCurrentPrice() {

		return coinMarketsDelegate.getCurrentPrice();
	}

	public BigDecimal getFullyDilutedValuation() {

		return coinMarketsDelegate.getFullyDilutedValuation();
	}

	public double getHigh24h() {

		return coinMarketsDelegate.getHigh24h();
	}

	public String getId() {

		return coinMarketsDelegate.getId();
	}

	public String getImageId() {

		return coinMarketsDelegate.getImage();
	}

	public String getLastUpdated() {

		return coinMarketsDelegate.getLastUpdated();
	}

	public double getLow24h() {

		return coinMarketsDelegate.getLow24h();
	}

	public double getMarketCap() {

		return coinMarketsDelegate.getMarketCap();
	}

	public double getMarketCapChange24h() {

		return coinMarketsDelegate.getMarketCapChange24h();
	}

	public double getMarketCapChangePercentage24h() {

		return coinMarketsDelegate.getMarketCapChangePercentage24h();
	}

	public long getMarketCapRank() {

		return coinMarketsDelegate.getMarketCapRank();
	}

	public String getName() {

		return coinMarketsDelegate.getName();
	}

	public double getPriceChange24h() {

		return coinMarketsDelegate.getPriceChange24h();
	}

	public double getPriceChangePercentage14dInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage14dInCurrency();
	}

	public double getPriceChangePercentage1hInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage1hInCurrency();
	}

	public double getPriceChangePercentage1yInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage1yInCurrency();
	}

	public double getPriceChangePercentage200dInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage200dInCurrency();
	}

	public double getPriceChangePercentage24h() {

		return coinMarketsDelegate.getPriceChangePercentage24h();
	}

	public double getPriceChangePercentage24hInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage24hInCurrency();
	}

	public double getPriceChangePercentage30dInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage30dInCurrency();
	}

	public double getPriceChangePercentage7dInCurrency() {

		return coinMarketsDelegate.getPriceChangePercentage7dInCurrency();
	}

	public Roi getRoi() {

		return coinMarketsDelegate.getRoi();
	}

	public SparklineIn7d getSparklineIn7d() {

		return coinMarketsDelegate.getSparklineIn7d();
	}

	public String getSymbol() {

		return coinMarketsDelegate.getSymbol();
	}

	public double getTotalSupply() {

		return coinMarketsDelegate.getTotalSupply();
	}

	public double getTotalVolume() {

		return coinMarketsDelegate.getTotalVolume();
	}

	public int hashCode() {

		return coinMarketsDelegate.hashCode();
	}

	public String toString() {

		return coinMarketsDelegate.toString();
	}

}
