/* 79. Word Search
Time Complexity: O(m*n*3^l) where l is the lenth of the word, 3 because we have 3 decisions to make when we come from the parent top node which is the 4th direction.
Space Complexity: O(m*n) for the recursive call stack and the boolean visited array

DFS with backtracking => mark a cell in the matrix as visited only when there is a match, here we use a boolean visited array. can be solved without extra space, similar to game of life. |||ar to Critical Connections in a Network question
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

        //observe what is getting changed, word right? so 
        // if(word.length() == 0)
        //     return true; 
        //implies we processsed all the chars and is present in the dfs path of the board

        //logic
        if(word.charAt(0) == board[i][j]){
            // if this is the last character to be matched or a word with one letter ['a']
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
            // travelled all 4 directions, could not find a match hence backtrack by marking visited as false
            visited[i][j] = false;
        }
        return false;
    }
}

/*
Time Complexity: O(m*n) * 3^l // l -> length of the word
Space Complexity: O(1)

find where is the fist element of the word.
then perform dfs on that particular index.
also, mutate the current board value while performing dfs such that, there is no loop. after the dfs is completed for a parent, revert back the value of the board index.
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


