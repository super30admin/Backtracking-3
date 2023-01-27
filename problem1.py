class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def helper(queens, ijDiff, ijSum):
            p = len(queens)  
            if p == n:
                res.append(queens)
                return None
            for q in range(n):   
                if q not in queens and p-q not in ijDiff and p+q not in ijSum:
                    helper(queens+[q], ijDiff+[p-q], ijSum+[p+q])
        res = []
        helper([], [], [])
        return [['.'*j + 'Q' + '.'*(n-j-1) for j in solution] for solution in res]