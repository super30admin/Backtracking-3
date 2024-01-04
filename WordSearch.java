//T.C O(m*n)
//S.C O(L) //recursive stack space will be of the length of given input word
//Did the code run in LeetCode: yes

//Using DFS approach to check if each letter matches the input word char, if yes, then use direction matrix for the next char.
// Use backtracking to reverse the path if next correct char isnt found.
public class WordSearch {
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        if(m==0||board == null || word.length() == 0) return false;

        for(int i=0;i<m;i++){ //O(m*n)
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j){
        //base case
        if(i<0 || i>=m ||j <0 || j>=n|| board[i][j] == '#')
            return false;

        //logic
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        if(board[i][j] == word.charAt(0)){
            if(word.length()==1) return true;
            char prev = board[i][j];
            board[i][j]='#';
            for(int[] dir: dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(dfs(board,word.substring(1),r,c))
                    return true;
            }

            //backtrack
            board[i][j] = prev;
        }
        return false;
    }

}