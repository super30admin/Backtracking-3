# TC: O(n* 3**L) iterate over board with each char exploring its path making 3 choices at each instant untill L(length) of word reached(traversed). 
# SC: O(n) recursive call stack
# Search for the required first letter. Start recursion with backtrack until word formed. If it breaks return false at each step. If all possibilities are returning False- its False 
class Solution:
    def __init__(self):
        self.m = None
        self.n = None
        
    def exist(self, board, word):
        if board == None or len(board) == 0: return False
        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.helper(board, word, i, j, 0):
                    return True
        return False
            
    def helper(self, board, word, i, j, index):
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
                if self.helper(board, word, r, c, index+1):
                    return True
            # backtrack
            board[i][j] = temp        
        return False
