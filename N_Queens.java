import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class N_Queens {

        // BACKTRACKING
        List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {

            result = new ArrayList<>();

            //create chess grid of n*n dimension
            boolean[][] chessGrid = new boolean[n][n]; //O(N^2)

            recurseBacktrack(n, chessGrid, 0);

            return result;
        }

        private void recurseBacktrack(int n, boolean[][] chessGrid, int row) {

            //base
            // all rows are covered
            if(row == n) {

                //making one possible solution order
                List<String> orderSol = new ArrayList<>();

                //nested for loops to make a single list
                for(int i = 0; i < n; i++) { // O(N^2)

                    //string builder for each row
                    StringBuilder rowSB = new StringBuilder();

                    for(int j = 0; j < n; j++) {

                        if(chessGrid[i][j]) rowSB.append('Q');

                        else rowSB.append('.');
                    }

                    //add each row string to list
                    orderSol.add(rowSB.toString());
                }
                // add list to result
                result.add(orderSol);

                // return to parent, i.e., zeroth row - go to next column position in it
                return;
            }


            //logic
            //iterate over columns of the row
            for(int col = 0; col < n; col ++) {

                if(isSafePlace(n, chessGrid, row, col)) {

                    // action
                    chessGrid[row][col] = true;

                    //recurse
                    recurseBacktrack(n, chessGrid, row+1);

                    //backtrack
                    chessGrid[row][col] = false;

                }

            }

        }

        private boolean isSafePlace(int n, boolean[][] chessGrid, int row, int col) { //O(N)

            // column up - check
            for(int i = row - 1; i >= 0; i--) {

                if(chessGrid[i][col]) return false;
            }

            // diagonal up left
            int i = row, j = col;
            while(i >= 0 && j >= 0) {

                if(chessGrid[i][j]) return false;

                i--; j--;
            }

            // diagonal up right
            i = row; j = col;
            while(i >= 0 && j < n) {

                if(chessGrid[i][j]) return false;

                i--; j++;
            }

            return true;
        }

        public static void main(String[] args) {

            N_Queens object = new N_Queens();

            // Create a Scanner object to read user input
            Scanner scanObj = new Scanner(System.in);

            // Prompt the user to enter an integer
            System.out.print("Enter n: ");
            int number = scanObj.nextInt();

            List<List<String>> answer = object.solveNQueens(number);

            for (List<String> list : answer) {
                for (String str : list) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }
        }


}

/*
    Remember: If I am able to place the queen into a particular row,
    1. Abandon the execution for that row i.e. parent row inside the recursion-stack
    and move over to the next row
    2. If not able to place the queen anywhere in a child row, recursively roll-back to parent row and check for placing in next column values, ..
    3. Recursively roll back after iterating over columns of each row to its parent
    4. Recursion ends with iteration of last column of first row.
    */

/* TIME COMPLEXITY = O(N!)

We place queens only in safe places, not everywhere i.e. not N^N = N*N*N...

Number of options for first queen = N
Number of options for second queen = N - 2 max (- 1 col, -1 diag)
Number of options for second queen = N - 4 max (-2 col, -2 diag) ..

Total options = N(N-2)(N-4) ... = O(N!)

One valid list = O(N^2) - nested for loop
Number of valid solutions be S(N) is small

But, 0(N!) > S(N)* O(N^2)

SPACE COMPLEXITY = O(N^2)

Matrix initialization = O(N^2)
Recursive stack with backtracking= O(N)

*/

