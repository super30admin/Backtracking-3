# Time Complexity : O(m*n)
# Space Complexity : O(w) where w is the length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        def backtrack(x, y, i):
            if i == len(word):
                return True
            # Out of bounds or havent found word
            if (x < 0 or x == m) or (y < 0 or y == n) or board[x][y] != word[i]:
                return False
            c = board[x][y]

            # Mark this character as visited
            board[x][y] = "#"

            i += 1
            res = backtrack(x + 1, y, i) or backtrack(x, y + 1, i) or backtrack(x - 1, y, i) or backtrack(x, y - 1, i)

            # Unvisit this character so we could visit it again on next dfs
            board[x][y] = c

            return res

        for i in range(m):
            for j in range(n):
                if backtrack(i, j, 0):
                    return True

        return False;
