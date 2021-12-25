package org.instrumenteddreams.cryptofinder.coin;

import java.time.temporal.ChronoUnit;

public enum CoinStandardPeriod {

    PERIOD_1H("1h", 1, ChronoUnit.HOURS), PERIOD_24H("24h", 24, ChronoUnit.HOURS), PERIOD_7D("7d", 7, ChronoUnit.DAYS),
    PERIOD_14d("14d", 14, ChronoUnit.DAYS), PERIOD_30D("30d", 30, ChronoUnit.DAYS),
    PERIOD_200D("200d", 200, ChronoUnit.DAYS), PERIOD_1Y("1y", 1, ChronoUnit.YEARS);

    private final String string;
    private final int duration;
    private final ChronoUnit timeUnit;

    private CoinStandardPeriod(String string, int duration, ChronoUnit timeUnit) {

	this.string = string;
	this.duration = duration;
	this.timeUnit = timeUnit;
    }

    public String getString() {

	return string;
    }

    @Override
    public String toString() {

	return getString();
    }

    public ChronoUnit getTimeUnit() {

	return timeUnit;
    }

    public int getDuration() {

	return duration;
    }

}
