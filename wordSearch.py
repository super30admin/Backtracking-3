# Time Complexity:    O(mxn)
# Space Complexity:   recursive stack

class Solution:
    def __init__(self):
        self.dirs = [[0,-1],[0,1],[-1,0],[1,0]]
    
    def backtrack(self,board,word,index,i,j):
        # base-case
        if index >= len(word)-1:
            return True
        
        # logic
        temp = board[i][j]
        
        # mark as visited -- action
        board[i][j] = "#"
        
        # check in 4 directions
        for direction in self.dirs:
            
            r = i + direction[0]
            c = j + direction[1]
            
            # check breach case
            if r >= 0 and r < len(board) and c >= 0 and c < len(board[0]) and index+1 < len(word) and board[r][c] == word[index+1]:
                
                # recursive
                if self.backtrack(board,word,index+1,r,c):
                    return True

        # backtrack
        board[i][j] = temp
        return False

    
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.backtrack(board,word,0,i,j):
                        return True
        return False