# Approach: Apply DFS everytime a character requirement of the word is met in the board. Explore a path and if it does not match the word backtrack
# Here we backtrack by modifying visited cell as unvisted again so we can continue searching in other directions from where we originally started
# Time - O (N * 3 ^ L) N represents the iteration over the board and L is the length of word for each charac in word we explore 3 directions, not 4 since we dont count the one we are currently at, as it becomes visited
# Space - O(N) not using a visited array, just mutating but since it is backtracking space on recursive call stack is used

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        # null checks
        if not board or len(board) == 0:
            return False
        
        self.rows = len(board)
        self.cols = len(board[0])
        
        for i in range(self.rows):
            for j in range(self.cols):
                if self.backtracking(board, i, j, 0, word):
                    return True
                
        return False
    
    #boolean function
    def backtracking(self, board, i, j, index, word):
        
        # base case 

        # we have found all the characters in the word
        if index == len(word):
            return True
        #boundary checks and already vivited cell
        if i < 0 or j < 0 or i == self.rows or j == self.cols or board[i][j] == '#':
            return False
        
        # logic

        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        
        if board[i][j] == word[index]: # we need to continue traversing board until we find char at index in board to explore path further
            temp = board[i][j] # take a copy incase we need to backtrack
             #action
            board[i][j] = '#'
            
            # recurse
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                
                if self.backtracking(board, r, c, index + 1, word):
                    return True

            # if done with iteration and we did not return True, we need to backtrack
            # backtrack, make it unvisited again   
            board[i][j] = temp
        
        return False
        
        
        
                
                
        