//TC:O(mn)*(3^l)
//DFS AND BACKTRACKING :: l is length of the string
//SC: O(l)

//connected components so, we can do DFS
//here we can use BFS the Queue can't track the visited locations exactly.
class Solution {
    
    private int[][] dirs;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {

        m=board.length;
        n=board[0].length;

        dirs = new int[][]{
            {1,0} , {-1,0} , {0,-1} , {0,1}
        };

        for(int i=0; i<m ;i++){
            for(int j=0; j<n;j++){
                if(backtrack(board, word, i,j,0)) return true;
            }
        }

        return false;
        
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length()) return true;
        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#') return false;

        

        //logic
        if(board[i][j] == word.charAt(index)){
            //action
            board[i][j] ='#';

            //recursion
            for(int[] dir : dirs){
                int nr = i+dir[0];
                int nc = j+dir[1];

                if(backtrack(board , word, nr, nc , index+1)) return true;
            }

            //backtrack
            board[i][j] = word.charAt(index);
        }

        return false;
    }
}
