
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.net.URLDecoder;

public class WebTree {
	public WebNode root;
	public GoogleQuery gq;
	public WebpageQuery wq;

	public WebTree(WebPage rootPage, String keyword) {
		this.root = new WebNode(rootPage);
		this.gq = new GoogleQuery(keyword);
		this.wq = new WebpageQuery();
	}

	public WebTree(WebNode root) {
		this.root = root;
	}

	public void setPostOrderScore() throws IOException {
		setPostOrderScore(root);
		// , root.webPage.keywords
	}

	private void setPostOrderScore(WebNode startNode) throws IOException {
		// 4. compute the score of children nodes postorder
		for (WebNode child : startNode.children) {
			setPostOrderScore(child);
			child.setNodeScore();
		}
		// 5.setNode score of startNode//
		startNode.setNodeScore();
	}

	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException {
		// 4. compute the score of children nodes postorder
		for (WebNode child : startNode.children) {
			setPostOrderScore(child, keywords);
			child.setNodeScore(keywords);
		}
		// 5.setNode score of startNode
		startNode.setNodeScore(keywords);
	}

	public void eularPrintTree() {
		eularPrintTree(root);
	}

	private void eularPrintTree(WebNode startNode) {
		int nodeDepth = startNode.getDepth();
		if (nodeDepth > 1)
			System.out.print("\n" + repeat("\t", nodeDepth - 1));
		// print "("
		System.out.print("(");
		// print "name","score"
		System.out.print(startNode.getWebPage().name + "," + startNode.nodeScore);
		// System.out.print(startNode.webPage.name + "," + startNode.nodeScore + "," +
		// startNode.webPage.url);
		// System.out.print(startNode.webPage.name + "," + startNode.webPage.url);//test
		// 7.print child preorder
		for (WebNode child : startNode.children) {
			eularPrintTree(child);
		}

		// print ")"
		System.out.print(")");

		/*
		 * for example (Publication,286.2)
		 */
		if (startNode.isTheLastChild())
			System.out.print("\n" + repeat("\t", nodeDepth - 2));

	}

	private String repeat(String str, int repeat) {
		String retVal = "";
		for (int i = 0; i < repeat; i++) {
			retVal += str;
		}
		return retVal;
	}

	public void search(String search) throws IOException {

		HashMap<String, String> page = gq.query();
		Set<String> keys = page.keySet();
		for (String key : keys) {
			String url = page.get(key);
			url = "http://www.google.com" + url;
			if (!key.equals("")) {
				WebNode subpage = new WebNode(new WebPage(url, key));
				this.root.addChild(subpage);
			}
		}

	}

	public String procurl(String url) {
		if (url.contains(".tw")) {
			if (url.contains(".org")) {
				url = url.substring(url.indexOf("url?q=") + 6);
				// url = url.substring(0, url.indexOf(".org") + 4);
				url = url.substring(0, url.indexOf(".org") + 7);
			} else if (url.contains(".cc")) {
				url = url.substring(url.indexOf("url?q=") + 6);
				// url = url.substring(0, url.indexOf(".cc") + 3);
				url = url.substring(0, url.indexOf(".cc") + 6);
			} else {
				url = url.substring(url.indexOf("url?q=") + 6);
				// url = url.substring(0, url.indexOf(".com") + 4);
				url = url.substring(0, url.indexOf(".com") + 7);
			}
		}
		return url;
	}

	public void searchpage(WebNode wn) {
		try {

			for (WebNode n : wn.children) {

				HashMap<String, String> page1 = wq.pagequery(n.getWebPage().url);

				Set<String> keys1 = page1.keySet();
				for (String key : keys1) {
					String url = procurl(n.getWebPage().url);
					url = url + page1.get(key);
					WebNode subpage;
					subpage = new WebNode(new WebPage(url, key));
					n.addChild(subpage);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buildTree(String search) throws IOException {
		search(search);
		searchpage(this.root);

	}

	public ArrayList<WebNode> sortPage() {
		ArrayList<WebNode> sort = root.children;
		java.util.Collections.sort(sort, new WebNodeComparator());
		return sort;
	}
}
