''' Time Complexity : O(m * n * 4^L) ; L - len of word
    Space Complexity : O(L)  
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : First do left pass to calculate running product. 
              Then second iteration from right to left and updating the new product
'''

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board),len(board[0])
        dirs = [(-1,0),(0,1),(1,0),(0,-1)]

        if rows==1 and cols == 1 and board[0][0] == word:
            return True

        def dfs(board, word, i, j, s):
            #base
            if s == len(word):
                return True
            if board[i][j] != word[s]:
                return False
            #logic
            #action 
            char = board[i][j]
            board[i][j] = "#"
            for dir in dirs:
                r = dir[0] + i
                c = dir[1] + j
                if 0<=r<rows and 0<=c<cols:
                    if dfs(board, word, r, c, s+1):
                        return True
            #backtrack
            board[i][j] = char

        for i in range(rows):
            for j in range(cols):
                if dfs(board, word, i, j, 0):
                    return True
        return False