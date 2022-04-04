package org.instrumenteddreams.cryptofinder.coin;

public class CFCoinImpl implements CFCoin {

	private CFCoinInfoBasic coinBasicInfo;
	private CFCoinOverallInfo coinOverallInfo;
	private CFCoinMarketInfo coinMarketInfo;
	private CFCoinChartInfo coinChartInfo;

	private final String id;

	public CFCoinImpl(CFCoinInfoBasic coinBasicInfo) {

		this.id = coinBasicInfo.getId();
		this.coinBasicInfo = coinBasicInfo;
	}

	@Override
	public CFCoinInfoBasic getCoinBasicInfo() {

		return coinBasicInfo;
	}

	public void setCoinBasicInfo(CFCoinInfoBasic coinBasicInfo) {

		this.coinBasicInfo = coinBasicInfo;
	}

	@Override
	public CFCoinOverallInfo getCoinOverallInfo() {

		return coinOverallInfo;
	}

	public void setCoinOverallInfo(CFCoinOverallInfo coinOverallInfo) {

		this.coinOverallInfo = coinOverallInfo;
	}

	@Override
	public CFCoinMarketInfo getCoinMarketInfo() {

		return coinMarketInfo;
	}

	@Override
	public CFCoinChartInfo getCoinChartInfo() {

		return coinChartInfo;
	}

	@Override
	public void setCoinMarketInfo(CFCoinMarketInfo coinMarketInfo) {

		this.coinMarketInfo = coinMarketInfo;
	}

	@Override
	public void setCoinOverAllInfo(CFCoinOverallInfo info) {

		this.coinOverallInfo = info;

	}

	@Override
	public void setCoinChartInfo(CFCoinChartInfo coinChartInfo) {

		this.coinChartInfo = coinChartInfo;
	}

	@Override
	public String getId() {

		return id;
	}

}
