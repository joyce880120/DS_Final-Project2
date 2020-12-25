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

public class GoogleQuery

{

	public String searchKeyword;

	public String url;

	public String content;

	public GoogleQuery(String searchKeyword)

	{
		/*
		 * try{ this.searchKeyword = new
		 * String(searchKeyword.getBytes("UTF-8"),"UTF-8"); }catch (Exception ignored) {
		 * // Ignore it }//轉換中文編碼為utf-8
		 */
		this.searchKeyword = searchKeyword;

		this.url = "http://www.google.com/search?q=" + searchKeyword + "&oe=utf8&num=20";

	}

	public String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(getUrl());

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while ((line = bufReader.readLine()) != null) {
			retVal += line;

		}
		return retVal;
	}

	public HashMap<String, String> query() throws IOException

	{

		if (content == null)

		{

			content = fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();

		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");

		for (Element li : lis) {
			try

			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				retVal.put(title, citeUrl);

			} catch (IndexOutOfBoundsException e) {

				// e.printStackTrace();

			}

		}
		return retVal;

	}

	public String getUrl() {
		return url;
	}

}