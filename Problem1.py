class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        res = []
        def okay_to_place(r,c, sofar):
            if not sofar:
                return True
            restricted_rows = set([i for i, j in sofar])
            restricted_cols = set([j for i, j in sofar])

            if r in restricted_rows or c in restricted_cols: #checked for same row or same col
                return False 
            
            for i, j in sofar:
                if abs(i-r) == abs(j-c):
                    return False
            return True #or False
        
        def form_a_board(sofar):
            board = ["."*n for _ in range(n)]
            for i, j in sofar:
                board[i][j] = "Q"
            return board

        def dfs(r, sofar, q):
            if q == 0:
                #res.append(sofar.copy())
                #print(sofar)
                board = [["."]*n for _ in range(n)]
                for i, j in sofar:
                    board[i][j] = "Q"
                
                board = ["".join(i) for i in board]
                res.append(board)
                return
            if not 0 <= r < n:
                return
            
            
            for c in range(n):
                if okay_to_place(r, c, sofar) and q > 0:
                    sofar.append((r,c))
                    dfs(r+1, sofar, q-1)
                    sofar.pop()
                    
            return
                
        dfs(0, [], n)
        return res
        

