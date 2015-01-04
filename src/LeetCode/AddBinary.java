package LeetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder retsb = new StringBuilder();
		int alen = a.length();
		int blen = b.length();

		int carryOver = 0;
		int ai = alen - 1;
		int bi = blen - 1;
		for (; ai >= 0 && bi >= 0; --ai, --bi) {
			int curSum = 0;
			curSum += (a.charAt(ai) == '1') ? 1 : 0;
			curSum += (b.charAt(bi) == '1') ? 1 : 0;
			curSum += carryOver;
			retsb.append(curSum % 2);
			carryOver = curSum / 2;
		}

		for (; ai >= 0; --ai) {
			int curSum = 0;
			curSum += (a.charAt(ai) == '1') ? 1 : 0;
			curSum += carryOver;
			retsb.append(curSum % 2);
			carryOver = curSum / 2;
		}

		for (; bi >= 0; --bi) {
			int curSum = 0;
			curSum += (b.charAt(bi) == '1') ? 1 : 0;
			curSum += carryOver;
			retsb.append(curSum % 2);
			carryOver = curSum / 2;
		}

		if (carryOver > 0) {
			retsb.append('1');
		}

		return retsb.reverse().toString();
	}
}
