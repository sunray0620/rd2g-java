package LeetCode;

public class SudokuSolver {
	final int n = 9;
	final int bn = 3;

	public void solveSudoku(char[][] board) {
		// Copy to int board.
		int[][] intBoard = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == '.') {
					intBoard[i][j] = 0;
				} else {
					intBoard[i][j] = (int) board[i][j] - '0';
				}
			}
		}

		//
		fillCell(intBoard, 0, 0, board);
	}

	public boolean fillCell(int[][] board, int i, int j, char[][] ret) {
		if (i == n && j == 0) {
			// Copy to ret
			for (int reti = 0; reti < n; ++reti) {
				for (int retj = 0; retj < n; ++retj) {
					ret[reti][retj] = (char) ((char) board[reti][retj] + '0');
				}
			}
			return true;
		}

		int nexti = i;
		int nextj = j + 1;
		if (nextj >= 9) {
			nextj = 0;
			nexti = nexti + 1;
		}
		if (board[i][j] != 0) {
			return fillCell(board, nexti, nextj, ret);
		}
		for (int fillNum = 1; fillNum <= 9; ++fillNum) {
			board[i][j] = fillNum;
			if (!isValidSudokuAtCell(board, i, j)) {
				continue;
			}
			if (fillCell(board, nexti, nextj, ret)) {
				return true;
			}
		}
		board[i][j] = 0;
		return false;
	}

	// ///////
	boolean[] seen = new boolean[10];

	private void cleanChecker() {
		for (int i = 0; i <= 9; ++i) {
			seen[i] = false;
		}
	}

	public boolean isValidRow(int[][] board, int row) {
		cleanChecker();
		for (int j = 0; j < n; ++j) {
			int cellValue = board[row][j];
			if (cellValue == 0) {
				continue;
			} else if (seen[cellValue]) {
				return false;
			}
			seen[cellValue] = true;
		}
		return true;
	}

	public boolean isValidCol(int[][] board, int col) {
		cleanChecker();
		for (int i = 0; i < n; ++i) {
			int cellValue = board[i][col];
			if (cellValue == 0) {
				continue;
			} else if (seen[cellValue]) {
				return false;
			}
			seen[cellValue] = true;
		}
		return true;
	}

	public boolean isValidBox(int[][] board, int row, int col) {
		cleanChecker();
		for (int i = row; i < row + bn; ++i) {
			for (int j = col; j < col + bn; ++j) {
				int cellValue = board[i][j];
				if (cellValue == 0) {
					continue;
				} else if (seen[cellValue]) {
					return false;
				}
				seen[cellValue] = true;
			}
		}
		return true;
	}

	public boolean isValidSudokuAtCell(int[][] board, int i, int j) {
		if (!isValidRow(board, i))
			return false;
		if (!isValidCol(board, j))
			return false;
		if (!isValidBox(board, i - i % bn, j - j % bn))
			return false;
		return true;
	}

	public static void main(String[] args) {
		String[] testInputStr = new String[] { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.." };
		char[][] testInput = new char[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				testInput[i][j] = testInputStr[i].charAt(j);
			}
		}

		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(testInput);
	}
}
