/**
 * 
 */
package org.instrumenteddreams.cryptofinder;

import org.instrumenteddreams.cryptofinder.coin.CFCoinOracle;
import org.instrumenteddreams.cryptofinder.coin.CFCoinOracles;
import org.instrumenteddreams.cryptofinder.coin.CFCoinVisualizer;
import org.instrumenteddreams.cryptofinder.coin.CFCoinVisualizers;

/**
 * Selects coins from a coin oracle by certain predefined criteria and
 * visualizes each one of them.
 * 
 * @author janusik
 *
 */
public class CryptoFinder {

	private static final CFCoinOracle coinOracle = CFCoinOracles.getDefault();
	private static final CFCoinVisualizer coinVisualizer = CFCoinVisualizers.getDefault();

	public static void main(String[] args) throws InterruptedException {

		coinOracle.start();
//		List<CoinBasicInfo> pageCoinInfos = Lists.newArrayList();
//
//		System.out.println("result: order-1 filters got " + order1SelectedCoins.size() + " coins");
//
//		if (!order1SelectedCoins.isEmpty()) {
//
//			System.out.println("applying order-2 filters...");
//
//			List<Coin> order2SelectedCoins = order1SelectedCoins.stream()
//					.map(coin -> coinOracle.completeCoinInfo(coin, order2requiredInfo)).toList();
//
//			System.out.println("result: order-2 filters got " + order2SelectedCoins.size() + " coins");
//
//			if (!order2SelectedCoins.isEmpty()) {
//				coinVisualizer.start();
//				order2SelectedCoins.stream().forEach(coin -> coinVisualizer.visualize(coin));
//			}
//		}

	}

}
