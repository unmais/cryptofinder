package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.List;
import java.util.Objects;

import org.instrumenteddreams.cryptofinder.coin.CoinChartInfo;
import org.instrumenteddreams.cryptofinder.coin.impl.OhlcRecordImpl;

import com.beust.jcommander.internal.Lists;
import com.litesoftwares.coingecko.domain.Coins.MarketChart;
import com.litesoftwares.coingecko.domain.Coins.OhlcSample;

public class CGCoinChartInfo implements CoinChartInfo {

	private static final int OHLC_DATA_PERIOD_IN_DAYS = 4;

	private MarketChart chartInfoDelegate;

	private List<OhlcRecord> ohlcInfos;

	public static CGCoinChartInfo fromChartData(MarketChart chartInfoDelegate, OhlcSample[] ohlcSamples, int days) {

		int numberOfOhlcs = ohlcSamples.length;

		List<OhlcRecord> ohlcInfos = Lists.newArrayList(numberOfOhlcs);

		int indexOfFirstOhlcInChar = findFirstTimeOccurrenceIndex(ohlcSamples[0].getTime(),
				chartInfoDelegate.getPrices(), OHLC_DATA_PERIOD_IN_DAYS);

		for (int i = 0; i < ohlcSamples.length; i++) {
			List<String> closingCap = chartInfoDelegate.getMarketCaps().get(i + indexOfFirstOhlcInChar);
			List<String> closingVolume = chartInfoDelegate.getTotalVolumes().get(i + indexOfFirstOhlcInChar);
			ohlcInfos.add(i, buildOhlcInfo(ohlcSamples[i], closingCap, closingVolume));
		}

		return new CGCoinChartInfo(ohlcInfos);
	}

	@Override
	public int hashCode() {

		return Objects.hash(chartInfoDelegate, ohlcInfos);
	}

	@Override
	public List<OhlcRecord> getOhlcRecords() {

		return ohlcInfos;
	}

	private CGCoinChartInfo(List<OhlcRecord> ohlcInfos) {

		this.ohlcInfos = ohlcInfos;
	}

	private static OhlcRecordImpl buildOhlcInfo(OhlcSample ohlcSample, List<String> closingCap,
			List<String> closingVolume) {

		return new OhlcRecordImpl(Long.valueOf(ohlcSample.getTime()), Double.valueOf(ohlcSample.getOpen()),
				Double.valueOf(ohlcSample.getHigh()), Double.valueOf(ohlcSample.getLow()),
				Double.valueOf(ohlcSample.getClose()), Double.valueOf(closingCap.get(1)),
				Double.valueOf(closingVolume.get(1)));
	}

	private static int findFirstTimeOccurrenceIndex(String time, List<List<String>> prices, int maxIndex) {

		for (int i = 0; i < maxIndex; i++) {
			String priceTime = prices.get(i).get(0);
			if (priceTime.equals(time)) {
				return i;
			}
		}
		throw new IllegalArgumentException(
				"date " + time + "not found in first " + OHLC_DATA_PERIOD_IN_DAYS + " prices");
	}

}
