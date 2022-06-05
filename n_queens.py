# Time Complexity : O(n!) where n is size of the board
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for _ in range(n)] for _ in range(n)]
        self.placeQueen(board, 0)
        return self.result
        
    def placeQueen(self, board, r):
        #base
        if r == len(board):
            b = []
            for i in range(len(board)):
                temp = []
                for j in range(len(board[0])):
                    if board[i][j]:
                        temp.append('Q')
                    else:
                        temp.append('.')
                b.append("".join(temp))
            self.result.append(b)
            return
            
        #logic
        for c in range(len(board[0])):
            if self.isQueenSafe(board, r, c):
                #action
                board[r][c] = True
                #recurse
                self.placeQueen(board, r+1)
                #backtrack
                board[r][c] = False
                
                
    def isQueenSafe(self, board, r, c):
        for i in range(r, -1, -1):
            if board[i][c]: return False
        
        i, j = r, c
        while i >= 0 and j >= 0:
            if board[i][j]: return False
            i -= 1
            j -= 1
            
        i, j = r, c
        while i >= 0 and j < len(board[0]):
            if board[i][j]: return False
            i -= 1
            j += 1
        return True
        