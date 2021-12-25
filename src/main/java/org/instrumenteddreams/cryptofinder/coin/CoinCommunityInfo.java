package org.instrumenteddreams.cryptofinder.coin;

public interface CoinCommunityInfo {

    long getFacebookLikes();

    double getRedditAccountsActive48h();

    double getRedditAverageComments48h();

    double getRedditAveragePosts48h();

    long getRedditSubscribers();

    long getTelegramChannelUserCount();

    long getTwitterFollowers();

}