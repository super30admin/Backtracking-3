//Approach: idea here is first check the first character in word if its present in board then check next element in word in its neighboring element
//to check neighboring element in 4 directions call recursive function 4 times.
//to make sure same letter cell may not be used make current letter cell null while checking its neighboring element and ater checking neighboring element again 
//set its value as before.
//if we don't want to modify input array then keep boolean visitedArray  and make it true for i and j inside dfs function and check its status.

//time complexity :o(m*n) where m are rows and n are columns //need  more clarity about dfs fucntion time complexity

//space complexity: in place modification of input array  but due to recusrion in worst case space require is O(N)


public class WordSearch {
	    public static boolean exist(char[][] board, String word) {
	        int rows = board.length;
	        int col = board[0].length;
	        for(int i =0; i<rows;i++){
	            for(int j=0;j<col;j++){
	                if(board[i][j]==word.charAt(0) && dfs(board, word, 0, i,j)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    
	    public static  boolean dfs(char[][] board, String word, int index, int i , int j){
	    	
	    	
	    	//if this condition is true it means all elements in word are found in board because index reached till last element of word and till this stage false is not return.
	        if(index == word.length()) return true;
	        
	        if(i<0 || i>=board.length|| j<0 ||j>=board[i].length || board[i][j]!=word.charAt(index)){
	            return false;
	        }
	        char temp = board[i][j]; //store board value in temp variable
	        board[i][j] = ' ';//make sure same letter  cell is not repeated
	        
	        //check neighboring element of board[i][j] in 4 direction
	       boolean found =dfs(board, word, index+1, i+1,j) ||
	          dfs(board, word, index+1, i,j+1) ||
	          dfs(board, word, index+1, i-1,j) ||
	          dfs(board, word, index+1, i,j-1);
	          
	        board[i][j] = temp; //in place implementation without visited array
	        return found;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= { {'A','B','C','E'},{'S','F','C','S'},
				{'A','D','E','E'}};
		String word ="ABCCED";
		boolean flag = exist(board, word);
		System.out.println("word is present in board="+flag);

	}

}
