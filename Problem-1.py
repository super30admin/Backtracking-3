#Approach
# start with each  placing on the queen , while placing the queen the check the previous row whether we can plac it or not
# If we place all queens and row is greater return that pattern

#Complexities
#Time: O(N!)
#Space: O(N)


from typing import List


class Solution:
    def __init__(self):
        self.result = []
        self.board = None

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.helper(0, n)
        return self.result

    def helper(self, index, n):
        if index == n:
            res = []
            for i in range(n):
                res_path = []
                for j in range(n):
                    if self.board[i][j] == True:
                        res_path.append("Q")
                    else:
                        res_path.append(".")
                res.append("".join(res_path))
            self.result.append(res)
            return

        for j in range(n):
            if (self.isSafe(index, j, n)):
                self.board[index][j] = True
                self.helper(index + 1, n)
                self.board[index][j] = False

    def isSafe(self, i, j, n):
        r = i
        c = j

        while (r >= 0):
            if self.board[r][c] == True:
                return False
            r -= 1
        r = i
        c = j
        while r >= 0 and c >= 0:
            if self.board[r][c] == True:
                return False
            r -= 1
            c -= 1

        r = i
        c = j
        while r >= 0 and c < n:
            if self.board[r][c] == True:
                return False
            r -= 1
            c += 1
        return True




