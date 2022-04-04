package org.instrumenteddreams.cryptofinder.coin;

public interface Coin {

	static enum CoinInfoType {
		BASIC, OVERALL, MARKET, CHART_OLHC_INFO_180D, NONE
	}

	String getId();

	CoinInfoBasic getCoinBasicInfo();

	CoinOverallInfo getCoinOverallInfo();

	CoinMarketInfo getCoinMarketInfo();

	CoinChartInfo getCoinChartInfo();

	void setCoinOverAllInfo(CoinOverallInfo info);

	void setCoinMarketInfo(CoinMarketInfo info);

	void setCoinChartInfo(CoinChartInfo info);

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
