//Time Complexity : O(3^L * N) where L is the length of the word string and N is the node (m*n)
//Space Complexity: O(L)

//Successfully runs on leetcode: 10 ms

//Approach: Here we start with searching the first character of the required word string and then perform dfs plus backtracking
//in order to find the required full word. In this process, as we encounter any word - we replace it with a '#' and check 
//the neighbors of this word to find the next character. If, the character is not found at any point - we backtrack by making
//'#' to the original character and then search for the word in other direction. We return true/ false accordingly


class Solution {
    private int m; 
    private int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(dfsAndBacktrack(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfsAndBacktrack(char[][] board, String word, int i, int j, int index)
    {
        //base
        if(index == word.length()) return true;
        if(i < 0 || i == m || j < 0 || j == n || board[i][j] == '#') return false;
        
        
        //logic
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(word.charAt(index) == board[i][j])
        {
            char temp = board[i][j];
            board[i][j] = '#';
            for(int[] dir: dirs)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(dfsAndBacktrack(board,word,r,c,index+1))
                        return true;
                }
            board[i][j] = temp;
        }
        return false;
    }
}