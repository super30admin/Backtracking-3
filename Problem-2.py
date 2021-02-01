#Time Complexity :O(3^l) l is avg lengtht of f word
#Space Complexity :O(l) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    m=None
    n=None
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if(board==None or len(board)==None):
            return False
        
        self.m=len(board)
        self.n=len(board[0])
        
        for i in range(self.m):
            for j in range(self.n):
                if(board[i][j]==word[0]):
                    if(self.dfs(board,word,i,j,0)):
                        return True
        return False
    
    def dfs(self,board,word,i,j,index):
        #base
        if(index==len(word)):
            return True
        if(i<0 or j<0 or i==self.m or j==self.n or board[i][j]=='#'):
            return False
        
        #logic
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        if(board[i][j]==word[index]):
            temp=board[i][j]
            board[i][j]='#'
            for dire in dirs:
                r=dire[0]+i
                c=dire[1]+j
                if(self.dfs(board,word,r,c,index+1)):
                    return True
            board[i][j]=temp
        return False
        
    