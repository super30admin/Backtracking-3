# Approach: Backtracking

# We will first start looking for the first character from given word in the matrix. If found, we will start our DFS from that point. 

# Here we wont be maintaining a visited matrix. Instead we will just replace the character with '#' marking it as visited. Also when we backtrack we need to change this character back to its original value that present there before.

# Now here we only recurse ahead if have found the next character we are looking for adjacent to the current character. If we do not find the required character we backtrack go another way.

# Time complexity: Exponential O(3^l); 
# Space complexity: O(l); l = length of the word
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None or len(board) == 0:
            return False
        
        self.dirs = [[0,1],[1,0], [0,-1], [-1,0]]
        
        for i in range(len(board)):
            for j in  range(len(board[0])):
                if(self.backtrack(board, word, i, j, 0)):
                    return True
                
        return False
    
    def backtrack(self, board, word, row, col, index):
        
        # Base
        if index == len(word):
            return True
        
        if row<0 or col<0 or row >= len(board) or col >= len(board[0]) or board[row][col] == "#":
            return False
        
        # Logic
        if board[row][col] == word[index]:
            
            # Action
            temp = board[row][col]
            board[row][col] = '#'
            
            for d in self.dirs:
                r = row + d[0]
                c = col + d[1]
                
                # Recurse
                if self.backtrack(board, word, r, c, index + 1):
                    board[row][col] = temp # Get original information back even if its true.
                    return True 
            
            # Backtrack
            board[row][col] = temp
            
        return False