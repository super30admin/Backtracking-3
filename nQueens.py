#Time complexity: O(n!)
#space complexity: O(n^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        board = [[False for j in range(n)] for i in range(n)]
        self.backtrack(board, 0, n)
        return self.res
    def backtrack(self, board, r, n):
        if r == n:
            li = []
            for i in range(n):
                curr = ""
                for j in range(n):
                    if board[i][j]:
                        curr += 'Q'
                    else:
                        curr += '.'
                li.append(curr)
            self.res.append(li)
            return
        for j in range(n):
            if self.isSafe(board, r, j, n):
                board[r][j] = True
                self.backtrack(board, r+1, n)
                board[r][j] = False
    def isSafe(self, board, r, c, n):
        #up col
        for i in range(r):
            if board[i][c]:
                return False
        #up left
        i, j = r, c
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1
        #up right
        i, j = r, c
        while i >= 0 and j < n:
            if board[i][j]:
                return False
            i -= 1
            j += 1
        return True
            
        
        
        
