package org.instrumenteddreams.cryptofinder.coin;

public interface CFCoin {

	static enum CoinInfoType {
		BASIC, OVERALL, MARKET, CHART_OLHC_INFO_180D, NONE
	}

	String getId();

	CFCoinInfoBasic getCoinBasicInfo();

	CFCoinOverallInfo getCoinOverallInfo();

	CFCoinMarketInfo getCoinMarketInfo();

	CFCoinChartInfo getCoinChartInfo();

	void setCoinOverAllInfo(CFCoinOverallInfo info);

	void setCoinMarketInfo(CFCoinMarketInfo info);

	void setCoinChartInfo(CFCoinChartInfo info);

	default void assertHasInfo(CoinInfoType info) {

		boolean missingInfo = false;
		if (info == CoinInfoType.BASIC) {
			missingInfo = this.getCoinBasicInfo() == null;
		}
		if (info == CoinInfoType.OVERALL) {
			missingInfo = this.getCoinOverallInfo() == null;
		}
		if (info == CoinInfoType.MARKET) {
			missingInfo = this.getCoinMarketInfo() == null;
		}
		if (missingInfo) {
			throw new IllegalArgumentException("expected a coin having non-null " + info.toString() + " info");
		}

	}

}
