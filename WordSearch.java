// Time Complexity : O(m*n*3^L) (board size : m*n) (length of word : L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    //board size 
    int rowLength;
    int colLength;
    public boolean exist(char[][] board, String word) {
        
        rowLength = board.length;
        colLength = board[0].length;
        
        //starting from each cell search for the word
        //if any returns true, return result as true
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                //method parameters : board, word, starting row and col cell position 
                //for that backtracking call, index postition (in word, starting vale =. 0)
                if(dfsbacktrack(board, word, i, j, 0)) return true;
            }
        }
        //if none of the starting cell return true, return result as false
        return false;        
    }
    
    private boolean dfsbacktrack(char[][] board,String word, int i, int j, int index) {
        //base case for false condition (returns value to the recursive call)
        //if i and j are index out of bounds, or next char is already visited 
        //next char != char at index position in word
        if(i<0 || i==rowLength || j<0 || j==colLength || board[i][j]=='!' || board[i][j]!=word.charAt(index)) return false;
        
        //base case for true (returns value to the recursive call)
        //if all letters are been found in the board in either 4 dirs, return true
        if(index == word.length()-1) return true;
        
        //store the actual board value in temp (instead of a visited matrix)
        //to restore value after backtracking (if all 4 dir return false)
        //we change the cell value in next step (to know if its visited)
        char tempChar = board[i][j];
        //to mark visited make the cell value = ! (or any value other than alphabets)
        board[i][j] = '!';
        //dirs array to visit 4 neighbors of cell
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : dirs) {
            //get new row and col position of the neighbors, and call the method 1 by 1
            int row = i + dir[0];
            int col = j + dir[1];
            //if the (base conditions) method returns true, return true to main method (we need only one instance matching to word)
            //if false return anything and goes to next neighbor
            //if all neighbors are visited
            //goes outside the loop and changes the cell value back, and that recursive call ends, 
            //control goes to prev recursive call
            if(dfsbacktrack(board, word, row, col, index+1)) return true;
        }
        //change back to tempChar for backtracking
        board[i][j] = tempChar;
        //return result = false for the recursive call (backtracks to prev char and checks for other neighbor position)
        return false; 
    }
}


///////////////////


class Solution {
    //board size 
    int rowLength;
    int colLength;
    public boolean exist(char[][] board, String word) {
        
        rowLength = board.length;
        colLength = board[0].length;
        
        //starting from each cell search for the word
        //if any returns true, return result as true
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                //call the backtracking method char at i and j = first char of word 
                if(board[i][j] == word.charAt(0)) {
                    //method parameters : board, word, starting row and col cell position 
                    //for that backtracking call, index postition (in word, starting vale =. 0)
                    if(dfsbacktrack(board, word, i, j, 0)) return true;
                }
            }
        }
        //if none of the starting cell return true, return result as false
        return false;        
    }
    
    private boolean dfsbacktrack(char[][] board,String word, int i, int j, int index) {       
        //base case for true (returns value to the recursive call)
        //if all letters are been found in the board in either 4 dirs, return true
        //we check if index == len-1, as we checked if last letter matches in the logic itself
        if(index == word.length()-1) return true;
        
        
        //store the actual board value in temp (instead of a visited matrix)
        //to restore value after backtracking (if all 4 dir return false)
        //we change the cell value in next step (to know if its visited)
        char tempChar = board[i][j];
        //to mark visited make the cell value = ! (or any value other than alphabets)
        board[i][j] = '!';
        //dirs array to visit 4 neighbors of cell
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : dirs) {
            //get new row and col position of the neighbors, and call the method 1 by 1
            int row = i + dir[0];
            int col = j + dir[1];
            
            //recursive call if neighbor is in bounds and has char = index+1 (can do in base case as well)
            if(row>=0 && row<rowLength && col>=0 && col<colLength && board[row][col] == word.charAt(index+1)) {
                //if the (base conditions) method returns true, return true to main method (we need only one instance matching to word)
            //if false return anything and goes to next neighbor
            //if all neighbors are visited
            //goes outside the loop and changes the cell value back, and that recursive call ends, 
            //control goes to prev recursive call
                if(dfsbacktrack(board, word, row, col, index+1)) return true;
            }
        }
        //change back to tempChar for backtracking
        board[i][j] = tempChar;
        //return result = false for the recursive call (backtracks to prev char and checks for other neighbor position)
        return false; 
    }
}

