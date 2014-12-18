package LeetCode;

public class CompareVersionNumber {

	public static int compareVersion(String version1, String version2) {
		String[] version1Strs = version1.split("\\.");
		int version1Length = version1Strs.length;
		int[] version1Nums = new int[version1Length];
		for (int i = 0; i < version1Length; ++i)
			version1Nums[i] = Integer.parseInt(version1Strs[i]);

		String[] version2Strs = version2.split("\\.");
		int version2Length = version2Strs.length;
		int[] version2Nums = new int[version2Length];
		for (int i = 0; i < version2Length; ++i)
			version2Nums[i] = Integer.parseInt(version2Strs[i]);

		int cmpIdx = 0;
		for (cmpIdx = 0; cmpIdx < version1Length && cmpIdx < version2Length; ++cmpIdx) {
			if (version1Nums[cmpIdx] < version2Nums[cmpIdx])
				return -1;
			else if (version1Nums[cmpIdx] > version2Nums[cmpIdx])
				return 1;
		}

		for (; cmpIdx < version1Length; ++cmpIdx) {
			if (version1Nums[cmpIdx] < 0)
				return -1;
			else if (version1Nums[cmpIdx] > 0)
				return 1;
		}

		for (; cmpIdx < version2Length; ++cmpIdx) {
			if (version2Nums[cmpIdx] < 0)
				return 1;
			else if (version2Nums[cmpIdx] > 0)
				return -1;
		}

		return 0;
	}

	public static void main(String[] args) {
		String v1 = "1";
		String v2 = "0";
		compareVersion(v1, v2);
	}
}
