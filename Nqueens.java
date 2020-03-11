//Not correct Still trying 

// Place a queen at a safe column in a row 
	// Move to next row for next queen
	// If all are safe, result is found.
	// Backtrack


public List<List<String>> solveNQueens(int n) {
	

	List<List<String>> result = new ArrayList<>();
	

	char[][] board = new char[n][n];
	//CREATE A BOARD
    
    for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			board[i][j] = '.';

	dfs(board, 0, result, n);

	return result;
}

private void dfs(char[][] board, int row, List<List<String>> result, int n) {
    //goal
	if (row == n) {
        List<String> state = new ArrayList<>();

	for (int i = 0; i < n; i++) {
		StringBuilder sb = new StringBuilder(n);
		for (int j = 0; j < n; j++)
			sb.append(board[i][j]);
		state.add(sb.toString());
	}
		result.add(state);
		return;
	}

	for (int col = 0; col < n; col++) {
		if (isValid(board, row, col,n)) {
			board[row][col] = 'Q';
			dfs(board, row + 1, result,n);
			board[row][col] = '.';
		}
	}
}
private boolean isValid(char[][] board, int row, int col, int n) {
	
	if (board[row][col] == 'Q') return false;
	for (int r = row - 1; r >= 0; r--)
		if (board[r][col] == 'Q') return false;
	for (int r = row + 1; r < n; r++)
		if (board[r][col] == 'Q') return false;

	for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
		if (board[r][c] == 'Q') return false;

	for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++)
		if (board[r][c] == 'Q') return false;

	return true;
}



