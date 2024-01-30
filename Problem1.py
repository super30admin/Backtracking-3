'''

Time Complexity : O(n!)
Space Complexity : O(n^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Helper function is defined to recursively add elements to a matrix to check where we can possible place the queen. The isValid() check if
the position is a valid position
'''

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        ref = [[False for _ in range(n)] for _ in range(n)]

        def helper(r,n):
            if r == n:
                temp = []
                for i in range(n):
                    s = ""
                    for j in range(n):
                        if ref[i][j] == False:
                            s += "."
                        else:
                            s += "Q"
                    temp.append(s)
                res.append(temp.copy())


            for i in range(n):
                if isvalid(r,i,n):
                    ref[r][i] = True
                    helper(r+1,n)
                    ref[r][i] = False


        def isvalid(r,c,n):
            for i in range(r,0,-1):
                if ref[i-1][c]:
                    return False

            i = r-1
            j = c-1
            while i >= 0 and j >= 0:
                if ref[i][j]:
                    return False

                i -= 1
                j -= 1

            i = r-1
            j = c+1
            while i >= 0 and j < n:
                if ref[i][j]:
                    return False

                i -= 1
                j += 1

            return True


        helper(0,n)
        return res
