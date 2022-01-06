package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import org.instrumenteddreams.cryptofinder.coin.CoinOtherScores;

import com.litesoftwares.coingecko.domain.Coins.CoinData.PublicInterestStats;

public class CGCoinOtherScores implements CoinOtherScores {

	private final PublicInterestStats delegate;

	public CGCoinOtherScores(PublicInterestStats delegate) {

		this.delegate = delegate;
	}

	public boolean equals(Object o) {

		return delegate.equals(o);
	}

	@Override
	public long getAlexaRank() {

		return delegate.getAlexaRank();
	}

	@Override
	public long getBingMatches() {

		return delegate.getBingMatches();
	}

	public int hashCode() {

		return delegate.hashCode();
	}

	public String toString() {

		return delegate.toString();
	}

}
