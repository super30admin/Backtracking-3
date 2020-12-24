#time and space complexity will be exponential 4^n as we are exploring 4 diff direction 

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        n = len(board)
        if n == 0: return False
        m = len(board[0])
        if m == 0: return False
        
        
        def backtrack(i,j,word):
            if len(word) == 0:
                return True
            if i<0 or j<0 or i>n-1 or j>m-1 or board[i][j] != word[0]: 
                return False
            
            board[i][j] = "#"
            
            d = [[1,0],[-1,0],[0,1],[0,-1]]
            for di,dj in d:
                if backtrack(i+di,j+dj,word[1:]):
                    return True
        
            board[i][j] = word[0]
            return False
    
        for i in range(n):
            for j in range(m):
                if backtrack(i,j,word):
                    return True
        return False
                    
# Approch 
# exploring all 4 direction if we find next letter than we continue to explore in that direction until we find the whole word or we didnt find the next letter.




                