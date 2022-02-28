# Time complexity: Exponential = o(n!)
# Space complexity: O(n^2 )
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        if n is None:
            return self.result

        self.board = [[False] * n for i in range(n)]
        self.helper(n, 0, 0)
        return self.result

    def helper(self, n, ind, j):
        # base case
        if ind == n:
            res = []
            for i in range(0, len(self.board)):
                str1 = ""
                for j in range(0, len(self.board[i])):
                    if self.board[i][j]:
                        str1 += "Q"
                    else:
                        str1 += "."
                res.append(str1)

            self.result.append(res)

        # logic
        for i in range(j, n):
            if self.ValidSquare(ind, i):
                self.board[ind][i] = True
                self.helper(n, ind + 1, 0)
                self.board[ind][i] = False
        return

    def ValidSquare(self, ind, j):
        if ind == 0 and j == 0:
            return True

        # top line

        for i in range(0, ind):
            if self.board[i][j] == True:
                return False

        i = ind - 1
        leftJ = j - 1
        rightJ = j + 1
        while i >= 0:
            # left side
            if leftJ >= 0:
                if self.board[i][leftJ] == True:
                    return False
                leftJ -= 1
            if rightJ < len(self.board):
                if self.board[i][rightJ] == True:
                    return False
                rightJ += 1
            i -= 1
        return True





