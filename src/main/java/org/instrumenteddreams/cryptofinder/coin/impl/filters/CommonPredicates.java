package org.instrumenteddreams.cryptofinder.coin.impl.filters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinStandardPeriod;
import org.instrumenteddreams.cryptofinder.math.timeseries.UnivariateTimeSeries;
import org.instrumenteddreams.cryptofinder.math.timeseries.predicates.TimeSeriesTester;
import org.instrumenteddreams.cryptofinder.utils.CoinUtils;
import org.instrumenteddreams.cryptofinder.utils.DateTimeUtils;

/**
 * Exercises predicates over coins.
 * 
 * @author janusik
 *
 */
public class CommonPredicates {

	public static boolean isPriceInDollarRange(CoinBasicInfo coin, double min, double max) {

		return coin.getCurrentPrice() >= min && coin.getCurrentPrice() <= max;
	}

	public static boolean isCurrentValuationUnknownOrMoreThanPercentageOfDillutedValuation(CoinBasicInfo coin,
			double percentage) {

		if (coin.getFullyDilutedValuation() == null) {
			return true;
		}
		BigDecimal fullyDillutedValuationPercentage = coin.getFullyDilutedValuation()
				.multiply(new BigDecimal(percentage));
		BigDecimal currentValuation = new BigDecimal(coin.getMarketCap());
		int comparisonResult = currentValuation.compareTo(fullyDillutedValuationPercentage);

		return comparisonResult > 0;
	}

	public static boolean isCirculatingMarketCapUnknownOrMoreThanPercentageOfTotalCap(CoinBasicInfo coin,
			double percentage) {

		if (coin.getCirculatingSupply() <= 0) {
			return true;
		}
		return coin.getCirculatingSupply() * coin.getCurrentPrice() > percentage * coin.getMarketCap();
	}

	public static boolean isAtlHappenedBeforeLatestPeriod(CoinBasicInfo coin, CoinStandardPeriod latestPeriod) {

		long latestPeriodStartEpochTime = CoinUtils.getLatestPeriodStartEpochTime(coin, latestPeriod);
		long atlEpochTime = CoinUtils.getAtlEpochTime(coin);

		return latestPeriodStartEpochTime > atlEpochTime;
	}

	public static boolean isAthHappenedBeforeLatestPeriod(CoinBasicInfo coin, CoinStandardPeriod latestPeriod) {

		long latestPeriodStartEpochTime = CoinUtils.getLatestPeriodStartEpochTime(coin, latestPeriod);
		long atlEpochTime = CoinUtils.getAtlEpochTime(coin);

		return latestPeriodStartEpochTime > atlEpochTime;
	}

	public static boolean isAtlHappenedBeforeDateTime(CoinBasicInfo coin, LocalDateTime dateTime) {

		LocalDateTime atlDateTime = DateTimeUtils.parseLocalDateTime(coin.getAtlDate());
		return dateTime.isAfter(atlDateTime);
	}

	public static boolean isGoinUpInLatestPeriod(CoinBasicInfo coin, CoinStandardPeriod latestPeriod) {

		Optional<UnivariateTimeSeries> priceLatestPeriodSeries = CoinUtils
				.getStandardPriceTimeSeriesForLatestPeriod(coin, latestPeriod);
		if (priceLatestPeriodSeries.isEmpty()) {
			throw new IllegalArgumentException("no time series found for coin and period");
		}

		return TimeSeriesTester.isMonotonic(priceLatestPeriodSeries.get(), true);
	}

	public static boolean isPriceGoingUpAfterConsolidation() {

		throw new UnsupportedOperationException();
	}

	public static boolean isBrokenAthAtLeastSoManyTimesInPeriod(int times, LocalDateTime startTime,
			LocalDateTime endTime) {

		throw new UnsupportedOperationException();
	}

	public static boolean isPercentOfMarketCapInWhaleHands(double percentage, short numberOfWhales) {

		throw new UnsupportedOperationException();
	}

	public static boolean isPriceDrivenByWhales() {

		throw new UnsupportedOperationException();
	}

	public static boolean isInPumpAndDumpCyclic() {

		throw new UnsupportedOperationException();
	}

	public static boolean isPriceResistingWhenBtcOrIndexesGoDown() {

		throw new UnsupportedOperationException();
	}

}
