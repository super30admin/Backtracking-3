# // Time Complexity :O(3^L * n^2) //L=lenght of word
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes but time limit exceeded
# // Any problem you faced while coding this :No

# we do dfs with backtracking. when we find a node thats needed we set it to visited and run dfs on its children.
# when we have to come back in the recusrsion to change the path 0 we backtrack and change the ndoe from visited to unvisited since it was not included in the path
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def backtrack(board, word, idx, i, j):
            # base
            if(idx==len(word)):
                return True
            dirs=[[1,0],[-1,0],[0,1],[0,-1]]
            if(i<0 or j<0 or i==len(board) or j==len(board[0]) ):
                return False
            # logic
            
            if(board[i][j]==word[idx]):
                # action
                board[i][j]='#'
                # recurse
                for dir in dirs:
                    r=i+dir[0]
                    c=j+dir[1]
                    if(backtrack(board, word, idx+1,r,c )):
                        return True
                # backtrack
                board[i][j]=word[idx]
            return False

        if (board is None):
            return False
        m=len(board)
        n=len(board[0])
        
        for i in range(m):
            for j in range(n):
                if (board[i][j]==word[0]):
                    if(backtrack(board, word, 0, i, j)):
                        return True
        # backtrack(board, word)
        return False