/*approach -1 backtracking
ex: find string 'abfs'
Do no have to traverse through the matrix,just input the first character's i and j to the backtrack method and it will result in false
if that doesnt match the first letter of charater.  
    a. if returned false, for loop will increment and go to the next i, j  throughout the matrix, 
    if i and j reached and nothing found finally return false, that means word doesnt exist. 
    b. if found, then recurse through it neighbors , if they have the second charcter, then recurse again their neighbors to find the next element
    and so on. 
    note - for recursing through the neighbors we use dirs array. 

    c. also, while recursing, we will mark visited value  as '#' and store the character in some ch variable 
    d. if we dint find the neighbor successfully, with the help of backtracking we will come back to the method call, and set back the ch as
    value replacing '#'. 
    e. # help us to check if the cell was visited or not , so that way we dont add same cell , if we ever run into duplicated or 
    if we are traversing, saves us some time saying that instance been already used in forming character. 
    f.let say we found the  'abf' but we didn't find the 's', then we recurse back to the f's remaining calls from TLDR and then in the rest
    of the calls we dint find the other character as 's', then we recurse back to the 'b' and with remaining calls, we find the 
    other occurance of 'f', if we find it, then we again try to find 's', here. Remeber we are doing recursive calls in TLDR manner
    so we never find the same occurance of 'f' again, and the second occurance will always be different. 

    //base case - 
        1. if we reachd the end of the word, that means we found all charcters and so return true. 
        2. if 1st condition is false, means there are characters left to evaluate in the word, but
         our rows and cols are out of bound or the cell value is mark visited we simply return false from there. 
    //TC - O(m*n) travere through matrix * 3^L(l= length of the word) + O(3n) making recursive calls to 3 directions. => O(3^L * m*n) + O(3n)
    //sc- Max of (recursive stack space, length of the word) = max of O(m*n , L);


*/

class Solution {
    int m, n;
    int[][] dirs ;
    public boolean exist(char[][] board, String word) {
    
        if(board == null || board.length ==0) return false;

        //calculate m, n
        m = board.length;
        n = board[0].length;

        dirs = new int[][] { {-1,0}, {0,-1}, {1,0}, {0,1}};

        //traverse throught he amtrix to find insance of characters in recursive way
        for(int i=0; i< m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(helper(board, i, j, word, 0))
                return true;
            }
        }
        return false;
    }

    //helper method def
    private boolean helper(char[][] board, int r, int c, String word, int index)
    {
            //base case
            if(index == word.length()) //exhausted the string and found all charcters
                return true;

            if(r ==m || r <0 || c == n || c <0 || board[r][c] == '#')
            return false;

            //logic
            //check if the charcter matches
            if(board[r][c] == word.charAt(index))
            {
                //yes, make recursive calls to neighbors and before that mark visited and store ch 
                char ch = board[r][c];
                board[r][c] = '#';

                for(int[] dir : dirs)
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(helper(board, nr, nc, word, index+1))
                    return true; // because if found the next carcter, we dont need to go through the rest of the neighbors. 
                }
                //back tracking - reverting the last visited to unvisited
                board[r][c] = ch;
            }
            return false;
    }
}