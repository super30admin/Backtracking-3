class Solution(object):
    dirr=[[0,1],[0,-1],[1,0],[-1,0]]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        :TC:O((m*n)*(3^w)  # len(word)=w
        :SC:O(w) # max length of recursive stack
    
        """
        if not board: return True
        if not word: return True
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False
    
    def dfs(self, board, word, r, c, index):
        
        # base
        if index==len(word):return True
        # if word's char in board[r][c]
        if r<0 or c<0 or r==len(board) or c==len(board[0]) or word[index]!=board[r][c]:
            return False
       
        
        # logic
        # action
        temp=board[r][c]
        board[r][c]='#'
        
        #recurse
        for d in self.dirr:
            i=r+d[0]
            j=c+d[1]
            if self.dfs(board, word, i,j,index+1):return True
        
        # backtrack
        board[r][c]=temp
        return False
            
        
        
        
        