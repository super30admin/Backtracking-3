#Time: O(n * 3^L), n is number of cells in the board and L is len of word
#Space: O(L)
#did the code run successfully? yes
#issues faced: forgot to add and remove the 1st cell as visited
#Approach:
#iterate thru all cells whose value mathces with word's 1st letter
#start recursion from there by DFS all the neighbors using backtracking when a candidate 
#does not lead towards solution
#check if a neighbor is valid before placing in visited and explore further and then backtrack
#when it does not lead to solution

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board),len(board[0])
        visited = [[0 for _ in range(n)] for i in range(m)]
        dirs = [(-1, 0), (0, -1), (1, 0), (0, 1)]
        def is_valid(r, c, letter):
            if 0<=r<m and 0<=c<n:
                if not visited[r][c] and board[r][c] == letter:
                    return 1
            return 0

        def backtrack(idx, r, c):
            if idx == len(word)-1:
                return 1 if board[r][c]==word[idx] else 0
            for i, j in dirs:
                nr, nc = r+i, c+j
                if is_valid(nr, nc, word[idx+1]):
                    visited[nr][nc] = 1 #place candidate
                    ans = backtrack(idx+1, nr, nc) #recurse
                    visited[nr][nc] = 0 #remove candidate and backtrack
                    if ans: return 1
            return 0

        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    visited[i][j] = 1
                    if backtrack(0, i, j):
                        return 1
                    visited[i][j] = 0
        return 0