"""
Time Complexity : O(N*3^L) where N = mxn(elements on board) and L is length of Word 
Space Complexity : O(L) where L is the length of the word
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board) == 0:
            return False
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if (self.backtrack(board, word, 0, i, j)):
                        return True
        return False
    def backtrack(self, board, word, index, row, col):
        # Base
        # If index has reached the end of the word mean we found the string
        if index == len(word):
            return True
        # If row and col are not within length or the letter at that index did not 
        # match we return False
        if row < 0 or row == self.m or col < 0 or col == self.n or board[row][col] != word[index]:
            return False
        # Logic
        # Action
        # Storing the letter so that we do not loose it when we come back as we'll 
        # mutate it with '#' once visited
        letter = board[row][col] 
        board[row][col] = '#'
        for d in self.dirs:
            r = row + d[0]
            c = col + d[1]
            # Recurse
            if(self.backtrack(board, word, index + 1, r, c)):
                return True
        # Backtrack
        board[row][col] = letter
        return False
            
            