//Time Complexity: O(m*n*(3^l)); where m is the no. of rows, n is the no. of columns and l is the length of the word.
//Space Complexity: O(l); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem2 {

    
    int m,n;
    int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
    int index;
    String word;
    public boolean exist(char[][] board, String word) {
        
        if(board == null|| board.length == 0)
            return false;
        
        m = board.length;
        n = board[0].length;
        this.word = word;
        
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                
                if(backtrack(board,i,j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int r, int c){
        
        if(index == word.length())
            return true;
        
        if(r < 0 || r >= m|| c <0 || c >= n|| board[r][c] != word.charAt(index))
         return false;
        
        if(board[r][c] == word.charAt(index))
        {
            index++;
            char d = board[r][c];
            board[r][c] = '#';
            
            for(int[] dir: dirs){
                
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(backtrack(board, nr, nc))
                    return true;
            }
            
            index--;
            board[r][c] = d;
        }
        
        return false;
    }
}
