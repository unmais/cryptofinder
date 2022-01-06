package org.instrumenteddreams.cryptofinder.utils;

import java.time.LocalDateTime;
import java.util.Optional;

import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinStandardPeriod;
import org.instrumenteddreams.cryptofinder.math.timeseries.UnivariateTimeSeries;

public class CoinUtils {

	private static final short NUMBER_OF_COIN_STANDARD_PERIODS = 7;

	public static UnivariateTimeSeries getStandardPriceTimeSeries(CoinBasicInfo coin) {

		LocalDateTime currentPriceDateTime = DateTimeUtils.parseLocalDateTime(coin.getLastUpdated());

		long[] coinTimes = new long[NUMBER_OF_COIN_STANDARD_PERIODS + 1];
		double[] coinPriceValues = new double[NUMBER_OF_COIN_STANDARD_PERIODS + 1];

		coinTimes[0] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_1Y);
		coinPriceValues[0] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage1yInCurrency());

		coinTimes[1] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_200D);
		coinPriceValues[1] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage200dInCurrency());

		coinTimes[2] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_30D);
		coinPriceValues[2] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage30dInCurrency());

		coinTimes[3] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_14d);
		coinPriceValues[3] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage14dInCurrency());

		coinTimes[4] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_7D);
		coinPriceValues[4] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage7dInCurrency());

		coinTimes[5] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_24H);
		coinPriceValues[5] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage24hInCurrency());

		coinTimes[6] = getLatestPeriodStartEpochTime(coin, CoinStandardPeriod.PERIOD_1H);
		coinPriceValues[6] = coin.getCurrentPrice() * (1 - coin.getPriceChangePercentage1hInCurrency());

		coinTimes[7] = DateTimeUtils.toEpochTime(currentPriceDateTime);
		coinPriceValues[7] = coin.getCurrentPrice();

		return new UnivariateTimeSeries(coinTimes, coinPriceValues);
	}

	public static Optional<UnivariateTimeSeries> getStandardPriceTimeSeriesForLatestPeriod(CoinBasicInfo coin,
			CoinStandardPeriod latestPeriod) {

		UnivariateTimeSeries standardPriceTimeSeries = getStandardPriceTimeSeries(coin);
		double fromEpochTime = getLatestPeriodStartEpochTime(coin, latestPeriod);
		return standardPriceTimeSeries.getSubSeries(fromEpochTime);
	}

	public static long getLatestPeriodStartEpochTime(CoinBasicInfo coin, CoinStandardPeriod period) {

		LocalDateTime currentPriceDateTime = DateTimeUtils.parseLocalDateTime(coin.getLastUpdated());
		return DateTimeUtils.getPeriodStartEpochTime(currentPriceDateTime, period);

	}

	public static long getAtlEpochTime(CoinBasicInfo coin) {

		return DateTimeUtils.parseEpochTime(coin.getAtlDate());
	}

	public static long getAthEpochTime(CoinBasicInfo coin) {

		return DateTimeUtils.parseEpochTime(coin.getAthDate());
	}

}
