// Time Complexity :O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in bracktracing of chose not choose on the board

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] Board = new boolean[n][n];
        helper(Board,n,0);
        return result;
    }

    public void helper(boolean[][] Board, int n, int index){
        //base
        if(index == n){
            List<String> li=new ArrayList<>(); 
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(Board[i][j]) {
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j=0;j<n;j++){
            if(isSafe(Board,n,index,j)){
                Board[index][j] = true;
                helper(Board,n,index+1);
                Board[index][j] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] Board, int n, int r, int c){
        for(int i=0;i<=r;i++){
            if(Board[i][c]) {
                return false;
            }
        }

        int i=r;int j=c;
        while(i>=0 && j<n){
             if(Board[i][j]) return false;
             i--;
             j++;
        }
         i=r;j=c;
          while(i>=0 && j>=0){
             if(Board[i][j]) return false;
             i--;
             j--;
        }
        return true;
    }
}