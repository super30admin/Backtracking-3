class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        columns=set()
        positive_diagonal=set()
        negative_diagonal=set()
        
        result=[]
        board=[["." for _ in range(n)]for _ in range(n)]
        
        def backtracking(r):
            if r==n:
                copy_board=["".join(row) for row in board]
                result.append(copy_board)
                return
            
            for c in range(n):
                if c in columns or (r+c) in positive_diagonal or (r-c) in negative_diagonal:
                    continue
                    
                columns.add(c)
                positive_diagonal.add((r+c))
                negative_diagonal.add((r-c))
                board[r][c]='Q'
                
                backtracking(r+1)
                
                columns.remove(c)
                positive_diagonal.remove((r+c))
                negative_diagonal.remove((r-c))
                board[r][c]='.'
                
        backtracking(0)
        return result
        