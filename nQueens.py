"""
Keep one queen per row using backtracking
Use sets to track columns and diagonals under usage
Add valid board to result when n queens are kept
"""
"""
Time Complexity: O(N!) – One queen per row, pruning invalid branches
                O(N²) per solution to build board strings
 Space Complexity: O(N) – sets and recursion
"""


from typing import List

class nQueens:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [['.'] * n for _ in range(n)]
        cols = set()
        diag1 = set()  
        diag2 = set() 

        def backtrack(r):
            if r == n:
                result.append([''.join(row) for row in board])
                return
            for c in range(n):
                if c in cols or (r - c) in diag1 or (r + c) in diag2:
                    continue
                board[r][c] = 'Q'
                cols.add(c)
                diag1.add(r - c)
                diag2.add(r + c)

                backtrack(r + 1)

                board[r][c] = '.'
                cols.remove(c)
                diag1.remove(r - c)
                diag2.remove(r + c)

        backtrack(0)
        return result

if __name__ == "__main__":
    obj = nQueens()
    res = obj.solveNQueens(4)
    for board in res:
        for row in board:
            print(row)
        print("------")
