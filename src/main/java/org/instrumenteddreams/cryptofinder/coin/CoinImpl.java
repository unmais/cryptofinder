package org.instrumenteddreams.cryptofinder.coin;

public class CoinImpl implements Coin {

	private CoinInfoBasic coinBasicInfo;
	private CoinOverallInfo coinOverallInfo;
	private CoinMarketInfo coinMarketInfo;
	private CoinChartInfo coinChartInfo;

	private final String id;

	public CoinImpl(CoinInfoBasic coinBasicInfo) {

		this.id = coinBasicInfo.getId();
		this.coinBasicInfo = coinBasicInfo;
	}

	@Override
	public CoinInfoBasic getCoinBasicInfo() {

		return coinBasicInfo;
	}

	public void setCoinBasicInfo(CoinInfoBasic coinBasicInfo) {

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
