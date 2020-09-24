def solveNQueens(self, n: int) -> List[List[str]]:
    sol = []
    def backtracking(board,i,queens_left):
        #base case
        if queens_left==0:
            makeoutput(board)
            return
                
        #recursive
        for j in range(n):
            if isValid(board,i,j):
                board[i][j]= 'Q'
                backtracking(board,i+1,queens_left-1)
                board[i][j]= '.'   
    def isValid(board,i,j):
        #top
        r=i
        c=j
        while (r>=0):
            if board[r][c]=='Q':
                return False
            r-=1
        
        #top_left
        r=i
        c=j
        while (r>=0 and c>=0):
            if board[r][c]=='Q':
                return False
            r-=1
            c-=1
        
        #top_right
        r=i
        c=j
        while (r>=0 and c<len(board)):
            if board[r][c]=='Q':
                return False
            r-=1
            c+=1
        return True
    def makeoutput(board):
        output=[]
        for i in range(len(board)):
            output.append("")
            for j in range(len(board[0])):
                output[i]+=board[i][j]
        sol.append(output)
    
    board = []
    for i in range(n):
        board.append([])
        for j in range(n):
            board[i].append('.')
    backtracking(board,0,n)
    return sol