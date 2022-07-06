# TC: O(N!)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def create_board(state):
            board = []
            for row in state:
                board.append("".join(row))
            return board
        
        def helper(row, cols, diagonals, antiDiagonal, state):
            if row == n:
                ans.append(create_board(state))
                return
            
            for col in range(n):
                curr_d = row - col
                curr_ad = row + col
                
                if (col in cols or curr_d in diagonals or curr_ad in antiDiagonal) :
                    continue
                
                cols.add(col)
                diagonals.add(curr_d)
                antiDiagonal.add(curr_ad)
                state[row][col] = "Q"
                
                helper(row+1, cols, diagonals, antiDiagonal, state)
                
                cols.remove(col)
                diagonals.remove(curr_d)
                antiDiagonal.remove(curr_ad)
                state[row][col] = "."
            
        ans = []
        
        empty_board = [["."] * n for _ in range(n)]
        helper(0, set(), set(), set(), empty_board)
        return ans
                
