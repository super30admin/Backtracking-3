# Approach: The position in the board where the Queen can be placed is the approach
# We start placing the queens wrt to rows and go over row 0 and check all columns in the row
# Create sets for cols, and 2 diags(left & right) and check if the particular position is not already in the three sets, only then it is safe to place queen
# If yes, continue recursing on next row
    # Backtrack to change the position as unvisited and remove entries from sets

# Time - (N !) starting with each row we have N-2, N-4 options representing a factorial
# Space - O(M * N) creating a new board + O(N) for recoridng values ~= O(M * N)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.result = []
        # sets for recording col and upleft upright diagnols
        self.cols = set()
        self.upLeft = set()
        self.upRight = set()
        
        # create a board where we store 1 and 0 for placing queen and unsafe position to place queen
        self.board = [[0 for j in range(n)]for i in range(n)]
        self.backtracking(0) # start with row 0
        
        return self.result
    
    def backtracking(self, row):
        
        # base case
        if row == len(self.board):
            temp = []
            for i in range(len(self.board)):
                s = ""
                for j in range(len(self.board[0])):
                    if self.board[i][j] == 1: # 1 -- denotes queen
                        s += 'Q' 
                    else:
                        s += '.' # 0 - denotes unsafe position
                        
                temp.append(s)
            self.result.append(temp)
            return
        
        
        # logic
        for col in range(len(self.board[row])):
            
            if col not in self.cols and (row - col) not in self.upLeft and (row + col) not in self.upRight:
                
                #action
                self.board[row][col] = 1
                self.cols.add(col)
                self.upLeft.add(row-col)
                self.upRight.add(row+col)
                
                #recurse
                self.backtracking(row + 1)
                
                #backtracking
                self.board[row][col] = 0
                self.cols.remove(col)
                self.upLeft.remove(row-col)
                self.upRight.remove(row+col)
        
        
        
        