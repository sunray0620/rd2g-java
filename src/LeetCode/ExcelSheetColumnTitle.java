package LeetCode;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		String alphabetStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int div = 26; n > 0; n = (n - 1) / div) {
			sb.append(alphabetStr.charAt((n - 1) % div));
		}
		return sb.reverse().toString();
	}
}
