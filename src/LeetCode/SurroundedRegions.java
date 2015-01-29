package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	class Cell {
		int i;
		int j;

		public Cell(int iv, int jv) {
			i = iv;
			j = jv;
		}
	}

	int m;
	int n;

	public void solve(char[][] board) {
		m = board.length;
		if (m == 0)
			return;

		n = board[0].length;
		if (n == 0)
			return;

		for (int i = 0; i < m; ++i) {
			floodAtCell(board, i, 0);
			floodAtCell(board, i, n - 1);
		}
		for (int j = 0; j < n; ++j) {
			floodAtCell(board, 0, j);
			floodAtCell(board, m - 1, j);
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == '1') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void floodAtCell(char[][] bd, int i, int j) {
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(i, j));
		while (q.size() > 0) {
			Cell curCell = q.poll();
			if (curCell.i < 0 || curCell.i >= m || curCell.j < 0 || curCell.j >= n) {
				continue;
			}
			if (bd[curCell.i][curCell.j] == 'X' || bd[curCell.i][curCell.j] == '1') {
				continue;
			}

			bd[curCell.i][curCell.j] = '1';
			q.add(new Cell(curCell.i - 1, curCell.j));
			q.add(new Cell(curCell.i + 1, curCell.j));
			q.add(new Cell(curCell.i, curCell.j - 1));
			q.add(new Cell(curCell.i, curCell.j + 1));

		}
	}
}
