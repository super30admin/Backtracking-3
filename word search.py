# // Time Complexity : O(N*4^L) where N is the number of cells and L is the lenght of the word
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def exist(self, board, word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        path = set()
        
        def backtrack(r, c, i):
            
            # base cases
            if i == len(word):
                return True
            
            # invalid conditions
            if (r < 0 or c < 0 or r >= ROWS or
               c >= COLS or word[i] != board[r][c]
               or (r,c) in path):
                return False
            
            path.add((r,c)) # add the path to the set
            
            # check all four adjacent cells
            res  = (backtrack(r+1, c, i+1) or
                    backtrack(r-1, c, i+1) or
                    backtrack(r, c+1, i+1) or
                    backtrack(r, c-1, i+1))
            
            path.remove((r,c)) # clean up for next call
            return res
            
        for r in range(ROWS):
            for c in range(COLS):
                if backtrack(r, c, 0): return True
        return False
                
        