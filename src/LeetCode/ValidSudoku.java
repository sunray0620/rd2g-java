package LeetCode;

public class ValidSudoku {
	int[] checker = new int[10];

	public void cleanChecker() {
		for (int i = 1; i <= 9; ++i) {
			checker[i] = 0;
		}
	}

	public boolean isValidRow(char[][] board, int row) {
		cleanChecker();
		for (int j = 0; j < 9; ++j) {
			int charint = board[row][j] - '0';
			if (charint > 9 || charint < 1) {
				continue;
			}
			int status = ++checker[charint];
			if (status > 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidCol(char[][] board, int col) {
		cleanChecker();
		for (int i = 0; i < 9; ++i) {
			int charint = board[i][col] - '0';
			if (charint > 9 || charint < 1) {
				continue;
			}
			int status = ++checker[charint];
			if (status > 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidBox(char[][] board, int row, int col) {
		cleanChecker();
		for (int i = row; i < row + 3; ++i) {
			for (int j = col; j < col + 3; ++j) {
				int charint = board[i][j] - '0';
				if (charint > 9 || charint < 1) {
					continue;
				}
				int status = ++checker[charint];
				if (status > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			if (!isValidRow(board, i))
				return false;
		}
		for (int j = 0; j < 9; ++j) {
			if (!isValidCol(board, j))
				return false;
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!isValidBox(board, i, j))
					return false;
			}
		}
		return true;
	}
}
