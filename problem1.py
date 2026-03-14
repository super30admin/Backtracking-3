# problem 1 

# https://leetcode.com/problems/n-queens/

class Solution:

    def helper(self,row,n):
        if row == n:
            total_arr = []
            for i in range(n):
                row_arr = []
                for j in range(n):
                    if self.board[i][j]:
                        row_arr.append('Q')
                    else:
                        row_arr.append('.')
                total_arr.append(''.join(row_arr))
            self.final_arr.append(total_arr)
            return
        for j in range(n):
            if self.isValid(row,j,n):
                self.board[row][j] = True 
                self.helper(row+1,n)
                self.board[row][j] = False 

    # check top, left diagonal, right diagonal
    def isValid(self,i,j,n):
        r = i
        c = j
        while r >= 0:
            if self.board[r][c]:
                return False 
            r-=1
        r = i
        c = j
        while r >= 0 and c >= 0:
            if self.board[r][c]:
                return False 
            r-=1
            c-=1
        r = i
        c = j
        while r >= 0 and c < n:
            if self.board[r][c]:
                return False 
            r-=1
            c+=1
        return True

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.final_arr = []
        self.board = [[False]*n for _ in range(n)]
        self.helper(0,n)
        return self.final_arr