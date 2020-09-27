class Solution(object):
    
    directions = [[0,1],[0,-1],[1,0],[-1,0]]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == word[0]:
                    if(self.backtracking(board, i, j, word, 0)):
                        return True
        
        return False
    
    def backtracking(self, board, i, j, word, index):
        # base case
        if index >= len(word) - 1:
            return True
        
        temp = board[i][j]
        board[i][j] = "#"
        
        # recursuve case
        for dirs in self.directions:
            r = i + dirs[0]
            c = j + dirs[1]
            
            if(r >=0 and r < len(board) and c >=0 and c < len(board[0]) 
               and word[index + 1] == board[r][c]):
                if(self.backtracking(board, r, c, word, index + 1)):
                    return True
        
        board[i][j] = temp
        return False
