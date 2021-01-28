class Solution:
    
    """
    Description: from m x n board of letters, and a word; find if word exists in the grid
    
    Time Complexicity: O(3^L), where L is length of the word
    Space Complexicity: O(m*n)
    
    worked on leetcode: Yes
    
    Approach: Use backtracking and recursion
    1. develop a function backtrack which takes the word, and board
    2. navigate to look for letters in the word starting from index 0
    3. find the letter at a given index, store in a temporary variable
    4. replace the value of the word by "#" (considered visited)
    5. if word cannot be found in board, use temporary variable to restore the value
    6. find another path using 1 -> 5
    """
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        self.word = word
        self.board = board
        
        if self.board == None or len(self.board) == 0: return False
        self.m = len(self.board); self.n = len(self.board[0])
        
        self.dirs = [(0, 1), (1, 0), (-1,0), (0,-1)] # right, up, left, down
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(i, j, 0): return True
                
        return False
    
    def backtrack(self, i, j, index):
        
        # base
        if i < 0 or j < 0 or i >= self.m or j >= self.n or self.board[i][j] != self.word[index]: return False
        if index == len(self.word) - 1: return True
        
        # logic
        if self.word[index] == self.board[i][j]:
            temp = self.board[i][j]      
            
        # action
        self.board[i][j] = "#"
        
        # recurse
        for dir_ in self.dirs:
            r = i + dir_[0]; c = j + dir_[1]
            if self.backtrack(r, c, index + 1):
                return True
        
        # backtrack
        self.board[i][j] = temp # back to original value
        
        return False
