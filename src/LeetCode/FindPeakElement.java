package LeetCode;

public class FindPeakElement {

	private int getStatus(int[] num, int i) {
		int arrLen = num.length;
		if (i == 0) {
			if (num[i] < num[i + 1]) {
				return 1;
			} else {
				return 0;
			}
		} else if (i == arrLen - 1) {
			if (num[i - 1] > num[i]) {
				return -1;
			} else {
				return 0;
			}
		} else {
			if (num[i + 1] > num[i] && num[i] > num[i - 1]) {
				return 1;
			} else if (num[i - 1] > num[i] && num[i] > num[i + 1]) {
				return -1;
			} else if (num[i] > num[i - 1] && num[i] > num[i + 1]) {
				return 0;
			} else {
				// Both is ok
				return -1;
			}
		}
	}

	public int findPeakElement(int[] num) {
		int arrLen = num.length;
		if (arrLen == 1) {
			return 0;
		}
		if (arrLen == 2) {
			if (num[0] > num[1]) {
				return 0;
			} else {
				return 1;
			}
		}

		int startPos = 0;
		int endPos = arrLen;

		while (startPos <= endPos) {
			int m = (startPos + endPos) / 2;
			int mStatus = getStatus(num, m);
			if (mStatus == 0) {
				return m;
			} else if (mStatus == -1) {
				endPos = m - 1;
			} else {
				startPos = m + 1;
			}
		}
		return 0;
	}
}
