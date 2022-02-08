
#Time complexity N!
#Space Complexity N^2
class Solution:
    def solveNQueens(self, n):
        def create_board(state):
            board = []
            for row in state:
                board.append("".join(row))
            return board
        
        def dfs(row, diagonals, anti_diagonals, cols, state):
            if row == n:
                ans.append(create_board(state))
                return

            for col in range(n):
                curr_diagonal = row - col
                curr_anti_diagonal = row + col
                # If the queen is not placeable
                if (col in cols 
                      or curr_diagonal in diagonals 
                      or curr_anti_diagonal in anti_diagonals):
                    continue

                cols.add(col)
                diagonals.add(curr_diagonal)
                anti_diagonals.add(curr_anti_diagonal)
                state[row][col] = "Q"
                dfs(row + 1, diagonals, anti_diagonals, cols, state)
                cols.remove(col)
                diagonals.remove(curr_diagonal)
                anti_diagonals.remove(curr_anti_diagonal)
                state[row][col] = "."

        ans = []
        empty_board = [["."] * n for _ in range(n)]
        dfs(0, set(), set(), set(), empty_board)
        return ans
