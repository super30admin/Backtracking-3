# Time Complexity : O(M * N * 4^L)
#   - M, N are dimensions of the board
#   - L is length of the word
#   - DFS explores up to 4 directions for each character in the word
#
# Space Complexity : O(L)
#   - Recursion stack depth up to length of word
#   - In-place marking used, so no extra space except call stack
#
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:

    def exist(self, board: List[List[str]], word: str) -> bool:
        # Backtracking with In-place Modification Approach
        row = len(board)
        col = len(board[0])

        def dfs(r: int, c: int, i: int) -> bool:
            # base case: all chars matched
            if i == len(word):
                return True
            
            # boundary and mismatch checks
            if r < 0 or c < 0 or r >= row or c >= col or board[r][c] != word[i]:
                return False
            
            # action: mark current cell as visited
            temp = board[r][c]
            board[r][c] = "#"

            # recurse in all 4 directions
            res = (dfs(r + 1, c, i + 1) or
                   dfs(r, c + 1, i + 1) or
                   dfs(r - 1, c, i + 1) or
                   dfs(r, c - 1, i + 1))

            # backtrack: restore cell
            board[r][c] = temp

            return res

        for r in range(row):
            for c in range(col):
                if dfs(r, c, 0):
                    return True
        return False


# --------------------------------------------
# Classic Approach (using path set to track visited cells)
#
# Time Complexity : O(M * N * 4^L)
# Space Complexity : O(L) + O(L) for path set
#
# class Solution:
#     def exist(self, board: List[List[str]], word: str) -> bool:
#         row = len(board)
#         col = len(board[0])
#         path = set()
#
#         def dfs(r: int, c: int, i: int) -> bool:
#             if i == len(word):
#                 return True
#             if (r < 0 or c < 0 or r >= row or c >= col or 
#                 board[r][c] != word[i] or (r, c) in path):
#                 return False
#
#             # action: add to visited path
#             path.add((r, c))
#
#             # recurse
#             res = (dfs(r + 1, c, i + 1) or
#                    dfs(r, c + 1, i + 1) or
#                    dfs(r - 1, c, i + 1) or
#                    dfs(r, c - 1, i + 1))
#
#             # backtrack: remove from visited path
#             path.remove((r, c))
#             return res
#
#         for r in range(row):
#             for c in range(col):
#                 if dfs(r, c, 0):
#                     return True
#         return False


# --------------------------------------------
if __name__ == "__main__":
    sol = Solution()

    board1 = [
        ["A","B","C","E"],
        ["S","F","C","S"],
        ["A","D","E","E"]
    ]
    word1 = "ABCCED"
    print(sol.exist(board1, word1))  # Expected: True

    board2 = [
        ["A","B","C","E"],
        ["S","F","C","S"],
        ["A","D","E","E"]
    ]
    word2 = "SEE"
    print(sol.exist(board2, word2))  # Expected: True

    board3 = [
        ["A","B","C","E"],
        ["S","F","C","S"],
        ["A","D","E","E"]
    ]
    word3 = "ABCB"
    print(sol.exist(board3, word3))  # Expected: False
