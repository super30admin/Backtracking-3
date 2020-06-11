/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 Tc : O(n^n)
 Sc : O(n^2)
 */
class Solution {
    char[][]board;
    int count=0;
     List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        
        board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0; j<n;j++)
                board[i][j] = '.';
        
        result = new ArrayList<>();
        place(board,0);
        
        return result;
        
    }
    public boolean isValid(int row, int col){
            
            boolean safe = true;
   
            for(int i=0; i<row; i++){
                if(board[i][col] == 'Q')
                    return false;
            } 
            for(int i=row, j=col ; i>=0 && j>=0 ; i--,j--){
                if(board[i][j] == 'Q')
                    return false;
             }
            
            for(int i=row, j=col ; i>= 0 && j<board[0].length ; i--,j++){
                if(board[i][j] == 'Q')
                    return false;
             }
            return safe;
        
        }
    
    public void place(char[][] board, int row){
            int n = board[0].length;
            for(int j=0; j<n; j++){
                if(isValid(row,j)){
                    board[row][j] = 'Q';
                    if(row == n-1){
                        count++;
                         
                        List<String> temp = new ArrayList<>();
                            for(char sub[] : board)
                            temp.add(String.valueOf(sub));
                        result.add(temp);
                    }
                    
                    else 
                        place(board, row+1);
                        board[row][j] = '.';
                 }
                if(j==n-1)
                    return;
            }
         }
}



