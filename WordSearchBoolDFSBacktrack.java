import java.util.Scanner;

public class WordSearchBoolDFSBacktrack {


        //BOOLEAN BACKTRACK

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        public boolean exist(char[][] board, String word) {

            int m = board.length; int n = board[0].length;

            //find first character of word through nested for loops
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(board[i][j] == word.charAt(0)) {

                        if(backtrack(board, i, j, word, 0, m, n)) return true;
                    }
                }
            }

            return false;
        }

        private boolean backtrack(char[][] board, int r, int c, String word, int idxW, int m, int n) {

            //base
            if(idxW == word.length()) return true;

            if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;

            //logic
            if(board[r][c] == word.charAt(idxW)) {

                //action
                board[r][c] = '#';

                //recurse
                for(int[] dir: dirs) {

                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(backtrack(board, nr, nc, word, idxW + 1, m, n)) return true;
                }

                //backtrack
                board[r][c] = word.charAt(idxW);
            }

            return false;
        }

    public static void main(String[] args) {

        WordSearchBoolDFSBacktrack object = new WordSearchBoolDFSBacktrack();

        // Create a Scanner object to read user input
        Scanner scanObj = new Scanner(System.in);

        // Prompt the user to enter the number of rows and columns in the rectangular array
        System.out.print("Enter the number of rows: ");
        int r = scanObj.nextInt();

        System.out.print("Enter the number of columns: ");
        int c = scanObj.nextInt();

        scanObj.nextLine(); // Consume the newline character

        // Create a rectangular array to store the elements
        char[][] board = new char[r][c];

        // Prompt the user to enter the elements of the rectangular array
        System.out.println("Enter the elements of the rectangular array:");

        for (int i = 0; i < r; i++) {
            String row = scanObj.nextLine();
            // Convert the row string to a character array and store it in the rectangular array

            // Check if the length of the row matches the number of columns
            if (row.length() != c) {
                System.out.println("Invalid input. Row length does not match the number of columns.");
                return;
            }
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanObj.nextLine();


        boolean answer = object.exist(board, inputString);

        System.out.println("Is word found in board? " +  answer);
    }


}

/* TIME COMPLEXITY = O(M*N*3^L)

M*N = dimension of board
L = length of word

SPACE COMPLEXITY = O(L)
*/

