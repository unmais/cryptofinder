package org.instrumenteddreams.cryptofinder.coin;

public class CoinTwitterState {

    private String twitterName;
    private int numberOfFollowers;
    private int numberOfFollowersInLast30Days;

    public CoinTwitterState(String twitterName, int numberOfFollowers, int numberOfFollowersInLast30Days) {

	this.twitterName = twitterName;
	this.numberOfFollowers = numberOfFollowers;
	this.numberOfFollowersInLast30Days = numberOfFollowersInLast30Days;
    }

    public String getTwitterName() {

	return twitterName;
    }

    public int getNumberOfFollowers() {

	return numberOfFollowers;
    }

    public int getNumberOfFollowersInLast30Days() {

	return numberOfFollowersInLast30Days;
    }

}
