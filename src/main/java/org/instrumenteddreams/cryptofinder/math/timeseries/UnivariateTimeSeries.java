package org.instrumenteddreams.cryptofinder.math.timeseries;

import java.util.Arrays;
import java.util.Optional;

public class UnivariateTimeSeries {

    private final double[] times;
    private final double[] values;

    public UnivariateTimeSeries(long[] times, double[] values) {

	super();
	this.times = new double[times.length];
	for (int i = 0; i < times.length; i++) {
	    this.times[i] = times[i];
	}
	this.values = values;

    }

    public UnivariateTimeSeries(double[] times, double[] values) {

	super();
	this.times = times;
	this.values = values;

    }

    public double[] getTimes() {

	return times;
    }

    public double[] getValues() {

	return values;
    }

    public int getSize() {

	return times.length;
    }

    public Optional<UnivariateTimeSeries> getSubSeries(double fromTime) {

	int i = 0;

	while (times[i] < fromTime && i < times.length) {
	    i++;
	}

	if (i == times.length) {
	    return Optional.empty();
	}

	double[] timeSubSeries = Arrays.copyOfRange(times, i, times.length);
	double[] valueSubSeries = Arrays.copyOfRange(values, i, values.length);

	return Optional.of(new UnivariateTimeSeries(timeSubSeries, valueSubSeries));

    }

}
