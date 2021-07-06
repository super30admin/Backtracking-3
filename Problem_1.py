from typing import List
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.board = [[0 for j in range(n)] for i in range(n)]
        self.backtrack(0, n)
        return self.result
    
    def backtrack(self, r: int, n: int) -> None:
        # base
        if r == n:
            li = []
            for i in range(n):
                string = ''
                for j in range(n):
                    if self.board[i][j] == 1:
                        string += 'Q'
                    else:
                        string += '.'
                li.append(string)
            self.result.append(li)
            return              
   
        #logic
        for j in range(0,n):
            if self.isSafe(r, j, n):
                self.board[r][j] = 1
                self.backtrack(r+1, n)
                self.board[r][j] = 0
    
    def isSafe(self, r: int, c: int, n: int) -> bool:
        # column up
        for j in range(0,r):
            if self.board[j][c] == 1:
                return False
        # column up left
        i = r
        j = c
        while i >= 0 and j >=0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
        # column up right
        i = r
        j = c
        while i >= 0 and j < n:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
        return True

# Time Complexity = O(n!)
# Space Complexity = O(n^2 for board and O(n) for recursive stack