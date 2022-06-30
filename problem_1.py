# Time Complexity : O(n!) --> exponential.
# Space Complexity : O(n*n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def isValid(self, row, column, n):
        for x in self.dirs:
            nr = x[0] + row
            nc = x[1] + column
            while 0 <= nr < n and 0 <= nc < n:
                if self.check[nr][nc] == 'Q':
                    return False
                nr += x[0]
                nc += x[1]
        return True

    def helper(self, n, i, j):
        # base
        if i == n:
            temp = []
            for x in self.check:
                temp.append(''.join(x))
            self.result.append(temp)
        # logic
        for j in range(n):
            if self.isValid(i, j, n):
                self.check[i][j] = 'Q'
                self.helper(n, i+1, 0)
                self.check[i][j] = '.'

    def solveNQueens(self, n: int) -> list[list[str]]:
        self.dirs = [[-1, -1], [-1, 0], [-1, 1]]
        self.result = []
        self.check = []
        for i in range(n):
            self.check.append(['.']*n)
        self.helper(n, 0, 0)
        return self.result


print(Solution().solveNQueens(5))


# Using Boolean matrix
# class Solution:
#     def isValid(self, row, column, n):
#         for x in self.dirs:
#             nr = x[0] + row
#             nc = x[1] + column
#             while 0 <= nr < n and 0 <= nc < n:
#                 if self.check[nr][nc] == 1:
#                     return False
#                 nr += x[0]
#                 nc += x[1]
#         return True
#
#     def helper(self, n, i, j):
#         # base
#         if i == n:
#             lst = []
#             for x in range(n):
#                 temp = ''
#                 for y in range(n):
#                     if self.check[x][y] == 0:
#                         temp += '.'
#                     else:
#                         temp += 'Q'
#                 lst.append(temp)
#             self.result.append(lst)
#             return
#         # logic
#         for j in range(n):
#             if self.isValid(i, j, n):
#                 self.check[i][j] = 1
#                 self.helper(n, i+1, 0)
#                 self.check[i][j] = 0
#
#     def solveNQueens(self, n: int) -> list[list[str]]:
#         self.dirs = [[-1, -1], [-1, 0], [-1, 1]]
#         self.result = []
#         self.check = []
#         for i in range(n):
#             self.check.append([0]*n)
#         self.helper(n, 0, 0)
#         return self.result
#
#
# print(Solution().solveNQueens(5))
