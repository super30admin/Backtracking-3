# Time Complexity = O(n!)  | Space Complexity = O(n^2)

class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        self.result = []
        self.board = [[False] * n for _ in range(n)]
        self.helper(0, n)
        return self.result

    def helper(self, i: int, n: int):
        # base case
        if i == n:
            path = []
            for r in range(n):
                sb = ""
                for c in range(n):
                    if self.board[r][c]:
                        sb += "Q"
                    else:
                        sb += "."
                path.append(sb)
            self.result.append(path)
            return

        # logic
        for j in range(n):
            if self.is_safe(i, j, n):
                # action
                self.board[i][j] = True
                # recurse
                self.helper( i +1, n)
                # backtrack
                self.board[i][j] = False


    def is_safe(self, i: int, j: int, n: int):

        # all rows same column
        r = i; c = j
        while( r>=0):
            if self.board[r][c]: return False
            r -= 1

        # top diagonal left
        r = i; c = j
        while( c>=0 and r>= 0):
            if self.board[r][c]: return False
            r -= 1
            c -= 1

        # top diagonal right
        r = i; c = j
        while (c < n and r >= 0):
            if self.board[r][c]: return False
            r -= 1
            c += 1

        return True

