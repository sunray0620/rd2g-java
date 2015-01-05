package LeetCode;

public class LongestSubstrWoRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;

		int[] charTable = new int[256];
		int strlen = s.length();
		char[] schars = s.toCharArray();
		int numOfRep = 0;
		int l = 0;
		int u = 0;
		while (u < strlen) {
			//
			if (numOfRep > 0) {
				int cin = (int) schars[l];
				++l;
				charTable[cin] -= 1;
				if (charTable[cin] == 1) {
					numOfRep -= 1;
				}
			} else {
				maxLen = Math.max(maxLen, u - l);
				int cin = (int) schars[u];
				++u;
				charTable[cin] += 1;
				if (charTable[cin] == 2) {
					numOfRep += 1;
				}
			}
		}
		if (numOfRep == 0) {
			maxLen = Math.max(maxLen, strlen - l);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String testStr = "gpdmyldxukdnftprrumbmemlrowrhwoqntclgh";
		LongestSubstrWoRepeatingChars cc = new LongestSubstrWoRepeatingChars();
		cc.lengthOfLongestSubstring(testStr);
	}
}
