package org.instrumenteddreams.cryptofinder.coin;

import com.litesoftwares.coingecko.domain.Coins.CoinData.Links_;

public interface CFCoinIcoInfo {

	String getAcceptingCurrencies();

	Object getAmountForSale();

	Object getBasePreSaleAmount();

	String getBasePublicSaleAmount();

	String getBountyDetailUrl();

	String getCountryOrigin();

	String getDescription();

	Object getHardcapAmount();

	String getHardcapCurrency();

	String getIcoEndDate();

	String getIcoStartDate();

	Links_ getLinks();

	Object getPreSaleAvailable();

	Object getPreSaleEndDate();

	Object getPreSaleStartDate();

	Object getQuotePreSaleAmount();

	String getQuotePreSaleCurrency();

	String getQuotePublicSaleAmount();

	String getQuotePublicSaleCurrency();

	String getShortDesc();

	Object getSoftcapAmount();

	String getSoftcapCurrency();

	Object getTotalRaised();

	String getTotalRaisedCurrency();

	Object getWhitelistAvailable();

	Object getWhitelistEndDate();

	Object getWhitelistStartDate();

	String getWhitelistUrl();

	boolean isKycRequired();

	boolean isPreSaleEnded();

}