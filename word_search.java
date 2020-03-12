

//Author Aupadhye
//Space complexity: O(L) that is the length of the word.  
//Time Complexity O(N^2) since we perform dfs on the whole matrix
public class word_search {

	
	  public boolean exist(char[][] board, String word) {
	        int m = board.length, n = board[0].length;
	        if (word.length() > m*n) {//If word is greater than dimensions then return true
	            return false;
	        }
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (dfs(board, i, j, word, 0)) {//Iterate through all elements for checking the word
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    private boolean dfs(char[][] board, int row, int col, String word, int index) {
	        if (row >= board.length || row < 0 || col >= board[row].length || col < 0) {
	            return false;//Check for bounds
	        }
	        
	        if (board[row][col] == word.charAt(index)) {
	            if (index == word.length() - 1) {
	                return true;// If last letter is encountered then return true, this means that the word is found
	            }

	            char t = board[row][col];
	            board[row][col] = '#';// Coat the state so that we dont have to iterate through the state
	            
	            if (dfs(board, row - 1, col, word, index + 1)) {//Perform dfs on all four components.
	                return true;
	            }
	            if (dfs(board, row + 1, col, word, index + 1)) {
	                return true;
	            }
	            if (dfs(board, row, col - 1, word, index + 1)) {
	                return true;
	            }
	            if (dfs(board, row, col + 1, word, index + 1)) {
	                return true;
	            }
	            
	            board[row][col] = t;//Assign the letter to string
	        }
	        
	        return false;
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	String word = "ABCCED";
	    	char[][] mat = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	    	
	    	word_search obj = new word_search();
	    	System.out.println(obj.exist(mat, word));
	    }
	
	
}
