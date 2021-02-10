// Time Complexity : O(n!) where n is the length of the board. Since first row has n options 2nd row has n-3 options ... last row has 1 option for each row we are exploring all the options
// Space Complexity : O(n*n) since we maintain a new board altogether
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
public class NQueen {
    class Solution {
        int [][] board;
        int rows;
        List<List<String>>result;
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> rightD = new HashSet<>();
        HashSet<Integer> leftD = new HashSet<>();
        public List<List<String>> solveNQueens(int n) {
            rows = n;
            result= new ArrayList<>();
            board = new int[n][n];
            backtrack(0);
            return result;
        }
       
        public boolean isSafe(int r, int c)
        {
            if(!col.contains(c) && !rightD.contains(r+c) && !leftD.contains(r-c)){
                col.add(c);
                rightD.add(r+c);
                leftD.add(r-c);
                return true;
            }
            return false;
        }
        
        public void backtrack(int r)
        {
            // base
            if(r==rows)
            {
              List<String> output = new ArrayList<>();  
              for(int i=0;i<board.length;i++)
              {
                 StringBuilder sb = new StringBuilder();   
                  for(int j=0;j<board[0].length;j++)
                  {
                      if(board[i][j]==1)
                      {
                          sb.append("Q");
                      }else{
                          sb.append(".");
                      }
                  }
                  output.add(sb.toString());
              }
                result.add(new ArrayList<>(output));
                return;
            }
            
            for(int c=0;c<board[0].length;c++)
            {
                if(isSafe(r,c))
                {
                    board[r][c]=1;
                    backtrack(r+1);
                    board[r][c]=0;
                    col.remove(c);
                    rightD.remove(r+c);
                    leftD.remove(r-c);
                }
            }
            
        }
        
    }    
}
