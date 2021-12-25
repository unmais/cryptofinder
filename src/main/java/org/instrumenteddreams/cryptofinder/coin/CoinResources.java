package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

import com.litesoftwares.coingecko.domain.Coins.CoinData.ReposUrl;

public interface CoinResources {

    List<String> getAnnouncementUrl();

    Object getBitcointalkThreadIdentifier();

    List<String> getBlockchainSite();

    List<String> getChatUrl();

    String getFacebookUsername();

    List<String> getHomepage();

    List<String> getOfficialForumUrl();

    ReposUrl getReposUrl();

    String getSubredditUrl();

    String getTelegramChannelIdentifier();

    String getTwitterScreenName();

    String toString();

}