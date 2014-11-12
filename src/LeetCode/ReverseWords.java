package LeetCode;

public final class ReverseWords {
	/*
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example,
	 * Given s = "the sky is blue",
	 * return "blue is sky the".
	 * 
	 * Clarification:
	 * What constitutes a word?
	 * A sequence of non-space characters constitutes a word.
	 * Could the input string contain leading or trailing spaces?
	 * Yes. However, your reversed string should not contain leading or trailing spaces.
	 * How about multiple spaces between two words?
	 * Reduce them to a single space in the reversed string.
	 */

	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		for (int j = s.length(), i = j - 1; i >= 0; --i) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				reversed.append(' ');
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString().trim();
	}

	public static void main(String[] args) {
		String a = "    the sky is blue   ";
		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords(a));
	}
}
