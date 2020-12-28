import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import java.io.*;

import java.net.HttpURLConnection;

public class WebpageQuery {

	public String content;

	public WebpageQuery()

	{
	}

	// new
	public HttpURLConnection getConn(String url) throws IOException {
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setConnectTimeout(10);
		conn.setReadTimeout(10);
		conn.connect();
		return conn;
	}

	public String fetchContent(String url) throws IOException {
		String retVal = "";
		System.out.println(url);
		HttpURLConnection conn = getConn(url);
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;
		while ((line = bufReader.readLine()) != null) {
			retVal += line;
		}
		conn.disconnect();
		return retVal;

	}

	// new//
	public HashMap<String, String> pagequery(String url) throws IOException

	{

		HashMap<String, String> retVal = new HashMap<String, String>();
		try {
			content = fetchContent(url);
			if (content.contains("302 Moved")) {
				String new_url = Jsoup.parse(content).select("a").get(0).attr("href");
				if (new_url.contains("pdf")) {
					return retVal;
				}
				content = fetchContent(new_url);
			}

			Document doc = Jsoup.parse(content);

			Elements lis = doc.select("a");
			for (Element a : lis) {
				String citeUrl = a.attr("href");
				String title = a.text();
				retVal.put(title, citeUrl);
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return retVal;

	}
}
