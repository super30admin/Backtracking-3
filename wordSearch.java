class Solution {
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m;i++){
            for(int j =0; j<n; j++){
                if(backtrack(board, word, 0, i, j, m, n)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int r, int c, int m, int n){


        if(idx == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c] == '#') return false;
        if(word.charAt(idx) == board[r][c]){
            //action
            
            board[r][c] = '#';
            //recurse
            for(int [] dir: dirs){
                int nr = dir[0] + r ;
                int nc = dir[1] + c;
                if(backtrack(board, word, idx+1, nr, nc, m , n)) return true;
            }
            board[r][c] = word.charAt(idx);

        }
        return false;
    }
}

/*
TC : the overall time complexity is O(4^word.length()), which can be simplified to O(4^N), where N is the length of the word.

SC : O(N)

Description : 

We can do this by doing DFS. Is there any backtracking in this question ?

There is backtracking, but exploring all the paths is recursion. It's not backtracking.

Action, recurse, backtrack is back tracking.

 If I visit all directions of a particular letter, and my recursion goes back. Then this letter is visited. If I visit this letter again → It will be visited but it's not used in our word.

We can't backtrack on BFS. because we add all nodes inside the queue. So we can do backtracking only in DFS. 

TC : mn 3^L → “3” every node there are 3 choices. “L” depth is length of the string. 
 


 */