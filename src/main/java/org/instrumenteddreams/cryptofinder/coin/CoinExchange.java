package org.instrumenteddreams.cryptofinder.coin;

public enum CoinExchange {

	BINANCE("binance"), OKEX("okex"), BINANCE_US("binance_us"), UPBIT("upbit"), COINBASE("gdax"), KUCOIN("kucoin"),
	PANCAKESWAP("pancakeswap"), HUOBI("huobi"), UNISWAP("uniswap"), SUSHISWAP("sushiswap"), ONEINCH("one_inch_liquidity_protocol");

	private final String id;

	private CoinExchange(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

}
