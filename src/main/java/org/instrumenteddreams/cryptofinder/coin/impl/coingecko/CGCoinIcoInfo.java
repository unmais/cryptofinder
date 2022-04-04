package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import org.instrumenteddreams.cryptofinder.coin.CFCoinIcoInfo;

import com.litesoftwares.coingecko.domain.Coins.CoinData.IcoData;
import com.litesoftwares.coingecko.domain.Coins.CoinData.Links_;

public class CGCoinIcoInfo implements CFCoinIcoInfo {

	private final IcoData icoData;

	public CGCoinIcoInfo(IcoData icoData) {

		super();
		this.icoData = icoData;
	}

	public boolean equals(Object o) {

		return icoData.equals(o);
	}

	@Override
	public String getAcceptingCurrencies() {

		return icoData.getAcceptingCurrencies();
	}

	@Override
	public Object getAmountForSale() {

		return icoData.getAmountForSale();
	}

	@Override
	public Object getBasePreSaleAmount() {

		return icoData.getBasePreSaleAmount();
	}

	@Override
	public String getBasePublicSaleAmount() {

		return icoData.getBasePublicSaleAmount();
	}

	@Override
	public String getBountyDetailUrl() {

		return icoData.getBountyDetailUrl();
	}

	@Override
	public String getCountryOrigin() {

		return icoData.getCountryOrigin();
	}

	@Override
	public String getDescription() {

		return icoData.getDescription();
	}

	@Override
	public Object getHardcapAmount() {

		return icoData.getHardcapAmount();
	}

	@Override
	public String getHardcapCurrency() {

		return icoData.getHardcapCurrency();
	}

	@Override
	public String getIcoEndDate() {

		return icoData.getIcoEndDate();
	}

	@Override
	public String getIcoStartDate() {

		return icoData.getIcoStartDate();
	}

	@Override
	public Links_ getLinks() {

		return icoData.getLinks();
	}

	@Override
	public Object getPreSaleAvailable() {

		return icoData.getPreSaleAvailable();
	}

	@Override
	public Object getPreSaleEndDate() {

		return icoData.getPreSaleEndDate();
	}

	@Override
	public Object getPreSaleStartDate() {

		return icoData.getPreSaleStartDate();
	}

	@Override
	public Object getQuotePreSaleAmount() {

		return icoData.getQuotePreSaleAmount();
	}

	@Override
	public String getQuotePreSaleCurrency() {

		return icoData.getQuotePreSaleCurrency();
	}

	@Override
	public String getQuotePublicSaleAmount() {

		return icoData.getQuotePublicSaleAmount();
	}

	@Override
	public String getQuotePublicSaleCurrency() {

		return icoData.getQuotePublicSaleCurrency();
	}

	@Override
	public String getShortDesc() {

		return icoData.getShortDesc();
	}

	@Override
	public Object getSoftcapAmount() {

		return icoData.getSoftcapAmount();
	}

	@Override
	public String getSoftcapCurrency() {

		return icoData.getSoftcapCurrency();
	}

	@Override
	public Object getTotalRaised() {

		return icoData.getTotalRaised();
	}

	@Override
	public String getTotalRaisedCurrency() {

		return icoData.getTotalRaisedCurrency();
	}

	@Override
	public Object getWhitelistAvailable() {

		return icoData.getWhitelistAvailable();
	}

	@Override
	public Object getWhitelistEndDate() {

		return icoData.getWhitelistEndDate();
	}

	@Override
	public Object getWhitelistStartDate() {

		return icoData.getWhitelistStartDate();
	}

	@Override
	public String getWhitelistUrl() {

		return icoData.getWhitelistUrl();
	}

	public int hashCode() {

		return icoData.hashCode();
	}

	@Override
	public boolean isKycRequired() {

		return icoData.isKycRequired();
	}

	@Override
	public boolean isPreSaleEnded() {

		return icoData.isPreSaleEnded();
	}

	public String toString() {

		return icoData.toString();
	}

}
