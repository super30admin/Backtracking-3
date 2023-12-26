// Time complexity : O(3^len) , where len -> length of word
// Space complexity : O(len) , len -> length of word
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = exist(board,word);
        System.out.println(result);
    }

    private static int[][] dirs; static int m; static int n;
    private static boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(backtrack(board,word,0,i,j)) return true;
            }
        }
        return false;
    }
    private static boolean backtrack(char[][] board , String word, int idx, int i, int j) {
        // base
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        // logic
        if(board[i][j] == word.charAt(idx)) {
            // action
            board[i][j] = '#';
            // recurs
            for(int[] dir : dirs) {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if(backtrack(board, word, idx+1, nr, nc)) return true;
            }
            // backtrack
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}
