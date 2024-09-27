# Time Complexity: O(n^n)
# Space Complexity:O(n^2) space of visited matrix and  
# Algorithm: Initialize a n*n viited matrix.
#            In each row, try to add a queen,If possible make that position in the visited matrix as -2 and increment all reachable cell values
#            Backtrack and Try to place next queen. If queen is placed in all rows save output

class Solution:
    
    def addQueen(self,visitedMatrix, i, j, n):
        
        if visitedMatrix[i][j] == 0:
            # Validate row and columns of possible Queen placement
            if -2 in [visitedMatrix[i][x] for x in range(n)] or -2 in [visitedMatrix[x][j] for x in range(n)]:
                return False
            
            # Validate diagonals of possible Queen placement
            for x in [(-1,-1), (1,1), (-1,1), (1,-1)]:
                row = i + x[0]
                col = j + x[1]

                while 0 <= row < n and 0 <= col < n: 
                    if visitedMatrix[row][col] == -2:
                        return False
                    row += x[0]
                    col += x[1]

            # Increment visited cost of all cells in row and column
            for x in range(n):
                visitedMatrix[i][x] += 1
                visitedMatrix[x][j] += 1

             # Increment visited cost of all cells in diagonals
            for x in [(-1,-1), (1,1), (-1,1), (1,-1)]:
                row = i + x[0]
                col = j + x[1]

                while 0 <= row < n and 0 <= col < n:
                    visitedMatrix[row][col] += 1
                    row += x[0]
                    col += x[1]

            visitedMatrix[i][j] = -2
            return True
        else:
            return False
                
    def removeQueen(self,visitedMatrix, i, j, n):
              
        # Undo visited cost of all cells in row and column
        for x in range(n):
            visitedMatrix[i][x] -= 1
            visitedMatrix[x][j] -= 1
           
        # Undo visited cost of all cells in diagonals
        for x in [(-1,-1), (1,1), (-1,1), (1,-1)]:
            row = i + x[0]
            col = j + x[1]

            while 0 <= row < n and 0 <= col < n:
                visitedMatrix[row][col] -= 1
                row += x[0]
                col += x[1]
        
        visitedMatrix[i][j] = 0
        
    # Convert visited matrix to desired output
    def convert_visited_to_output(self, visited_matrix):
        result = []
        for i in visited_matrix:
            row = []
            for j in i:
                if j == -2:
                    row.append("Q")
                else:
                    row.append(".")  
            result.append("".join(row))
        return result
    
    # Call Backtrack on Queens
    def backtrackQueen(self, row, visited_matrix, n, result):
        if row == n:
            result.append(self.convert_visited_to_output(visited_matrix))
            return
            
        for i in range(n):
            if self.addQueen(visited_matrix, row, i, n):
                self.backtrackQueen(row+1, visited_matrix, n, result)
                self.removeQueen(visited_matrix, row, i, n)
    
    # Main function
    def solveNQueens(self, n: int) -> List[List[str]]:
        visited_matrix = [[0] * n for i in range(n)]
        result = []
        self.backtrackQueen(0, visited_matrix, n, result)
        
        return result
        
        
        