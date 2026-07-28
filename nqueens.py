class Solution:
    def solveNQueens(self, n):
        self.result = []
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.helper(0, n)
        return self.result

    def helper(self, r, n):
        if r == n:
            list = []
            for i in range(n):
                sb = []
                for j in range(n):
                    if self.board[i][j]:
                        sb.append("Q")
                    else:
                        sb.append(".")
                list.append("".join(sb))
            self.result.append(list)
            return

        for c in range(n):
            if self.isValid(r, c, n):
                self.board[r][c] = True
                self.helper(r + 1, n)
                self.board[r][c] = False

    def isValid(self, r, c, n):
        k = 1
        while r - k >= 0:
            if self.board[r - k][c]:
                return False
            if c - k >= 0 and self.board[r - k][c - k]:
                return False
            if c + k < n and self.board[r - k][c + k]:
                return False
            k += 1
        return True

# TC - O(n * n! )
# SC - O( n^2 ) for the board + O( n ) recursive stack space