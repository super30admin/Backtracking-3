/**
 * Time Complexity : O(N!)
 * Space Complexity: O(N)
 */

class Solution {
    public List<List<String>> solveNQueens(int N) {
	List<List<String>> res = new ArrayList<List<String>>();
	if(N<1) return res;
	char[][] board = new char[N][N];
	for(char[] row : board) {
		for(int j=0; j<N; j++) {
			row[j] = '.';
		}
	}
	solve(board, N, 0, res);
	return res;
}
private boolean solve(char[][] board, int N, int col, List<List<String>> res) {
	if(col==N) { // done soving, simply add the board into the result
		List<String> list = new ArrayList<String>();
        for(int i = 0; i < N; i++) {
            list.add(String.valueOf(board[i]));
        }
		res.add(list);
		return false; // return false so will backtrack
	}
	for(int i=0; i<N; i++) {
		if(isSafe(board, N, i, col)) {
			board[i][col] = 'Q'; // greedy
			if(solve(board, N, col+1, res)) return true;
			else board[i][col] = '.'; // backtrack
		}
	}
	return false;
}
private boolean isSafe(char[][] board, int N, int row, int col) {
	for(int i=0; i<N; i++) {
		if(board[i][col]!='.') return false;
		if(board[row][i]!='.') return false;
	}
	int step = 1;
	while(row-step>=0 && col-step>=0)
		if(board[row-step][col-step++]!='.') return false;
	step = 1;
	while(row+step<N && col-step>=0)
		if(board[row+step][col-step++]!='.') return false;
	return true;
}
}