package LeetCode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		int[] charTable = new int[128];
		charTable[40] = 1;
		charTable[41] = -1;
		charTable[91] = 2;
		charTable[93] = -2;
		charTable[123] = 3;
		charTable[125] = -3;

		char[] schars = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < schars.length; ++i) {
			int charint = charTable[(int) schars[i]];
			if (charint > 0) {
				stack.push(charint);
			} else {
				if (stack.empty() || stack.peek() != -charint) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.size() == 0;
	}
}
