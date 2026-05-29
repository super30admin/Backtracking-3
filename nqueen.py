class Solution:
    def solveNQueens(self, n):
        self.result = []
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.colSet = [False for _ in range(2*n)]
        self.mainDiagSet = [False for _ in range(2*n)]
        self.antiDiagSet = [False for _ in range(2*n)]

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
            md = r + c
            ad = r - c + n

            if (not self.colSet[c]) and (not self.mainDiagSet[md]) and (not self.antiDiagSet[ad]):
                self.colSet[c] = True
                self.mainDiagSet[md] = True
                self.antiDiagSet[ad] = True

                self.board[r][c] = True
                self.helper(r + 1, n)
                self.board[r][c] = False

                self.colSet[c] = False
                self.mainDiagSet[md] = False
                self.antiDiagSet[ad] = False


# Time: O(n!)
# Space: O(n^2) + O(n)