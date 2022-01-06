package org.instrumenteddreams.cryptofinder.math.timeseries.predicates;

import org.instrumenteddreams.cryptofinder.math.timeseries.UnivariateTimeSeries;

public class TimeSeriesTester {

	public static boolean isMonotonic(UnivariateTimeSeries series, boolean positively) {

		if (series.getSize() <= 1) {
			return true;
		}

		for (int i = 0; i < series.getSize() - 1; i++) {
			if (positively && series.getValues()[i] > series.getValues()[i + 1]
					|| !positively && series.getValues()[i] < series.getValues()[i + 1]) {
				return false;
			}
		}

		return true;
	}

}
