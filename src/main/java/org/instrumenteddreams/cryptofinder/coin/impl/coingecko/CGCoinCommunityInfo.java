package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import org.instrumenteddreams.cryptofinder.coin.CFCoinCommunityInfo;

import com.litesoftwares.coingecko.domain.Coins.CoinData.CommunityData;

public class CGCoinCommunityInfo implements CFCoinCommunityInfo {

	private final CommunityData delegate;

	public CGCoinCommunityInfo(CommunityData delegate) {

		super();
		this.delegate = delegate;
	}

	@Override
	public long getFacebookLikes() {

		return delegate.getFacebookLikes();
	}

	@Override
	public double getRedditAccountsActive48h() {

		return delegate.getRedditAccountsActive48h();
	}

	@Override
	public double getRedditAverageComments48h() {

		return delegate.getRedditAverageComments48h();
	}

	@Override
	public double getRedditAveragePosts48h() {

		return delegate.getRedditAveragePosts48h();
	}

	@Override
	public long getRedditSubscribers() {

		return delegate.getRedditSubscribers();
	}

	@Override
	public long getTelegramChannelUserCount() {

		return delegate.getTelegramChannelUserCount();
	}

	@Override
	public long getTwitterFollowers() {

		return delegate.getTwitterFollowers();
	}

	public int hashCode() {

		return delegate.hashCode();
	}

	public String toString() {

		return delegate.toString();
	}

}
