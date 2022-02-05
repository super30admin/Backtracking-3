# Backtracking-3

## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

# Time Complexity = O(n!)
# Space Complexity = O(n**2)

class Solution:
    def __init__(self):
        self.board=[]
        self.result=[]
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        result=[]
        l = [False]*n
        for i in range(n):
            self.board.append(l[:])
        def backtrack(row):
            if row==n:
                b = []
                for i in range(n):
                    a=[]
                    for j in range(n):
                        if self.board[i][j]==True:
                            a.append('Q')
                        else:
                            a.append('.')
                    b.append("".join(a))
                self.result.append(b)
                        
            for k in range(n):
                if position(row,k):
                    self.board[row][k]=True
                    backtrack(row+1)
                    self.board[row][k]=False
            
        def position(x,y):
            for k in range(x):
                if self.board[k][y]==True:
                    return False
            r,c=x,y
            while(r>=0 and c>=0):
                if self.board[r][c]:
                    return False
                r-=1
                c-=1
            r,c=x,y
            while(r>=0 and c<n):
                if self.board[r][c]:
                    return False
                r-=1
                c+=1
            return True
        backtrack(0)
        return self.result
        
## Problem2
Word Search(https://leetcode.com/problems/word-search/)

# Time Complexity = O(n*3**l)
# Space Complexity = O(l)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m=len(board)
        n=len(board[0])
        if m==0 or n==0 or board==None or board[0]==None:
            return False
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        def backtrack(x,y,index):
            if index==len(word):
                return True
            if x<0 or y<0 or x==m or y==n or board[x][y]=='#':
                return False
            if board[x][y]==word[index]:
                c=word[index]
                board[x][y]='#'
                for k in dirs:
                    r=x+k[0]
                    col=y+k[1]
                    if backtrack(r,col,index+1):
                        return True
                board[x][y]=c        
            return False
        for i in range(m):
            for j in range(n):
                if backtrack(i,j,0):
                    return True
        return False