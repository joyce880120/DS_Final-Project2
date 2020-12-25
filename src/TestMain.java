import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TestMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String url = "https://zh.wikipedia.org/zh-tw/%E5%BE%AE%E5%BE%AE%E4%B8%80%E7%AC%91%E5%BE%88%E5%80%BE%E5%9F%8E_(%E7%94%B5%E8%A7%86%E5%89%A7)";
		WebPage test = new WebPage(url, "test");
		
		GoogleQuery gq = new GoogleQuery("nccu");
		WebPage testgq = new WebPage(gq.getUrl(), "nccu");
		WebNode root = new WebNode(testgq);
		WebTree keywordTree = new WebTree(testgq,"nccu" );
		
		try {
			test.count();
		} catch (Exception ignored) {
			// Ignore it
		}
		System.out.println(test.getScore());
		
		keywordTree.buildTree("nccu");
		System.out.println("a");
		keywordTree.setPostOrderScore();
		System.out.println("a");
		ArrayList<WebNode> sort = keywordTree.sortPage();
		System.out.println("a");
		System.out.println(sort.isEmpty());
//		System.out.println(sort.get(0).getWebPage().getUrl());
//		System.out.println(sort.get(0).getWebPage().getScore());
//		System.out.println(sort.get(0).getWebPage().getName());
//		System.out.println(sort.get(1).getWebPage().getUrl());
//		System.out.println(sort.get(1).getWebPage().getScore());
//		System.out.println(sort.get(1).getWebPage().getName());
		System.out.println("a");
		//System.out.println(sort.size());
		for(WebNode a : sort)
		{
			System.out.println(a.getWebPage().getName());
			System.out.println(a.getWebPage().getScore());
		}
		
	}

}
