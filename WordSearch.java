// Time Complexity :O(n factorial) so all permutations 
// Space Complexity :O(n)
class Solution {
    public boolean exist(char[][] board, String word) {
        int [][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
        for( int i=0;i<board.length;i++)
        {for(int j=0;j<board[0].length;j++)
        {
            if(board[i][j]==word.charAt(0))
                if( helper(board, word, i, j,0,dirs))
                    return true;


        }


         }
              return false;        
    }


   private boolean helper(char[][]board, String word, int i , int j, int index,int[][]dirs)
   {
       if(index==word.length())
           return true;

       if(i<0 || i==board.length || j<0 || j==board[0].length || board[i][j]=='#')
           return false;

       if(board[i][j]==word.charAt(index))
       { board[i][j]='#';
       for( int []d :dirs)
       {
           int r = i+d[0];
           int c = j+d[1];

           if(helper(board,word, r, c, index+1,dirs))
               return true;


       }
        board[i][j]=word.charAt(index);

       }
       return false;






   }
