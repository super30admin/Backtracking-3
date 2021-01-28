# Time Complexity : O(N * 3^Letters) at each node there are three decisions
# Space Complexity : O(L) L = length of word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Forgot my base case where I need to 
# check if index == len(words) 


# Your code here along with comments explaining your approach

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        DFS?
        Look for first letter in word and check. 
        """
        if not board or not word:
            return False
        
        dirs = [[0,1],
            [-1,0],
           [0,-1],
           [1,0]]
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.dfs(board, word, i, j, 0, dirs):
                        return True           
                    
    def dfs(self, board, word, i, j, index, dirs):
        if index == len(word):
            return True
    
        if i < 0 or i == len(board) or j < 0 or j == len(board[0]):
            return False
        if board[i][j] == '-1':
            return False    
        if word[index] == board[i][j]:
            letter = board[i][j]
            
            board[i][j] = '-1' 
            for direction in dirs:
                row = direction[0] + i
                col = direction[1] + j
                
                if self.dfs(board,word,row, col, index + 1, dirs):
                    return True
            #put letter back    
            board[i][j] = letter
            
        return False