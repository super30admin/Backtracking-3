# // Time Complexity : O(n!) where n is the length of the board.
# // Space Complexity : O(n^2) where n is the length of the board.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.result = []
        self.n = n
        
        def isSafe(i,j):
            for k in range(i+1):
                if self.board[k][j] == True:
                    return False
            r = i
            c = j
            while(r>=0 and c >= 0):
                if self.board[r][c] == True:
                    return False
                r -= 1
                c -= 1
            while(i >= 0 and j <n):
                if self.board[i][j] == True:
                    return False
                i -= 1
                j += 1
            return True

        def helper(i):
            # base
            if i == self.n:
                res = []
                for k in range(self.n):
                    temp = ""
                    for k1 in range(self.n):
                        if self.board[k][k1] :
                            temp += "Q"
                        else:
                            temp += "."
                    res.append(temp)
                self.result.append(res)
                return
                
            
            # logic
            for j in range(n):
                if isSafe(i,j):
                    self.board[i][j] = True
                    helper(i+1)
                    self.board[i][j] = False
        helper(0)
        return self.result
