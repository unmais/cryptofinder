package org.instrumenteddreams.cryptofinder.coin.impl.filters.ta;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.CFCoin;
import org.instrumenteddreams.cryptofinder.coin.CFCoin.CoinInfoType;

public class SMAPriceCrossCoinFilter {

	private static final String COIN_BAR_CHART_NAME_SUFFIX = "_bar_chart";

	public CoinInfoType getInfoRequirementsForFiltersOfOrder() {

		return CoinInfoType.CHART_OLHC_INFO_180D;
	}

	public Predicate<CFCoin> asPredicate() {

		return coin -> isPassingOrder2Filters(coin);
	}

	private boolean isPassingOrder2Filters(CFCoin coin) {

		throw new UnsupportedOperationException();
//	BarSeries series = new BaseBarSeriesBuilder().withName(coin.getId() + COIN_BAR_CHART_NAME_SUFFIX).build();
//
//	for (OhlcSampleInfo ohlcSample : coin.getCoinChartInfo().getOhlcInfos()) {
//	    series.addBar(DateTimeUtils.toUtcZonedDateTime(ohlcSample.getEpochTime()), ohlcSample.getOpen(),
//		    ohlcSample.getHigh(), ohlcSample.getLow(), ohlcSample.getClose(), ohlcSample.getCloseVolume());
//	}
//
//	ClosePriceIndicator closePrice = new ClosePriceIndicator(series);
//	SMAIndicator shortSma = new SMAIndicator(closePrice, 10);
//	System.out.println(
//		"10-ticks-SMA value at the last index: " + shortSma.getValue(series.getEndIndex()).doubleValue());
//	return true;
	}

}
