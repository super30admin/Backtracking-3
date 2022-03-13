//Time Complexity: O( m * n * (3^l)) m = board row, n= board column, l = length of word
//Space Complexity: O(l)
//runs successfully
//didn't face any problems


public class WordSearch79LeetCode {

        private int[][] directions={               //direction array, we can go in this direction from any element
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0}
        };


        public boolean exist(char[][] board, String word) {

            for(int i=0; i<board.length; i++){          //iterating through board array

                for(int j=0; j<board[i].length; j++){

                    if(exist(board, word, i, j, 0)){        //calling the dfs function and check if we can search the word using this index
                        return true;                //if so, then return true
                    }
                }
            }

            return false;                       //if not then return false
        }

        private boolean exist(char[][] board, String word, int row, int col, int index){

            if(index == word.length()){        //check if index== word.length(), which means we searched our target word
                return true;                    //if so, then return true
            }

            if(row<0 || col<0 || row>=board.length || col>=board[0].length){    //check if the positions are valid or not

                return false;               //if not valid then return false
            }

            if(board[row][col] == word.charAt(index)){  //check if the character at the board is equal to the word's index

                board[row][col] = '#';      //if so, then temporary assign the "#" at this position to avoid using the same character in our result

//             for(int[] dir : directions){

//                 int newRow = row + dir[0];
//                 int newCol = col + dir[1];

//                 if(exist(board, word, newRow, newCol, index+1)){

//                     return true;
//                 }

//             }


                //iterarting through each direction and check if we can get the word,
                boolean found = exist(board, word, row-1, col, index+1) ||  //Up
                        exist(board, word, row+1, col, index+1) ||  //Down
                        exist(board, word, row, col-1, index+1) ||  //Left
                        exist(board, word, row, col+1, index+1);    //Right

                board[row][col] = word.charAt(index); //backtracking(put the original value to the board)

                return found;           //if found the word then return true

            }

            return false;               //if not then return false

        }
}
