class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
	  # 1. Columns 
	  # 2. Rows 
	  # 3. Upper left diagonal 
	  # 4. Upper right diagonal 
        '''
        Time complexity: O(N!)
        Space complexity: O(N^2)  
        '''
        board = [[None for c in range(n)] for r in range(n)]
        self.result = []
            
        self.helper(board, 0, n)
        return self.result
            
    def helper(self, board, row, n):
        
            # base case
            if row==n:
                sb = ['' for _ in range(n)]
                for x in range(n):
                    for y in range(n):
                        if board[x][y]:
                            sb[x] += 'Q'  
                        else:
                            sb[x] += '.'
                self.result.append(list(sb))
                return
            
            # logic
            for col in range(n):
                if self.isSafe(board, row, col, n):
                    board[row][col] = True
                    self.helper(board, row+1, n)
                    # backtrack
                    board[row][col] = False
                    
    def isSafe(self, board, row, col, n):

        # Up
        for r in range(row):
            if board[r][col] == 1:
                return False

        # Left-up diagonally
        r = row; c = col
        while (r > -1 and c > -1):
            if (board[r][c] == 1):
                return False
            r -= 1; c -= 1

        # Right-up diagonally
        r = row ; c = col
        while (r > -1 and c < n):
            if (board[r][c] == 1):
                return False
            r -= 1; c += 1
            
        #   return true if everything is fine
        return True
                
        
