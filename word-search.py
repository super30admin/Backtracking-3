'''
## Problem2
Word Search(https://leetcode.com/problems/word-search/)

TC = O(m x n x 4^L)
SC = O(L)
m = number of rows
n = number of columns
L = length of the word
'''

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        def backTrack(r,c,i):
            if i == len(word):
                return True
            if r >= rows or r < 0 or c >= cols or c < 0 or board[r][c] != word[i]:
                return False
            temp = board[r][c]
            board[r][c] = "#"            
            found = (
                backTrack(r+1, c , i+1) or
                backTrack(r-1, c , i+1) or
                backTrack(r, c+1 , i+1) or
                backTrack(r, c-1 , i+1) 
            )
            board[r][c] = temp
            return found
            
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0]:
                    if backTrack(r,c,0):
                        return True
        return False
            
        