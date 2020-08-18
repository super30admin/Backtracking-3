#Backtracking-3
#Problem1 : https://leetcode.com/problems/n-queens/
#All test cases passed on Leetcode
#Time Complexity:    O(n!)
#Space Complexity:    O(n*n) 
class Solution:
    
    def isValid(self, board, row, col, n):

        #   check whether we can place queen in the current cell or not

        #   check all rows with same column above the current cell
        for r in range(row):
            if board[r][col] == 1:
                return False

        #   check diagonally top left above the current cell
        r = row - 1; c = col - 1
        while (r >= 0 and c >= 0):
            if (board[r][c] == 1):
                return False
            r -= 1; c -= 1

        #   check diagonally top right above the current cell
        r = row - 1; c = col + 1
        while (r >= 0 and c < n):
            if (board[r][c] == 1):
                return False
            r -= 1; c += 1

        #   return true if everything is fine
        return True

       

    def placeQueens(self, board, row, n, finalList):

        #   base case to add valid board configuration
        if (row == n):
            string = ['' for _ in range(n)]
            for r in range(n):
                for c in range(n):
                    if (board[r][c] == 1):
                        string[r] += 'Q'
                    else:
                        string[r] += '.'
            finalList.append(string)
            return

        #   for each column in the current row
        for col in range(n):

            #   place the queen only if the current cell is valid
            if self.isValid(board, row, col, n):

                #   action -- mark the cell as 1 and check for below rows
                board[row][col] = 1

                #   recursion -- place queen on below rows
                self.placeQueens(board, row + 1, n, finalList)

                #   backtrack -- mark the cell 0 again once all the below rows are explored
                board[row][col] = 0

        return

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        #   edge case check
        if (n == 0):
            return []
        finalList = []
        #   initialize the board
        board = [[0 for c in range(n)] for r in range(n)]

        #   start placing the queen on the first row
        self.placeQueens(board, 0, n, finalList)

        #   return final result
        return finalList
        
        
    