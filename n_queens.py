# Time Complexity :
# O(N !) (N factorial)

# Space Complexity :
# O(N^3) - we are storing a current board for upto N times in the recursion stack

# Did this code successfully run on Leetcode :
#Yes

#We start adding queens to the board row by row. At each row, we check which is the first column that the queen can be added and add it there
#If queen cannot be added at any column, then that configuration until then is not possible, so we backtrack and change the position of the previous queen and do this until the first row
#If we are able to place a queen in all rows, then we are done

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [ "." * n for j in range(n)]
        self.n = n
        self.return_boards = []
        self.helper(board,0)
        return self.return_boards

    def helper(self,current_board,row):
        if row == self.n :
            self.return_boards.append(current_board[:])
            return
        for j in range(0,self.n):
            if self.can_place(current_board,row,j):
                current_board[row] = current_board[row][0:j] + "Q" + current_board[row][j+1:]
                self.helper(current_board,row+1)
                current_board[row] = current_board[row][0:j] + "." + current_board[row][j+1:]

    #Checks if a queen can be placed in the current position by seeing if a queen exists in the current column or diagonally in any direction
    def can_place(self,current_board,x,y):
        for i in range(0,x):
            if current_board[i][y] == 'Q':
                return False

        diagonal_1 = self.check_diagonal(current_board,x,y,-1)
        diagonal_2 = self.check_diagonal(current_board,x,y,1)
        return diagonal_1 and diagonal_2

    #Function for checking if a queen exists diagonally of the given position
    def check_diagonal(self,current_board,x,y,direction):
        i = x
        j = y
        while self.is_valid_index(i,j):
            if current_board[i][j] == "Q":
                return False
            i -= 1 
            if direction == -1 :
                j -= 1
            else :
                j += 1
        #exit()
        return True

    #Valid index checking function
    def is_valid_index(self,x,y):
        if x < 0 or x >= self.n :
            return False
        if y < 0 or y >= self.n :
            return False
        return True
