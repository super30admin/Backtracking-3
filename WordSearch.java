
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

/*
This code solves the Word Search problem using Depth-First Search (DFS).
The algorithm explores each cell in the board, recursively trying to match the characters of
the given word while marking cells as visited to avoid revisiting them.
It checks all four possible directions (up, down, left, right) from each cell.
If a complete match of the word is found, it returns true; otherwise,
it backtracks by resetting the visited cells.
The DFS ensures that the search explores all potential paths efficiently.
* */

public class WordSearch {
    int[][] dirs;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        int m=board.length;
        int n=board[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dfs(board,i,j,word,0)) return true;
            }

        }
        return false;
    }
    private boolean dfs(char[][] board,int row,int col,String word,int index)
    {
        if(index==word.length())
        {
            return true;
        }
        if(row<0 || col<0 || row==visited.length || col==visited[0].length || visited[row][col]==true)
            return false;



        if(word.charAt(index)!=board[row][col])
            return false;

        visited[row][col]=true;
        for(int[] dir:dirs)
        {
            int r=row + dir[0];
            int c=col + dir[1];
            if(dfs(board,r,c,word,index + 1))
                return true;
        }
        visited[row][col]=false;
        return false;
    }
}
