# Time Complexity: O(n * n!)
# Space Complexity: O(|n|)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def dfs(queens, xy_dif, xy_sum):
            p = len(queens)
            if p == n:
                result.append(queens)
                return None
            for q in range(n):
                if (q not in queens) and (p - q not in xy_dif) and (p + q not in xy_sum): 
                    dfs((queens + [q]), (xy_dif + [p - q]), (xy_sum + [p + q]))
        result = []
        dfs([], [], [])
        return [[("." * i) + ("Q" + ("." * (n - i - 1))) for i in sol] for sol in result]