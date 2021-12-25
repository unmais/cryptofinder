package org.instrumenteddreams.cryptofinder.coin.impl.webscrapping;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class XPathWebScrapper {

    private OkHttpClient client = new OkHttpClient.Builder().build();
    private DocumentBuilder builder;
    private XPathFactory xpathFactory;
    private XPath xpath;
    private DocumentBuilderFactory factory;

    public XPathWebScrapper() {

	factory = DocumentBuilderFactory.newInstance();
	factory.setNamespaceAware(true);
	try {
	    builder = factory.newDocumentBuilder();
	    xpathFactory = XPathFactory.newInstance();
	    xpath = xpathFactory.newXPath();
	} catch (ParserConfigurationException e) {
	    throw new IllegalStateException("internal error", e);
	}
    }

    public Object scrapDataFromWeb(String webUrl, String xpathQuery, QName dataType) {

	String htmlResponse;
	try {
	    htmlResponse = getUrl(webUrl);
	    return runXPathQuery(htmlResponse, xpathQuery, dataType);
	} catch (IOException e) {
	    throw new IllegalArgumentException("failed to load URL", e);
	}
    }

    private Object runXPathQuery(String htmlDocumentAsString, String xpathQuery, QName dataType) {

	try {
	    InputSource inputSource = new InputSource(new StringReader(htmlDocumentAsString));
	    builder.parse(inputSource);
	    XPathExpression xpathExpression = xpath.compile(xpathQuery);
	    return xpathExpression.evaluate(inputSource, dataType);
	} catch (SAXException e) {
	    throw new IllegalArgumentException("failed to parse html document", e);
	} catch (IOException e) {
	    throw new IllegalArgumentException("failed to load URL", e);
	} catch (XPathExpressionException e) {
	    throw new IllegalArgumentException("invalid XPath expression", e);
	}
    }

    private String getUrl(String url) throws IOException {

	Request request = new Request.Builder().url(url).build();
	try (Response response = client.newCall(request).execute()) {
	    return response.body().string();
	}
    }

}
