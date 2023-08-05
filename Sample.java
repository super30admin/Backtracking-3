//Problem 1: NQueens
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> Do dfs traversal on below rows, and insert true in boolean matrix if it is a valid combination(isSafe function)
// it wont recurse to the last row if there is no valid place for next row queen. if it recursion finishes last row means they have found a combination,-> add to list
class Solution {
    List<List<String>> res;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.res=new ArrayList<>();
        this.n=n;
        if(n==0) return res;
        boolean[][] board= new boolean[n][n]; //to keep track of visited locations
        helper(board, 0);
        return res;
    
    private void helper(boolean[][] board, int row){
        //base
        if(row==n){ //came to final row
            List<String> li= new ArrayList<>();
            for(int j=0;j<n;j++){
                StringBuilder sb=new StringBuilder(); //stringbuilder for each row
                for(int i=0;i<n;i++){
                    if(board[j][i]) // if it is true, means queen exists there
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(sb.toString()); //add String to list
            }
            res.add(li);//one of the possibility added
        }

        //logic
        for(int j=0;j<n;j++){
            if(isSafe(board, row, j)){
                //action
                board[row][j]=true;
                helper(board, row+1);
                //backtrack
                board[row][j]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        //col up
        for(int j=0;j<row;j++){ //check for all above columns
            if(board[j][col]) return false;
        }

        //diagonal up right
        int i=row, j=col;
        while(i>=0 && j<n){ //check for row and col in bounds
            if(board[i][j]) return false;
            i--; j++; //check next diagonal up right
        }
        //diagonal up left
        i=row; j=col;
        while(i>=0 && j>=0){ //check row and col in bounds
            if(board[i][j]) return false;
            i--; j--; //check next diagonal up left
        }
        return true;
    }
}



//Problem 2: Word Search
// Time Complexity : O(l*mn) l is length of word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Approach -> do dfs traversal on all neighbors, check if we find the word in matrix. 
class Solution {
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(word==null) return true;
        this.m=board.length;
        this.n=board[0].length;
        this.dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board, word, i, j, 0))return true;
            }
        }
        return false;
    }
    // private void helper(char[][] board, String word, int i, int j, int idx){
    //     //base
    //     if(idx==word.length()){
    //         flag=true;
    //         return;
    //     }
    //     if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='.')
    //         return;
    //     //logic
    //     if(board[i][j]==word.charAt(idx)){
    //         //action
    //         board[i][j]='.';
    //         for(int[] dir: dirs){
    //             int nr= dir[0]+i;
    //             int nc= dir[1]+j;

    //             if(!flag){
    //                 helper(board, word, nr, nc, idx+1);
    //             }
    //             if(flag) break;
    //         }
    //         //backtrack
    //         board[i][j]=word.charAt(idx);
    //     }
    // }

    //boolean based recursion.
    private boolean helper(char[][] board, String word, int i, int j, int idx){
        //base
        if(idx==word.length()){ //if word pointer has reached, means word is found, return true
            return true;
        }
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='.') // if bounds hit or letter is visited, return false, means word isnt valid as not completed
            return false;
        //logic
        if(board[i][j]==word.charAt(idx)){ // if board value is equal then only proceed
            //action
            board[i][j]='.'; //mark visited
            for(int[] dir: dirs){ //check for all 4 directions
                int nr= dir[0]+i;
                int nc= dir[1]+j;

                
                if(helper(board, word, nr, nc, idx+1)) //recursive call for next letter in direction
                    return true;
                
            }
            //backtrack
            board[i][j]=word.charAt(idx); //backtrack, maybe there can be another path so mark it same word character.
        }
        return false; //base value for function, we wont reach here.
    }
}