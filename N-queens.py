# Time Complexity:- O(n!)
# Space Complexity:- O(n) At max the recursion depth can be upto n queens
# Approach:- Use backtracking to enumerate all the possibilites. Before placing a queen at a point in the matrix,
# check if it is safe to place it there. If it is not then check the next position.
class Solution:
    def solveNQueens(self, n):
        self.res=[]
        def issafe(matrix,i,j):
            for k in range(i,-1,-1):
                if matrix[k][j]=="Q":
                    return False
            l,m=i,j
            while(l>=0 and m>=0):
                if matrix[l][m]=='Q':
                    return False
                l-=1
                m-=1
            l,m=i,j
            while(l>=0 and m<n):
                if matrix[l][m]=='Q':
                    return False
                l-=1
                m+=1
            return True
        def backtrack(i):
            # base case
            if i==n:
                local=[]
                for i in range(n):
                    local.append("".join(matrix[i]))
                self.res.append(local)
                return
            for j in range(n):
                if issafe(matrix,i,j):
                    # action
                    matrix[i][j]="Q"
                    # recurse
                    backtrack(i+1)
                    # backtrack
                    matrix[i][j]="."
        matrix=[]
        for i in range(n):
            matrix.append(["."]*n)
        backtrack(0)
        return self.res