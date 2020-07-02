#51. N-Queens
# Time Complexity : O(n!)
# Space Complexity : O(n x n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    result = None
    board = None 
    def solveNQueens(self, n: int) -> List[List[str]]:
        if not n :
            return []
        self.result = []
        self.m = n
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        self.backtrack(0)
        return self.result
    def backtrack(self,indx):
        #base
        if indx == len(self.board):
            li = []
            for i in range(len(self.board)):
                st = ''
                for j in range(len(self.board[0])):
                    if self.board[i][j] == 0:
                        st += '.'
                    else:
                        st += 'Q'
                li.append(st)
            self.result.append(li)
        #logic
        for i in range(len(self.board[0])):
            if self.isSafe(indx,i):
                #action
                self.board[indx][i] = 1
                #recurse
                self.backtrack(indx+1)
                self.board[indx][i] = 0
                
                
    def isSafe(self,r,c):
        #above col
        for i in range(len(self.board)):
            if self.board[i][c] == 1:
                return False
        #daig left
        i = r - 1
        j = c - 1
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
            
      
        #daig right
        i = r-1
        j = c+1
        while i >= 0 and j < len(self.board[0]):
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
        return True