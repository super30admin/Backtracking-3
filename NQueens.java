package backtracking3;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<List<String>> solveNQueens(int n) {

		char[][] puzzle = new char[n][n];
		List<List<String>> solutionSet = new ArrayList<List<String>>();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				puzzle[i][j] = '.';

		NQueens(solutionSet, n, 0, 0, puzzle, 0);
		return solutionSet;
	}

	public void NQueens(List<List<String>> solutionSet, int n, int row, int col, char[][] puzzle, int queenNo) {

		if (isQueenSafe(puzzle, row, col, n)) {
			puzzle[row][col] = 'Q';

			if (queenNo == n - 1) {
				puzzleToString(solutionSet, puzzle, n);
				puzzle[row][col] = '.';
				return;
			} else {
				if (col < n - 1)
					NQueens(solutionSet, n, 0, col + 1, puzzle, queenNo + 1);
				puzzle[row][col] = '.';
			}

		}
		// check row and cols boundarry
		if (row < n - 1)
			NQueens(solutionSet, n, row + 1, col, puzzle, queenNo);
	}

	// This function adds found placing to solutionset
	public void puzzleToString(List<List<String>> solutionSet, char[][] puzzle, int n) {
		StringBuilder sb;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(puzzle[i][j]);
			}
			result.add(sb.toString());

		}
		solutionSet.add(result);
	}

	// Row and col for current place of a queen
	public boolean isQueenSafe(char[][] puzzle, int row, int col, int n) {

		// check for left && right
		for (int i = (col + 1) % n; i != col && i < n; i = (i + 1) % n)
			if (puzzle[row][i] != '.')
				return false;

		// check for up & down
		for (int i = (row + 1) % n; i != row && i < n; i = (i + 1) % n)
			if (puzzle[i][col] != '.')
				return false;

		// right -bottom
		for (int i = row + 1, j = col + 1; i >= 0 && j >= 0 && i < n && j < n; i = i + 1, j = j + 1)
			if (puzzle[i][j] != '.')
				return false;

		// right - up
		for (int i = row - 1, j = col + 1; i >= 0 && j >= 0 && i < n && j < n; i = i - 1, j = j + 1)
			if (puzzle[i][j] != '.')
				return false;
		// left - top
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 && i < n && j < n; i = i - 1, j = j - 1)
			if (puzzle[i][j] != '.')
				return false;
		// left bottom
		for (int i = row + 1, j = col - 1; i >= 0 && j >= 0 && i < n && j < n; i = i + 1, j = j - 1)
			if (puzzle[i][j] != '.')
				return false;

		return true;
	}
}