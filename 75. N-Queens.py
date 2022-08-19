class Solution:
    result = []
    board = []

    def solveNQueens(self, n: int):
        self.result = []
        self.board = [[False] * n for i in range(n)]
        # print(self.board)
        self.dfs(0)
        return print(self.result)

    def dfs(self, row):
        if row == len(self.board):
            li = []
            # print(self.board)
            for i in range(len(self.board)):
                sb = []
                for j in range(len(self.board)):
                    if self.board[i][j]:
                        sb.append("Q")
                    else:
                        sb.append(".")
                li.append("".join(sb))
            self.result.append(li)

        for j in range(len(self.board)):
            if self.isSafe(row, j):
                self.board[row][j] = True
                # print(self.board)
                # recurse
                self.dfs(row + 1)
                # backtracking
                self.board[row][j] = False

    def isSafe(self, r, c):
        # up column check
        for i in range(r):
            # print(self.board[i][c])
            if self.board[i][c]:
                return False

        # diagonal up left
        i = r
        j = c
        while i >= 0 and j >= 0:
            if self.board[i][j]:
                return False
            i -= 1
            j -= 1

        i = r
        j = c

        while i >= 0 and j < len(self.board):
            if self.board[i][j]:
                return False
            i -= 1
            j += 1

        return True


if __name__ == "__main__":
    obj = Solution()
    obj.solveNQueens(4)

# TC =O(n!).
# Space complexity : O(n!)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
