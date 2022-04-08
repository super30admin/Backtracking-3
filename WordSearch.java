//Time Complexity: Exponential O(m*n*3^L)
//Space Complexity: O(L) ; where L is length of the word
public class WordSearch {	
	/**Approach: DFS + Backtrack**/
	int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        dirs= new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        m= board.length;
        n= board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(helper(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int r, int c, int index){
        //base
        if(index == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c]=='#') return false;        
        
        //logic
        if(board[r][c]==word.charAt(index)){            
            //action
            char ch= board[r][c];
            board[r][c]='#';
            //recurse
            for(int[] dir: dirs){
                int nr= r+dir[0];
                int nc= c+dir[1];                
                if (helper(board, word, nr, nc, index+1)) return true;
            }        
            //backtrack
            board[r][c]=ch;            
        }
        return false;
    }
	
	// Driver code to test above 
	public static void main (String[] args) {
		WordSearch ob = new WordSearch();
    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	String word = "SEE";  	
    	
		System.out.println("Is word found on the board? "+ob.exist(board, word));
	}
}
