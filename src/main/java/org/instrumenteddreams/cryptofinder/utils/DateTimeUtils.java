package org.instrumenteddreams.cryptofinder.utils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.instrumenteddreams.cryptofinder.coin.CoinStandardPeriod;

public class DateTimeUtils {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

	public static long parseEpochTime(String dateTimeString) {

		LocalDateTime dateTime = parseLocalDateTime(dateTimeString);
		return toEpochTime(dateTime);
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeString) {

		return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
	}

	public static long toEpochTime(LocalDateTime dateTime) {

		return dateTime.toEpochSecond(getSystemZoneOffset());
	}

	private static ZoneOffset getSystemZoneOffset() {

		ZoneId zoneId = ZoneId.systemDefault();
		return zoneId.getRules().getOffset(Instant.now());
	}

	public static long getPeriodStartEpochTime(LocalDateTime nowDatetime, CoinStandardPeriod period) {

		return toEpochTime(nowDatetime.minus(period.getDuration(), period.getTimeUnit()));
	}

	public static ZonedDateTime toUtcZonedDateTime(long epochTime) {

		BigDecimal bd = new BigDecimal(epochTime);
		BigDecimal[] wholeAndFractional = bd.divideAndRemainder(BigDecimal.ONE);
		long seconds = wholeAndFractional[0].longValueExact();
		int nanos = wholeAndFractional[1].movePointRight(9).intValue();
		return Instant.ofEpochSecond(seconds, nanos).atZone(ZoneId.of("UTC"));
	}

}
