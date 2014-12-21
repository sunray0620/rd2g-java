package LeetCode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int l = 0;
		int u = s.length() - 1;
		for (; l < u;) {
			char cl = Character.toLowerCase(s.charAt(l));
			char cu = Character.toLowerCase(s.charAt(u));

			if (!Character.isLetterOrDigit(cl)) {
				++l;
			} else if (!Character.isLetterOrDigit(cu)) {
				--u;
			} else if (cl != cu) {
				return false;
			} else {
				++l;
				--u;
			}
		}
		return true;
	}
}
