/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Space complexity is O(N) for rows and diagonal values
//Time complexity is O(N!) to check if queen is put in one position, then check other positions
class NQueens 
{ 
  
static int N = 4;  
static int k = 1; 
  
/* A utility function to print solution */
static void printSolution(int board[][])  
{  
    System.out.printf("%d-\n", k++);  
    for (int i = 0; i < N; i++)  
    {  
        for (int j = 0; j < N; j++)  
            System.out.printf(" %d ", board[i][j]);  
        System.out.printf("\n");  
    }  
    System.out.printf("\n");  
}  
  
static boolean isSafe(int board[][], int row, int col)  
{  
    int i, j;  
  
    /* Check this row on left side */
    for (i = 0; i < col; i++)  
        if (board[row][i] == 1)  
            return false;  
  
    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)  
        if (board[i][j] == 1)  
            return false;  
  
    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < N; i++, j--)  
        if (board[i][j] == 1)  
            return false;  
  
    return true;  
}  
  

static boolean solveNQUtil(int board[][], int col)  
{  
    /* base case: If all queens are placed  
    then return true */
    if (col == N)  
    {  
        printSolution(board);  
        return true;  
    }  
  
    /* Consider this column and try placing  
    this queen in all rows one by one */
    boolean res = false;  
    for (int i = 0; i < N; i++)  
    {  
       
        if ( isSafe(board, i, col) )  //Check the safe condition
        {  
           
            board[i][col] = 1;   /* Place this queen in board[i][col] */
  
          
            res = solveNQUtil(board, col + 1) || res;  
  
        
            board[i][col] = 0; // BACKTRACK  and change the state to zero
        }  
    }  
  
   
    return res;  
}  
  

static void solveNQ()  
{  
    int board[][] = new int[N][N];  
  
    if (solveNQUtil(board, 0) == false)  
    {  
        System.out.printf("Solution does not exist");  
        return ;  
    }  
  
    return ;  
}  
  
// Driver code  
public static void main(String[] args) 
{ 
    solveNQ(); 
} 
} 
