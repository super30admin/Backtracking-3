# Can you let me know what wronf I am doing? I am not able to understand.

class Solution:
    def solveNQueens(self, n):
        board = [['.']*n for _ in range(n)]
        # print(board)
        output = []
        self.helper(board,0,output)
        return output
    
    def helper(self,board,col,out):
        # base case
        if col==len(board):
            out.append(self.construct(board))
            return
        # Iterate the cols
        for i in range(len(board)):
            if self.validate(board,i,col):
                board[i][col] = 'Q'
                self.helper(board,col+1,out)
                board[i][col] = '.'
                
    def construct(self,board):
        ans = []
        for i in range(len(board)):
            s = board[i]
            ans.append(s)
        print(ans)
        return ans
    
    def validate(self,board,r,c):
        for i in range(len(board)):
            for j in range(c):
                if board[i][j]=='Q' and (i==r or r+c==i+j or r+j==c+i):
                    return False
        return True