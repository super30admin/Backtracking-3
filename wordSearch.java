// TC: O(n * pow(3, l)) 
// SC : O(L) length of the word to be matched

// Traverse through the board and check if the words are present in the board. We can traverse the board in only four directions, 
// Since we can only go through four directions, we traverse through the four directions in the board and check if any of the four directions have the matching
// word, if present, return true, similary we check every character in the word to board and at any point we dont find the solution, we return false;

public class wordSearch {

	public boolean exists(char[][] board, String word) {
		
		char[] ch = word.toCharArray();
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(backTrack(board, i, j, ch, 0))
					return true;
			}
		}
		return false;
	}
	
	public boolean backTrack(char[][] board, int i, int j, char[] word, int index) {
		if(index == word.length)
			return true;
		
		if(i<0 || j<0 || i>=board.length || j>=board[0].length)
			return false;
		
		if(board[i][j]!=word[index])
			return false;
		board[i][j] ^= 256;
		
		boolean exist = backTrack(board, i+1, j, word, index+1) || backTrack(board, i, j+1, word, index+1) 
				|| backTrack(board, i, j-1, word, index+1)
				|| backTrack(board, i-1, j, word, index+1);
		board[i][j] ^=256;
		return exist;
	}
	
	public static void main(String[] args) {
		
		wordSearch ws = new wordSearch();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCED";
		System.out.println(ws.exists(board, word));
	}
}
