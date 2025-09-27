'''
Solution : DFS with backtracking 
    - For each row, we try to add a queen on each column, one at a time. If 
      that is a valid move, then we recurse on the next row. 
    - Once we are able to recurse on all rows, we have a valid board for placing the queens
    - Use a boolean board grid, when we place the queen at a cell, we mark it True.
    - after recursion function returns at function call, we backtrack and mark it False.
    - When we have a valid board
        - We need to save it as a List[<strings>].
        - StringBuilder (Java) => list([char]) & "".join(list) in Python 
Time Complexity: O(N!) (One can say, O(N^N) but not exactly)
    - First row -> N options
    - Second row -> N-2 options 
    - Third row -> N-4 options 
    - This comes to (N)*(N-2)*(N-4)... == N*(N-1)*(N-2)*(N-3)...
Space Complexity: O(N^2) + O(N) 
                 - board + Recursive stack 
'''
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        valid_boards = []
        board = [[False]*n for i in range(n)] 
        
        self.helper(n,0,board,valid_boards) # board_dimension,row, current_board, answer list

        return valid_boards
    
    def helper(self,n,row,board,valid_boards):
        # base
        if row==n: # completed placing queen in all rows of board.
            new_valid_board = []
            for i in range(n):
                row_char = []
                for j in range(n):
                    if board[i][j]==True:
                        row_char.append('Q')
                    else:
                        row_char.append('.')
                row_string = "".join(row_char) # make each row elements as one string
                new_valid_board.append(row_string)
            
            valid_boards.append(new_valid_board) # add to the answer list
            return 
        
        # logic
        for col in range(n):
            board[row][col] = True # action
            if self.isValidMove(board,n,row,col):
                self.helper(n,row+1,board,valid_boards)
            board[row][col] = False # backtrack
    

    def isValidMove(self,board,n,row,col):
        # check column
        for i in range(row-1,-1,-1):
            if board[i][col]:
                return False
        
        # check left diagonal
        diag_col_check = col
        for i in range(row-1,-1,-1):
            diag_col_check-=1
            if diag_col_check>=0:
                if board[i][diag_col_check]:
                    return False

        # check right diagonal
        diag_col_check = col
        for i in range(row-1,-1,-1):
            diag_col_check+=1
            if diag_col_check<=n-1:
                if board[i][diag_col_check]:
                    return False
        
        return True
