package org.instrumenteddreams.cryptofinder.coin.impl.filters.altcointrader;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.Coin.Info;
import org.instrumenteddreams.cryptofinder.coin.filters.FilterStrategy;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;

/**
 * All the credit goes to
 * <a href="https://www.altcointradershandbook.com">Altcoin's Trader</a>.
 * 
 * <p>Set of criteria (default values indicated):</p>
 * <ul>
 * <li>Market cap between 1mn and 1bn</li>
 * <li>Listed on at least one of the big exchanges</li>
 * <li>Circulating supply between 500k and 1mn</li>
 * <li>Maximum supply of 1bn</li>
 * <li>Maximum supply minted lesser than 10%</li>
 * <li>Premine lesser than 5%</li>
 * <li>(??????) Bitcoin Talk activity, Social Media Audience Size, Twitter Engagement Rate, FB Engagment Rate := community score > 7</li>
 * <li>Average Exchange Volume to Market Cap greater than 0.5%</li>
 * <li>Volatility = -0.0625 (50% range from price average over the past 30 days)</li>
 * <li>Liquidity = 0.25%</li>
 * <li>% of circulating supply on exchanges: less than 3%</li>
 * <li>% from ATH: at least 50%</li>
 * <li>Annual Inflation Rate lesser than 50%</li>
 * <li>Average Exchange Volume-To-Average Supply Emission = 5</li>
 * <li>Liquidity-To-Average Daily Supply Emission = 2</li>
 * <li>Supply held by top 100 addresses less than 66%</li>
 * <li>Staking/MasterNode ROI greater than 33%</li>
 * <li>Technical Analysis: range bound price at historical support</li>
 * <li>Distribution Evaluation: over the last 30 days, at least half the 20 top addresses adding, and no 
 * more than 5 of them distributing</li>
 * </ul>
 * 
 * @author janusik
 *
 */
public class AltcoinTraderAltcoinStrategy implements FilterStrategy {

	private double minCapInDollars = 1000000;
	private double maxCapInDollars = 500000000;
	private double circulatingSupplyMin = 1;
	private int circulatingSupplyMax = 1000000000;
	private double volume24hToCapPercentageMin = 2;
	private double volume24hToCapPercentageMax = 100;
	private double circulatingSupplyToTotalSupplyPercentageMin = 50;
	private double circulatingSupplyToTotalSupplyPercentageMax = 100;
	private double minCommunityScore = 7;
	
	public AltcoinTraderAltcoinStrategy(double minCapInDollars, double maxCapInDollars, double circulatingSupplyMin,
			int circulatingSupplyMax, double volume24hToCapPercentageMin, double volume24hToCapPercentageMax,
			double circulatingSupplyToTotalSupplyPercentageMin, double circulatingSupplyToTotalSupplyPercentageMax,
			double minCommunityScore) {
		super();
		this.minCapInDollars = minCapInDollars;
		this.maxCapInDollars = maxCapInDollars;
		this.circulatingSupplyMin = circulatingSupplyMin;
		this.circulatingSupplyMax = circulatingSupplyMax;
		this.volume24hToCapPercentageMin = volume24hToCapPercentageMin;
		this.volume24hToCapPercentageMax = volume24hToCapPercentageMax;
		this.circulatingSupplyToTotalSupplyPercentageMin = circulatingSupplyToTotalSupplyPercentageMin;
		this.circulatingSupplyToTotalSupplyPercentageMax = circulatingSupplyToTotalSupplyPercentageMax;
		this.minCommunityScore = minCommunityScore;
	}

	public AltcoinTraderAltcoinStrategy() {}

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
		return isCommunityScoreOverMin(coin, minCommunityScore);
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
