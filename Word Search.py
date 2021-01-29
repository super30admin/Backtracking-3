class Solution:
    #Solution 1
    def exist(self, board: List[List[str]], word: str) -> bool:
        #Approach: Recursion with backtracking
        #Time Complexity: O(N * 3^l)    // cells * no. of decisions at each cell 
        #Space Complexity: O(l)         // recursion stack under the hood
        #where, n is the number of cells on the board, and
        #l is the length of the word
        
        self.m = len(board)
        self.n = len(board[0])
        
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, word, 0, i, j):
                    return True
        return False
    
    def backtrack(self, board, word, idx, i, j):
        #base
        if idx == len(word):
            return True
        if i < 0 or i == self.m or j < 0 or j == self.n or board[i][j] == '.':
            return False
        
        #logic
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        if board[i][j] == word[idx]:
            #action
            board[i][j] = '.'
            
            for d in dirArr:
                r = i + d[0]
                c = j + d[1]
                
                if self.backtrack(board, word, idx + 1, r, c):
                    return True
            
            #backtracking
            board[i][j] = word[idx]
            
        return False
    
    #Solution 2
    """
    def exist(self, board: List[List[str]], word: str) -> bool:
        #Approach: Recursion with backtracking
        #Time Complexity: O(N * 3^l)    // cells * no. of decisions at each cell 
        #Space Complexity: O(l)         // recursion stack under the hood
        #where, n is the number of cells on the board, and
        #l is the length of the word
        
        self.m = len(board)
        self.n = len(board[0])
        
        self.result = False
        for i in range(self.m):
            for j in range(self.n):
                self.backtrack(board, word, 0, i, j)
                if self.result:
                    return self.result
        
        return self.result
    
    def backtrack(self, board, word, idx, i, j):
        #base
        if idx == len(word):
            self.result = True
            return
        if i < 0 or i == self.m or j < 0 or j == self.n or board[i][j] == '.':
            return
        
        #logic
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        if board[i][j] == word[idx]:
            #action
            board[i][j] = '.'

            for d in dirArr:
                r = i + d[0]
                c = j + d[1]
                
                self.backtrack(board, word, idx + 1, r, c)
                if self.result:
                    return
                
            #backtracking
            board[i][j] = word[idx]
    """