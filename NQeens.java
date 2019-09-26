//Time Complexity: O(N^2 N!)
//space complexity: O(N^2)
//Accepted on leetcode after several attempts
//Was able to understand the question and partly the intuition in general but was stuck while attempting to code myself. 
//Had to refer to a few solutions to see how to break my problems into parts and do it
//This was the only solution I could come up myself even though it is not optimal! 
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //Initialise the board
        char[][] board = new char[n][n];
        //iterate over the board and mark all the box as '.'
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n; j++)
            {
                board[i][j] = '.';
            }
        }
        //Initialise Resultant board representation to represent the queens in safe positions
        List<List<String>> res = new ArrayList<List<String>>();
        //dfs function with the board, initial col index and resultant list of list as inputs to mark the position of the 'Q'
        dfs(board,0,res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res)
    {
        //If col Index is equal to board length 
        if(colIndex == board.length)
        {
            //construct the board and append to result
            res.add(construct(board));
            return;
        }
        
        //Iterate over the rows for each column
        for(int i=0; i< board.length; i++)
        {
                //check if the given col Index is a safe position for Q
                if(validate(board,i,colIndex))
                {
                    //if valid column assign Q to the position
                    board[i][colIndex] = 'Q';
                    //Check the above conditions for next adjacent row
                    dfs(board,colIndex+1,res);
                    //assign the current pos to '.'
                    board[i][colIndex] = '.';
                } 
        }
       
    }
    //Function to validate if col is safe
    private boolean validate(char[][] board, int r, int c)
    {
        //Iterate over all rows
        for(int i=0;i<board.length;i++)
        {
            //Iterate over columns less c index
            for(int j=0;j<c;j++)
            {
                //If there is a conflict ie; there is another Queen or if its diagonaly placed opposite to another queen then return false
                if(board[i][j]=='Q' && (r+j==c+i || r+c==i+j || r==i))
                    return false;
            }
        }
        //else true
        return true;
    }
    private List<String> construct(char[][] board)
    {
        //result linkedlist for each row in a board
        List<String> res = new LinkedList<String>();
        //construct row wise
        for(int i=0; i< board.length; i++)
        {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}