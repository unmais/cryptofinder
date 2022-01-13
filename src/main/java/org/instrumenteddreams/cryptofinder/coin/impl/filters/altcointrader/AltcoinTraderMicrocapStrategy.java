package org.instrumenteddreams.cryptofinder.coin.impl.filters.altcointrader;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.Coin.Info;
import org.instrumenteddreams.cryptofinder.coin.filters.FilterStrategy;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinExchange;

/**
 * All the credit goes to
 * <a href="https://www.altcointradershandbook.com">Altcoin's Trader</a>.
 * 
 * <p>
 * Set of criteria (default values indicated):
 * </p>
 * <ul>
 * <li>Market cap between 0 and 1000000 (25 btc)</li>
 * <li>Listed on at least one of the big exchanges</li>
 * <li>Circulating supply below 1bn</li>
 * <li>24h volume greater than 2% of market cap</li>
 * <li>Circulating supply at least 50% of total supply</li>
 * <li>??? Social media momentum</li>
 * <li>??? Devs momentum</li>
 * <li>??? Block explorer momentum: measure what the big addresses are
 * doing</li>
 * <li>Technical indicators: volume, price ranges
 * 
 * </ul>
 * 
 * @author janusik
 *
 */
public class AltcoinTraderMicrocapStrategy implements FilterStrategy {

	private double minCapInDollars = 0;
	private double maxCapInDollars = 1000000;
	private double circulatingSupplyMin = 1;
	private int circulatingSupplyMax = 1000000000;
	private double volume24hToCapPercentageMin = 2;
	private double volume24hToCapPercentageMax = 100;
	private double circulatingSupplyToTotalSupplyPercentageMin = 50;
	private double circulatingSupplyToTotalSupplyPercentageMax = 100;
	private double minCommunityScore = 70;

	public AltcoinTraderMicrocapStrategy() {
	}

	@Override
	public Info getInfoRequirementsForFiltersOfOrder(int order) {

		if (order == 1) {
			return Coin.Info.BASIC;
		}
		if (order == 2) {
			return Coin.Info.OVERALL;
		}

		return Coin.Info.NONE;
	}

	@Override
	public Predicate<Coin> getFiltersOfOrder(int order) {

		if (order == 1) {
			return coin -> isPassingAllOrder1Filters(coin);
		}
		if (order == 1) {
			return coin -> isPassingAllOrder2Filters(coin);
		}
		return coin -> true;
	}

	private boolean isPassingAllOrder2Filters(Coin coin) {

		coin.assertHasInfo(Coin.Info.OVERALL);
		return isListedInBigExchanges(coin) && isCommunityScoreOverMin(coin, minCommunityScore);
	}

	private boolean isCommunityScoreOverMin(Coin coin, double minCommunityScore) {

		return coin.getCoinOverallInfo().getCommunityScore() > minCommunityScore;
	}

	public boolean isPassingAllOrder1Filters(Coin coin) {

		coin.assertHasInfo(Coin.Info.BASIC);
		CoinBasicInfo coinBasicInfo = coin.getCoinBasicInfo();
		return isMarketCapInDollarRange(coinBasicInfo, minCapInDollars, maxCapInDollars)
				&& isCirculatingSupplyInCoinsNumberRange(coinBasicInfo, circulatingSupplyMin, circulatingSupplyMax)
				&& is24hVolumeToMarketCapPercentageInRange(coinBasicInfo, volume24hToCapPercentageMin,
						volume24hToCapPercentageMax)
				&& isCirculatingSupplyInPercentageRangeOfTotalSupply(coinBasicInfo,
						circulatingSupplyToTotalSupplyPercentageMin, circulatingSupplyToTotalSupplyPercentageMax);
	}

	private boolean isListedInBigExchanges(Coin coin) {

		return coin.getCoinOverallInfo().getTickers().stream().map(t -> t.getMarket().getName())
				.anyMatch(n -> n.equalsIgnoreCase(CoinExchange.BINANCE.getId())
						|| n.equalsIgnoreCase(CoinExchange.BINANCE_US.getId())
						|| n.equalsIgnoreCase(CoinExchange.COINBASE.getId()));
	}

	public static boolean isMarketCapInDollarRange(CoinBasicInfo coin, double min, double max) {

		return coin.getMarketCap() >= min && coin.getMarketCap() <= max;
	}

	public static boolean is24hVolumeToMarketCapPercentageInRange(CoinBasicInfo coin, double min, double max) {

		double percentage = 100 * coin.getTotalVolume() / coin.getMarketCap();
		return min <= percentage && percentage <= max;
	}

	public static boolean isCirculatingSupplyInCoinsNumberRange(CoinBasicInfo coin, double min, double max) {

		return coin.getCirculatingSupply() >= min && coin.getCirculatingSupply() <= max;
	}

	public static boolean isCirculatingSupplyInPercentageRangeOfTotalSupply(CoinBasicInfo coin, double min,
			double max) {

		double percentage = 100 * coin.getCirculatingSupply() / coin.getTotalSupply();
		return min <= percentage && percentage <= max;
	}

}
