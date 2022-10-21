//approach- Recursion and Backtracking
//take a boolean matrix, of size n*n to represent the chess board. 
//take a global variable, so that we can assign n's value to it for Helper method's use. 
//Now we know, the number of rows will be equal to n, but in matrix we start rows from 0, so it will reach upto n-1 and 
//so row == n is our boundary check/ base case. 

//so we call the helper method named backtracking with only parameter row=0. 

//logic of the backtracking method
//1. take the for loop which will represent column for the current row. 
//2. now take the first cell and check , if that place isValid, (isValid) comes true, we can place the Queen there, else 
//we move on to the other col as the for loop goes and check isValid for every individual cell of the currnt row. 
//if we find the valid place, then only we will move to the next row, with recursive call as backtrack(row+1), so, this way 
//we will check the entire matrix and every row we'll try to put Queen. 
//Now once we hit the base case,, row == n; we will add the current combination to the list - refer seprate logic for that
//and then we'll backtrack, so, we'll return to the previous method acll and put the cell's value back to False. This is
//also the case when we couldn't find the coorect combination into any of the row, let say at last row, then we will not put that
//into result and we'll just backtrack and recurse until we find the new combination. 

//logic for isValid
//for every cell, we will check three sides f neighbors - 1. upper left diagonal 2. Upper right diagonal, 3. Same col for all the 
//rows above
//1 for loop and 2 while loops to cover this scenario. 

//logic for printing
//once we hit the base case, we'll create a list<string > and then traverse a matrix; 
//for every row, we will define a string builder, that will present that rows value 
//when we get into the col loop, we check if the cell is Truw, we append 'Q' else we append '.'
//once we are out of col's for loop, we will add it to the list<string>, 
//once we are done with traversing the entire matrix, we will just add the list to result. result.add(list<String>) 

class Solution {
    int m;
    List<List<String>> result;
    boolean[][] chessBoard;
    public List<List<String>> solveNQueens(int n) {
 
        if(n==0) return result;

        this.m = n;
        chessBoard = new boolean[m][m];

        backtrack(0);

        return result;
    }

    private void backtrack(int row)
    {
        //base case
        if(row == m)
        {
            List<String> answer = new ArrayList<>();
            for(int i=0; i< m; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(j =0; j< m; j++ )
                {
                    if(chessBoard[i][j] == true)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
            }
            result.add(answer);
        }

        //logic
        for(int col =0; col < m; col++)
        {
            
            if(isValid(row, col))
            {
                //action
                chessBoard[row][col] = true;
                //recurse
                backtrack(row+1);

                //backtrack
                chessBoard[row][col] = false;
            }
        }

    }
    private boolean isValid(int i, int j)
    {
        int row = i-1;
        int col = j;
        //upper rows

        while(row >=0)
        {
            if(chessBoard[row][col] == true) 
                return false;
            row--;    
        }

        //upper left diagonal
        row = i-1;
        col = j-1;
        while(row >=0 && col >=0)
        {
            if(chessBoard[row][col] == true)
            return false;

            row--;
            col--;
        }

        //upper Right diagonal
        row = i-1;
        col = j+1;
        while(row >=0 && col < m)
        {
            if(chessBoard[row][col] == true)
            return false;

            row--;
            col++;
        }
        
        return true;
    }
}

//tC - exponential; now, 1st row has n place, 2nd n-2, 3rd n-4... so this reflcets  - O(n!) + Recursive calls O(3n)
//sc - O(n*n) + (at max n recursive stacks = O(n))  --> O(n^2)