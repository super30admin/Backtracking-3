# Time Complexity : O(M*N * 4^S) (Where M and N is row and column of board and S is length of word.) 
# Space Complexity : O(4^S) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Keep visited matrix. Call helper function on each of the cell of board
# - Helper function checks that cell is not out of bound, not visited and equal to character at given index in word. Mark the cell visited and if we reached at the end of word return True.
# - Call helper function on all neighbour of cell and increase the index, If any of the neighbour returns true taht means we found our word in matrix so return true. After neighbouring function call mark current cell to not visited and return False.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
#       Store number of rows and columns in the board
        maxR = len(board)
        maxC = len(board[0])
#       Create visited matrix and mark it as false.
        visited = [ [False for i in range(maxC)] for j in range(maxR)]
#       Run for loop to find each cell in the matrix
        for i in range(maxR):
            for j in range(maxC):
#               Call helper function on each cell and if helper function returns true we return true from the main function.
                if self.helper(board, visited, i, j, 0, word):
                    return True
#       If helper function call on every cell returns false that means word is not found so return False.
        return False
        
    def helper(self, board, visited, row, col, index, word):
#       if cell is out of bound return False
        if 0 > row  or row >= len(board) or 0 > col  or col >= len(board[0]):
            return False
        
#       If cell is already visited return false.  
        if visited[row][col] == True: 
            return False
        
#       If cell's character value does not match with string than return False
        if word[index] != board[row][col]:
            return False
        
#       If we reach at the end of the word return True
        if index == len(word) - 1:
            return True
        
#       Mark current cell visited
        visited[row][col] = True

#       Call helper function on given neighbour with incresed index. If any of this returns true that means we found given word in the board so return true.
        if self.helper(board, visited, row+1, col, index + 1, word) or self.helper(board, visited, row-1, col, index + 1, word) or self.helper(board, visited, row, col+1, index + 1, word) or self.helper(board, visited, row, col-1, index + 1, word):
            return True
        
#       Unmark the visited cell for current cell and return false because we did not found word with this starting point.
        visited[row][col] = False
        
        return False
            
