"""
Start to match the word starting from each cell
At each step, mark visited and go in 4 directions
Backtrack if needed to restore cell
"""
"""
Time Complexity: O(M × N × 4^L) where M × N = board size, L = length of the word
 Space Complexity: O(L) recursion stack (L = word length)
"""


from typing import List

class wordSearch:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])

        def dfs(r, c, i):
            if i == len(word):
                return True
            if r < 0 or c < 0 or r >= rows or c >= cols:
                return False
            if board[r][c] != word[i]:
                return False

            temp = board[r][c]
            board[r][c] = "#" 

            found = (dfs(r+1, c, i+1) or
                     dfs(r-1, c, i+1) or
                     dfs(r, c+1, i+1) or
                     dfs(r, c-1, i+1))

            board[r][c] = temp 
            return found

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0] and dfs(r, c, 0):
                    return True
        return False


if __name__ == "__main__":
    obj = wordSearch()
    board = [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
    ]
    print(obj.exist(board, "ABCCED"))
    print(obj.exist(board, "SEE"))
    print(obj.exist(board, "ABCB"))
