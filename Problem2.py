# Time complexity : O(n*m*3^k) k - length of word, n - rows, m - cols
# Space complexity : O(k) - k - lenght of word
# Leetcode : Solved and submitted

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
         # find dimentions of the board
        rows = len(board)
        cols = len(board[0])
        # dirs is the directions to look for in the matrix
        self.dirs = [[0,-1],[-1,0],[1,0],[0,1]]
        
        # traversing through the board, if the first char of the word matched with the board, then start dfs search
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if self.helper(board, word, 0, i, j, rows, cols):
                        # return true if we can find the complete word through this call, else return false
                        return True
        return False
    
    def helper(self, board, word, idx, r, c, rows, cols):
        # base
        # if we reach the end of the word, then return true
        if idx == len(word):
            return True
          # if we do out of bounds, then return False or we encounter a # char
        if r < 0  or c < 0 or r == rows or c == cols or board[r][c] == '#':
            return False
        
        # logic
        # check for the char at idx in word with in the board, if it matches, then we start finding other chars
        if board[r][c] == word[idx]:
            # action
            # store the char in temp and change it o #, marking it as visited
            temp = board[r][c]
            board[r][c] = '#'
            
            # recurse
            # search in other directions and traverse them recursivley. If we can find all the letters then return True
            for di in self.dirs:
                nr = r + di[0]
                nc = c + di[1]
                
                if self.helper(board, word, idx + 1, nr, nc, rows, cols):
                    return True
                
            # backtrack
            # change the char # back to the original character
            board[r][c] = temp
                
