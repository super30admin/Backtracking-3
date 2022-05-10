class Solution {

    //Time Complexity : 0(3^l) where l is the length of the string
    //Space Complexity : 0(l) where l is the recursive stack
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while writing this code: No

    //In short explain your approach:

    int m, n;
    int direction[][];
    public boolean exist(char[][] board, String word) {
        m = board.length;   //finding the rows
        n = board[0].length;    //finding no. columns
        direction = new int [][]{{1,0}, {0,1}, {-1,0}, {0,-1}}; //to traverse in all 4 directions and check if the next letter is present or not
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, word, i, j, 0) == true){   //sending the backtrack method the current index
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char [][] board, String word, int r, int c, int index ){
        //base
        if(index == word.length()){
            return true;
        }
        if(r < 0 || r == m || c < 0 || c == n || board[r][c] == '#'){
            return false;
        }
        //logic
        if(word.charAt(index) == board[r][c]){
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            for(int [] dir: direction){
                int newR = dir[0] + r;
                int newC = dir[1] + c;
                //recurse
                if(helper(board, word, newR, newC, index + 1) == true){
                    return true;
                }
            }
            //backtrack
            board[r][c] = ch;
        }
        return false;
    }
}