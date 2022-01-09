// Time Complexity: O(m*n*3^l) (time to traverse * 3 decision raise to length of string)-> (3^l)
// Space Complexity: O(l) recursive stack space
// Backtracking w/o space
public class WordSearch {
    int n , m;
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        n = board.length; 
        m = board[0].length;
        dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1,0}};
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(board[i][j] == word.charAt(0))
                    if(backtrack(board, word, 0, i , j))
                        return true;
            }
        }
    
        return false;
    }
    
    
    private boolean backtrack(char[][]board, String word, int index,  int r, int c)
    {
        // base
        if(index == word.length())
            return true;
        
        if(r < 0 || r == n || c < 0 || c == m || board[r][c] == '#')
            return false;
        
        // recursive
        if(word.charAt(index) == board[r][c])
        {
            char currChar = board[r][c];
            // mark visited by converting to diff val
            board[r][c] = '#'; 
            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, index+1, nr, nc, visited))
                    return true;
            }
            board[r][c] = currChar; 
        }
        return false;
    }
}

// Time Complexity: O(m*n*3^l) -> (3^l)
// Space Complexity: O(l) + O(m*n)
// Backtracking extra space
public class WordSearch {
    int n , m;
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        n = board.length; 
        m = board[0].length;
        dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1,0}};
        boolean visited [][] = new boolean[n][m];
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(board[i][j] == word.charAt(0))
                    if(backtrack(board, word, 0, i , j, visited))
                        return true;
            }
        }
    
        return false;
    }
    
    
    private boolean backtrack(char[][]board, String word, int index,  int r, int c, boolean [][] visited)
    {
        // base
        if(index == word.length())
            return true;
        
        if(r < 0 || r == n || c < 0 || c == m || visited[r][c])
            return false;
        
        // recursive
        if(word.charAt(index) == board[r][c])
        {
            visited[r][c] = true;   
            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, index+1, nr, nc, visited))
                    return true;
            }
            visited[r][c] = false;
        }
        return false;
    }
}
