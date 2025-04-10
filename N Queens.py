#Time Complexity : O(N!) At most, you have N choices in the first row, N-1 in the second row, and so on. In the worst case, the number of recursive calls is approximately N!.
#Space Complexity : O(N^2) + O(N) Recursive Stack , + O(N) for each colset, postiveDiagset and negativeDiagset
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols =set()
        postiveDiag = set()
        negativeDiag = set()
        board = [["."]*n for i in range(n)]
        result = list()
        def dfs(r):
            if(r==n): 
                copy = ["".join(row) for row in board]
                result.append(copy)
                return
            for c in range(n):
                if(c in cols or (r+c) in postiveDiag or (r-c) in negativeDiag):
                    continue
                cols.add(c)
                postiveDiag.add(r+c)
                negativeDiag.add(r-c)
                board[r][c] = "Q"
                dfs(r+1)
                cols.remove(c)
                postiveDiag.remove(r+c)
                negativeDiag.remove(r-c)
                board[r][c] = "."
        dfs(0)
        return result



        