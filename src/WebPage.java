import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	ArrayList<Keyword> keywords = new ArrayList();

	public WebPage(String url, String name) {
		this.setUrl(url);
		this.setName(name);
		this.counter = new WordCounter(url);
//		keywords.add(0, new Keyword("nccu", 0, 10));
//		keywords.add(1, new Keyword("professor", 0, 8));
		keywords.add(0, new Keyword("�p��", 0, 10));
		keywords.add(1, new Keyword("�q�l��", 0, 8));
		keywords.add(2, new Keyword("�ѦW", 0, 5));
		keywords.add(3, new Keyword("��r", 0, 3));
		keywords.add(4, new Keyword("�@��", 0, 2));
		keywords.add(5, new Keyword("�ѵ�", 0, 1));
		keywords.add(6, new Keyword("�t��", 0, -2));
		keywords.add(7, new Keyword("�D�t", 0, -3));
		keywords.add(8, new Keyword("���W", 0, -5));
		keywords.add(9, new Keyword("�q�v", 0, -6));

	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		for (Keyword k : keywords) {
			int temp = 0;
			temp = counter.countKeyword(k.name);
			k.setCount(temp);
			score += k.getCount() * k.weight;
		}
	}

	public void count() throws IOException {
		setScore(this.keywords);
	}

	public double getScore() {
		return this.score;
	}

	public String getUrl() {
		return this.url;
	}

	public String getName() {
		return this.name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}

}
