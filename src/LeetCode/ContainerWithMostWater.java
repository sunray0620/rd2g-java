package LeetCode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxWater = 0;
		int l = 0;
		int u = height.length - 1;

		while (l < u) {
			maxWater = Math.max(maxWater, Math.min(height[l], height[u]) * (u - l));
			if (height[l] <= height[u]) {
				++l;
			} else {
				--u;
			}
		}
		return maxWater;
	}
}
