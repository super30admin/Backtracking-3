class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        results = []
        def _helper(S, slate, i, path):
            # Backtracking Case
            if len(slate) != 0:
                lastq = len(slate) - 1
                for earlierq in range(lastq):
                    if slate[earlierq] == slate[lastq]:
                        return
                    rowdiff = abs(lastq - earlierq)
                    coldiff = abs(slate[lastq] - slate[earlierq])
                    if rowdiff == coldiff:
                        return
    
            # Base Case
            if n == i:
                results.append(path)

            # Recursive Case
            for col in range(n):
                idx = col
                tmp = '.' * n
                slate.append(col)
                _helper(n, slate, i+1, path+[tmp[:idx]+"Q"+tmp[idx+1:]])
                slate.pop()
        
        nums = [0 for _ in range(n+1)]
        _helper(nums, [], 0,[])            
        return results
            