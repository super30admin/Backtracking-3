# // Time Complexity : O(n*3^n)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Apply DFS and backtrack

class Solution:
    
    def __init__(self):
        self.m = None
        self.n = None
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        self.m = len(board)
        self.n = len(board[0])
        
        for i in range(self.m):
            for j in range(self.n):
                if self.helper(board,i,j,word,0):
                    return True
        return False
    
    def helper(self, board, i, j,word, index):
        # base
        if index == len(word): return True
        # boundary conditions
        if i<0 or j <0 or i == self.m or j == self.n or board[i][j] == '#': return False

        # logic
        dirs = [(0,1), (0,-1), (1, 0), (-1,0)]
        if word[index] == board[i][j]:
            temp = board[i][j]
            # action
            board[i][j] = '#'
            # recurse
            for d in dirs:
                r, c = i + d[0], j + d[1]
                if self.helper(board,  r, c, word,index+1):
                    return True
            # backtrack
            board[i][j] = temp        
        return False