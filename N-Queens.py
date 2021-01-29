from copy import deepcopy

class Solution:
    #Solution 1
    def solveNQueens(self, n: int) -> List[List[str]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n!)
        #Space Complexity: O(n^2) // board; but can be done away with
        #where, n is the either board dimension
        
        result = []
        board = [[0 for j in range(n)] for i in range(n)]
        cols = set()
        upLeft = set()
        upRight = set()
    
        def backtrack(r):
            #base
            if r == len(board):
                ls = []
                for i in range(len(board)):
                    s = ''
                    for j in range(len(board[0])):
                        if board[i][j] == 1:
                            s += 'Q'
                        else:
                            s += '.'
                    ls.append(s)
                result.append(ls)
                return
            
            #logic
            for c in range(len(board[r])):
                if c not in cols and r - c not in upLeft and r + c not in upRight:
                    #action
                    board[r][c] = 1
                    cols.add(c)
                    upLeft.add(r - c)
                    upRight.add(r + c)
                    
                    #recursion
                    backtrack(r + 1)
                    
                    #backtracking
                    board[r][c] = 0
                    cols.remove(c)
                    upLeft.remove(r - c)
                    upRight.remove(r + c)
        
        backtrack(0)
        return result
    
    #Solution 2
    """
    def solveNQueens(self, n: int) -> List[List[str]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n!)
        #Space Complexity: O(n^2) // board; but can be done away with
        #where, n is the either board dimension
        
        self.result = []
        self.board = [[0 for j in range(n)] for i in range(n)]
        
        self.backtrack(0)
        return self.result
    
    def backtrack(self, r):
        #base
        if r == len(self.board):
            ls = []
            for i in range(len(self.board)):
                s = ''
                for j in range(len(self.board[0])):
                    if self.board[i][j] == 1:
                        s += 'Q'
                    else:
                        s += '.'
                ls.append(s)
            self.result.append(ls)
            return
        
        #logic
        for c in range(len(self.board[r])):
            if self.isSafe(r, c):
                #action
                self.board[r][c] = 1
                
                #recursion
                self.backtrack(r + 1)
                
                #backtracking
                self.board[r][c] = 0
                
    def isSafe(self, r, c):
        #column
        for i in range(0, r):
            if self.board[i][c] == 1:
                return False
        
        #upLeft
        i, j = r, c
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
            
        #upLeft
        i, j = r, c
        while i >= 0 and j < len(self.board[0]):
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
            
        return True
    """
    
    #Solution 3
    """
    def solveNQueens(self, n: int) -> List[List[str]]:
        #Approach: Recursion
        #Time Complexity: O(n!)
        #Space Complexity: O(n^3) // deep copy of board at every row
        #where, n is the either board dimension
        
        self.result = []
        board = [[0 for j in range(n)] for i in range(n)]
        
        self.helper(0, board)
        return self.result
    
    def helper(self, r, board):
        #base
        if r == len(board):
            ls = []
            for i in range(len(board)):
                s = ''
                for j in range(len(board[0])):
                    if board[i][j] == 1:
                        s += 'Q'
                    else:
                        s += '.'
                ls.append(s)
            self.result.append(ls)
            return
        
        #logic
        for c in range(len(board[r])):
            if self.isSafe(board, r, c):
                #action
                new = deepcopy(board)
                new[r][c] = 1
                
                #recursion
                self.helper(r + 1, new)
                
    def isSafe(self, board, r, c):
        #column
        for i in range(0, r):
            if board[i][c] == 1:
                return False
        
        #upLeft
        i, j = r, c
        while i >= 0 and j >= 0:
            if board[i][j] == 1:
                return False
            i -= 1
            j -= 1
            
        #upLeft
        i, j = r, c
        while i >= 0 and j < len(board[0]):
            if board[i][j] == 1:
                return False
            i -= 1
            j += 1
            
        return True
    """