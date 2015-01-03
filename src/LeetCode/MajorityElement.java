package LeetCode;

public class MajorityElement {
	public int majorityElement(int[] num) {
		int majorityElement = num[0];
		int occurance = 1;
		for (int i = 1; i < num.length; ++i) {
			if (num[i] == majorityElement) {
				++occurance;
			} else if (occurance > 0) {
				--occurance;
			} else {
				majorityElement = num[i];
				occurance = 1;
			}
		}
		return majorityElement;
	}
}
