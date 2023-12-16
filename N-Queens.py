# TC:O(N!)
# SC:O(N)

class Solution:
    res=[]
    mat=[[]]

    def isvalid(self,row,col,n):
        for i in range(row,-1,-1):
            if self.mat[i][col]==True:
                return False
        
        p=row
        q=col
        while p>-1 and q>-1:
            if self.mat[p][q]==True:
                return False
            p-=1
            q-=1
        
        p=row
        q=col
        while p>-1 and q<n:
            if self.mat[p][q]==True:
                return False
            p-=1
            q+=1
        
        return True

    def helper(self,row,n):
        if row==n:
            print("hello")
            print(self.mat)
            li=[]
            for i in range(0,n):
                s=""
                for j in range(0,n):
                    if self.mat[i][j]==True:
                        s+="Q"
                    else:
                        s+="."
                li.append(s)
            self.res.append(li.copy())
            return

        for j in range(0,n):
            if self.isvalid(row,j,n)==True:
                self.mat[row][j]=True
                self.helper(row+1,n)
                self.mat[row][j]=False


    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res=[]
        self.mat=[[False for i in range(0,n)] for j in range(0,n)]
        self.helper(0,n)
        return self.res

        