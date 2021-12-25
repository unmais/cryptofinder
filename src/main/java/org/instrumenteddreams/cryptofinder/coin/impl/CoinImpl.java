package org.instrumenteddreams.cryptofinder.coin.impl;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinChartInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinMarketInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinOverallInfo;

public class CoinImpl implements Coin {

    private CoinBasicInfo coinBasicInfo;
    private CoinOverallInfo coinOverallInfo;
    private CoinMarketInfo coinMarketInfo;
    private CoinChartInfo coinChartInfo;

    private final String id;

    public CoinImpl(CoinBasicInfo coinBasicInfo) {

	this.id = coinBasicInfo.getId();
	this.coinBasicInfo = coinBasicInfo;
    }

    @Override
    public CoinBasicInfo getCoinBasicInfo() {

	return coinBasicInfo;
    }

    public void setCoinBasicInfo(CoinBasicInfo coinBasicInfo) {

	this.coinBasicInfo = coinBasicInfo;
    }

    @Override
    public CoinOverallInfo getCoinOverallInfo() {

	return coinOverallInfo;
    }

    public void setCoinOverallInfo(CoinOverallInfo coinOverallInfo) {

	this.coinOverallInfo = coinOverallInfo;
    }

    @Override
    public CoinMarketInfo getCoinMarketInfo() {

	return coinMarketInfo;
    }

    @Override
    public CoinChartInfo getCoinChartInfo() {

	return coinChartInfo;
    }

    @Override
    public void setCoinMarketInfo(CoinMarketInfo coinMarketInfo) {

	this.coinMarketInfo = coinMarketInfo;
    }

    @Override
    public void setCoinOverAllInfo(CoinOverallInfo info) {

	this.coinOverallInfo = info;

    }

    @Override
    public void setCoinChartInfo(CoinChartInfo coinChartInfo) {

	this.coinChartInfo = coinChartInfo;
    }

    @Override
    public String getId() {

	return id;
    }

}
