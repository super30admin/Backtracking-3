//Time Complexity: O(n! + n*n*x) n=board size, x= number of possible ways to put a queen
//Space Complexity: O(n*n + 3*n)
//runs successfully
//didn't face any problems


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens51LeetCode {

        boolean[][] board;                              //creating the board, which help us in storing the queen's position
        List<List<String>> result;                      //result list
        Set<Integer> colSet, leftUpperDiagSet, rightUpperDiagSet;   //creating the hashset to store queen's location, which help us to put new queen at location which has to be not attacked by previous queens

        public List<List<String>> solveNQueens(int n) {

            result = new ArrayList<>();
            board = new boolean[n][n];              //creating the board

            colSet = new HashSet<>();
            leftUpperDiagSet = new HashSet<>();
            rightUpperDiagSet = new HashSet<>();

            solve(0);                               //calling the function with first row

            return result;

        }

        private void solve(int row){

            if(row == board.length){            //check if we reached till the last row, if so then we can successfully put the queens

                List<String> temp = new ArrayList<>();

                for(int i=0; i<board.length; i++){      //iterating through the board

                    StringBuilder res = new StringBuilder();

                    for(int j=0; j<board[0].length; j++){

                        if(board[i][j]){                //check if queen is present then append "Q"
                            res.append("Q");
                        }
                        else{                       //if not present then append "."
                            res.append(".");
                        }
                    }

                    temp.add(res.toString());       //adding string to the list
                }

                result.add(temp);                   //adding to the global list
                return;

            }

            for(int col=0; col<board[0].length; col++){     //iterating through column

                if(isSafe(row, col)){                   //check if we can put the queen at this position, and it is not under attack by other queen

                    board[row][col] = true;         //if it is safe, the, put the queen at that place, so we need to store this location in hashset and board array
                    colSet.add(col);
                    leftUpperDiagSet.add(row-col);
                    rightUpperDiagSet.add(row+col);

                    solve(row+1);               //calling the recursive function with increament the row

                    board[row][col] = false;    //backtracking our previous steps
                    colSet.remove(col);
                    leftUpperDiagSet.remove(row-col);
                    rightUpperDiagSet.remove(row+col);

                }
            }
        }

        private boolean isSafe(int row, int column){

            return isSafeColumn(row, column) &&             //checking that queen at row and column is safe or not
                    isSafeUpperRightDiagonal(row, column) &&
                    isSafeUpperLeftDiagonal(row, column);

        }

        private boolean isSafeColumn(int row, int column){

            return !colSet.contains(column);            //check if colSet contains this column or not, if it contains which means queen is present in the column so its not safe
        }

        private boolean isSafeUpperRightDiagonal(int row, int column){

            return !rightUpperDiagSet.contains(row+column); //check if rightUpperDiagSet contains this value or not, if it contains which means queen is present in this position so its not safe
        }

        private boolean isSafeUpperLeftDiagonal(int row, int column){

            return !leftUpperDiagSet.contains(row-column); //check if rightUpperDiagSet contains this value or not, if it contains which means queen is present in this position so its not safe
        }


//Time Complexity: O(n!*n*n + n*n*x) n=board size, x= number of possible ways to put a queen
//Space Complexity: O(n*n + 3*n)
//     boolean[][] board;
//     List<List<String>> result;

//     public List<List<String>> solveNQueens(int n) {

//         result = new ArrayList<>();
//         board = new boolean[n][n];

//         solve(0);

//         return result;

//     }

//     private void solve(int row){

//         if(row == board.length){

//             List<String> temp = new ArrayList<>();

//             for(int i=0; i<board.length; i++){

//                 StringBuilder res = new StringBuilder();

//                 for(int j=0; j<board[0].length; j++){

//                     if(board[i][j]){
//                         res.append("Q");
//                     }
//                     else{
//                         res.append(".");
//                     }
//                 }
//                 temp.add(res.toString());
//             }
//             result.add(temp);
//             return;

//         }

//         for(int col=0; col<board[0].length; col++){

//             if(isSafe(row, col)){

//                 board[row][col] = true;
//                 solve(row+1);
//                 board[row][col] = false;

//             }
//         }
//     }

//     private boolean isSafe(int row, int column){

//         return isSafeColumn(row, column) &&
//             isSafeUpperRightDiagonal(row, column) &&
//             isSafeUpperLeftDiagonal(row, column);

//     }


//     private boolean isSafeColumn(int row, int column){

//         while(row >= 0){

//             if(board[row][column]){
//                 return false;
//             }
//             row = row-1;

//         }
//         return true;
//     }


//     private boolean isSafeUpperRightDiagonal(int row, int column){

//         row = row - 1;
//         column = column + 1;
//         while(row >= 0 && column < board[0].length){

//             if(board[row][column]){
//                 return false;
//             }
//             row = row - 1;
//             column = column + 1;

//         }
//         return true;
//     }

//     private boolean isSafeUpperLeftDiagonal(int row, int column){

//         row = row - 1;
//         column = column - 1;
//         while(row >= 0 && column >= 0){

//             if(board[row][column]){
//                 return false;
//             }
//             row = row - 1;
//             column = column - 1;

//         }
//         return true;

//     }

}
