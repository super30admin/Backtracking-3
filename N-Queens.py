####51. N-Queens##################################################################################################
// Time Complexity : n^n
// Space Complexity : nXn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We have used for loop based recursion along with backtracking where we found all the possible place where queen can be placed, and stored in another array with Boolean flag.
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result=[]
        mat=[[False for r in range(n)] for c in range(n)]
        self.backtrack(result,n,mat,0)
        return result
        
    def backtrack(self,result,n,mat,r):
        #base
        if r==n:
            l1=[]
            print('in base')
            #print(mat)
            for k in range(n):
                str1=''
                for l in range(n):
                    if mat[k][l]==True:
                        str1+='Q'
                    else:
                        str1+='.'
                l1.append(str1)
            result.append(l1)

            return

        #logic
        #for i in range(n):
        for j in range(n):
            if self.isSafe(r,j,n,mat):
                #print('safe:',r,j)
                mat[r][j]=True
                #print(mat)
                self.backtrack(result,n,mat,r+1)
                mat[r][j]=False
        
                    


    def isSafe(self,r,c,n,mat) -> bool:
        #check vertical
        for i in range(r):
            #print('safe 1:',i,r,c)
            if mat[i][c]==True:
                #print('false')
                return False

        #check top right
        i,j=r,c
        while i>=0 and j<n:
            if mat[i][j]==True:
                return False
            i-=1
            j+=1


        #check topleft
        i,j=r,c
        while i>=0 and j>=0:
            if mat[i][j]==True:
                return False
            i-=1
            j-=1
        return True