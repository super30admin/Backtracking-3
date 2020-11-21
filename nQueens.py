#Time Complexity : O(n!) where n is number of queens
#Space Complexity : O(n) where n is number of queens
#Did this code successfully run on Leetcode : Yes

class Solution:
    def canPlace(self, row, col):
        #check in that column above curr
        for r in range(0, row):
            if self.board[r][col] == 1:
                return False

        #check in that diagonal above curr (row-1, col+1)
        r, c = row, col
        while r >= 0 and c < self.n:
            if self.board[r][c] == 1:
                return False
            r-=1
            c+=1

        #check in that anti-diagonal above curr (row-1, col-1)
        r, c = row, col
        while r >= 0 and c >= 0:
            if self.board[r][c] == 1:
                return False
            r-=1
            c-=1

        return True

    #get result board if we're able to place all the queens in the correct position
    def getboard(self):
        curr = []
        for r in range(self.n):
            temp = []
            for c in range(self.n):
                if self.board[r][c] == 0:
                    temp.append(".")
                else:
                    temp.append("Q")
            curr.append("".join(temp))
        return curr

    def backtrack(self, r):
        #if we pass the last row, successfully placing all queens then we can get the resulting board and store in out result array
        if r == self.n:
            temp = self.getboard()
            self.result.append(temp)
            return

        #iterate through all columns
        for c in range(self.n):
            #see if we can place a queen in the current (r, c) position
            if self.canPlace(r, c):
                self.board[r][c] = 1 #action
                self.backtrack(r + 1) #recurse
                self.board[r][c] = 0 #backtrack

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.n = n
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        self.result = []
        self.backtrack(0)

        return self.result
