# Time Complexity : O(m*n * 3^L). mn is the size of the matrix, L is the word length
# Space Complexity : O(mn) for visited set and O(L) for the recursive stack

# The code ran on LeetCode

# Traverse the matrix and find the occurence of word[0] in the matrix. Perform dfs search starting from this index, maintain a visited set to keep track of previously visited nodes and remove that node from the set when all its babies are processed.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board); n = len(board[0])
        visited = set()
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        flag = False

        def dfs(x, y, idx):
            nonlocal flag
            
            if x < 0 or x > m-1 or y < 0 or y > n-1 or board[x][y] != word[idx] or (x, y) in visited:
                return
            if idx == len(word) - 1:
                flag = True
                return

            visited.add((x, y))

            for dx, dy in dirs:
                xn = x + dx; yn = y + dy
                dfs(xn, yn, idx+1)
               
            visited.remove((x, y))

        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    dfs(i,j, 0)
                    if flag:
                        return True
        return flag