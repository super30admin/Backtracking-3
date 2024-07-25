def solveNQueens(N):
    def is_safe(board, row, col):
        # Check this row on left side
        for i in range(col):
            if board[row][i] == 'Q':
                return False

        # Check upper diagonal on left side
        for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
            if board[i][j] == 'Q':
                return False

        # Check lower diagonal on left side
        for i, j in zip(range(row, N, 1), range(col, -1, -1)):
            if board[i][j] == 'Q':
                return False

        return True

    def solve(board, col): #backtracking function
        # base case: If all queens are placed
        if col >= N:
            solutions.append([''.join(row) for row in board])
            return

        # Consider this column and try placing this queen in all rows one by one
        for i in range(N):
            if is_safe(board, i, col):
                board[i][col] = 'Q'
                solve(board, col + 1)
                board[i][col] = '.'  # backtrack

    solutions = []
    board = [['.' for _ in range(N)] for _ in range(N)]
    solve(board, 0)
    return solutions

# Example usage:
N = 4
solutions = solveNQueens(N)
for solution in solutions:
    for row in solution:
        print(row)
    print()

#time = O(N⋅N!)
#space = O(S⋅N ^2)