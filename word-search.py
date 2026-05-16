# Time Complecity: O(mn*4^l)
# Space Complecity: O(l)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        m=len(board)
        n=len(board[0])

        def helper(r,c,idx):
            if idx==len(word):
                return True
            
            if r==m or r<0 or c==n or c<0:
                return False
            
            if board[r][c]!=word[idx]: 
                return False

            board[r][c]='#'
            for d in dirs:
                if helper(r+d[0],c+d[1],idx+1): 
                    return True
            
            board[r][c]=word[idx] 
            return False       
        

        for i in range(m):
            for j in range(n):
                if helper(i,j,0):
                    return True
        return False



        