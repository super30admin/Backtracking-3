

//Time Complexity: n^n
//Space Complexity: N^2



class Solution {

	private List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] b : board) {
			Arrays.fill(b, '.');
		}
		helper(board, 0);
		return res;
	}


	private void helper(char[][] board, int row) {
		if (row == board.length) {
			res.add(construct(board));
		} else {
			for (int j = 0; j < board.length; j++) {
				if (isValid(board, row, j)) {
					board[row][j] = 'Q';
					helper(board, row + 1);
					board[row][j] = '.';
				}
			}
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'Q' && (row - i == col - j || row - i == j - col
						|| col == j))
					return false;
			}
		}
		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> temp = new ArrayList<>();
		for (char[] b : board) {
			String s = new String(b);
			temp.add(s);
		}
		return temp;
	}
}
