package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.List;

import org.instrumenteddreams.cryptofinder.coin.CFCoinResources;

import com.litesoftwares.coingecko.domain.Coins.CoinData.Links;
import com.litesoftwares.coingecko.domain.Coins.CoinData.ReposUrl;

public class CGCoinResources implements CFCoinResources {

	private final Links delegate;

	public CGCoinResources(Links delegate) {

		this.delegate = delegate;
	}

	public boolean equals(Object o) {

		return delegate.equals(o);
	}

	@Override
	public List<String> getAnnouncementUrl() {

		return delegate.getAnnouncementUrl();
	}

	@Override
	public Object getBitcointalkThreadIdentifier() {

		return delegate.getBitcointalkThreadIdentifier();
	}

	@Override
	public List<String> getBlockchainSite() {

		return delegate.getBlockchainSite();
	}

	@Override
	public List<String> getChatUrl() {

		return delegate.getChatUrl();
	}

	@Override
	public String getFacebookUsername() {

		return delegate.getFacebookUsername();
	}

	@Override
	public List<String> getHomepage() {

		return delegate.getHomepage();
	}

	@Override
	public List<String> getOfficialForumUrl() {

		return delegate.getOfficialForumUrl();
	}

	@Override
	public ReposUrl getReposUrl() {

		return delegate.getReposUrl();
	}

	@Override
	public String getSubredditUrl() {

		return delegate.getSubredditUrl();
	}

	@Override
	public String getTelegramChannelIdentifier() {

		return delegate.getTelegramChannelIdentifier();
	}

	@Override
	public String getTwitterScreenName() {

		return delegate.getTwitterScreenName();
	}

	public int hashCode() {

		return delegate.hashCode();
	}

	@Override
	public String toString() {

		return delegate.toString();
	}

}
