package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.List;

import org.instrumenteddreams.cryptofinder.coin.CFCoinDeveloperInfo;

import com.litesoftwares.coingecko.domain.Coins.CoinData.CodeAdditionsDeletions4Weeks;
import com.litesoftwares.coingecko.domain.Coins.CoinData.DeveloperData;

public class CGCoinDeveloperInfo implements CFCoinDeveloperInfo {

	private final DeveloperData developerData;

	public CGCoinDeveloperInfo(DeveloperData developerData) {

		super();
		this.developerData = developerData;
	}

	public boolean equals(Object o) {

		return developerData.equals(o);
	}

	@Override
	public long getClosedIssues() {

		return developerData.getClosedIssues();
	}

	@Override
	public CodeAdditionsDeletions4Weeks getCodeAdditionsDeletions4Weeks() {

		return developerData.getCodeAdditionsDeletions4Weeks();
	}

	@Override
	public long getCommitCount4Weeks() {

		return developerData.getCommitCount4Weeks();
	}

	@Override
	public long getForks() {

		return developerData.getForks();
	}

	@Override
	public List<Long> getLast4WeeksCommitActivitySeries() {

		return developerData.getLast4WeeksCommitActivitySeries();
	}

	@Override
	public long getPullRequestContributors() {

		return developerData.getPullRequestContributors();
	}

	@Override
	public long getPullRequestsMerged() {

		return developerData.getPullRequestsMerged();
	}

	@Override
	public long getStars() {

		return developerData.getStars();
	}

	@Override
	public long getSubscribers() {

		return developerData.getSubscribers();
	}

	@Override
	public long getTotalIssues() {

		return developerData.getTotalIssues();
	}

	public int hashCode() {

		return developerData.hashCode();
	}

	public String toString() {

		return developerData.toString();
	}

}
