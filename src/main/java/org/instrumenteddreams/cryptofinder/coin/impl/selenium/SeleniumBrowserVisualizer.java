package org.instrumenteddreams.cryptofinder.coin.impl.selenium;

import org.instrumenteddreams.cryptofinder.coin.Coin;
import org.instrumenteddreams.cryptofinder.coin.CoinVisualizer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBrowserVisualizer implements CoinVisualizer {

	public final String baseUrl;

	private FirefoxDriver webDriver;

	public SeleniumBrowserVisualizer(String baseUrl) {

		this.baseUrl = baseUrl;
	}

	@Override
	public void start() {

		System.setProperty("webdriver.gecko.driver", "C:\\installed\\selenium\\webdrivers\\gecko\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\installed\\Waterfox\\waterfox.exe");
		webDriver = new FirefoxDriver();
	}

	@Override
	public void visualize(Coin coin) {

		openCoinInBrowser(coin.getId());
	}

	private void openCoinInBrowser(String coin) {

		System.out.println("opening browser tab for: " + coin);
		String coinUrl = baseUrl + coin;
		((JavascriptExecutor) webDriver).executeScript("window.open(\"" + coinUrl + "\")");
	}

}
