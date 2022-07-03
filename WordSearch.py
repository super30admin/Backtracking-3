#TC:O(mn(3^L))
#SC:O(L)
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        if board==None or len(board)==0:
            return False
        m=len(board)
        n=len(board[0])
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        def backtrack(board,i,j,word,index):
            #base
            if index==len(word):return True
            if i<0 or j<0 or i==m or j==n or board[i][j]=='#': return False
            #logic
            if word[index]==board[i][j]:
                #action
                board[i][j]='#'
                for k in range(len(dirs)):
                    r=i+dirs[k][0]
                    c=j+dirs[k][1]
                    
                    #recurse
                    if(backtrack(board,r,c,word,index+1)): return True
                #backtrack
                board[i][j]=word[index]
                
        
        
        for i in range(m):
            for j in range(n):
                if word[0]==board[i][j]:
                    if(backtrack(board,i,j,word,0)): return True
        return False