package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

	public static String add(String num1, String num2) {
		int num1Len = num1.length();
		int num2Len = num2.length();
		StringBuilder sb = new StringBuilder();

		int idx1 = num1Len - 1;
		int idx2 = num2Len - 1;
		int carryOver = 0;
		for (; idx1 >= 0 && idx2 >= 0; --idx1, --idx2) {
			char c1 = num1.charAt(idx1);
			char c2 = num2.charAt(idx2);
			int n3 = c1 - '0' + c2 - '0' + carryOver;
			sb.append(n3 % 10);
			carryOver = n3 / 10;
		}

		for (; idx1 >= 0; --idx1) {
			char c1 = num1.charAt(idx1);
			int n3 = c1 - '0' + carryOver;
			sb.append(n3 % 10);
			carryOver = n3 / 10;
		}

		for (; idx2 >= 0; --idx2) {
			char c2 = num2.charAt(idx2);
			int n3 = c2 - '0' + carryOver;
			sb.append(n3 % 10);
			carryOver = n3 / 10;
		}

		if (carryOver > 0) {
			sb.append(carryOver % 10);
		}
		sb.reverse();
		return sb.toString();
	}

	public static String multiplyHelper(String num1, int digit, int numOfTrailingZeros) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numOfTrailingZeros; ++i) {
			sb.append(0);
		}

		int num1Len = num1.length();
		int carryOver = 0;
		int idx1 = num1Len - 1;
		for (; idx1 >= 0; --idx1) {
			int nd = num1.charAt(idx1) - '0';
			int nr = nd * digit + carryOver;
			sb.append(nr % 10);
			carryOver = nr / 10;
		}

		if (carryOver > 0) {
			sb.append(carryOver % 10);
		}
		for (int i = sb.length() - 1; i > 0; --i) {
			if (sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}
		sb.reverse();
		return sb.toString();
	}

	// Not a good one. Back up for reference.
	public static String multiply2(String num1, String num2) {
		// int num1Len = num1.length();
		int num2Len = num2.length();
		List<String> temp = new ArrayList<String>();

		int pos = 0;
		for (int i = num2Len - 1; i >= 0; --i, ++pos) {
			String tempString = multiplyHelper(num1, num2.charAt(i) - '0', pos);
			temp.add(tempString);
		}

		String ret = "0";
		for (int i = 0; i < temp.size(); ++i) {
			ret = add(ret, temp.get(i));
		}
		return ret;
	}

	public static String multiply(String num1, String num2) {
		int num1Len = num1.length();
		int num2Len = num2.length();

		StringBuilder sb = new StringBuilder();
		int carryOver = 0;
		for (int k = num1Len + num2Len - 2; k >= 0; --k) {
			int tempRetOnPos = 0;
			for (int idx1 = 0; idx1 < num1Len; ++idx1) {
				int idx2 = k - idx1;
				if (idx2 < 0 || idx2 >= num2Len) {
					continue;
				}
				int n1 = num1.charAt(idx1) - '0';
				int n2 = num2.charAt(idx2) - '0';
				tempRetOnPos += n1 * n2;
			}
			tempRetOnPos += carryOver;
			sb.append(tempRetOnPos % 10);
			carryOver = tempRetOnPos / 10;
		}
		sb.append(carryOver);

		for (int i = sb.length() - 1; i > 0; --i) {
			if (sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String n1 = "0";
		String n2 = "456";
		System.out.println(String.format("%s", multiply(n1, n2)));
	}
}
