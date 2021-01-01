
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

import java.net.URI;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// add a web tree for ranking
	public WebTree keywordTree;
	public WebNode keywordNode;
	public WebPage keywordPage;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestProject() {
		super();
		// one for url one for keyword
		this.keywordPage = new WebPage(null, null);
		this.keywordNode = new WebNode(keywordPage);
		this.keywordTree = new WebTree(null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (request.getParameter("keyword") == null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		// get google query and put it in hashmap, which can get title and url

		String k = request.getParameter("keyword") + "+小說";// 偷偷在搜尋結果關鍵字上加上"小說"
		GoogleQuery google = new GoogleQuery(k);
		WebPage testgq = new WebPage(google.getUrl(), k);
		WebTree keywordTree = new WebTree(testgq, k);
		keywordTree.buildTree(k);
//		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
//
//		HashMap<String, String> query = google.query();
//
//		WebPage testgq = new WebPage(google.getUrl(), request.getParameter("keyword"));
//		WebTree keywordTree = new WebTree(testgq, request.getParameter("keyword"));

//		keywordTree.buildTree(request.getParameter("keyword"));
		keywordTree.setPostOrderScore();
		ArrayList<WebNode> sorts = keywordTree.sortPage();
		String[][] s = new String[sorts.size()][2];

		int num = 0;//
		for (WebNode sort : sorts) {
			String citeUrl = sort.getWebPage().getUrl();
			int index = citeUrl.indexOf("?q=");
			int index2 = citeUrl.lastIndexOf("&sa=");
			citeUrl = citeUrl.substring(index + 3, index2);// 網址去頭去尾
			String title = sort.getWebPage().getName();

			System.out.print(sort.nodeScore);// test
			System.out.print(title);// test
			System.out.println(citeUrl);// test
			s[num][0] = title;//
			s[num][1] = citeUrl;//
			num++;
		}
		request.setAttribute("query", s);
		request.getRequestDispatcher("googleitem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}