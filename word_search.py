'''
79 Word Search
https://leetcode.com/problems/word-search/description/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Solution:
1. Backtracking using for-loop based recursion:
We scan every cell in the board and check if it contains the first letter of the search word. If it does, we perform a recursion call from every such cell in the grid. Hence, we explore multiple starting cells.

Given the starting cell, we explore adjacent cells (up, down, left, right). If the letter in the adjacent cell matches the next letter in the word, we perform a recursion from the adjacent cell. We mark the adjacent cell as visited (i.e.,in-place mutation, by changing the letter in the cell to lowercase). This helps avoid revisiting the visited cell.

If the adjacent cell doesn't contain the next letter, then we don't visit that cell.

Upon returning from the recursion call, we mark the visited cell as unvisited by uppercasing the letter (getting the cell back to the original board state). This is because, if the path fails, then we give a chance for other paths to explore that cell.

The terminating condition is that anytime we discover the path matches the word, we declare the word exists in the grid and return.

Let W = length of word
Time: At each cell, we have 3 possible choices to recurse.

For eg, if we have visited D->E, then from E we can go to B, F, H but not D.
Hence, 3 possible directions not 4.
   A - B - C
   |   |   |
   D - E - F
   |   |   |
   G - H - I
At the max, the recursion depth is just the length of the search word. Hence, 3^W. O(MN) since we explore multiple starting points in the grid.
Time: O(M*N *3^W), Space: O(W), W = length of word
https://www.youtube.com/watch?v=-JJCOdLilxg
https://youtu.be/3x8kbRppZ5Q?t=1795

Note: it can be done using BFS + backtracking but the solution is a bit clumsy

'''
from collections import deque
from copy import deepcopy as dcp

def mprint(matrix):
    print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in matrix]))

def exist_dfs(board, word):
    def recurse(board, i, j, wid):
        # i = row index of the current cell on board
        # j = col index of the current cell on board
        # wid = index of the current character in word
        # base
        if wid == W:
            return True

        for dir in dirs:
            x, y = i + dir[0], j + dir[1]
            if 0 <= x <= M-1 and 0 <= y <= N-1 and not board[x][y].islower():
                if board[x][y] == word[wid]:
                    board[x][y] = board[x][y].lower()  # lower case for visited
                    found = recurse(board, x, y, wid+1)
                    if found:
                        return True
                    board[x][y] = word[wid] # unvisit (backtrack step)
        return False


    if not board:
        return False
    dirs = [[0,-1],[-1,0],[0,1],[1,0]] # L, U, R, D
    M, N, W = len(board), len(board[0]), len(word)
    for i in range(M):
        for j in range(N):
            if board[i][j] == word[0]:
                board[i][j] = board[i][j].lower()  # lower case for visited
                found = recurse(board, i, j, 1)
                if found:
                    return True
                board[i][j] = word[0] # unvisit (backtrack step)
    return False


def exist_bfs(board, word):
        def bfs(start_i, start_j):
            queue = deque()
            queue.append((start_i, start_j, 0, {(start_i, start_j)}))

            while queue:
                i, j, idx, visited = queue.popleft()

                if idx == len(word) - 1:
                    return True

                for di, dj in directions:
                    new_i, new_j = i + di, j + dj

                    if 0 <= new_i < rows and 0 <= new_j < cols and (new_i, new_j) not in visited:
                        if board[new_i][new_j] == word[idx + 1]:
                            new_visited = visited.copy()
                            new_visited.add((new_i, new_j))
                            queue.append((new_i, new_j, idx + 1, new_visited))

            return False

        if not board or not board[0]:
            return False

        rows, cols = len(board), len(board[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if bfs(i, j):
                        return True
        return False

def run_tests():
    tests = [([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED", True),
             ([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE", True),
             ([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB", False),
             ([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "CED", True), # note: we have CES and CED and we are searching for CED. Without backtracking, we could end up marking traversing CE (and changing it to 'ce') and then arrive at the incorrect character S resulting in ceS. We then discard this path and explore a new path from a new starting point. The problem is that this will incorrectly mark 'ce' as visited and limit the traversal for exploring new paths. Only if we use backtracking, we will be to restore 'ce' (visited) to 'CE' (unvisited).
            ([["A","B","R","O"],["S","F","C","S"],["L","O","R","E"]], "SFCRESOR", True),
    ]
    for test in tests:
        board, word, ans = test[0], test[1], test[2]
        print(f"\nBoard:")
        mprint(board)
        print(f"Search word = {word}")
        for method in ['dfs', 'bfs']:
            grid = dcp(board)
            if method == 'dfs':
                found = exist_dfs(grid, word)
                print(f"Method {method}: Found = {found}")
                print(f"Path in lower case:")
                mprint(grid)
            elif method == 'bfs':
                found = exist_bfs(grid, word)
                print(f"Method {method}: Found = {found}")
            passed = (ans == found)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")


run_tests()