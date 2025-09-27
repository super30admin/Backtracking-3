'''
Solution : DFS with backtracking
    - At each cell, we explore 4 options. 
    - Base is when we end up finding all characters of the target word, we return True
Time Complexity: O(m*n*4^L), L = length of word, m = rows, n = cols
                - from each cell we try finding word. O(m*n)
                - at each cell we'll do 4^L recursions
Space Complexity: O(L) - Height of Tree/Recursive stack
'''
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.rows = len(board)
        self.cols = len(board[0])

        for i in range(self.rows):
            for j in range(self.cols):
                if self.helper(i,j,word,board):
                    return True
        
        return False

    
    def helper(self,row,col,remaining_word,board):
        # base
        if remaining_word == "":
            return True
        
        if row<0 or row>=self.rows or col<0 or col>=self.cols or board[row][col]!=remaining_word[0]:
            return False


        # logic
        board[row][col] = "#" # mark visited - action

        found_remaining_word = False
        for (row_offset, col_offset) in [[0,-1],[0,1],[-1,0],[1,0]]:
            found_remaining_word = self.helper(row+row_offset,col+col_offset,remaining_word[1:], board)
            if found_remaining_word:
                break


        board[row][col] = remaining_word[0] # backtrack

        return found_remaining_word
