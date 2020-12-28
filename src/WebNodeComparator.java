
import java.util.Comparator;

public class WebNodeComparator implements Comparator<WebNode> {
	@Override
	public int compare(WebNode o1, WebNode o2) {
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		int one = (int) o1.nodeScore;
		int two = (int) o2.nodeScore;
		return two-one;
//
	}
}