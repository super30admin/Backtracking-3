"""
51. N-Queens

Time Complexity : O(n^n) because for every queen there are n number of choices
Space Complexity : O(n) recursion stack
Successfully excecuted on leetcode


Approach:
1. Recursion + dfs (backtracking)
2. Nums is a one-dimension array, like [1, 3, 0, 2] means; first queen is placed in column 1, second queen is placed in column 3, etc.
3. Check whether nth queen can be placed in that column

"""

class NQueens:
    def solveNQueens(self, n):
        res = []
        self.dfs([-1]*n, 0, [], res)
        return res

    
    def dfs(self, nums, index, path, res):
        if index == len(nums):
            res.append(path)
            return  # backtracking
        for i in range(len(nums)):
            nums[index] = i
            if self.valid(nums, index):  # pruning
                tmp = "."*len(nums)
                self.dfs(nums, index+1, path+[tmp[:i]+"Q"+tmp[i+1:]], res)

    # check whether nth queen can be placed in that column
    def valid(self, nums, n):
        for i in range(n):
            if abs(nums[i]-nums[n]) == n -i or nums[i] == nums[n]:
                return False
        return True