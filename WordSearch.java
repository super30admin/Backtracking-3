//Time Complexity : O(n^m.3^l) l is length of word
//Space Complexity : O(n) stack space

class Solution {

    int[][] directions;
    int m,n;

    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0)
            return false;

        m = board.length;
        n = board[0].length;

        directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(helper(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    //index on the word
    private boolean helper(char[][] board, String word, int r, int c, int index)
    {
        //base
        //index has reached end of word
            if(index == word.length())
                return true;

        //check bounds and if we can't go in a directions (neighbor is visited already)
        if(r<0 || r==m || c<0 || c==n || board[r][c] == '#')
            return false;

        //logic
        if(board[r][c] == word.charAt(index))
        {
            //action - mark visited
            char ch = board[r][c];
            board[r][c] = '#';
            //recurse
            for(int[] d : directions)
            {
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(helper(board, word, nr, nc, index+1))
                    return true;
            }
            //backtrack - put back the character, not needed in our path
            board[r][c] = ch;
        }

        //none of the directions worked
        return false;
    }
}
