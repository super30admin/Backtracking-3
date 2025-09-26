def solveNQueens(self, n: int) -> List[List[str]]:
    self.result=[]
    board=[[False]*n for _ in range(n)]
    self.helper(board,0,n) 
    return self.result

def helper(self,board,row,n):
    if row==n:
        list_=[]
        for i in range(n):
            sb=[]
            for j in range(n):
                if board[i][j]:
                    sb.append("Q")
                else:
                    sb.append(".")
            list_.append("".join(sb))
        self.result.append(list_)
        return
    for j in range(n):
        if self.issafe(board,row,j,n):
            board[row][j]=True
            self.helper(board,row+1,n)
            board[row][j]=False

def issafe(self,board,i,j,n):
    r=i
    c=j
    while r>=0:
        if board[r][c]:
            return False
        r-=1
    r=i
    c=j
    while r>=0 and c>=0:
        if board[r][c]:
            return False
        r-=1
        c-=1
    r=i
    c=j
    while r>=0 and c<n:
        if board[r][c]:
            return False
        r-=1
        c+=1
    return True

    

