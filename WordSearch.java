/* Time Complexity: O(m*n*3^l) where l is the length of the word
Space Complexity: O(m*n) we used a 2D visited array
Approach: DFS with backtracking: mark a cell in the matrix as visited only when there is a match
*/

class Solution {
    private int m;
    private int n;
    boolean[][] visited;
    int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;

        if(board == null || m==0)
            return false;

        n = board[0].length;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j){
        //Base Cases
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])
            return false;

        //logic
        if(word.charAt(0) == board[i][j]){
            // last character or word of length 1
            if(word.length() == 1)
                return true;

            visited[i][j] = true;
            // run dfs on all 4 dirs
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];

                if(dfs(board, word.substring(1), r, c))
                    return true;
            }
            // after all 4 traversals, no match, so backtrack
            visited[i][j] = false;
        }
        return false;
    }
}

/*
Time Complexity: O(m*n*3^l) where l is the length of the word
Space Complexity: O(1)
Approach: without using a visited array
*/
class Solution {
    int [][] dirs = new int [][] {{0,1},{1,0},{-1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {

        boolean result=false;

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            {
                if(word.charAt(0) == board[i][j])
                    result=helper(board,word,i,j,0);
                if(result==true)
                    return true;
            }
        return false;
    }


    boolean helper(char[][] board, String word, int row,int col,int index){

        if(board[row][col] != word.charAt(index) || board[row][col]== (char)'\0')
            return false;

        if(index==word.length()-1)
            return true;

        char temp=board[row][col];
        board[row][col] = (char)'\0';
        boolean result=false;

        for(int [] dir : dirs)
        {
            int i=row+dir[0];
            int j=col+dir[1];

            if(i>=0 && i< board.length && j>=0 && j< board[0].length)
            {
                result =helper(board,word,i,j,index+1);

                if(result==true)
                {
                    board[row][col] = temp;
                    return true;
                }
            }
        }

        board[row][col] = temp;

        return false;
    }
}