/*
Time Complexity- O(m * n * 3^L) where L is the length of string
Space Complexity- O(L) where L is the length of string
*/
import java.util.*;
public class WordSearch {
    static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(isValid(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean isValid(char[][] board, int r, int c, String word,int p) {
        if(p == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(p)) return false;

        board[r][c] = '.';
        for(int[] d : dir) {
            int cr = d[0] + r;
            int cc = d[1] + c;
            if(isValid(board, cr, cc, word, p+1)) return true;
        }
        board[r][c] = word.charAt(p);
        return false;
    }
    public static void main(String[] args) {
        String word = "ABCCED";
        char [][] board = {{'A','B','C', 'E'}, {'S','F','C','S'},{'A','D','E','E'}};
        for(char[] c: board) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println("Does the string " + word  + " exist in board ? " + exist(board, word));
    }
}
