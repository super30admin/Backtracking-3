class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        mat=[[0 for _ in range(n)] for _ in range(n)]
        #we will go rowwise and increment the column to check if that is valid
        def helper(row,mat):
            #Base case
            if row==n:
                res=[]
                for i in range(len(mat)):
                    cur=""
                    for j in range(len(mat[0])):
                        if mat[i][j]==1:
                            cur+="Q"
                        else:
                            cur+="."
                    res.append(cur)
                self.final.append(res)
                return
            
            #check all columns for that row:
            for col in range(0,n):
                if valid(mat,row,col):
                    mat[row][col]=1
                    helper(row+1,mat)
                    mat[row][col]=0
        def valid(mat,row,col):
            #check the same col and all rows above if any queen present
            for i in range(row-1,-1,-1):
                if mat[i][col]==1:
                    return False
            #check diagonal if any queen present
            row1=row-1
            col1=col-1
            while(row1>=0 and col1>=0):
                if mat[row1][col1]==1:
                    return False
                row1-=1
                col1-=1
            #check anti diagonal if any queen present
            row1=row-1
            col1=col+1
            while(row1>=0 and col1<len(mat)):
                if mat[row1][col1]==1:
                    return False
                row1-=1
                col1+=1  
            return True
        self.final=[]
        helper(0,mat)
        print(self.final)
        return self.final
    #Time complexity: O(N!)
    #Space : O(N^2)+stack space
