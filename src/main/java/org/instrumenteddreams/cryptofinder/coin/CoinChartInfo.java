package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

public interface CoinChartInfo {

	public interface OhlcSampleInfo {

		long getEpochTime();

		double getOpen();

		double getHigh();

		double getLow();

		double getClose();

		double getCloseVolume();

		double getCloseMarketCap();

	}

	List<OhlcSampleInfo> getOhlcInfos();

}