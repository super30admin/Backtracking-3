# Time Complexity : O(n!)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = [False for _ in range(n)]
        diags = [False for _ in range(n+n)]
        adiags = [False for _ in range(n+n)]

        res = []
        def helper(r, n, cols, diags, adiags, path):
            nonlocal res
            if r==n:
                res.append(["".join(row) for row in path])
            
            for c in range(n):
                diag = r-c+n
                adiag = r+c
                if cols[c] or diags[diag] or adiags[adiag]:
                    continue
                path[r][c] = "Q"
                cols[c] = True
                diags[diag] = True
                adiags[adiag] = True
                helper(r+1, n, cols, diags, adiags, path)

                cols[c] = False
                diags[diag] = False
                adiags[adiag] = False
                path[r][c] = "."



        path = []
        for i in range(n):
            path.append(["." for _ in range(n)])
        helper(0, n, cols, diags, adiags, path)
        return res
