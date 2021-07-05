class Solution(object):
    """
    #     :type n: int
    #     :rtype: List[List[str]]
    #     :SC:O(n*n) # creating a board and size of recursive stack: O(n*n)+O(n)
    #     :TC:O(factorial(n)) # n(n-2)*(n-4)*(n-6)....
    #     """
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        self.board = [[False]*n for i in range(n)]
        self.backtrack(0, n)
        return self.res
    
    def backtrack(self, row, n):
        #base
        if row == n: 
            li = []
            for i in range(n):
                stringBuilder = ""
                for j in range(n):
                    if self.board[i][j] == True:
                        stringBuilder += "Q"
                    else:
                        stringBuilder += "."
                li.append(stringBuilder)
            self.res.append(li)
            return
        
        # logic
        for j in range(n):
            if self.isSafe(row,j,n):
                self.board[row][j]  = 1
                
                # recurse
                self.backtrack(row+1, n)
                
                #backtrack
                self.board[row][j] = 0
    
    def isSafe(self, r, c, n): # check diagonals, row and col condition
        
        # check col
        for i in range(r):
            if self.board[i][c] == 1:
                return False
        
        #diagonal up left
        i = r 
        j = c 
        
        # check diagonal
        while(i>=0 and j>= 0):
            if self.board[i][j] == 1:
                return False
            i-=1
            j-=1
        
        #diagonal up right
        i=r
        j=c
        while(i >= 0 and j < n):
            if self.board[i][j] == 1:
                return False
            i-=1
            j+=1
        
        return True


    
    # def solveNQueens(self, n):
    #     """
    #     :type n: int
    #     :rtype: List[List[str]]
    #     :SC:O(n*n) # creating a board and size of recursive stack: O(n*n)+O(n)
    #     :TC:O(factorial(n)) # n(n-2)*(n-4)*(n-6)....
    #     """
    #     col=set()
    #     postDiag = set()  #r+c=const
    #     negDiag = set()   #r-c=const
    #     res=[]
    #     # board=[['.']*n for i in range(n)]
    #     board=[]
    #     for i in range(n):
    #         board.append(['.']*n)
    #     # print(board)
        
    #     self.backtrack(n, 0, board, col, postDiag, negDiag, res)
    #     return res
    
    # def backtrack(self,n,row, board, col, postDiag, negDiag, res):
    #     # base
    #     if row==n:
    #         copy=["".join(r) for r in board]  # convert array elements into string
    #         res.append(copy)
    #         return
        
    #     # logic
    #     # cols as children.Visiting all childern using for loop since children are greater than 2
    #     for c in range(n):
    #         if c in col or (row+c) in postDiag or (row-c) in negDiag:
    #             continue
    #         col.add(c)
    #         postDiag.add(row+c)
    #         negDiag.add(row-c)
    #         board[row][c]='Q'
            
    #         # recurse
    #         self.backtrack(n, row+1, board, col, postDiag, negDiag, res)
            
    #         # backtrack
    #         col.remove(c)
    #         postDiag.remove(row+c)
    #         negDiag.remove(row-c)
    #         board[row][c]='.'
						