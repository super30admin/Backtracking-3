"""
79. Word Search

Time = O(N*4^L) N = number of cells in the board, L = length of the word to be matched
space = O(L) ; memory lies in the recursion call of the backtracking function. The maximum length of the call stack       would be the length of the word. 

Successfully excecuted on leetcode


Approach:
1. Recursion + dfs (backtracking)
2. Go through each row and coloumn and check whether can find word, start at (i,j) position   
3. First character is found, check the remaining part; avoid visiting agian 
4. Check whether can find "word" along one direction

"""

class WordSearch:
    def solveNQueens(self, n):
        def exist(self, board, word):
        if not board:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word):
                    return True
        return False

    # check whether can find word, start at (i,j) position    
    def dfs(self, board, i, j, word):
        if len(word) == 0: 
            return True
        #check for valid move 
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or word[0]!=board[i][j]:
            return False
        tmp = board[i][j]  
        board[i][j] = " "  # avoid revisit
        
        res = self.dfs(board, i+1, j, word[1:]) or self.dfs(board, i-1, j, word[1:]) \
        or self.dfs(board, i, j+1, word[1:]) or self.dfs(board, i, j-1, word[1:])
        board[i][j] = tmp
        return res