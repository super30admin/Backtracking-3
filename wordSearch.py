# m is the number of rows and n is number of columns
# T.C. O(m X n)
# L is the length of the word
# S.c. O(L)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        m=len(board)
        n=len(board[0])
        
        global dirs
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        
        
        for i in range(m):
            for j in range(n):
                if self.backtrack(board,word,i,j,0):
                    return True
                
        return False
    
    def backtrack(self,board,word,r,c,index):
#         base
        global dirs
        if index==len(word):
            return True
        if r<0 or r>=len(board) or c<0 or c>=len(board[0]) or board[r][c]=='#':
            return False

#           logic

        if board[r][c]==word[index]:
#             action
            ch=board[r][c]
            board[r][c]='#'
#             recurse
            for dir in dirs:
                nr=r+dir[0]
                nc=c+dir[1]
                if self.backtrack(board,word,nr,nc,index+1):
                    return True
        
#           undo
            board[r][c]=ch
        return False
        
