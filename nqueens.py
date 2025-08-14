# Time Complexity: O(n!)
# Space Complexity: O(n^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [[False] * n for i in range(n)]
        self.backtrack(n, board, 0)
        return self.result

    def backtrack(self, n, board, row):
        if row == n:
            templist = []
            for i in range(n):
                temprowList = []
                for k in range(n):
                    if board[i][k] == True:
                        temprowList.append('Q')
                    else:
                        temprowList.append('.')
                templist.append(''.join(temprowList))
            self.result.append(templist)
            return

        for j in range(n):
            if self.isvalid(n, board, row, j):
                board[row][j] = True
                self.backtrack(n, board, row + 1)
                board[row][j] = False

    def isvalid(self, n, board, row, col):
        r = row
        c = col
        while r >= 0:  # same column check
            if board[r][c]:
                return False
            r -= 1

        r = row
        c = col
        while r >= 0 and c >= 0:  # left diagonal check
            if board[r][c]:
                return False
            r -= 1
            c -= 1

        r = row
        c = col
        while r >= 0 and c < n:  # right diagonal check
            if board[r][c]:
                return False
            r -= 1
            c += 1
        return True
