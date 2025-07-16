// Time Complexity: O(m * n * 3^L)
// - m * n: for starting the DFS from every cell in the board
// - 3^L: for each DFS call, we explore up to 3 directions (not 4, because we avoid going back to the previous cell), where L is the length of the word

// Space Complexity: O(L)
// - The recursion stack can go up to depth L in the worst case
// - Frequency map uses O(1) space as the number of lowercase characters is fixed and limited (at most 26)

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - First, we apply *frequency pruning* as a pre-check:
//     - Count how many times each character appears on the board.
//     - If any character in the word is either missing or appears fewer times than needed, we return false early.
//     - This avoids unnecessary DFS calls when the word is clearly unformable.
// - If the word passes frequency pruning, we proceed with DFS from every cell on the board.
// - At each step of DFS:
//     - Check if the current cell matches the expected character in the word.
//     - If it does, mark the cell as visited (e.g., with '#') to avoid revisiting.
//     - Recursively explore all four directions.
//     - After exploring, backtrack by restoring the original character.
// - If any path matches the word, return true.
// - If no path matches, return false at the end.

class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {

        // Frequency pruning
        if (!canFormWord(board, word)) return false;

        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};// right, up, left, down

        // Try starting the DFS from every cell in the board
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,i,j,word,0)) return true;
            }
        }

        // If no valid path is found
        return false;
    }

    private boolean canFormWord(char[][] board, String word){
        // Create a frequency map for all characters in the board
        Map<Character, Integer> boardFreq = new HashMap<>();
        for (char[] row : board){
            for (char c : row){
                boardFreq.put(c, boardFreq.getOrDefault(c, 0) + 1);
            }
        }
        // Iterate through each character in the word
        for (char c : word.toCharArray()){
            // If the board does not contain the character at all, return false
            if (!boardFreq.containsKey(c)){
                return false;
            }
            // Decrement the frequency since we plan to use this character
            int freq = boardFreq.get(c) - 1;
            boardFreq.put(c,freq);
            // If we use more of a character than is available on the board, return false
            if (freq < 0) return false;
        }

        return true;
    }

    private boolean dfs(char[][] board, int i, int j,String word, int idx){
        // If the entire word is matched
        if(idx == word.length()) return true;

        // Boundary conditions or character mismatch
        if(i<0 || j<0 || i>=m || j>=n) return false;
        if(board[i][j] != word.charAt(idx)) return false;

        //Action : Temporarily mark the current cell as visited
        board[i][j] = '#';

        //Recurse: Explore all 4 directions
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(dfs(board,r,c,word,idx+1)) return true;
        }

        //Backtrack: by restoring the original character
        board[i][j] = word.charAt(idx);

        return false;
    }


}