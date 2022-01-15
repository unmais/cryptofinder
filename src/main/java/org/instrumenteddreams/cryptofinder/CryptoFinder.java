/**
 * 
 */
package org.instrumenteddreams.cryptofinder;

import java.util.List;
import java.util.function.Predicate;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.CoinBasicInfo;
import org.instrumenteddreams.cryptofinder.coin.CoinFactory;
import org.instrumenteddreams.cryptofinder.coin.CoinOracle;
import org.instrumenteddreams.cryptofinder.coin.CoinOracles;
import org.instrumenteddreams.cryptofinder.coin.CoinVisualizer;
import org.instrumenteddreams.cryptofinder.coin.CoinVisualizers;
import org.instrumenteddreams.cryptofinder.coin.impl.filters.FilterStrategy;
import org.instrumenteddreams.cryptofinder.coin.impl.filters.altcointrader.AltcoinTraderFilterStrategy;

import com.google.common.collect.Lists;

/**
 * Selects coins from a coin oracle by certain predefined criteria and
 * visualizes each one of them.
 * 
 * @author janusik
 *
 */
public class CryptoFinder {

    private static final CoinOracle coinOracle = CoinOracles.getDefault();
    private static final CoinVisualizer coinVisualizer = CoinVisualizers.getDefault();
    private static final FilterStrategy filterStrategy = new AltcoinTraderFilterStrategy();

    public static void main(String[] args) throws InterruptedException {

	List<Coin> order1SelectedCoins = Lists.newArrayList();

	Predicate<Coin> order1Filters = filterStrategy.getFiltersOfOrder(1);
	Coin.Info order1requiredInfo = filterStrategy.getInfoRequirementsForFiltersOfOrder(1);

	Predicate<Coin> order2Filters = filterStrategy.getFiltersOfOrder(2);
	Coin.Info order2requiredInfo = filterStrategy.getInfoRequirementsForFiltersOfOrder(2);

	coinOracle.start();
	List<CoinBasicInfo> pageCoinInfos = Lists.newArrayList();
	int pageNumber = 1;
	do {
	    pageCoinInfos.clean();
	    pageCoinInfos = coinOracle.getCoinBasicInfos(pageNumber);
	    System.out.println("fetched " + pageCoinInfos.size() + " coins from page #" + pageNumber);

	    List<Coin> selectedPageCoins = pageCoinInfos.stream().map(info -> CoinFactory.buildCoin(info))
		    .map(coin -> coinOracle.completeCoinInfo(coin, order1requiredInfo)).filter(order1Filters).toList();

	    if (!selectedPageCoins.isEmpty()) {
		System.out.println(">> order-1 filters got " + selectedPageCoins.size() + " coins from this page");
		order1SelectedCoins.addAll(selectedPageCoins);
	    }

	    pageNumber = pageNumber + 1;
	} while (pageCoinInfos.size() == coinOracle.getDefaultPageSize());

	System.out.println("result: order-1 filters got " + order1SelectedCoins.size() + " coins");

	if (!order1SelectedCoins.isEmpty()) {

	    System.out.println("applying order-2 filters...");

	    List<Coin> order2SelectedCoins = order1SelectedCoins.stream()
		    .map(coin -> coinOracle.completeCoinInfo(coin, order2requiredInfo)).filter(order2Filters).toList();

	    System.out.println("result: order-2 filters got " + order2SelectedCoins.size() + " coins");

	    if (!order2SelectedCoins.isEmpty()) {
		coinVisualizer.start();
		order2SelectedCoins.stream().forEach(coin -> coinVisualizer.visualize(coin));
	    }
	}

    }

}
