// Time Complexity: O((m*n) * 3^L) - L is the length of the string
//  Space Complexity: O(L)

class Solution {
    int m, n;
    boolean flag;
    String word;
    int dirs[][];

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.flag = false;
        this.word = word;
        this.dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!flag){
                    dfs(board, i, j, 0);
                }
            }
        }
        return flag;

        
    }

    private void dfs(char board[][], int i, int j, int ind){
        // base case
        if(ind == word.length()){
            flag = true;
            return;
        }

        if(i<0 || j<0 || i>=m || j>=n || board[i][j] == '#') return;

        if(board[i][j] != word.charAt(ind)) return;

        // logic
        board[i][j] = '#';
        for(int dir[] : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            // if(r>=0 && c>=0 && r<m && c<n )
            dfs(board, r,c, ind + 1);

        }
        board[i][j] = word.charAt(ind);

    }
}