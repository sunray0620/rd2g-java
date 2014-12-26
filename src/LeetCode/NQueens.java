package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static List<String[]> solveNQueens(int n) {
		boolean[] colSeen = new boolean[n];
		boolean[] diagSeen1 = new boolean[2 * n + 1];
		boolean[] diagSeen2 = new boolean[2 * n + 1];
		char[][] board = new char[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = '.';
			}
		}
		List<String[]> ret = new ArrayList<String[]>();
		solveNQueensAtLine(n, 0, colSeen, diagSeen1, diagSeen2, board, ret);
		return ret;
	}

	public static void solveNQueensAtLine(int n, int i, boolean[] colSeen, boolean[] diagSeen1, boolean[] diagSeen2, char[][] board, List<String[]> ret) {
		if (i == n) {
			String[] sln = new String[n];
			for (int kk = 0; kk < n; ++kk) {
				sln[kk] = new String(board[kk]);
			}
			ret.add(sln);
		}
		for (int j = 0; j < n; ++j) {
			if (colSeen[j] || diagSeen1[i + j] || diagSeen2[n - 1 + i - j])
				continue;
			colSeen[j] = diagSeen1[i + j] = diagSeen2[n - 1 + i - j] = true;
			board[i][j] = 'Q';
			solveNQueensAtLine(n, i + 1, colSeen, diagSeen1, diagSeen2, board, ret);
			board[i][j] = '.';
			colSeen[j] = diagSeen1[i + j] = diagSeen2[n - 1 + i - j] = false;
		}
	}

	public int totalNQueens(int n) {
		boolean[] colSeen = new boolean[n];
		boolean[] diagSeen1 = new boolean[2 * n + 1];
		boolean[] diagSeen2 = new boolean[2 * n + 1];
		int[] ret = new int[1];
		solveNQueensAtLine(n, 0, colSeen, diagSeen1, diagSeen2, ret);
		return ret[0];
	}

	public static void solveNQueensAtLine(int n, int i, boolean[] colSeen, boolean[] diagSeen1, boolean[] diagSeen2, int[] ret) {
		if (i == n) {
			++ret[0];
		}
		for (int j = 0; j < n; ++j) {
			if (colSeen[j] || diagSeen1[i + j] || diagSeen2[n - 1 + i - j])
				continue;
			colSeen[j] = diagSeen1[i + j] = diagSeen2[n - 1 + i - j] = true;
			solveNQueensAtLine(n, i + 1, colSeen, diagSeen1, diagSeen2, ret);
			colSeen[j] = diagSeen1[i + j] = diagSeen2[n - 1 + i - j] = false;
		}
	}

	public static void main(String[] args) {
		solveNQueens(8);
	}
}
