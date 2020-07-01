# Time Complexity : O(n!) n factorial, as we are eliminating 2 cells each time downward 
# Space Complexity : O(n x n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    result = None
    board = None 
    def solveNQueens(self, n):
        self.result = []
        if n <= 0:
            return self.result
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        self.backtrack(0)
        return self.result 

    def backtrack(self,r):
        # base 
        if r == len(self.board):
            temp = []
            for i in range(len(self.board)):
                s = ''
                for j in range(len(self.board[0])):
                    if self.board[i][j] == 1:
                        s += 'Q'
                    else:
                        s += '.'
                temp.append(s)
            self.result.append(temp)
            return 

        # logic 
        # action 
        for i in range(len(self.board[0])):
            if self.isSafe(r,i):
                self.board[r][i] = 1 
                self.backtrack(r+1)
                self.board[r][i] = 0 

    def isSafe(self,i,j):
        # col 
        for row in range(len(self.board)):
            if self.board[row][j] == 1:
                return False 

        # Diagonal upper left
        r , c = i, j  
        r, c = r -1 , c - 1  
        while r >= 0 and c >= 0 :
            if self.board[r][c] == 1:
                return False 
            r -= 1 
            c -= 1 

        r , c = i, j  
        r -= 1 
        c += 1 
        # Diagonal upper right 
        while r >= 0 and c < len(self.board[0]):
            if self.board[r][c] == 1:
                return False 
            r -= 1 
            c += 1 
        return True 

if __name__ == "__main__":
    s = Solution()
    res = s.solveNQueens(4)
    print(res)