# Time complexity: O(N * 3^L) since L is the length of the word for each letter we are looking into 3 direction it's not 4 since we are check from the letter we are and N is the total number of elememts in board

# Space complexity: O(N) we are just mutating the given board
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or len(board) == 0:
            return False
        
        self.row = len(board)
        self.col = len(board[0])
        for i in range(self.row):
            for j in range(self.col):
                if self.backtrack(board, word, i, j, 0):
                    return True
        return False
    
    def backtrack(self, board, word, i, j, index):
        #base
        # if we found all the character in the word then return True
        if len(word) == index:
            return True
        #boundary condition
        if i < 0 or j < 0 or i == self.row or j == self.col or board[i][j] == '#':
            return False
        
        #logic
        directions = [(-1,0), (1,0), (0,1), (0,-1)]
        if board[i][j] == word[index]:
            temp = board[i][j]
            #action 
            board[i][j] = '#'
            #recurse
            for dirs in directions:
                r = i + dirs[0]
                c = j + dirs[1]
                # with the backtrack if we find the whole word will return true
                if self.backtrack(board, word, r,c, index + 1): 
                    return True
                
            #backtrack
            board[i][j] = temp
        return False    
                
            
