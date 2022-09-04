# 51. N-Queens

'''
Leetcode all test cases passed: Yes
Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        n is the length of board
        Time Complexity: O(n!) 
        Space Complexity: O(n ^ 2)
'''
class Solution:
    def isValid(self,curr_board,r,c):
        for i in range(r):
            if curr_board[i][c] == "Q":
                return False
            
        m,n = r,c
        while (m >= 0 and n >= 0):
            if curr_board[m][n] == "Q":
                return False
            m -=1
            n -=1
        m,n = r,c
        while (m >= 0 and n < len(curr_board)):
            if curr_board[m][n] == "Q":
                return False
            m -=1
            n +=1
            
        return True
    def helper(self,r,curr_board):
        
        if r == len(curr_board):
            temp = []
            for k in curr_board:
                temp.append("".join(k))
            self.result.append(temp)
            return
        for i in range(len(curr_board)):
            if self.isValid(curr_board,r,i):
                curr_board[r][i] = "Q"
                self.helper(r + 1,curr_board)
                curr_board[r][i] = "."
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = []
        self.result = []
        for i in range(n):
            l = []
            for j in range(n):
                l.append(".")
            board.append(l)
        self.helper(0,board)
        return self.result
