package org.instrumenteddreams.cryptofinder.coin;

public interface Coin {

	static enum Info {
		BASIC, OVERALL, MARKET, CHART_OLHC_INFO_180D, NONE
	}

	String getId();

	CoinBasicInfo getCoinBasicInfo();

	CoinOverallInfo getCoinOverallInfo();

	CoinMarketInfo getCoinMarketInfo();

	CoinChartInfo getCoinChartInfo();

	void setCoinOverAllInfo(CoinOverallInfo info);

	void setCoinMarketInfo(CoinMarketInfo info);

	void setCoinChartInfo(CoinChartInfo info);

	default void assertHasInfo(Info info) {

		boolean missingInfo = false;
		if (info == Info.BASIC) {
			missingInfo = this.getCoinBasicInfo() == null;
		}
		if (info == Info.OVERALL) {
			missingInfo = this.getCoinOverallInfo() == null;
		}
		if (info == Info.MARKET) {
			missingInfo = this.getCoinMarketInfo() == null;
		}
		if (missingInfo) {
			throw new IllegalArgumentException("expected a coin having non-null " + info.toString() + " info");
		}

	}

}
