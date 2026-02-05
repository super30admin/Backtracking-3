''' Time Complexity : O(n * n!) ; 
    Space Complexity : O(n^2 + n)  
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No


    Approach - Place the queen if safe , go to next row. if cannot place in next row, backtrack by making 1->0
'''

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.mat=[[False for _ in range(n)] for _ in range(n)]
        self.result = []

        def helper(i, j, n):
            #base
            if i == n:
                li = []
                for r in range(n):
                    s = ""
                    for c in range(n):
                        if self.mat[r][c]:
                            s += "Q"
                        else:
                            s += "."
                    li.append(s)
                self.result.append(li)
                return

            for j in range(n):
                if self.isSafe(i,j,n):
                    self.mat[i][j] = True
                    helper(i+1,j,n)
                    self.mat[i][j] = False
        
        helper(0,0,n)
        return self.result


    def isSafe(self,i, j,n):
        r,c = i, j
        #up check
        while r>=0:
            if self.mat[r][c]:
                return False
            r -= 1
        
        r,c = i, j
        #right check diagonal
        while r>=0 and c<n:
            if self.mat[r][c]:
                return False
            r -= 1
            c += 1

        r,c = i, j
        #right left diagonal
        while r>=0 and c>=0:
            if self.mat[r][c]:
                return False
            r -= 1
            c -= 1
        return True










        