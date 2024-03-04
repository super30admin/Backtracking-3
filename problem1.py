# https://leetcode.com/problems/n-queens/

# Time Complexity : O(N!) We will only place queens where there is not previous queen. Which reduces the possibilities
# Let's say for first row N possibilities, next row has N-2, and next row has N-4.. so..on it is approx equal to N!
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only
# Approach : We first create a dummy grid will all '.''s and start placing queens on a col in a row. Mark the col as
# visited and update the value at 'Q'. Keep track of positive diagonal and negative diagonal which are unique for a
# given queen position.

from typing import List


class Solution:
    positive_diagonal = set()
    negative_diagonal = set()
    visited_cols = set()
    result = []

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.positive_diagonal = set()
        self.negative_diagonal = set()
        self.visited_cols = set()

        self.result = []
        temp = ['.'] * n
        grid = [['.'] * n for i in temp]

        self.backtrack(grid, 0, n)

        return self.result

    def backtrack(self, grid, row, n):
        if row == n:
            cur = []
            # print(grid)
            for row in grid:
                cur.append(''.join(row))
            self.result.append(cur)
            return

        for col in range(n):
            p_val = col + row
            n_val = row - col
            if col not in self.visited_cols and p_val not in self.positive_diagonal and n_val not in self.negative_diagonal:
                grid[row][col] = 'Q'
                self.visited_cols.add(col)
                self.positive_diagonal.add(p_val)
                self.negative_diagonal.add(n_val)

                self.backtrack(grid, row + 1, n)

                grid[row][col] = '.'
                self.visited_cols.remove(col)
                self.positive_diagonal.remove(p_val)
                self.negative_diagonal.remove(n_val)





