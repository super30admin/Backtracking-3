# Time Complexity : O(n**2*!n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def isSafe(self, r, c, arr):
        # col check
        for i in range(r):
            if arr[i][c] == True:
                return False
        
        # diag left check
        i = r
        j = c
        while i >= 0 and j >= 0:
            if arr[i][j] == True:
                return False
            i -= 1
            j -= 1
        
        # diag right check
        i = r
        j = c
        while i >= 0 and j < len(arr[0]):
            if arr[i][j] == True:
                return False
            i -= 1
            j += 1

        return True

    def backtrack(self, arr, i, n):
        # base
        if i == n:
            res = []
            for r in range(n):
                s = ''
                for c in range(n):
                    if arr[r][c] == False:
                        s += '.'
                    else:
                        s += 'Q'
                res.append(s)

            self.result.append(res)

        # logic
        for j in range(n):
            # action
            if self.isSafe(i, j, arr):
                arr[i][j] = True
                # recurse
                self.backtrack(arr, i+1, n)
                # backtrack
                arr[i][j] = False

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.arr = [[False for _ in range(n)] for _ in range(n)]
        self.backtrack(self.arr, 0, n)
        return self.result

