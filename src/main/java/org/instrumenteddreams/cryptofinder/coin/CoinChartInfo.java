package org.instrumenteddreams.cryptofinder.coin;

import java.util.List;

public interface CoinChartInfo {

	interface OhlcRecord {

		long getEpochTime();

		double getOpen();

		double getHigh();

		double getLow();

		double getClose();

		double getCloseVolume();

		double getCloseMarketCap();

	}

	List<OhlcRecord> getOhlcRecords();

}