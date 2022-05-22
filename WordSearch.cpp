// Time Complexity : O(3^L * m*n) where L = length of a word
// Space Complexity : O(L) where L = length of a word
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Backtracking approach. Perform exhaustive search - find the first word character. From the first word character cell start the search for the next word characters.
 * Change the current cell value to '#' to indicate visited cell. 
 * If next word character is found in neighboring cell then call the recursive method to search for the remaning characters.  
 */

class Solution {
public:
    
    int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    bool exist(vector<vector<char>>& board, string word) {
        
        if (board.size() == 0)
            return false;
        
        m = board.size();
        n = board[0].size();
        
        for (int i = 0; i < m ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == word[0] && helper(board, i, j, word, 0))
                { 
                    return true;
                }
            }
        }
       
        return false; 
    }
    
    bool helper(vector<vector<char>>& board, int br, int bc, string& word, int si)
    {
        if (si == word.length())
        {
            return true;
        }
        
        if (br < 0 || br == m || bc < 0 || bc == n || board[br][bc] != word[si])
        {
            return false;
        }
        
      
        char temp = board[br][bc]; 
        board[br][bc] = '#';
        
    
        for (auto d : dir)
        {
            int nr = br + d[0];
            int nc = bc + d[1];

            if (helper(board, nr, nc, word, si + 1))
                   return true;
        }
            
        board[br][bc] = temp;
        
        return false;
    }
};