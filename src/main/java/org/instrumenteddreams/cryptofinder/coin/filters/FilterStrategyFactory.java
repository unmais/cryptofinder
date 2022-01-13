package org.instrumenteddreams.cryptofinder.coin.filters;

import java.util.Map;

import org.instrumenteddreams.cryptofinder.coin.impl.filters.altcointrader.AltcoinTraderAltcoinStrategy;

import com.google.common.collect.Maps;

public class FilterStrategyFactory {

	public static enum StrategyId {
		ALTCOIN_TRADER
	}
	
	private static Map<StrategyId, FilterStrategy> strategyMap = Maps.newEnumMap(StrategyId.class);
	
	static {
		strategyMap.put(StrategyId.ALTCOIN_TRADER, new AltcoinTraderAltcoinStrategy());
	}
	
	public static FilterStrategy buildStrategy(StrategyId id) {
		return strategyMap.get(id);
	}
	
}
