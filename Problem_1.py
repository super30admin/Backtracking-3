class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        sol = []
        board = [[False for i in range(n)] for i in range(n)]
        cols = set()
        diags = set()       # row - col
        anti_diags = set()  # row + col
        
        def recur(row):
            if row == n:
                temp = []
                for i in range(n):
                    s = ''
                    for j in range(n):
                        if board[i][j]:
                            s = s + 'Q'
                        else:
                            s = s + '.'
                    temp.append(s)
                sol.append(temp)
                return
            
            for i in range(n):
                # O(1) conflict check instead of O(n) loops!
                if i in cols or (row - i) in diags or (row + i) in anti_diags:
                    continue
                
                # Place queen
                board[row][i] = True
                cols.add(i)
                diags.add(row - i)
                anti_diags.add(row + i)
                
                recur(row + 1)
                
                # Backtrack - remove queen
                board[row][i] = False
                cols.remove(i)
                diags.remove(row - i)
                anti_diags.remove(row + i)
        
        recur(0)
        return sol
    