# Time complexity - O(n^3) # O(n^2) recursion O(n) to check free block.
# Space complexity - O(2n) # O(n) for the recursive stack, O(n) for queens set
# Did these solution run on leetcode? - yes
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def add_queens():
            position = []
            for _, col in sorted(queens):
                position.append("."*col + "Q" + "."*(n-col-1))
            # append to the output
            output.append(position)
            
            
        def backtrack(c):
            for r in range(n):
                if freeBlock(r, c):
                    # 1. Action
                    queens.add((r, c))

                    # 2. Recurse
                    if c+1==n:
                        add_queens() 
                    else:
                        backtrack(c+1)

                    # 3. Backtrack
                    # place the queen on unavailable
                    # mark as unvisited
                    queens.remove((r, c))
                

        def freeBlock(r, c):    
            # check the columns in the same row
            for col in range(c):
                if (r, col) in queens:
                    return False

            # lower left diagonal
            row, col = r+1, c-1
            while row<n and col>=0:
                if (row, col) in queens:
                    return False
                row+=1
                col-=1

            # upper left diagonal
            row, col = r-1, c-1
            while row>=0 and col>=0:
                if (row, col) in queens:
                    return False
                row-=1
                col-=1
                
            return True
            
        queens = set()
        output = []
        backtrack(0)
        return output
                    
    
# Recursive solution
# Time complexity - O(n^3) # O(n^2) recursion O(n) to check free block.
# Space complexity - O(n^3+n) # O(n^3) a new queens set for O(n^2) iterations and O(n) for recursive stack
# Did these solution run on leetcode? - yes
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def add_queens(queens):
            position = []
            for _, col in sorted(queens):
                position.append("."*col + "Q" + "."*(n-col-1))
            # append to the output
            output.append(position)
            
            
        def recursion(c, queens_set):
            for r in range(n):
                if freeBlock(r, c, queens_set):
                    # 1. Action
                    queens = copy.copy(queens_set)
                    queens.add((r, c))

                    # 2. Recurse
                    if c+1==n:
                        add_queens(queens) 
                    else:
                        recursion(c+1, queens)


        def freeBlock(r, c, queens):    
            # check the columns in the same row
            for col in range(c):
                if (r, col) in queens:
                    return False

            # lower left diagonal
            row, col = r+1, c-1
            while row<n and col>=0:
                if (row, col) in queens:
                    return False
                row+=1
                col-=1

            # upper left diagonal
            row, col = r-1, c-1
            while row>=0 and col>=0:
                if (row, col) in queens:
                    return False
                row-=1
                col-=1
                
            return True
            
        output = []
        recursion(0, set())
        return output
                    
                    