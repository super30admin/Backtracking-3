# Time complexity:O(length of string)*O(mn)
# space complexity: O(length of string)
# Approach: Traverse the matrix
# while traversing, do recursion by checking the present index in the matrix if its matching
# with the string's value starting from first index of string
# if it matches at some index of matrix, continue doing recursion to check for the entire string match
# mark the index as visited in the  matrix.
# backtrack the visited index by unmarking it. 






class Solution:
    m, n = 0,0
    dirs = []
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, word, i, j, 0):
                    return True
                
        return False
    def backtrack(self, board, word, row, col, index):
        #base case
        if index == len(word):
            return True
        if row< 0 or row == self.m or col < 0 or col == self. n or board[row][col] == '#':
            return False
        
        #logic
        if board[row][col]== word[index]:
            # action
            ch = board[row][col]
            board[row][col]='#'
            for dir in self.dirs:
                nr = row + dir[0]
                nc = col + dir[1]
                  #recursion
                if self.backtrack(board, word, nr, nc, index+1):
                    return True
        
            #backtrack
            board[row][col]=ch
        
                
        
        