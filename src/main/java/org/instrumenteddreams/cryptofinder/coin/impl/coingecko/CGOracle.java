package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.instrumenteddreams.cryptofinder.coin.CFCoin;
import org.instrumenteddreams.cryptofinder.coin.CFCoin.CoinInfoType;
import org.instrumenteddreams.cryptofinder.coin.CFCoinChartInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinImpl;
import org.instrumenteddreams.cryptofinder.coin.CFCoinOracle;
import org.instrumenteddreams.cryptofinder.coin.CFCoinOverallInfo;
import org.instrumenteddreams.cryptofinder.coin.CFCoinStandardPeriod;

import com.google.common.base.Joiner;
import com.litesoftwares.coingecko.constant.Currency;
import com.litesoftwares.coingecko.domain.Coins.CoinFullData;
import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;
import com.litesoftwares.coingecko.domain.Coins.MarketChart;
import com.litesoftwares.coingecko.domain.Coins.OhlcSample;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;

public class CGOracle implements CFCoinOracle {

	private static final int CHAR_RANGE_IN_DAYS = 180;

	private static final String CHAR_SAMPLING_FREQUENCY_DAILY = "daily";

	public static final int COINS_LIST_PAGE_SIZE = 250;

	private static final String ALL_COIN_STANDARD_PERIODS;

	private static final int MINIMUM_WAIT_BETWEEN_REQUESTS_IN_MILLISECONDS = 1200;

	private AtomicLong lastRequestTime = new AtomicLong(0);

	private CoinGeckoApiClientImpl coinGeckoClient;

	private boolean started = false;

	static {
		ALL_COIN_STANDARD_PERIODS = Joiner.on(',').join(CFCoinStandardPeriod.values());

	}

	@Override
	public void start() {

		coinGeckoClient = new CoinGeckoApiClientImpl();
		coinGeckoClient.ping();
		started = true;
	}

	@Override
	public List<CFCoin> getAllCoins(int pageNumber) {

		return getCoinBasicInfos(Currency.USD, null, null, null, COINS_LIST_PAGE_SIZE, pageNumber, false,
				ALL_COIN_STANDARD_PERIODS);
	}

	@Override
	public void shutDown() {

		coinGeckoClient = null;
	}

	@Override
	public boolean isStarted() {

		return started;
	}

	@Override
	public CFCoin completeCoinInfo(CFCoin coin, CoinInfoType info) {

		if (info == CFCoin.CoinInfoType.NONE) {
			return coin;
		}
		if (info == CFCoin.CoinInfoType.BASIC) {
			if (coin.getCoinBasicInfo() != null) {
				return coin;
			}
			throw new UnsupportedOperationException("info type not supported");
		}
		if (info == CFCoin.CoinInfoType.OVERALL) {
			if (coin.getCoinOverallInfo() != null) {
				return coin;
			}
			CFCoinOverallInfo overallInfo = getCoinOverallInfo(coin.getId());
			coin.setCoinOverAllInfo(overallInfo);
			return coin;
		}
		if (info == CFCoin.CoinInfoType.CHART_OLHC_INFO_180D) {
			if (coin.getCoinChartInfo() != null) {
				return coin;
			}
			CFCoinChartInfo chartInfo = getCoinChartInfo(coin.getId(), CHAR_RANGE_IN_DAYS);
			coin.setCoinChartInfo(chartInfo);
			return coin;
		}

		throw new IllegalArgumentException("info type not supported");
	}

	@Override
	public int getDefaultPageSize() {

		return COINS_LIST_PAGE_SIZE;
	}

	public void waitIfNeeded() {

		long currentTime = System.currentTimeMillis();
		long timeSinceLastRequest = currentTime - lastRequestTime.longValue();
		if (timeSinceLastRequest < MINIMUM_WAIT_BETWEEN_REQUESTS_IN_MILLISECONDS) {
			try {
				Thread.sleep(MINIMUM_WAIT_BETWEEN_REQUESTS_IN_MILLISECONDS - timeSinceLastRequest);
			} catch (InterruptedException e) {
				throw new IllegalStateException("internal error");
			}
		}
	}

	private void setLastRequestTime() {

		lastRequestTime.set(System.currentTimeMillis());
	}

	private CFCoinOverallInfo getCoinOverallInfo(String id) {

		return getCoinOverallInfo(id, true, true, true, true, true, true);
	}

	private CFCoinChartInfo getCoinChartInfo(String id, int days) {

		if (days != CHAR_RANGE_IN_DAYS) {
			throw new IllegalArgumentException("only " + CHAR_RANGE_IN_DAYS + " days ranges supported");
		}

		waitIfNeeded();
		MarketChart chartData = coinGeckoClient.getCoinMarketChartById(id, Currency.USD, days,
				CHAR_SAMPLING_FREQUENCY_DAILY);
		setLastRequestTime();

		waitIfNeeded();
		OhlcSample[] ohlcData = coinGeckoClient.getCoinOhlcById(id, Currency.USD, days);
		setLastRequestTime();

		return CGCoinChartInfo.fromChartData(chartData, ohlcData, days);
	}

	private CFCoinOverallInfo getCoinOverallInfo(String id, boolean localization, boolean tickers, boolean marketData,
			boolean communityData, boolean developerData, boolean sparkline) {

		waitIfNeeded();
		CoinFullData conFullData = coinGeckoClient.getCoinById(id, localization, tickers, marketData, communityData,
				developerData, sparkline);
		setLastRequestTime();
		return new CGOCoinOverallInfo(conFullData);
	}

	private List<CFCoin> getCoinBasicInfos(String vsCurrency, String ids, String category, String order, Integer perPage,
			Integer page, boolean sparkline, String priceChangePercentage) {

		waitIfNeeded();
		List<CoinMarkets> coinMarkets = coinGeckoClient.getCoinMarkets(vsCurrency, ids, category, order, perPage, page,
				sparkline, priceChangePercentage);
		setLastRequestTime();
		return coinMarkets.stream().map(coinMarket -> new CGCoinBasicInfo(coinMarket))
				.map(coinInfo -> new CFCoinImpl(coinInfo)).collect(Collectors.toList());
	}

}