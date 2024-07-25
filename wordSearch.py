class Solution:
    def exist(self, board, word):
        def backtrack(i, j, k):
            if k == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[k]:
                return False

            # Mark the cell as visited
            temp = board[i][j]
            board[i][j] = '#'

            # Explore all possible directions: up, down, left, right
            found = (backtrack(i + 1, j, k + 1) or
                     backtrack(i - 1, j, k + 1) or
                     backtrack(i, j + 1, k + 1) or
                     backtrack(i, j - 1, k + 1))

            # Restore the cell
            board[i][j] = temp

            return found

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0] and backtrack(i, j, 0):
                    return True
        return False

# Example usage:
solution = Solution()
board = [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
]
word = "ABCCED"
print(solution.exist(board, word))  # Output: True

# Time Complexity: O(M×N×4 ^L)
# Space Complexity = O(L)