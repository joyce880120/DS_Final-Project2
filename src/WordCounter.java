
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordCounter {
	private String urlStr;
	private String content;

	public WordCounter(String urlStr) {
		this.urlStr = urlStr;
	}

	private String fetchContent(String url) throws IOException {
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		// 使用UTF-8讀取網頁內容
		String retVal = "";

		String line = null;

		while ((line = br.readLine()) != null) {
			retVal = retVal + line + "\n";
		}

		return retVal;
	}

	public int countKeyword(String keyword) throws IOException {
		int retVal = 0;
		try {
			if(content == null) {
				content = fetchContent(this.urlStr);
			}
			if (content.contains("302 Moved")) {
				String new_url = Jsoup.parse(content).select("a").get(0).attr("href");
				if (new_url.contains("pdf")) {
					return retVal;
				}
				content = fetchContent(new_url);
			}

			// To do a case-insensitive search, we turn the whole content and keyword into
			// upper-case:
			content = content.toUpperCase();
			keyword = keyword.toUpperCase();

			int fromIdx = 0;
			int found = -1;

			while ((found = content.indexOf(keyword, fromIdx)) != -1) {
				retVal++;
				fromIdx = found + keyword.length();
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return retVal;
	}

	public String getContent() {
		return this.content;
	}
}
