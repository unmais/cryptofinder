package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.Map;

import org.instrumenteddreams.cryptofinder.coin.CFCoinMarketInfo;

import com.litesoftwares.coingecko.domain.Coins.MarketData;
import com.litesoftwares.coingecko.domain.Coins.CoinData.Roi;

public class CGCoinMarketInfo implements CFCoinMarketInfo {

	private final MarketData delegate;

	public CGCoinMarketInfo(MarketData delegate) {

		super();
		this.delegate = delegate;
	}

	public boolean equals(Object o) {

		return delegate.equals(o);
	}

	@Override
	public Map<String, Double> getAth() {

		return delegate.getAth();
	}

	@Override
	public Map<String, Double> getAthChangePercentage() {

		return delegate.getAthChangePercentage();
	}

	@Override
	public Map<String, String> getAthDate() {

		return delegate.getAthDate();
	}

	@Override
	public Map<String, Double> getAtl() {

		return delegate.getAtl();
	}

	@Override
	public Map<String, Double> getAtlChangePercentage() {

		return delegate.getAtlChangePercentage();
	}

	@Override
	public Map<String, String> getAtlDate() {

		return delegate.getAtlDate();
	}

	@Override
	public double getCirculatingSupply() {

		return delegate.getCirculatingSupply();
	}

	@Override
	public Map<String, Double> getCurrentPrice() {

		return delegate.getCurrentPrice();
	}

	@Override
	public String getFdvToTvlRatio() {

		return delegate.getFdvToTvlRatio();
	}

	@Override
	public Map<String, Long> getFullyDilutedValuation() {

		return delegate.getFullyDilutedValuation();
	}

	@Override
	public Map<String, Double> getHigh24h() {

		return delegate.getHigh24h();
	}

	@Override
	public String getLastUpdated() {

		return delegate.getLastUpdated();
	}

	@Override
	public Map<String, Double> getLow24h() {

		return delegate.getLow24h();
	}

	@Override
	public Map<String, Double> getMarketCap() {

		return delegate.getMarketCap();
	}

	@Override
	public double getMarketCapChange24h() {

		return delegate.getMarketCapChange24h();
	}

	@Override
	public Map<String, Double> getMarketCapChange24hInCurrency() {

		return delegate.getMarketCapChange24hInCurrency();
	}

	@Override
	public double getMarketCapChangePercentage24h() {

		return delegate.getMarketCapChangePercentage24h();
	}

	@Override
	public Map<String, Double> getMarketCapChangePercentage24hInCurrency() {

		return delegate.getMarketCapChangePercentage24hInCurrency();
	}

	@Override
	public long getMarketCapRank() {

		return delegate.getMarketCapRank();
	}

	@Override
	public double getMaxSupply() {

		return delegate.getMaxSupply();
	}

	@Override
	public String getMcapToTvlRatio() {

		return delegate.getMcapToTvlRatio();
	}

	@Override
	public double getPriceChange24h() {

		return delegate.getPriceChange24h();
	}

	@Override
	public Map<String, Double> getPriceChange24hInCurrency() {

		return delegate.getPriceChange24hInCurrency();
	}

	@Override
	public double getPriceChangePercentage14d() {

		return delegate.getPriceChangePercentage14d();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage14dInCurrency() {

		return delegate.getPriceChangePercentage14dInCurrency();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage1hInCurrency() {

		return delegate.getPriceChangePercentage1hInCurrency();
	}

	@Override
	public double getPriceChangePercentage1y() {

		return delegate.getPriceChangePercentage1y();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage1yInCurrency() {

		return delegate.getPriceChangePercentage1yInCurrency();
	}

	@Override
	public double getPriceChangePercentage200d() {

		return delegate.getPriceChangePercentage200d();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage200dInCurrency() {

		return delegate.getPriceChangePercentage200dInCurrency();
	}

	@Override
	public double getPriceChangePercentage24h() {

		return delegate.getPriceChangePercentage24h();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage24hInCurrency() {

		return delegate.getPriceChangePercentage24hInCurrency();
	}

	@Override
	public double getPriceChangePercentage30d() {

		return delegate.getPriceChangePercentage30d();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage30dInCurrency() {

		return delegate.getPriceChangePercentage30dInCurrency();
	}

	@Override
	public double getPriceChangePercentage60d() {

		return delegate.getPriceChangePercentage60d();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage60dInCurrency() {

		return delegate.getPriceChangePercentage60dInCurrency();
	}

	@Override
	public double getPriceChangePercentage7d() {

		return delegate.getPriceChangePercentage7d();
	}

	@Override
	public Map<String, Double> getPriceChangePercentage7dInCurrency() {

		return delegate.getPriceChangePercentage7dInCurrency();
	}

	@Override
	public Roi getRoi() {

		return delegate.getRoi();
	}

	@Override
	public double getTotalSupply() {

		return delegate.getTotalSupply();
	}

	@Override
	public Map<String, Long> getTotalValueLocked() {

		return delegate.getTotalValueLocked();
	}

	@Override
	public Map<String, Double> getTotalVolume() {

		return delegate.getTotalVolume();
	}

	public int hashCode() {

		return delegate.hashCode();
	}

	public String toString() {

		return delegate.toString();
	}

}
