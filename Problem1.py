class Solution:
    # Time Complexity:N!
    # Space Complexity:O(n)
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [[False for _ in range(n)] for _ in range(n)]
        self.helper(board, 0, n)
        return self.result

    def helper(self, board, r, n):
        if r == n:
            li = []
            for i in range(0, n):
                st = ""
                for j in range(0, n):
                    if board[i][j]:
                        st += "Q"
                    else:
                        st += "."
                li.append(st)
            self.result.append(li)

        for j in range(0, n):
            if self.isSafe(board, r, j):
                board[r][j] = True
                self.helper(board, r + 1, n)
                board[r][j] = False

    def isSafe(self, board, r, c):
        for i in range(0, r):
            if board[i][c]:
                return False
        i = r
        j = c
        while i >= 0 and j < len(board):
            if board[i][j]:
                return False
            i -= 1
            j += 1
        i = r
        j = c
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1
        return True
