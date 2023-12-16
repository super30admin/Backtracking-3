class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res=[]
        self.board=[[False]*n for _ in range(n)]
        self.helper(0,n)
        return self.res

    def helper(self,row,n):

        if row == n:
            temp=[]
            for i in range(n):
                string=""
                for k in range(n):
                    if self.board[i][k]:
                        string+="Q"
                    else:
                        string+="."
                temp.append(string)

            self.res.append(temp)
            return
        
        for j in range(0,n):
            if self.isSafe(row,j,n):
                self.board[row][j]=True
                self.helper(row+1,n)
                self.board[row][j]=False


    def isSafe(self,row,j,n):
        i=row
        c=j

        while(i>=0):

            if self.board[i][c]:
                return False

            i-=1

        i=row
        c=j

        while i>=0 and c>=0:
            if self.board[i][c]:
                return False
            i-=1
            c-=1

        i=row
        c=j

        while i>=0 and c<n:
            if self.board[i][c]:
                return False
            i-=1
            c+=1

        return True

            



        