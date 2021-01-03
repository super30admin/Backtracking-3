/*
# we could have also maintained an array of placed queen and in safemove function checked for same col by looking at col number of placed
# queen and for diagonal by taking difference between x and y coordinate of both queens. But the dominating function is backtracking as it
# is n! and safemove is just O(n). By maintaining array we would have extra space but it doesnt matter as we didnt reduce dominating time complexity
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n is None or n == 0:
            return []
        
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        self.result = []
        self.backtrack(0, n)
        
        return self.result
    
    def backtrack(self, row, n):
        if row == n:
            temp2 = []
            for i in range(n):
                temp = []
                for j in range(n):
                    if self.board[i][j] == 1:
                        temp.append("Q")
                    else:
                        temp.append(".")
                
                temp2.append("".join(temp))
            self.result.append(temp2)
            return
                
            
        for i in range(n):
            if self.safemove(row, i, n):
                # action
                self.board[row][i] = 1
                
                #recurse
                self.backtrack(row+1, n)
                
                #backtrack
                self.board[row][i] = 0
    
    def safemove(self, row, col, n):
        #checking same col
        for i in range(row, -1, -1):
            if self.board[i][col] == 1:
                return False
        
        # checking upper left
        i = row
        j = col
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
            
            
        # checking upper left
        i = row
        j = col
        while i >= 0 and j < n:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
        
        return True
*/


// Time Complexity : O(n!) as after placing every queen we will have n-2 options for next one. If we would be done recursion without checking then it would be n^n
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Going through each row and checking whether it is safe to place a 
// queen everytime
class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        if (n == 0)
            return result;
        backtrack(0, n);
        
        return result;
    }
    private void backtrack(int row, int n){
        if (row == n){
            List<String> temp = new ArrayList<>();
            for (int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++){
                    if (board[i][j] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        for (int i=0; i<n; i++){
            if (safemove(row, i, n)){
                board[row][i] = 1;
                backtrack(row+1, n);
                board[row][i] = 0;
            }
        }
    }
    
    private boolean safemove(int row, int col, int n){
        // same col
        
        for (int i=row; i>=0; i--){
            if (board[i][col] == 1)
                return false;
        }
        int i,j;
        // upper left
        i = row;
        j = col;
        while (i >= 0 && j >= 0){
            if (board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        
        // upper right
        i = row;
        j = col;
        while (i >= 0 && j < n){
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}