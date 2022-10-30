##Time Complexity : O(n!) --> exponential.
##Space Complexity : O(n*n)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        answer = []
        cols = [False] * n
        diagonal1 = [False] * (2 * n - 1)
        diagonal2 = [False] * (2 * n - 1)

        def dfs(i, board):
            if i == n:
                answer.append(board)
                return

            for j in range(n):
                if cols[j] or diagonal1[i + j] or diagonal2[j - i + n - 1]:
                    continue
                cols[j] = diagonal1[i + j] = diagonal2[j - i + n - 1] = True
                dfs(i + 1, board + ['.' * j + 'Q' + '.' * (n - j - 1)])
                cols[j] = diagonal1[i + j] = diagonal2[j - i + n - 1] = False

        dfs(0, [])
        return answer
        