'''
Time Complexity: O(n!)
Space Complexity: O(n*n)
Run on Leetcode: YES
'''
class Solution:
    def isSafe(self,board: list[list[bool]], i: int, j: int) -> bool:
        for x in range(i):
            if board[x][j]:
                return False
        x = i
        y = j
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1
        while x >= 0 and y < len(board):
            if board[x][y]:
                return False
            x -= 1
            y += 1
        return True
                
    def nQueens(self, board: list[list[bool]], row: int):
        #base
        if row == len(board):
            re = []
            for r in board:
                li = ""
                for x in r:
                    if x:
                        li += 'Q'
                    else:
                        li += '.'
                re.append(li)
            self.result.append(re)
            return
        #logic
        #action
        for i in range(len(board[row])):
            if self.isSafe(board, row, i):
                #recurse
                board[row][i] = True
                self.nQueens(board, row + 1)
                #backtrack
                board[row][i] = False
        
    
    def solveNQueens(self, n: int) -> list[list[str]]:
        if n == 0:
            return [[]]
        self.result = []
        board = [[False] * n for i in range(n)]
        self.nQueens(board, 0)
        return self.result