package org.instrumenteddreams.cryptofinder.coin.impl.filters.altcointrader;

import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.Coin.Info;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.impl.filters.FilterStrategy;

/**
 * All the credit goes to
 * <a href="https://www.altcointradershandbook.com">Altcoin's Trader</a>.
 * 
 * @author janusik
 *
 */
public class AltcoinTraderFilterStrategy implements FilterStrategy {

    private double minCapInDollars = 1;
    private double maxCapInDollars = 5000000;
    private double circulatingSupplyMin = 1;
    private int circulatingSupplyMax = 1000000000;
    private double volume24hToCapPercentageMin = 2;
    private double volume24hToCapPercentageMax = 100;
    private double circulatingSupplyToTotalSupplyPercentageMin = 50;
    private double circulatingSupplyToTotalSupplyPercentageMax = 100;
    private double minCommunityScore = 9;

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
