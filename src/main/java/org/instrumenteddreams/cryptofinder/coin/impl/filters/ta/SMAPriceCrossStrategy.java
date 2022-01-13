package org.instrumenteddreams.cryptofinder.coin.impl.filters.ta;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.Coin.Info;
import org.instrumenteddreams.cryptofinder.coin.filters.FilterStrategy;

public class SMAPriceCrossStrategy implements FilterStrategy {

	private static final String COIN_BAR_CHART_NAME_SUFFIX = "_bar_chart";

	@Override
	public Info getInfoRequirementsForFiltersOfOrder(int order) {

		if (order == 2) {
			return Coin.Info.CHART_OLHC_INFO_180D;
		}

		return Coin.Info.NONE;
	}

	@Override
	public Predicate<Coin> getFiltersOfOrder(int order) {

		if (order == 2) {
			return coin -> isPassingOrder2Filters(coin);
		}

		return coin -> true;
	}

	private boolean isPassingOrder2Filters(Coin coin) {

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
