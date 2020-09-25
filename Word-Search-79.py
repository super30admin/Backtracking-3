
# Time Complexity : O(n*m)
# Space Complexity : O(n*m)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def dfs(self, board, word, i, j, dirs, idx):
        if idx == len(word) - 1:
            return True
        #store the value in temp and do dfs
        temp = board[i][j]
        board[i][j] = ''
        
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if 0 <= r < len(board) and 0 <= c < len(board[0]) and board[r][c] == word[idx + 1]:
                if self.dfs(board, word, r, c, dirs, idx + 1):
                    return True
        board[i][j] = temp
        return False
    
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(word) == 0 or len(board) == 0 or board is None:
            return
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                #check for the first char in word and then proceed with dfs
                if word[0] == board[i][j] and self.dfs(board, word, i ,j, dirs, 0):
                       return True
        return False
