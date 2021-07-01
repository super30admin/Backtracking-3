class Solution {
    // Time complexity: O(n * 3 ^ l)
    // Space comeplexity: O(l) l indicates the length of the word
    char[] chars;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        chars = word.toCharArray();
        char startChar = chars[0];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == startChar){
                    Set<Integer> set = new HashSet<Integer>();
                    set.add(i * board[0].length + j);
                    if(dfs(i, j, board, set, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, char[][] board, Set<Integer> set, int idx){
    //base case
        if(idx == chars.length - 1){
        return true;
        }

        for(int[] dir : dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(newRow >=0 && newRow < board.length && newCol >= 0 && newCol < board[0].length){
                if(board[newRow][newCol] == chars[idx + 1] && !set.contains(newRow * board[0].length + newCol)){
                    set.add(newRow * board[0].length + newCol);

                    if(dfs(newRow, newCol, board, set, idx + 1)){
                        return true;
                    }
                    set.remove(newRow * board[0].length + newCol);    
                }
            }
        }
        return false;
    }
}