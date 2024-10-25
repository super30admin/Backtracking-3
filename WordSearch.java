//we can use bfs or dfs because we have connected components
//we need backtracking in this problem because if we have visited a char and marked it visited and if it comes
//again in curr path it will be lost, so backtracking from that char is needed.
// we can not do bk using bfs, we need dfs for bk.

//TC- each baby is producing almost 3 child at a time for the word's length that is n s0 O(3^n)*m*n(for matrix traversal)
//SC- stack space - O(n)
// //void based recurssion
// class Solution {
//     int m,n;
//     int[][] dirs;
//     boolean flag;
//     public boolean exist(char[][] board, String word) {
//         this.m = board.length;
//         this.n = board[0].length;
//         this.flag = false;
//         this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

//         for(int i = 0;i<m;i++){
//             for(int j= 0; j<n;j++){
//                 if(!flag){
//                     helper(board, i, j, word, 0);
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return flag;
//     }

//     private void helper(char[][] board, int i, int j, String word, int idx){
//         //base
//        if(idx == word.length()){// if the len of word is 1 then we need to do this first
//             flag = true;
//             return;
//         }
        
//         if(i<0 || j<0 || i==m || j == n || board[i][j] == '#'){
//             return;
//         }
        
//         //logic
//         if(word.charAt(idx) == board[i][j]){
//             //action
//             board[i][j] = '#';
//             //recurssion
//             for(int[] dir: dirs){
//                 int r = i + dir[0];
//                 int c = j + dir[1];
//                 if(!flag){
//                 helper(board, r, c, word, idx+1);
//                 }
//             }
//             //backtrack when we are done with all the children of board[i][j], backtrack 
//             board[i][j] = word.charAt(idx);

//         }
//     }
// }

//boolean based recurssion
class Solution {
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i = 0;i<m;i++){
            for(int j= 0; j<n;j++){
               if(helper(board, i, j, word, 0)){
                    return true;
               }
               
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int idx){
        //base
       if(idx == word.length()){// if the len of word is 1 then we need to do this first
           return true;
        }
        
        if(i<0 || j<0 || i==m || j == n || board[i][j] == '#'){
            return false;
        }
        
        //logic
        if(word.charAt(idx) == board[i][j]){
            //action
            board[i][j] = '#';
            //recurssion
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(helper(board, r, c, word, idx+1)){
                return true;
                }
            }
            //backtrack when we are done with all the children of board[i][j], backtrack 
            board[i][j] = word.charAt(idx);

        }
        return false;
    }
}