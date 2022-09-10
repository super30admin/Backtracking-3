# TC : O(mn (3^l))
# SC : O(l)
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m = len(board)
        n = len(board[0])
        self.board = board
        
        #to find the start of word - start DFS here
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if self.backtrack(i,j,m,n,0,word): return True                
        
        return False
        
    def backtrack(self,i,j,m,n,index,word): # boolean return type function
        #base
        if index==len(word):
            return True
        if (i<0 or i==m or j<0 or j==n or self.board[i][j]=="#"):
            return False
        
        #logic
        if (self.board[i][j]==word[index]):
            #action
            self.board[i][j] = "#"
            for dx,dy in [[1,0],[-1,0],[0,-1],[0,1]]:
                nr = dx + i
                nc = dy + j
                #recurse
                if self.backtrack(nr,nc,m,n,index+1,word):
                    return True
                
            #backtrack
            self.board[i][j] = word[index]
            
        return False