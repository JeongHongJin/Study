package HackerRank.Implementation;

import java.util.List;

public class DesignerPDFViewer {
	public static int designerPdfViewer(List<Integer> h, String word) {
		int max = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			max = Math.max(max, h.get(c - 'a'));
		}
		return word.length() * max;
	}
}
