package org.instrumenteddreams.cryptofinder.coin;

import org.instrumenteddreams.cryptofinder.coin.CoinChartInfo.OhlcRecord;

public class OhlcRecordImpl implements OhlcRecord {

	private final long epochTime;

	private final double open;

	private final double high;

	private final double low;

	private final double close;

	private final double closeVolume;

	private final double closeMarketCap;

	public OhlcRecordImpl(long epochTime, double open, double high, double low, double close, double closeVolume,
			double closeMarketCap) {

		super();
		this.epochTime = epochTime;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.closeVolume = closeVolume;
		this.closeMarketCap = closeMarketCap;
	}

	@Override
	public long getEpochTime() {

		return epochTime;
	}

	@Override
	public double getOpen() {

		return open;
	}

	@Override
	public double getHigh() {

		return high;
	}

	@Override
	public double getLow() {

		return low;
	}

	@Override
	public double getClose() {

		return close;
	}

	@Override
	public double getCloseVolume() {

		return closeVolume;
	}

	@Override
	public double getCloseMarketCap() {

		return closeMarketCap;
	}

}
