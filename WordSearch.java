package backtracking3;

public class WordSearch {

	// start with 0,0 and scan for first character in the word
	// If we get first character, use backtracking to explore all 4 directions
	// recursively.
	// if at any point character does not match then return false;
	// else continue as long as characters keep matching.

	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return false;
		boolean result = false;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0))
					result = checkWord(board, word, 0, i, j);

				if (result)
					return result;
			}
		return result;
	}

	public boolean checkWord(char[][] board, String word, int index, int row, int col) {
		char original;

		if (!(row >= 0 && row < board.length && col >= 0 && col < board[0].length && index < word.length()))
			return false;

		if (board[row][col] == word.charAt(index)) {
			original = board[row][col];
			board[row][col] = '\0'; // To prevent from using same letter again
			if (index == word.length() - 1)
				return true;
			else {
				// Up
				if (checkWord(board, word, index + 1, row - 1, col))
					return true;
				// Down
				if (checkWord(board, word, index + 1, row + 1, col))
					return true;
				// left
				if (checkWord(board, word, index + 1, row, col - 1))
					return true;
				// right
				if (checkWord(board, word, index + 1, row, col + 1))
					return true;
			}
			board[row][col] = original;
		}
		return false;
	}

}