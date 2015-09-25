package cc.megamind.leetcode;

public class WordSearch {

	public static void main(String[] args) {
		char[][] A = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCEE";
		System.out.println(exist(A, word));
	}

	public static boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0 || word == null) {
			return false;
		}
		if (word == "") {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int k = 0;
				if (search(i, j, k, board, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean search(int i, int j, int k, char[][] board,
			String word) {
		char[] wd = word.toCharArray();
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (wd[k] == board[i][j]) {
			char temp = board[i][j];
			board[i][j] = '#';
			if (k == wd.length - 1) {
				return true;
			}
			if (search(i + 1, j, k + 1, board, word)
					|| search(i - 1, j, k + 1, board, word)
					|| search(i, j + 1, k + 1, board, word)
					|| search(i, j - 1, k + 1, board, word)) {
				return true;
			}
			board[i][j] = temp;
		}
		return false;
	}
}
