# Time Complexity : O(3XNXMXL) # Exponential
# Space Complexity : O(N) N-> size of recursion
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to Recurse all possible 4 directions and search for the word using visited approach.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if(board == None or len(board)==0):
            return False
        
        m=len(board)
        n=len(board[0])
        for i in range(0,m):
            for j in range(0,n):
                if(self.backtrack(board, word,i,j, 0)):
                    return True
        return False
    
    def backtrack(self, board, word, i,j,id):
        if(id == len(word)):
            return True
        
        if(i<0 or j<0 or i>=len(board) or j>=len(board[0]) or board[i][j]=="#"):
            return False
        
        if(board[i][j]==word[id]):
            board[i][j]="#"
            for (r,c) in [(i-1,j), (i+1,j), (i,j-1), (i,j+1)]:
                if(self.backtrack(board, word, r, c, id+1)):
                    return True
            board[i][j]=word[id]
        
        return False