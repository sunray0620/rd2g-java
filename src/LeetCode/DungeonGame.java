package LeetCode;

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		int[][] wt = new int[m][n];

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (i == m - 1 && j == n - 1) {
					wt[i][j] = getNeededHP(1 - dungeon[i][j]);
				} else if (i == m - 1) {
					wt[i][j] = getNeededHP(wt[i][j + 1] - dungeon[i][j]);
				} else if (j == n - 1) {
					wt[i][j] = getNeededHP(wt[i + 1][j] - dungeon[i][j]);
				} else {
					int fromDown = getNeededHP(wt[i + 1][j] - dungeon[i][j]);
					int fromRight = getNeededHP(wt[i][j + 1] - dungeon[i][j]);
					wt[i][j] = Math.min(fromDown, fromRight);
				}
			}
		}
		return wt[0][0];

	}

	private int getNeededHP(int x) {
		return Math.max(x, 1);
	}
}
