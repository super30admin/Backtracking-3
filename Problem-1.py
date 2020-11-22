class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        def isSafe(r,c):
            #column up
            for i in range(r):
                if board[i][c] == 1:
                    return False
            i=r;j=c
            #diagnol left
            while i>=0 and j>=0:
                if board[i][j] == 1:
                    return False
                i-=1
                j-=1
            i=r;j=c
            #diagnol dright
            while i>=0 and j<m:
                if board[i][j] == 1:
                    return False
                i-=1
                j+=1

            return True



        def backtrack(r):

            #base
            if r ==m:
                temp=[]
                for i in range(m):
                    s = ""
                    for j in range(n):
                        if board[i][j]==0:
                            s=s+"."
                        else:
                            s=s+"Q"
                    temp.append(s)
                result.append(temp)
                return result

            #logic
            for j in range(m):
                if isSafe(r,j):
                    board[r][j] = 1
                    backtrack(r+1)
                    board[r][j] = 0





        result = []
        board = [[0 for i in range(n)] for j in range(n)]
        m =n
        backtrack(0)
        return result
