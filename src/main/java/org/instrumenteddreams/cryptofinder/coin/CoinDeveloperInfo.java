package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

import com.litesoftwares.coingecko.domain.Coins.CoinData.CodeAdditionsDeletions4Weeks;

public interface CoinDeveloperInfo {

	long getClosedIssues();

	CodeAdditionsDeletions4Weeks getCodeAdditionsDeletions4Weeks();

	long getCommitCount4Weeks();

	long getForks();

	List<Long> getLast4WeeksCommitActivitySeries();

	long getPullRequestContributors();

	long getPullRequestsMerged();

	long getStars();

	long getSubscribers();

	long getTotalIssues();

}