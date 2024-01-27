// Time Complexity :O(M * N * 4^L)  where M and N are the dimensions of the board, and L is the length of the word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Y 


public class WordSearch {
    private int [][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null)
            return false;
        this.m = board.length;
        this.n = board[0].length;
        dirs = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i =0; i< m ; i++)
        {
            for(int j =0; j< n; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(helper(board, i, j, word, 0))
                        return true;
                }
            }
        } 
        return false;   

    }
    public boolean helper(char[][] board,int r, int c, String word, int idx)
    {
        if(idx == word.length())
            return true;

        //base
        if(r<0 || c<0 || r ==m || c == n || board[r][c] == '#')
            return false;

        //logic
        if(board[r][c] == word.charAt(idx))
        {
            board[r][c] = '#';
            ///recurse
            for(int [] dir : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(helper(board, nr, nc, word, idx+1))
                {
                    return true;
                }
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }

    public static void main(String[] args)
    {
        WordSearch g = new WordSearch();
        char[][] arr = { { 'A','B','C','E'}, { 'S','F','C','S' },{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(g.exist(arr,word));
        
    } 
}
