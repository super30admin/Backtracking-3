# Time Complexity: O(4^k)
# Space Complexity: O(h)

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        dir=[[0,-1],[0,1],[-1,0],[1,0]]
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if self.helperFunction(word,board,i,j,0,dir,m,n):
                    return True
        return False

    def helperFunction(self, word, board, i,j, idx, dir,m,n):
        # base
        if idx==len(word):
            return True
        if i<0 or j<0 or i>=m or j>=n or board[i][j]=="#":
            return False
        # logic
        if board[i][j]==word[idx]:
            board[i][j]="#"
            for d in dir:
                newRow=i+d[0]
                newCol=j+d[1]
                if (self.helperFunction(word,board,newRow,newCol,idx+1,dir,m,n)):
                    return True
        # backtrack
            board[i][j]=word[idx]
        return False
        
