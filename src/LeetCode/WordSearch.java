package LeetCode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Corner case
		if (word.length() == 0 || board.length == 0 || board[0].length == 0) {
			return false;
		}

		int boardheight = board.length;
		int boardwidth = board[0].length;
		boolean[][] used = new boolean[boardheight][boardwidth];

		for (int i = 0; i < boardheight; ++i) {
			for (int j = 0; j < boardwidth; ++j) {
				if (existHere(board, j, i, word, 0, used)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean existHere(char[][] board, int bx, int by, String word, int wPos, boolean[][] used) {
		int wordLength = word.length();
		int boardwidth = board[0].length;
		int boardheight = board.length;

		if (wPos == wordLength) {
			return true;
		}
		if (bx < 0 || bx >= boardwidth || by < 0 || by >= boardheight) {
			return false;
		}
		if (used[by][bx]) {
			return false;
		}
		if (word.charAt(wPos) != board[by][bx]) {
			return false;
		}
		used[by][bx] = true;
		boolean validResult = existHere(board, bx - 1, by, word, wPos + 1, used) || //
				existHere(board, bx + 1, by, word, wPos + 1, used) || //
				existHere(board, bx, by - 1, word, wPos + 1, used) || //
				existHere(board, bx, by + 1, word, wPos + 1, used);
		used[by][bx] = false;
		return validResult;
	}
}
