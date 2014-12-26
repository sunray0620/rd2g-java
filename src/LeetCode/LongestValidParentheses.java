package LeetCode;

import java.util.Stack;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		int lastValidEnd = -1;
		int maxValid = 0;
		Stack<Integer> ws = new Stack<Integer>();

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				ws.push(i);
			} else {
				if (!ws.isEmpty()) {
					int validStart = ws.pop();
					if (ws.isEmpty()) {
						validStart = lastValidEnd;
					} else {
						validStart = ws.peek();
					}
					maxValid = Math.max(maxValid, i - validStart);
				} else {
					lastValidEnd = i;
				}
			}
		}
		return maxValid;
	}

	public static void main(String[] args) {
		String testStr = "())()((())((()))))()";
		int ret = longestValidParentheses(testStr);
		System.out.println(ret);
	}
}
