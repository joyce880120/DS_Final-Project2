import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncode {
	public URLEncode() {

	}

	public String urlEncoder(String url) {
		String encodedURL = "";
		try {
			// 進行 URL 百分比編碼//
			encodedURL = URLEncoder.encode(url, "UTF-8");
			System.out.println(encodedURL);
		} catch (UnsupportedEncodingException e) {
			// 例外處理 ...
		}
		return encodedURL;
	}
}
