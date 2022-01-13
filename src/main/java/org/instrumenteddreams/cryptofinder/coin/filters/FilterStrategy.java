package org.instrumenteddreams.cryptofinder.coin.filters;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;

public interface FilterStrategy {

	Coin.Info getInfoRequirementsForFiltersOfOrder(int order);

	Predicate<Coin> getFiltersOfOrder(int order);

}
